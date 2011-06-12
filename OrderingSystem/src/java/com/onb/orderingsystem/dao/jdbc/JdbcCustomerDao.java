package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDao;
import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.domain.OrderItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Implementation of the CustomerDao interface.
 * @see com.onb.orderingsystem.dao.CustomerDao
 * @see com.onb.orderingsystem.dao.AbstractDao
 */
public class JdbcCustomerDao extends AbstractDao implements CustomerDao {
    
    /**
     * @see java.sql.Connection
     * @param connection 
     * @throws IllegalArgumentException if the connection is null.
     */
    public JdbcCustomerDao(Connection connection) throws IllegalArgumentException {
        super(connection);
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDao
     * @return
     * @throws DaoException 
     */
    @Override
    public Set<Customer> getCustomersCreditLimitNotExceeded() throws DaoException {
        Set<Customer> customersCreditLimitNotExceeded = new LinkedHashSet<Customer>();
        Set<Customer> allCustomers = getAllCustomers();
        
        for(Customer c: allCustomers) {
            if(c.isCreditLimitNotExceeded()) {
                customersCreditLimitNotExceeded.add(c);
            }
        }
        
        return customersCreditLimitNotExceeded;
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDao
     * @return
     * @throws DaoException 
     */
    @Override
    public Set<Customer> getCustomersWithUnpaidOrders() throws DaoException {
        Set<Customer> customersWithUnpaidOrders = new LinkedHashSet<Customer>();
        Set<Customer> allCustomers = getAllCustomers();
        
        for(Customer c:allCustomers) {
            if(c.hasUnpaidOrders()) {
                customersWithUnpaidOrders.add(c);
            }
        }
        
        return customersWithUnpaidOrders;
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDao
     * @return
     * @throws DaoException 
     */
    @Override
    public Set<Customer> getAllCustomers() throws DaoException {
        Set<Customer> allCustomers = new LinkedHashSet<Customer>();
        String customerQueryAll = "SELECT * FROM customers";
        
        try {
            Statement select = connection.createStatement();
            ResultSet result = select.executeQuery(customerQueryAll);
            while(!result.isAfterLast()) {
                Customer c = new Customer(result.getInt("id"), result.getNString("name"), new LinkedHashSet<Order>());
                allCustomers.add(c);
            }
        } catch (SQLException e) {
            throw new DaoException("Query failed.");
        }
        
        return allCustomers;
    }
    
    private void restoreOrdersForCustomer(Customer c) {
        
    }
    
    private void restoreOrderItemsForOrder(Order o) {
        
    }
    
    private void restoreProductForOrderItems(OrderItem oi) {
        
    }
    
}
