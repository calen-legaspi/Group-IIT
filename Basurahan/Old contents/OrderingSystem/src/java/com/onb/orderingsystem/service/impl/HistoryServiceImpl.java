package com.onb.orderingsystem.service.impl;

import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.dao.DAOFactory;
import com.onb.orderingsystem.dao.DAOFactoryException;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.dao.OrderDao;
import com.onb.orderingsystem.dao.jdbc.JdbcDAOFactory;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.service.HistoryService;
import com.onb.orderingsystem.service.ServiceException;
import com.onb.orderingsystem.util.ApplicationEnvironment;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 */
public class HistoryServiceImpl implements HistoryService {
    private DAOFactory daoFactory;
    private CustomerDao customerDao;
    private OrderDao orderDao;
    
    /**
     * 
     * @throws DAOFactoryException 
     */
    public HistoryServiceImpl() throws DAOFactoryException {
        daoFactory = JdbcDAOFactory.getInstance(ApplicationEnvironment.PRODUCTION);
        customerDao = daoFactory.getCustomerDao();
        orderDao = daoFactory.getOrderDao();
    }

    /**
     * 
     * @return
     * @throws ServiceException 
     */
    @Override
    public Set<Customer> getCustomers() throws ServiceException {
        Set<Customer> customers = new LinkedHashSet<Customer>();
        
        try {
            customers = customerDao.getAllCustomers();
        } catch (DaoException e) {
            throw new ServiceException("Something went wrong while retrieving your data.");
        }
        
        return customers;
    }

    /**
     * 
     * @param customer
     * @return
     * @throws ServiceException
     * @throws IllegalArgumentException 
     */
    @Override
    public List<Order> getOrderHistoryByDateDescending(Customer customer) throws ServiceException, IllegalArgumentException {
        List<Order> orderHistoryByDateDescending = new LinkedList<Order>();
        
        try {
            orderHistoryByDateDescending = orderDao.getOrderByCustomerSortedByDateDescending(customer);
        } catch(DaoException e) {
            throw new ServiceException("Something went wrong while retrieving your data.");
        }
        
        return orderHistoryByDateDescending;
    }
    
}
