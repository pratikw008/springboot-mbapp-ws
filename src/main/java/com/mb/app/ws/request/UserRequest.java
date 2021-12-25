package com.mb.app.ws.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
	
	@NotBlank(message = "FirstName is mandatory")
	private String firstName;
	
	@NotBlank(message = "LastName is mandatory")
	private String lastName;
	
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotBlank(message = "Password is mandatory")
	private String password;
}
