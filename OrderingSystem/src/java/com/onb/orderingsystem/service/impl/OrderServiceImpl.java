package com.onb.orderingsystem.service.impl;

import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.dao.DAOFactory;
import com.onb.orderingsystem.dao.DAOFactoryException;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.dao.InventoryItemDao;
import com.onb.orderingsystem.dao.OrderDao;
import com.onb.orderingsystem.dao.jdbc.JdbcDAOFactory;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.InventoryItem;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.service.OrderService;
import com.onb.orderingsystem.service.ServiceException;
import com.onb.orderingsystem.util.ApplicationEnvironment;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * 
 */
public class OrderServiceImpl implements OrderService {
    private DAOFactory daoFactory;
    private CustomerDao customerDao;
    private OrderDao orderDao;
    private InventoryItemDao inventoryItemDao;
    
    /**
     * Creates a new instance of an OrderServiceImpl.
     * @throws DAOFactoryException if the database connection failed to open
     */
    public OrderServiceImpl() throws DAOFactoryException {
        daoFactory = JdbcDAOFactory.getInstance(ApplicationEnvironment.PRODUCTION);
        customerDao = daoFactory.getCustomerDao();
        orderDao = daoFactory.getOrderDao();
        inventoryItemDao = daoFactory.getInventoryItemDao();
    }

    /**
     * Retrieves the set of all available customers.
     * Available customers refers to customers who have not exceeded their credit limit.
     * @return the Set of customers who have not exceeded their credit limit.
     * @throws ServiceException if something goes wrong while retrieving the Set.
     */
    @Override
    public Set<Customer> getAvailableCustomers() throws ServiceException {
        Set<Customer> availableCustomers = new LinkedHashSet<Customer>();
        
        try {
            availableCustomers = customerDao.getCustomersCreditLimitNotExceeded();
        } catch (DaoException e) {
            throw new ServiceException("I dont know what the heck happened here!");
        }
        
        return availableCustomers;
    }

    /**
     * Retrieves the Set of available InventoryItems.
     * Available InventoryItems refer to InventoryItems whose 
     * @return
     * @throws ServiceException 
     */
    @Override
    public Set<InventoryItem> getAvailableInventoryItems() throws ServiceException {
        Set<InventoryItem> availableInventoryItems = new LinkedHashSet<InventoryItem>();
        
        try {
            availableInventoryItems = inventoryItemDao.getAvailableInventoryItems();
        } catch (DaoException e) {
            throw new ServiceException("I dont know what the heck happened here!");
        }
        
        return availableInventoryItems;
    }

    /**
     * 
     * @param order
     * @param customer
     * @throws ServiceException
     * @throws IllegalArgumentException 
     */
    @Override
    public void createOrder(Order order, Customer customer) throws ServiceException, IllegalArgumentException {
        //TODO: evaluate if the new order is valid.
        
    }
    
}
