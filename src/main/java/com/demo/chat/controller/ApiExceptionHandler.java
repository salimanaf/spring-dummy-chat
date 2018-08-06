package com.demo.chat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.chat.exception.InvalidMessageInputException;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler({ InvalidMessageInputException.class })
	public ResponseEntity<?> invalidMessageInputException(Exception e) {
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
	}
}
