package com.onb.shoppingcart.services.exceptions;

public class InsufficientInventoryException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public InsufficientInventoryException() {
	}

	public InsufficientInventoryException(String message) {
		super(message);
	}

	public InsufficientInventoryException(Throwable cause) {
		super(cause);
	}

	public InsufficientInventoryException(String message, Throwable cause) {
		super(message, cause);
	}

}
