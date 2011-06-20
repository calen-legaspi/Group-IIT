package com.onb.orderingsystem.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 3033200513666625538L;

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
