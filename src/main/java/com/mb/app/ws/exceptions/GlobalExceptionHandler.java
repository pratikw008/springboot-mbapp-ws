package com.mb.app.ws.exceptions;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mb.app.ws.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ErrorMessages.USER_NOT_FOUND.toString(), ErrorMessages.USER_NOT_FOUND.getErrorMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), 
												HttpStatus.BAD_REQUEST.value(), 
												ex.getClass().getSimpleName(), 
												ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), 
												request.getDescription(false),
												ex.getBindingResult().getFieldErrors().stream()
												  .map(fe -> new SubError(fe.getField(), fe.getRejectedValue(), fe.getDefaultMessage())).collect(Collectors.toList()));
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), 
												HttpStatus.BAD_REQUEST.value(), 
												ex.getClass().getSimpleName(), 
												ex.getMessage(), 
												request.getDescription(false));
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(),
												HttpStatus.BAD_REQUEST.value(),
												ex.getClass().getSimpleName(),
												ex.getLocalizedMessage(),
												request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(),
				HttpStatus.METHOD_NOT_ALLOWED.value(),
				ex.getClass().getSimpleName(),
				ex.getMethod()+" is not Supported. Supported Methods:: "+Arrays.asList(ex.getSupportedMethods()),
				request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.METHOD_NOT_ALLOWED);
	}
}
