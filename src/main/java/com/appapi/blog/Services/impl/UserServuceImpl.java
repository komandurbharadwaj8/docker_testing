package com.appapi.blog.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import com.appapi.blog.Exceptions.*;
import com.appapi.blog.Entites.User;
import com.appapi.blog.Payloads.UserDto;
import com.appapi.blog.Repositories.UserRepo;
import com.appapi.blog.Services.UserService;

public class UserServuceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoTouser(userDto);
		User saveUser = this.userRepo.save(user);
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ConfigDataResourceNotFoundException("User", "user Id", userId));


		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateduser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateduser);
		
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteuser(Integer userId) {
		// TODO Auto-generated method stub

	}

	private User dtoTouser(UserDto userDto)
	{
		User user1=new User();
		user1.setid(userDto.getId());
		user1.setName(userDto.getName());
		user1.setEmail(userDto.getEmail());
		user1.setAbout(userDto.getAbout());
		user1.setPassword(userDto.getPassword());
		
		return user1;
		
		
	}
	
	public UserDto userToDto(User user)
	{
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName);
		userDto.setEmail(user.getEmail);
		userDto.setPassword(user.getPassword);
		userDto.setAbout(user.getAbout);
		return userDto;
	}
}
