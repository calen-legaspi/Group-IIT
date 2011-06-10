/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.Order;

/**
 *
 * @author The Architect
 */
public interface OrderDAO {
    public void createOrder(Order order) throws DAOException, IllegalArgumentException;
    public void updateOrder(Order order) throws DAOException, IllegalArgumentException;
}
