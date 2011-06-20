package com.onb.orderingsystem.dao;

import java.util.Set;

import com.onb.orderingsystem.domain.Customer;

public interface CustomerDao {
	
	public Set<Customer> getCustomersWithCreditLimitNotExceeded();
	
	public Set<Customer> getAllCustomers();
	
	public Set<Customer> getCustomersWithUnpaidOrders();
}
