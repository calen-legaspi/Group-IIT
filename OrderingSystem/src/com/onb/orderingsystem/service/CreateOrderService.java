package com.onb.orderingsystem.service;

import java.util.Set;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Inventory;
import com.onb.orderingsystem.domain.Order;

public interface CreateOrderService {
	
	/**
	 * Generates a new order with a new serial number in it.
	 * @return an empty order with a serial number.
	 */
	public Order generateNewOrder();
	
	/**
	 * Fetches all customers who are available for a new order.
	 * This refers to customers who have not yet reached their credit limit.
	 * @return the set of customers who have not reached their credit limit.
	 */
	public Set<Customer> getCustomersWithCreditLimitNotExceeded();
	
	/**
	 * Returns an instance of the inventory.
	 * A table was created to accommodate one row. Which is lame.
	 * This could be lame, but maybe in the near future inventories should be added.
	 * @return the one and only instance of the Inventory.
	 */
	public Inventory getInventory();
	
	/**
	 * Updates the previously created order.
	 * Checks if the order is valid.
	 * Deduct the item from the inventory.
	 * Converts the status of the order to UNPAID. 
	 * Roll back if necessary, then throw a ServiceException. 
	 * 
	 * @param order the relatively new order.
	 * @param customer the customer to make the order.
	 * @param inventory to be updated.
	 * @throws ServiceException if the transaction failed.
	 */
	public void createOrder(Order order, Customer customer, Inventory inventory) throws ServiceException;
}
