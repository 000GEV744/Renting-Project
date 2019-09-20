package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.response.RequestModel;
import com.example.demo.response.ResponseModel;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired private UserService userServ;
	ModelMapper mapper = new ModelMapper();
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<ResponseModel> getUserbyUserId(@PathVariable String userId){
		UserDto user = userServ.findUserByUserId(userId);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ResponseModel response = mapper.map(user, ResponseModel.class);
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<ResponseModel> createUser(@RequestBody RequestModel request){
		
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDetails=mapper.map(request, UserDto.class);
		UserDto dto=userServ.createUser(userDetails);
		ResponseModel response = mapper.map(dto, ResponseModel.class);
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody RequestBody request){
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDetails=mapper.map(request, UserDto.class);
		
		return null;
	}
}
