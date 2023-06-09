package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.UserRequest;
import com.example.dto.UserSearchRequest;
import com.example.dto.UserUpdateRequest;
import com.example.entity.User;
@Mapper
public interface UserMapper {
	void delete(Long id);
	
	void save(UserRequest userRequest);
	
	List<User> findAll();
	
	List<User> selectAll();
	
	User findById(Long id) ;
	
	User search(UserSearchRequest userSearchRequest);
	
	void update(UserUpdateRequest userUpdateRequest);
}
