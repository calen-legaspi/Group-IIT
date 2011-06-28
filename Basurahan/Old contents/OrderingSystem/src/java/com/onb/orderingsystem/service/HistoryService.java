package com.onb.orderingsystem.service;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import java.util.List;
import java.util.Set;

/**
 * Service class for Use Case #03: <b>Order History</b>.
 */
public interface HistoryService {
    
    /**
     * 
     * @return
     * @throws ServiceException 
     */
    public Set<Customer> getCustomers() throws ServiceException;
    
    /**
     * 
     * @param customer
     * @return
     * @throws ServiceException
     * @throws IllegalArgumentException 
     */
    public List<Order> getOrderHistoryByDateDescending(Customer customer) throws ServiceException, IllegalArgumentException;
}
