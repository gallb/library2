package edu.msg.library2server.repository.jdbc;

public class SqlHandlerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SqlHandlerException() {
		super();
	}

	public SqlHandlerException(String message) {
		super(message);
	}

	public SqlHandlerException(String message, Exception ex) {
		super(message, ex);
	}

}
