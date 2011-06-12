/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service.impl;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.InventoryItem;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.service.OrderService;
import com.onb.orderingsystem.service.ServiceException;
import java.util.Set;

/**
 *
 * @author The Architect
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public Set<Customer> getAvailableCustomers() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<InventoryItem> getAvailableInventoryItems() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createOrder(Order order, Customer customer) throws ServiceException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
