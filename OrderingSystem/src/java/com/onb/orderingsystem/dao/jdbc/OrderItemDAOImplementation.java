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
 *
 * @author lyndon
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
