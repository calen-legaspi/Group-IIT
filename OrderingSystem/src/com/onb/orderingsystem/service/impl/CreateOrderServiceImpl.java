package com.onb.orderingsystem.service.impl;

import java.util.Set;

import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.dao.InventoryDao;
import com.onb.orderingsystem.dao.OrderDao;
import com.onb.orderingsystem.dao.OrderItemDao;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Inventory;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.service.CreateOrderService;
import com.onb.orderingsystem.service.ServiceException;

/**
 * @see CreateOrderService
 */
public class CreateOrderServiceImpl implements CreateOrderService {

	private final CustomerDao customerDao;
	private final OrderDao orderDao;
	private final InventoryDao inventoryDao;
	private final OrderItemDao orderItemDao;
	
	public CreateOrderServiceImpl(CustomerDao customerDao, OrderDao orderDao, InventoryDao inventoryDao, OrderItemDao orderItemDao) {
		this.customerDao = customerDao;
		this.orderDao = orderDao;
		this.inventoryDao = inventoryDao;
		this.orderItemDao = orderItemDao;
	}

	/**
	 * @see CreateOrderService
	 */
	@Override
	public Order generateNewOrder() {
		synchronized (orderDao) {
			return orderDao.generateNewOrder();
		}
	}

	/**
	 * @see CreateOrderService
	 */
	@Override
	public Set<Customer> getCustomersWithCreditLimitNotExceeded() {
		synchronized (customerDao) {
			return customerDao.getCustomersWithCreditLimitNotExceeded();
		}
	}

	/**
	 * @see CreateOrderService
	 */
	@Override
	public Inventory getInventory() {
		synchronized (inventoryDao) {
			return inventoryDao.getInventory();
		}
	}

	/**
	 * @see CreateOrderService
	 */
	@Override
	public void createOrder(Order order, Customer customer, Inventory inventory) throws ServiceException {
		// TODO Auto-generated method stub
	}


}
