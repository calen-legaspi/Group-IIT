package com.onb.orderingsystem.domain;

/**
 * This exception is thrown when a business rule is violated at the domain
 * layer.
 */
public class DomainException extends Exception {

	private static final long serialVersionUID = 8360430011695738186L;

	public DomainException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public DomainException(Throwable throwable) {
		super(throwable);
	}

	public DomainException(String message) {
		super(message);
	}
}
