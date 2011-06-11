package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDao;
import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.domain.Customer;
import java.sql.Connection;
import java.util.Set;

/**
 * Implementation of the CustomerDao interface.
 * @see com.onb.orderingsystem.dao.CustomerDao
 * @see com.onb.orderingsystem.dao.AbstractDao
 */
public class JdbcCustomerDao extends AbstractDao implements CustomerDao {
    
    /**
     * @see java.sql.Connection
     * @param connection 
     * @throws IllegalArgumentException if the connection is null.
     */
    public JdbcCustomerDao(Connection connection) throws IllegalArgumentException {
        super(connection);
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDao
     * @return
     * @throws DaoException 
     */
    @Override
    public Set<Customer> getCustomersCreditLimitNotExceeded() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDao
     * @return
     * @throws DaoException 
     */
    @Override
    public Set<Customer> getCustomersWithUnpaidOrders() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDao
     * @return
     * @throws DaoException 
     */
    @Override
    public Set<Customer> getAllCustomers() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
