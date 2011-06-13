/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.OrderDao;
import java.io.FileInputStream;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

public class OrderDaoTest extends DBTestCase {

    public static final String INITIAL_DATABASE = "test/com/onb/orderingsystem/dao/jdbc/OrderDaoTest.xml";
    public static final String AFTER_INSERT = "test/com/onb/orderingsystem/dao/jdbc/OrderDaoTest_INSERT.xml";
    private OrderDao orderDao;

    public OrderDaoTest(String name) throws Exception {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://127.0.0.1/orderingsystem_test");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "");
        orderDao = new JdbcOrderDao(getConnection().getConnection());
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream(INITIAL_DATABASE));
    }
    
    @Override
    public DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.DELETE_ALL;
    }
    
    @Test
    public void testCreateOrder() {
        fail();
    }
    
    @Test
    public void testGetOrderByCustomerSortedByDescending() {
        fail();
    }
    
    @Test
    public void testUpdateOrder() {
        fail();
    }
}
