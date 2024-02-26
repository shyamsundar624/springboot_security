package com.library.shyam.exception;

public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException(String msg) {
		super(msg);
	}
}
