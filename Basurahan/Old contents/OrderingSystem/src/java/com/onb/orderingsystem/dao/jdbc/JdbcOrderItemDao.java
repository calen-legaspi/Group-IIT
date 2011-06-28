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
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implementation of the OrderItemDao.
 * @see com.onb.orderingsystem.dao.OrderItemDao
 * @see com.onb.orderingsystem.dao.AbstractDao
 */
public class JdbcOrderItemDao extends AbstractDao implements OrderItemDao {
    
    /**
     * 
     * @param connection
     * @throws IllegalArgumentException 
     */
    JdbcOrderItemDao(Connection connection) throws IllegalArgumentException {
        super(connection);
    }

    /**
     * 
     * @param orderItem
     * @throws IllegalArgumentException
     * @throws DaoException 
     */
    @Override
    public void createOrderItem(OrderItem orderItem) throws IllegalArgumentException, DaoException {
        String createOrderItem = "INSERT INTO order_items(order_order_number, product_sku_number, quantity) VALUES(?, ?, ?)";
        
        try {
            PreparedStatement insert = connection.prepareStatement(createOrderItem);
            insert.setInt(1, orderItem.getOrder().getOrderNumber());
            insert.setInt(2, orderItem.getProduct().getSkuNumber());
            insert.setInt(3, orderItem.getQuantity());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Query["+createOrderItem+"] failed:"+e.getMessage());
        }
    }
    
}
