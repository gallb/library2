package edu.msg.library2server.business;

public class BusinessLayerException extends RuntimeException{
	private static final long serialVersionUID = 6821687023588658570L;

	public BusinessLayerException() {
		super();
	}

	public BusinessLayerException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessLayerException(String message) {
		super(message);
	}
}
