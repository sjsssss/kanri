package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserRequest;
import com.example.dto.UserSearchRequest;
import com.example.dto.UserUpdateRequest;
import com.example.entity.User;
import com.example.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public void delete(Long id) {
		userMapper.delete(id);
	    }

	public User findById(Long id) {
       return userMapper.findById(id);
   }
	
	public void save(UserRequest userRequest) {
		userMapper.save(userRequest);
	}
	public List<User> searchAll(){
		return userMapper.findAll();
	}

	public void update(UserUpdateRequest userUpdateRequest) {
		userMapper.update(userUpdateRequest);
    }
	public User search(UserSearchRequest userSearchRequest) {
        return userMapper.search(userSearchRequest);
    }
	public List<User> selectAll() {
	    return userMapper.selectAll();
	  }
}
