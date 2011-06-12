package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.domain.*;
import com.onb.orderingsystem.dao.*;
import com.onb.orderingsystem.util.ApplicationEnvironment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * This implementation 
 * @see com.onb.orderingsystem.dao.DAOFactory
 */
public class JdbcDAOFactory implements DAOFactory {
    private static DAOFactory instance;
    
    private Map<Class,Object> daoInstances;
    private Connection connection;
    
    private JdbcDAOFactory(ApplicationEnvironment env) throws DAOFactoryException {
        daoInstances = new HashMap<Class, Object>();
        try {
            connection = DriverManager.getConnection("jdbc:"+env.dbConnectionDriver+"://"+env.dbUrl+":/"+env.dbName,env.dbUsername,env.dbPassword);
        } catch(SQLException e) {
            throw new DAOFactoryException("Failed to establish connection to the database server.");
        }
    }
    
    /**
     * 
     * @param env
     * @return
     * @throws DAOFactoryException 
     */
    public static DAOFactory getInstance(ApplicationEnvironment env) throws DAOFactoryException {
        if(instance == null) {
            instance = new JdbcDAOFactory(env);
        }
        return instance;
    }

    /**
     * 
     * @return 
     */
    @Override
    public CustomerDao getCustomerDao() {
        if(!daoInstances.containsKey(Customer.class)) {
            daoInstances.put(Customer.class, new JdbcCustomerDao(connection));
        }
        return (CustomerDao)daoInstances.get(Customer.class);
    }

    /**
     * 
     * @return 
     */
    @Override
    public InventoryItemDao getInventoryItemDao() {
        if(!daoInstances.containsKey(InventoryItem.class)) {
            daoInstances.put(InventoryItem.class, new JdbcInventoryItemDao(connection));
        }
        return (InventoryItemDao)daoInstances.get(InventoryItem.class);
    }

    /**
     * 
     * @return 
     */
    @Override
    public OrderDao getOrderDao() {
        if(!daoInstances.containsKey(Order.class)) {
            daoInstances.put(Order.class, new JdbcOrderDao(connection));
        }
        return (OrderDao)daoInstances.get(Order.class);
    }

    /**
     * 
     * @return 
     */
    @Override
    public OrderItemDao getOrderItemDao() {
        if(!daoInstances.containsKey(OrderItem.class)) {
            daoInstances.put(OrderItem.class, new JdbcOrderItemDao(connection));
        }
        return (OrderItemDao)daoInstances.get(OrderItem.class);
    }
    
}
