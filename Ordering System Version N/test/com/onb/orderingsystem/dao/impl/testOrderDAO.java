/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.impl;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import java.util.Set;
import org.junit.Test;

/**
 *
 * @author juliusmercons
 */
public class testOrderDAO {
   @Test
    public void testOrder(){
    CustomerDAOimp cust_dao = new CustomerDAOimp();
    OrderDAOImp dao = new OrderDAOImp();
    Set<Customer> unpaid = cust_dao.getAllUnpaid();
    Customer one = (Customer) unpaid.toArray()[0];
    one.setOrders(dao.getCustomerUnpaidOrders(one));
    Order o = (Order)one.getOrders().toArray()[0];
    System.out.println(o.getDate());
            
}
}
