package com.mb.app.ws.service;

import com.mb.app.ws.dtos.UserDTO;

public interface UserService {
	
	public UserDTO createUser(UserDTO userDTO);
	
	public UserDTO getUserByUserId(String userId);
	
	public UserDTO updateUserByUserId(String userId, UserDTO userDTO);
	
	public String deleteUserByUserId(String userId);
}
