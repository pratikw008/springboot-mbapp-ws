package com.mb.app.ws.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SubError {
	
	private String fieldName;
    
	private Object rejectedValue;
    
	private String messageError;
}
