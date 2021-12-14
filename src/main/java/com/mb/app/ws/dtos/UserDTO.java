package com.mb.app.ws.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private Long id;

	private String userId;

	private String firstName;

	private String lastName;

	private String email;

	private String encryptedPassword;

	private String emailVerificationToken;

	private Boolean emailVerificationStatus = false;
}
