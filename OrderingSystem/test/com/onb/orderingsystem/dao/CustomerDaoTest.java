package com.onb.orderingsystem.dao;

import org.dbunit.dataset.IDataSet;
import java.util.Set;
import com.onb.orderingsystem.domain.Customer;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.junit.Test;

public class CustomerDaoTest extends DBTestCase {
    private CustomerDao customerDAO;
    
    //DBUNIT METHODS START//
    
    public CustomerDaoTest(String name) {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,"");
    }
    
    @Override
    protected IDataSet getDataSet() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
    //DBUNIT METHODS END//
   
    @Test
    public void testGetCustomerCreditLimitNotExceeded() throws DaoException {
        Set<Customer> availableCustomers = customerDAO.getCustomersCreditLimitNotExceeded();
        
        int expected = 5;
        int actual = availableCustomers.size();
      
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetAllCustomers() throws DaoException {
        Set<Customer> allCustomers = customerDAO.getCustomersCreditLimitNotExceeded();
        
        int expected = 10;
        int actual = allCustomers.size();
      
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetCustomersWithUnpaidOrders() throws DaoException {
        Set<Customer> customersWithUnpaidAmount = customerDAO.getCustomersWithUnpaidOrders();
        
        int expected = 5;
        int actual = customersWithUnpaidAmount.size();
        
        assertEquals(expected, actual);
    }


}
