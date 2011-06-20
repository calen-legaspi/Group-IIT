package com.onb.orderingsystem.service;

import java.util.Set;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.Order;

public interface PaymentService {
	
	public Set<Customer> getCustomersWithUnpaidOrders();
	
	public void payForOrder(Order order);
}
