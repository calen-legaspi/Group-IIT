package com.onb.orderingsystem.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

public class CustomerDaoTest extends DBTestCase {

    private IDataSet loadedDataSet;
    
    public CustomerDaoTest() {
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://127.0.0.1:3306/orderingsystem_test" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
    }

    @Override
    protected IDataSet getDataSet() throws DataSetException,FileNotFoundException {
        loadedDataSet = null;
        loadedDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("test/com/onb/orderingsystem/dao/CustomerDaoTest_INITIAL.xml"));
        return loadedDataSet;
    }
}
