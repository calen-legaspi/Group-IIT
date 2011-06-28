package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.OrderItem;

/**
 * Database CRUD for the OrderItem object.
 */
public interface OrderItemDao {
    
    /**
     * Inserts a new order item into the database.
     * @param orderItem the OrderItem object to persist into the database.
     * @throws IllegalArgumentException if the parameter is null.
     * @throws DaoException if something goes wrong while persisting the object.
     */
    public void createOrderItem(OrderItem orderItem) throws IllegalArgumentException, DaoException;
}
