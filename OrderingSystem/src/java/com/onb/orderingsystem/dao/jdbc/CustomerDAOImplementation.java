/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDAO;
import com.onb.orderingsystem.dao.CustomerDAO;
import com.onb.orderingsystem.dao.DAOException;
import com.onb.orderingsystem.domain.Customer;
import java.sql.Connection;
import java.util.Set;

/**
 *
 * @author lyndon
 */
public class CustomerDAOImplementation extends AbstractDAO implements CustomerDAO {
    
    public CustomerDAOImplementation(Connection connection) {
        super(connection);
    }

    @Override
    public Set<Customer> getCustomersCreditLimitNotExceeded() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Customer> getCustomersWithUnpaidOrders() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Customer> getAllCustomers() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
