package com.mb.app.ws.exceptions;

public enum ErrorMessages {
	
	MISSING_REQUIRED_FIELD("Missing Required Field"),
	USER_ALREADY_EXISTS("User Already Exists"),
	INTERNAL_SERVER_ERROR("Internal Server Error"),
	USER_NOT_FOUND("User Not Found Plz Check Id"),
	COULD_NOT_UPDATE_USER("Could Not Update User"),
	COULD_NOT_DELETE_USER("Could Not Delete User"),
	EMAIL_ADDRESS_NOT_VERIFIED("Email Address Could Not Be Verified");
		
	private String errorMessage;
	
	ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}	
}
