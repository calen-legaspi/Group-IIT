package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.dao.InventoryItemDao;
import com.onb.orderingsystem.domain.InventoryItem;
import com.onb.orderingsystem.domain.Product;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Set;
import org.dbunit.Assertion;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

public class InventoryItemDaoTest extends DBTestCase {

    public static final String INITIAL_DATABASE = "test/com/onb/orderingsystem/dao/jdbc/InventoryItemDaoTest.xml";
    public static final String UPDATED_DATABASE = "test/com/onb/orderingsystem/dao/jdbc/InventoryItemDaoTest_UPDATED.xml";

    private InventoryItemDao inventoryItemDao;
    
    public InventoryItemDaoTest(String name) throws Exception {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://127.0.0.1/orderingsystem_test");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "");
        inventoryItemDao = new JdbcInventoryItemDao(getConnection().getConnection());
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
    public void testGetAvailableInventoryItems() throws DaoException {
        Set<InventoryItem> availableInventoryItems = inventoryItemDao.getAvailableInventoryItems();
        
        int expectedCount = 2;
        int actualCount = availableInventoryItems.size();
        
        assertEquals(expectedCount, actualCount);
    }
    
    @Test
    public void testUpdateInventoryItems() throws DaoException, Exception {
        //simulate update
        InventoryItem inventoryItem2 = new InventoryItem(2, new Product(2, "Product 2", new BigDecimal("10.00")), 15);
        InventoryItem inventoryItem4 = new InventoryItem(4, new Product(4, "Product 4", new BigDecimal("10.00")), 10);
        inventoryItemDao.updateInventoryItem(inventoryItem2);
        inventoryItemDao.updateInventoryItem(inventoryItem4);
        
        //from actual database after the update
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("inventory_items"); 
        
        //from the xml file
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File(UPDATED_DATABASE));
        ITable expectedTable = expectedDataSet.getTable("inventory_items");
        
        Assertion.assertEquals(expectedTable, actualTable);
    }
}
