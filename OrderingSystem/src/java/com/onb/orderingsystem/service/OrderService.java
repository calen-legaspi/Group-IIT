/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.InventoryItem;
import com.onb.orderingsystem.domain.Order;
import java.util.Set;

/**
 *
 * @author The Architect
 */
public interface OrderService {
    public Set<Customer> getAvailableCustomers() throws ServiceException;
    public Set<InventoryItem> getAvailableInventoryItems() throws ServiceException; 
    public void createOrder(Order order, Customer customer) throws ServiceException, IllegalArgumentException;
    public boolean isValidOrder(Order order, Customer customer) throws ServiceException, IllegalArgumentException;
}
