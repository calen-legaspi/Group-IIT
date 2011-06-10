package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDAO;
import com.onb.orderingsystem.dao.CustomerDAO;
import com.onb.orderingsystem.dao.DAOException;
import com.onb.orderingsystem.domain.Customer;
import java.sql.Connection;
import java.util.Set;

/**
 * Implementation of the CustomerDAO interface.
 * @see com.onb.orderingsystem.dao.CustomerDAO
 * @see com.onb.orderingsystem.dao.AbstractDAO
 */
public class CustomerDAOImplementation extends AbstractDAO implements CustomerDAO {
    
    /**
     * @see java.sql.Connection
     * @param connection 
     * @throws IllegalArgumentException if the connection is null.
     */
    public CustomerDAOImplementation(Connection connection) throws IllegalArgumentException {
        super(connection);
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDAO
     * @return
     * @throws DAOException 
     */
    @Override
    public Set<Customer> getCustomersCreditLimitNotExceeded() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDAO
     * @return
     * @throws DAOException 
     */
    @Override
    public Set<Customer> getCustomersWithUnpaidOrders() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDAO
     * @return
     * @throws DAOException 
     */
    @Override
    public Set<Customer> getAllCustomers() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
