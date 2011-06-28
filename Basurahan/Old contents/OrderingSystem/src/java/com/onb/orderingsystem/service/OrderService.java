package com.onb.orderingsystem.service;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.InventoryItem;
import com.onb.orderingsystem.domain.Order;
import java.util.Set;

/**
 * Service class for Use Case #01: <b>Create Order</b>.
 */
public interface OrderService {
    
    /**
     * 
     * @return
     * @throws ServiceException 
     */
    public Set<Customer> getAvailableCustomers() throws ServiceException;
    
    /**
     * 
     * @return
     * @throws ServiceException 
     */
    public Set<InventoryItem> getAvailableInventoryItems() throws ServiceException; 
    
    /**
     * 
     * @param order
     * @param customer
     * @throws ServiceException
     * @throws IllegalArgumentException 
     */
    public void createOrder(Order order, Customer customer) throws ServiceException, IllegalArgumentException;
}
