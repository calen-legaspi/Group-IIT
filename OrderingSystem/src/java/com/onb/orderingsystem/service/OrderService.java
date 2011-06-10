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
    public Set<Customer> getAvailableCustomers() throws IllegalArgumentException;
    public Set<InventoryItem> getAvailableInventoryItems() throws IllegalArgumentException; 
    public void createOrder(Order order, Customer customer) throws IllegalArgumentException;
    public boolean isValidOrder(Order order, Customer customer) throws IllegalArgumentException;
}
