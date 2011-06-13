package com.onb.orderingsystem.service.impl;

import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.dao.DAOFactory;
import com.onb.orderingsystem.dao.DAOFactoryException;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.dao.OrderDao;
import com.onb.orderingsystem.dao.jdbc.JdbcDAOFactory;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.domain.OrderStatus;
import com.onb.orderingsystem.service.PaymentService;
import com.onb.orderingsystem.service.ServiceException;
import com.onb.orderingsystem.util.ApplicationEnvironment;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class PaymentServiceImpl implements PaymentService {
    private DAOFactory daoFactory;
    private CustomerDao customerDao;
    private OrderDao orderDao;
    
    public PaymentServiceImpl() throws DAOFactoryException {
        daoFactory = JdbcDAOFactory.getInstance(ApplicationEnvironment.PRODUCTION);
        customerDao = daoFactory.getCustomerDao();
        orderDao = daoFactory.getOrderDao();
    }
    
    @Override
    public Set<Customer> getCustomersWithCredit() throws ServiceException {
        Set<Customer> customersWithCredit = new LinkedHashSet<Customer>();
        
        try {
            customersWithCredit = customerDao.getCustomersWithUnpaidOrders();
        } catch (DaoException e) {
            throw new ServiceException("Something went wrong!");
        }
        
        return customersWithCredit;
    }

    @Override
    public Set<Order> getUnpaidOrders(Customer customer) throws ServiceException, IllegalArgumentException {
        Set<Order> unpaidOrders = new LinkedHashSet<Order>();
        
        for(Order o: customer.getOrders()) {
            if(o.getOrderStatus() == OrderStatus.UNPAID) {
                unpaidOrders.add(o);
            }
        }
        
        return unpaidOrders;
    }

    @Override
    public void payFor(Order order) throws ServiceException, IllegalArgumentException {
        order.setOrderStatus(OrderStatus.PAID);
        try {
            orderDao.updateOrder(order);
        } catch (DaoException ex) {
            throw new ServiceException("Something went very wrong!");
        }
    }
    
}
