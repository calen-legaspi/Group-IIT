package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.domain.Customer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Set;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

public class CustomerDaoTest extends DBTestCase {

    public static final String INITIAL_DATABASE = "test/com/onb/orderingsystem/dao/jdbc/CustomerDaoTest.xml";
    private CustomerDao customerDao;

    public CustomerDaoTest(String name) throws Exception {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://127.0.0.1/orderingsystem_test");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "");
        customerDao = new JdbcCustomerDao(getConnection().getConnection());
    }

    @Override
    protected IDataSet getDataSet() throws DataSetException, FileNotFoundException {
        return new FlatXmlDataSetBuilder().build(new FileInputStream(INITIAL_DATABASE));
    }

    @Override
    public DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.DELETE_ALL;
    }

    @Test
    public void testGetCustomersCreditLimitNotExceeded() throws DaoException {
        Set<Customer> customersWithCreditLimitNotExceeded = new LinkedHashSet<Customer>();
        customersWithCreditLimitNotExceeded = customerDao.getCustomersCreditLimitNotExceeded();

        int actualCount = customersWithCreditLimitNotExceeded.size();
        int expectedCount = 5;

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testGetCustomersWithUnpaidOrders() throws DaoException {
        Set<Customer> customersWithUnpaidOrders = new LinkedHashSet<Customer>();
        customersWithUnpaidOrders = customerDao.getCustomersWithUnpaidOrders();

        int actualCount = customersWithUnpaidOrders.size();
        int expectedCount = 4;

        assertEquals(expectedCount, actualCount);
    }
}
