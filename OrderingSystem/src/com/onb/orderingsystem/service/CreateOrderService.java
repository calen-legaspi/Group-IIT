package com.onb.orderingsystem.service;

import java.util.Set;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Inventory;
import com.onb.orderingsystem.domain.Order;

public interface CreateOrderService {
	public Order generateNewOrder();
	public Set<Customer> getCustomersWithCreditLimitNotExceeded();
	public Inventory getInventory();
	public void createOrder(Order order, Customer customer) throws ServiceException;
}
