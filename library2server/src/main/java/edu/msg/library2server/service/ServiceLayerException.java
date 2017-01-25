package edu.msg.library2server.service;

public class ServiceLayerException extends RuntimeException {
	private static final long serialVersionUID = 2341687053488658570L;

	public ServiceLayerException() {
		super();
	}

	public ServiceLayerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceLayerException(String message) {
		super(message);
	}
}
