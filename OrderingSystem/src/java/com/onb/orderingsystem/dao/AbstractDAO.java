package com.onb.orderingsystem.dao;

import java.sql.Connection;

/**
 * DAO classes are responsible for mapping relational database tables to java objects.
 * All DAO must extend this class.
 * 
 */
public abstract class AbstractDAO {
    /**
     * The Connection interface for the utilization of all DAO.
     * @see java.sql.Connection
     */
    protected final Connection connection;
    
    /**
     * Creates an Instance of the a DAO.
     * @param connection the data source.
     * @see java.sql.Connection
     */
    public AbstractDAO(Connection connection) throws IllegalArgumentException {
        if(connection == null) {
            throw new IllegalArgumentException("Invalid Connection.");
        }
        this.connection = connection;
    }
}
