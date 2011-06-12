/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service.impl;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.service.PaymentService;
import com.onb.orderingsystem.service.ServiceException;
import java.util.Set;

/**
 *
 * @author The Architect
 */
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Set<Customer> getCustomersWithCredit() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Order> getUnpaidOrders(Customer customer) throws ServiceException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void payFor(Order order) throws ServiceException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
