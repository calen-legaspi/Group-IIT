/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import java.util.Set;

/**
 * Service class for Use Case #02: <b>Payment</b>.
 */
public interface PaymentService {
    
    /**
     * 
     * @return
     * @throws ServiceException 
     */
    public Set<Customer> getCustomersWithCredit() throws ServiceException;
    
    /**
     * 
     * @param customer
     * @return
     * @throws ServiceException
     * @throws IllegalArgumentException 
     */
    public Set<Order> getUnpaidOrders(Customer customer) throws ServiceException, IllegalArgumentException;
    
    /**
     * 
     * @param order
     * @throws ServiceException
     * @throws IllegalArgumentException 
     */
    public void payFor(Order order) throws ServiceException, IllegalArgumentException;
}
