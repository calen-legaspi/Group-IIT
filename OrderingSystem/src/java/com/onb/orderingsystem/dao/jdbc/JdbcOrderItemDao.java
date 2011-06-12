/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDao;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.dao.OrderItemDao;
import com.onb.orderingsystem.domain.OrderItem;
import java.sql.Connection;

/**
 * Implementation of the OrderItemDao.
 * @see com.onb.orderingsystem.dao.OrderItemDao
 * @see com.onb.orderingsystem.dao.AbstractDao
 */
public class JdbcOrderItemDao extends AbstractDao implements OrderItemDao {
    
    JdbcOrderItemDao(Connection connection) throws IllegalArgumentException {
        super(connection);
    }

    @Override
    public void createOrderItem(OrderItem orderItem) throws IllegalArgumentException, DaoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
