package edu.msg.library2server.service.exceptions;

import edu.msg.library2common.service.ServiceException;

public class LoginException extends ServiceException {
	public LoginException() {
		super();
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginException(String message) {
		super(message);
	}
}
