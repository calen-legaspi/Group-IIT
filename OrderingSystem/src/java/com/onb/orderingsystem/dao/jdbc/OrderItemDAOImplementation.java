/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDAO;
import com.onb.orderingsystem.dao.DAOException;
import com.onb.orderingsystem.dao.OrderItemDAO;
import com.onb.orderingsystem.domain.OrderItem;
import java.sql.Connection;

/**
 * Implementation of the OrderItemDAO.
 * @see com.onb.orderingsystem.dao.OrderItemDAO
 * @see com.onb.orderingsystem.dao.AbstractDAO
 */
public class OrderItemDAOImplementation extends AbstractDAO implements OrderItemDAO {
    
    public OrderItemDAOImplementation(Connection connection) throws IllegalArgumentException {
        super(connection);
    }

    @Override
    public void createOrderItem(OrderItem orderItem) throws IllegalArgumentException, DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
