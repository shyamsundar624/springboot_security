package com.library.shyam.exception;

public class UserAlreadyExistsException extends RuntimeException{

	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
}
