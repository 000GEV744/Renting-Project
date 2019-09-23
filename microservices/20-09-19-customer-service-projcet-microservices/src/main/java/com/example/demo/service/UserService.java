package com.example.demo.service;
import com.example.demo.dto.UserDto;


public interface UserService {

	UserDto findUserByUserId(String userId);

	UserDto createUser(UserDto userDetails);
	public UserDto verifyUser(String email,String pass);
	
}

