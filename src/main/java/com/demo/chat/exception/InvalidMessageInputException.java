package com.demo.chat.exception;

public class InvalidMessageInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	public InvalidMessageInputException(String msg) {
		super(msg);
	}


	public InvalidMessageInputException(String msg, Throwable t) {
		super(msg, t);
	}
}
