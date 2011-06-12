/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.domain.OrderItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;
import org.junit.Test;

/**
 *
 * @author The Architect
 */
public class JdbcCustomerDaoTest {

    @Test
    public void testSomeMethod() throws SQLException, DaoException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/orderingsystem_test", "root", "password");
        
        CustomerDao cd = new JdbcCustomerDao(con);
        
        Set<Customer> all = cd.getAllCustomers();
        for(Customer c: all) {
            System.out.println(c.getId()+")"+c.getName());
            for(Order o: c.getOrders()) {
                System.out.println(o);
                for(OrderItem oi: o.getOrderItems()) {
                    System.out.println(oi);
                }
            }
        }
    }
    
    @Test
    public void testInventoryItemsAll() {
        
    }
}
