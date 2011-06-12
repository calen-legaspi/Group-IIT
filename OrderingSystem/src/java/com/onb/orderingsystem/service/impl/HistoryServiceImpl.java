/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service.impl;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.service.HistoryService;
import com.onb.orderingsystem.service.ServiceException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author The Architect
 */
public class HistoryServiceImpl implements HistoryService {

    @Override
    public Set<Customer> getCustomers() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Order> getOrderHistoryByDateDescending(Customer customer) throws ServiceException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
