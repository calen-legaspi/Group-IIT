package com.onb.shoppingcart.services.exceptions;

public class DuplicateCategoryException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public DuplicateCategoryException() {
	}

	public DuplicateCategoryException(String message) {
		super(message);
	}

	public DuplicateCategoryException(Throwable cause) {
		super(cause);
	}

	public DuplicateCategoryException(String message, Throwable cause) {
		super(message, cause);
	}

}
