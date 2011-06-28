package com.onb.orderingsystem.dao;

/**
 * The Exception object representing an exception in the DAO layer.
 */
public class DaoException extends Exception {
    private final String message;
    
    public DaoException() {
        super();
        message = "Unknown exception in the DAO layer.";
    }
    
    public DaoException(String message) {
        super(message);
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
}
