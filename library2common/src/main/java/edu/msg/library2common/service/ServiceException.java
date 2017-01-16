package edu.msg.library2common.service;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 6821687073588658770L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

}
