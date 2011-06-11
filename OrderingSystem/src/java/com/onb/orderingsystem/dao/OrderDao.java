package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;
import java.util.List;

/**
 * Database CRUD for the Order object.
 */
public interface OrderDao {
    
    /**
     * Inserts a new Order into the database.
     * @param order the new order to insert.
     * @throws DaoException if something goes wrong with the persistence operation.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void createOrder(Order order) throws DaoException, IllegalArgumentException;
    
    /**
     * Updates the order in the database.
     * @param order the order with the changes to commit.
     * @throws DaoException if the persistence of the object fails.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void updateOrder(Order order) throws DaoException, IllegalArgumentException;
    
    /**
     * Returns an ordered list of orders from the customer parameter. 
     * The list is sorted by date in descending order.
     * @param customer the customer who owns the orders to query.
     * @return the ordered List of Orders from the customer.
     * @throws DaoException if something goes wrong while retrieving the values.
     * @throws IllegalArgumentException  if the parameter is null.
     */
    public List<Order> getOrderByCustomerSortedByDateDescending(Customer customer) throws DaoException, IllegalArgumentException;
}
