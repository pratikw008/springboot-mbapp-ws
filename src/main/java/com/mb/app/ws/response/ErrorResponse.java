package com.mb.app.ws.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mb.app.ws.exceptions.SubError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonInclude(value = Include.NON_NULL)
@AllArgsConstructor
@Getter
public class ErrorResponse {
	
	private LocalDateTime timestamp;
	
	private int status;
	
	private String error;
	
	private String message;
	
	private String path;
	
	private List<SubError> subErrors;

	public ErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
}
