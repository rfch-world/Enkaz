package com.secondhand.secondhand.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIsNotActiveException extends RuntimeException {
	

	private static final  String  message="The user is not active for updating!";
	
	
	public UserIsNotActiveException() {
		super(message);
	}
	public UserIsNotActiveException(String message) {
		super(message);
	
	}
}
