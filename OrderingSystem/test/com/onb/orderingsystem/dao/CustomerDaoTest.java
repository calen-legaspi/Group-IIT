package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.dao.jdbc.JdbcDAOFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dbunit.dataset.IDataSet;
import java.util.Set;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.util.ApplicationEnvironment;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.junit.Test;

public class CustomerDaoTest extends DBTestCase {
    private CustomerDao customerDAO;
    
    //DBUNIT METHODS START//
    
    public CustomerDaoTest(String name) {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,"com.mysql.jdbc");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,"jdbc:m");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,"com.mysql.jdbc");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,"com.mysql.jdbc");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA,"");
        
    }
    
    @Override
    protected IDataSet getDataSet() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
    //DBUNIT METHODS END//
   
    @Test
    public void testGetCustomerCreditLimitNotExceeded() throws DaoException {
        //ApplicationEnvironment x = ApplicationEnvironment.TEST;
        
        
    }
    
   
}
