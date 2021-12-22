package com.mb.app.ws.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mb.app.ws.dtos.UserDTO;
import com.mb.app.ws.mapper.UserMapper;
import com.mb.app.ws.request.UserRequest;
import com.mb.app.ws.response.UserResponse;
import com.mb.app.ws.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	private UserMapper userMapper;

	public UserController(UserService userService, UserMapper userMapper) {
		super();
		this.userService = userService;
		this.userMapper = userMapper;
	}
	
	@PostMapping
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
		UserDTO userDTO = userService.createUser(userMapper.userRequestToDto(userRequest));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(userDTO.getUserId()).toUri();
		return ResponseEntity.created(location).body(userMapper.userDtoToUserResponse(userDTO));
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse> getUserByUserId(@PathVariable("userId") String userId) {
		return ResponseEntity.ok(userMapper.userDtoToUserResponse(userService.getUserByUserId(userId)));
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserResponse> updateUSerById(@PathVariable("userId") String userId, @RequestBody UserRequest userRequest) {
		UserDTO userDTO = userService.updateUserByUserId(userId, userMapper.userRequestToDto(userRequest));
		return ResponseEntity.ok(userMapper.userDtoToUserResponse(userDTO));
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUserByUserId(@PathVariable String userId) {
		return userService.deleteUserByUserId(userId);
	}
}