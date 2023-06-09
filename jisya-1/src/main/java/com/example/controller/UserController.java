package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dto.UserRequest;
import com.example.dto.UserSearchRequest;
import com.example.dto.UserUpdateRequest;
import com.example.entity.User;
import com.example.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping(value = "/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.selectAll();
		model.addAttribute("userlist", userlist);
		return "user/list";
	}
	
	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		return "user/add";
	}
	
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/add";
		}
		// ユーザー情報の登録
		userService.save(userRequest);
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/{id}")
	public String displayView(@PathVariable Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("userData", user);
		return "user/view";
	}
	
	@GetMapping("/user/{id}/edit")
	public String displayEdit(@PathVariable Long id, Model model) {
		User user = userService.findById(id);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
		userUpdateRequest.setId(user.getId());
		userUpdateRequest.setGUIDE_ID(user.getGUIDE_ID());
		userUpdateRequest.setGUIDE_NAME(user.getGUIDE_NAME());
		userUpdateRequest.setCAR_NUM(user.getCAR_NUM());
		userUpdateRequest.setCAR_NAME(user.getCAR_NAME());
		userUpdateRequest.setSTART_PLACE(user.getSTART_PLACE());
		userUpdateRequest.setCHECK_TYPE(user.getCHECK_TYPE());
		userUpdateRequest.setENOUGH_SLEEP(user.getENOUGH_SLEEP());
		userUpdateRequest.setDEPARTURE_DETECTOR(user.getDEPARTURE_DETECTOR());
		userUpdateRequest.setDEPARTURE_CHECKNAME(user.getDEPARTURE_CHECKNAME());
		userUpdateRequest.setEND_PLACE(user.getEND_PLACE());
		model.addAttribute("userUpdateRequest", userUpdateRequest);
		return "user/edit";
	}
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/edit";
		}
		// ユーザー情報の更新
		userService.update(userUpdateRequest);
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        // ユーザー情報の削除
		userService.delete(id);
        return "redirect:/user/list";
        
    }
	
	@GetMapping(value = "/user/search")
	public String displaySearch(Model model) {
		model.addAttribute("userSearchRequest", new UserSearchRequest());
		return "user/search";
	}
	
	@RequestMapping(value = "/user/id_search", method = RequestMethod.POST)
	  public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
			User user = userService.search(userSearchRequest);
	    
	    model.addAttribute("userinfo", user);
	    return "user/search";
	  }
}
