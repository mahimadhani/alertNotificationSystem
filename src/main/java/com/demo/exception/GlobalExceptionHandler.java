package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = TeamNotAddedException.class)
	public ResponseEntity<Object> exception(TeamNotAddedException exception) {
		return new ResponseEntity<>("{\n" +
				"    error: \"Mandatory Fields are missing\",\n" +
				"}", HttpStatus.BAD_REQUEST);
	}
}
