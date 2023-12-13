package com.appapi.blog.Services;

import java.util.List;

import com.appapi.blog.Entites.User;
import com.appapi.blog.Payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteuser(Integer userId);
	
}
