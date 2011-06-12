/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import java.util.Set;

/**
 *
 * @author juliusmercons
 */
public interface OrderDAO {
    
    public Set<Order> getCustomerOrders(Customer customer);
    public void payCustomerOrder(int order_id);
    public Set<Order> getCustomerUnpaidOrders(Customer customer);

    public int getCustomerIdAssocWithOrder(int order_number);
}
