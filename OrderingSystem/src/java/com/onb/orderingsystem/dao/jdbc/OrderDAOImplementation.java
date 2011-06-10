/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDAO;
import com.onb.orderingsystem.dao.DAOException;
import com.onb.orderingsystem.dao.OrderDAO;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author lyndon
 */
public class OrderDAOImplementation extends AbstractDAO implements OrderDAO {
    
    /**
     * 
     * @param connection
     * @throws IllegalArgumentException 
     */
    public OrderDAOImplementation(Connection connection) throws IllegalArgumentException {
        super(connection);
    }

    /**
     * @see com.onb.orderingsystem.dao.OrderDAO
     * @param order
     * @throws DAOException
     * @throws IllegalArgumentException 
     */
    @Override
    public void createOrder(Order order) throws DAOException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see com.onb.orderingsystem.dao.OrderDAO
     * @param order
     * @throws DAOException
     * @throws IllegalArgumentException 
     */
    @Override
    public void updateOrder(Order order) throws DAOException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see com.onb.orderingsystem.dao.OrderDAO
     * @param customer
     * @return
     * @throws DAOException
     * @throws IllegalArgumentException 
     */
    @Override
    public List<Order> getOrderByCustomerSortedByDateDescending(Customer customer) throws DAOException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
