/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service;
import com.onb.orderingsystem.dao.impl.OrderDAOImp;
import com.onb.orderingsystem.domain.*;
import java.util.Set;
/**
 *
 * @author juliusmercons
 */
public class OrderHistoryService {
    
    public Set<Order> getUnpaidOrdersByCustomer(Customer customer){
        return new OrderDAOImp().getCustomerUnpaidOrders(customer);
    }
    
    
}
