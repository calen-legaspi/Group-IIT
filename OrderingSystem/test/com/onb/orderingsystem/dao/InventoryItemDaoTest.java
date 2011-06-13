package com.onb.orderingsystem.dao;

import java.io.FileInputStream;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

public class InventoryItemDaoTest extends DBTestCase {

    public static final String INITIAL_DATABASE = "test/com/onb/orderingsystem/dao/InventoryItemDaoTest_INITIAL.xml";
    private IDataSet loadedDataSet;

    public InventoryItemDaoTest(String name) {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://127.0.0.1/orderingsystem_test");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "");
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        loadedDataSet = null;
        loadedDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream(INITIAL_DATABASE));
        return loadedDataSet;
    }

    @Override
    public DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.DELETE_ALL;
    }

    @Test
    public void testSomething() {
    }
}
