package com.mb.app.ws.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.mb.app.ws.dtos.UserDTO;
import com.mb.app.ws.model.UserEntity;
import com.mb.app.ws.request.UserRequest;
import com.mb.app.ws.response.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	public UserDTO userToUserDto(UserEntity entity);
	
	public UserEntity userDtoToEntity(UserDTO dto);
	
	@Mapping(target = "encryptedPassword", source = "password")
	public UserDTO userRequestToDto(UserRequest userRequest);
	
	public UserResponse userDtoToUserResponse(UserDTO dto);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	public void updateUser(UserDTO dto, @MappingTarget UserEntity entity);
}
