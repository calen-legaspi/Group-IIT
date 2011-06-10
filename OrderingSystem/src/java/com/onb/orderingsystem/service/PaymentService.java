/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import java.util.Set;

/**
 *
 * @author The Architect
 */
public interface PaymentService {
    public Set<Customer> getCustomersWithCredit() throws ServiceException;
    public Set<Order> getUnpaidOrders(Customer customer) throws ServiceException, IllegalArgumentException;
    public void payFor(Order order) throws ServiceException, IllegalArgumentException;
}
