package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.Customer;
import java.util.Set;

/**
 * Database CRUD for the Customer object.
 */
public interface CustomerDAO {
    
    /**
     * Gets all customers who's unpaid orders have not yet exceeded/reached their credit limit.
     * @return the Set of Customers who's orders have not yet exceeded their credit limit. 
     * @throws DAOException if something goes wrong with the retrieval of data.
     */
    public Set<Customer> getCustomersCreditLimitNotExceeded() throws DAOException;
    
    /**
     * Gets all customers with unpaid orders.
     * @return the Set of Customers with unpaid orders.
     * @throws DAOException if something goes wrong with the retrieval of data.
     */
    public Set<Customer> getCustomersWithUnpaidOrders() throws DAOException;
    
    /**
     * Gets all the customers from the database.
     * @return The Set of Customers stored in the database.
     * @throws DAOException if something goes wrong with the data retrieval.
     */
    public Set<Customer> getAllCustomers() throws DAOException;
}
