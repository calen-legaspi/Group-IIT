package com.onb.orderingsystem.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

public class CustomerDaoTest extends DBTestCase {

    public static final String INITIAL_DATABASE = "test/com/onb/orderingsystem/dao/CustomerDaoTest_INITIAL.xml";
    public static final String CREDITLIMITNOTEXCEEDED_DATABASE = "test/com/onb/orderingsystem/dao/CustomerDaoTest_CREDITLIMITNOTEXCEEDED.xml";
    public static final String UNPAID_DATABASE = "test/com/onb/orderingsystem/dao/CustomerDaoTest_UNPAID.xml";
    
    private IDataSet loadedDataSet;

    public CustomerDaoTest(String name) {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://127.0.0.1/orderingsystem_test");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "");
    }

    @Override
    protected IDataSet getDataSet() throws DataSetException, FileNotFoundException {
        loadedDataSet = null;
        loadedDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream(INITIAL_DATABASE));
        return loadedDataSet;
    }

    @Override
    public DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.DELETE_ALL;
    }

    @Test
    public void testGetCustomersCreditLimitNotExceeded() {
    }
    
    @Test
    public void testGetCustomersWithUnpaidOrders() {
    }
}
