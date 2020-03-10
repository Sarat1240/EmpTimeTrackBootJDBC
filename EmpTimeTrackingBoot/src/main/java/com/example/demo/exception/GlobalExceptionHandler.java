package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeNotFoundException exception) {
		return null;
	}
	

}
