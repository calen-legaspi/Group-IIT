/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDao;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.dao.OrderDao;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import java.sql.Connection;
import java.util.List;

/**
 * Implementation of the OrderDao interface.
 * @see com.onb.orderingsystem.dao.OrderDao
 * @see com.onb.orderingsystem.dao.AbstractDao
 */
public class OrderDaoJdbcImpl extends AbstractDao implements OrderDao {
    
    /**
     * 
     * @param connection
     * @throws IllegalArgumentException 
     */
    public OrderDaoJdbcImpl(Connection connection) throws IllegalArgumentException {
        super(connection);
    }

    /**
     * @see com.onb.orderingsystem.dao.OrderDao
     * @param order
     * @throws DaoException
     * @throws IllegalArgumentException 
     */
    @Override
    public void createOrder(Order order) throws DaoException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see com.onb.orderingsystem.dao.OrderDao
     * @param order
     * @throws DaoException
     * @throws IllegalArgumentException 
     */
    @Override
    public void updateOrder(Order order) throws DaoException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see com.onb.orderingsystem.dao.OrderDao
     * @param customer
     * @return
     * @throws DaoException
     * @throws IllegalArgumentException 
     */
    @Override
    public List<Order> getOrderByCustomerSortedByDateDescending(Customer customer) throws DaoException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
