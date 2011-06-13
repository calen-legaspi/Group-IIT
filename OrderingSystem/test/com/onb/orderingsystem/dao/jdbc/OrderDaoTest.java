package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.dao.OrderDao;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.DiscountStatus;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.domain.OrderItem;
import com.onb.orderingsystem.domain.OrderStatus;
import com.onb.orderingsystem.domain.Product;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

public class OrderDaoTest extends DBTestCase {

    public static final String INITIAL_DATABASE = "test/com/onb/orderingsystem/dao/jdbc/OrderDaoTest.xml";
    public static final String AFTER_INSERT = "test/com/onb/orderingsystem/dao/jdbc/OrderDaoTest_INSERT.xml";
    public static final String AFTER_UPDATE = "test/com/onb/orderingsystem/dao/jdbc/OrderDaoTest_UPDATE.xml";
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
    
    /**
    @Test
    public void testCreateOrder() throws DaoException, Exception {
        OrderItem newOrderItem = new OrderItem(9, new Product(3, "Product 3", new BigDecimal("60.00")), 3);
        Customer customer = new Customer(6, "Customer 6", new LinkedHashSet<Order>());
        Order newOrder = new Order(7, new Date(), new LinkedHashSet<OrderItem>(), OrderStatus.PROCESSING, DiscountStatus.NO_DISCOUNT, new BigDecimal("180.00"));
        
        newOrder.setCustomer(customer);
        newOrder.addOrderItem(newOrderItem);
        newOrder.setOrderStatus(OrderStatus.UNPAID);
        orderDao.createOrder(newOrder);
        
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("orders");
        
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File(AFTER_INSERT));
        ITable expectedTable = expectedDataSet.getTable("orders");
        
        Assertion.assertEquals(expectedTable, actualTable);
    }
    
    @Test
    public void testGetOrderByCustomerSortedByDescending() {
        fail();
    }
    **/
    @Test
    public void testUpdateOrder() throws DaoException, Exception {
        Order orderToUpdate = new Order(5, new Date(), new LinkedHashSet<OrderItem>(), OrderStatus.PAID, DiscountStatus.NO_DISCOUNT, new BigDecimal("2180.00"));
        orderDao.updateOrder(orderToUpdate);
        
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("orders");
        
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File(AFTER_UPDATE));
        ITable expectedTable = expectedDataSet.getTable("orders");
        
        Assertion.assertEquals(expectedTable, actualTable);
    }
}
