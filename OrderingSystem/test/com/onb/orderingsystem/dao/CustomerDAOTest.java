/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao;

import org.junit.Before;
import org.junit.After;
import java.util.Set;
import com.onb.orderingsystem.domain.Customer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lyndon
 */
public class CustomerDAOTest {
    private CustomerDAO customerDAO;
    
   
    @Before
    public void setUp() throws Exception {
        /*
         * Setup a database of 10 customers.
         * Five of which must be available*.
         * Five must exceed the credit limit.
         */
        //TODO: write codes to do the things written above
    }

    @After
    public void tearDown() throws Exception {
        customerDAO = null;
        /*
         * Empty the database
         */
        //TODO: write codes to empty the test database
    }

    @Test
    public void testGetAvailableCustomers() {
        Set<Customer> availableCustomers = customerDAO.getAvailableCustomers();
        
        int expected = 5;
        int actual = availableCustomers.size();
      
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetAllCustomers() {
        Set<Customer> allCustomers = customerDAO.getAvailableCustomers();
        
        int expected = 10;
        int actual = allCustomers.size();
      
        assertEquals(expected, actual);
    }
}
