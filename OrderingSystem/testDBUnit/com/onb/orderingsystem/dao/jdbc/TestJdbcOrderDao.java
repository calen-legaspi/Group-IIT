package com.onb.orderingsystem.dao.jdbc;

import static org.junit.Assert.*;

import java.io.FileInputStream;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.onb.orderingsystem.dao.OrderDao;

public class TestJdbcOrderDao extends DatabaseTestCase {
	
	public static final String INITIAL_DATABASE = "test/com/onb/orderingsystem/dao/jdbc/CustomerDaoTest.xml";
	
	private OrderDao orderDao;
	
	//DB UNIT STUFFS
	
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		return new DatabaseConnection(applicationContext.getBean("testDataSource", DriverManagerDataSource.class).getConnection());
	}
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream(INITIAL_DATABASE));
	}

	@Override
    public DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.DELETE_ALL;
    }

	//ACTUAL TESTS
	
	/**
	 * 
	 */
	@Test
	public void testGenerateNewOrder() {
		fail("Not yet implemented");
	}

	/**
	 * 
	 */
	@Test
	public void testUpdateOrder() {
		fail("Not yet implemented");
	}
	
}
