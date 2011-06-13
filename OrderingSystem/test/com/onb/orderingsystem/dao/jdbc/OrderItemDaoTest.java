/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import java.io.FileInputStream;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import com.onb.orderingsystem.dao.OrderItemDao;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

public class OrderItemDaoTest extends DBTestCase {
    
    public static final String INITIAL_DATABASE = "test/com/onb/orderingsystem/dao/jdbc/OrderItemDaoTest.xml";
    private OrderItemDao orderItemDao;
    
    public OrderItemDaoTest(String name) throws Exception {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://127.0.0.1/orderingsystem_test");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "");
        orderItemDao = new JdbcOrderItemDao(getConnection().getConnection());
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
    public void testCreateOrderItem() {
        
    }
    
}
