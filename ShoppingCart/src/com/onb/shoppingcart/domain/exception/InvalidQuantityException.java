package com.onb.shoppingcart.domain.exception;

public class InvalidQuantityException extends DomainException {
	private static final long serialVersionUID = 1L;

	public InvalidQuantityException() {
	}

	public InvalidQuantityException(String message) {
		super(message);
	}

	public InvalidQuantityException(Throwable cause) {
		super(cause);
	}

	public InvalidQuantityException(String message, Throwable cause) {
		super(message, cause);
	}

}
