package com.mb.app.ws.service.impl;

import org.springframework.stereotype.Service;

import com.mb.app.ws.dtos.UserDTO;
import com.mb.app.ws.mapper.UserMapper;
import com.mb.app.ws.model.UserEntity;
import com.mb.app.ws.repository.UserRepository;
import com.mb.app.ws.service.UserService;
import com.mb.app.ws.utils.Utils;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private UserMapper userMapper;
	
	private Utils utils;
	
	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, Utils utils) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.utils = utils;
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		if(userRepository.findByEmail(userDTO.getEmail()).isPresent())
			throw new RuntimeException("User Already Exists With this Email");
		
		UserEntity userEntity = userMapper.userDtoToEntity(userDTO);
		userEntity.setUserId(utils.generateUserId(5));
		return userMapper.userToUserDto(userRepository.save(userEntity));
	}
	
	@Override
	public UserDTO getUserByUserId(String userId) {
		return userRepository.findByUserId(userId)
							 .map(userMapper::userToUserDto)
							 .orElseThrow(() -> new RuntimeException("UserId::"+userId+" Not Exists"));
	}
	
	@Override
	public UserDTO updateUserByUserId(String userId, UserDTO userDTO) {
		return userRepository.findByUserId(userId)
					  		 .map(userEntity -> updateUser(userEntity,userDTO))
					  		 .orElseThrow(() -> new RuntimeException("UserId::"+userId+" Not Exists"));
	}

	private UserDTO updateUser(UserEntity userEntity, UserDTO userDTO) {
		userMapper.updateUser(userDTO, userEntity);
		UserEntity updatedUser = userRepository.save(userEntity);
		return userMapper.userToUserDto(updatedUser);
	}
	
	@Override
	public String deleteUserByUserId(String userId) {
		return userRepository.findByUserId(userId)
							 .map(entity -> deleteUser(entity))
							 .orElseThrow(() -> new RuntimeException("UserId::"+userId+" Not Exists"));
	}

	private String deleteUser(UserEntity entity) {
		userRepository.delete(entity);
		return "User Deleted Successfully";
	}
}
