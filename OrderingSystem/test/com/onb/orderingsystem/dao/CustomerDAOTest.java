package com.onb.orderingsystem.dao;

import org.junit.Before;
import org.junit.After;
import java.util.Set;
import com.onb.orderingsystem.domain.Customer;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerDAOTest {
    private CustomerDAO customerDAO;
    
   
    @Before
    public void setUp() throws Exception {
        /*
         * Setup a database of 15 customers.
         * Five of which must be available*.
         * Five must exceed the credit limit.
         * Five should have credits.
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
    public void testGetCustomerCreditLimitNotExceeded() throws DAOException {
        Set<Customer> availableCustomers = customerDAO.getCustomersCreditLimitNotExceeded();
        
        int expected = 5;
        int actual = availableCustomers.size();
      
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetAllCustomers() throws DAOException {
        Set<Customer> allCustomers = customerDAO.getCustomersCreditLimitNotExceeded();
        
        int expected = 10;
        int actual = allCustomers.size();
      
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetCustomersWithUnpaidOrders() throws DAOException {
        Set<Customer> customersWithUnpaidAmount = customerDAO.getCustomersWithUnpaidOrders();
        
        int expected = 5;
        int actual = customersWithUnpaidAmount.size();
        
        assertEquals(expected, actual);
    }
}
