package com.onb.shoppingcart.services.exceptions;

public class DuplicateProductException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public DuplicateProductException() {
		super();
	}

	public DuplicateProductException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateProductException(String message) {
		super(message);
	}

	public DuplicateProductException(Throwable cause) {
		super(cause);
	}

}
