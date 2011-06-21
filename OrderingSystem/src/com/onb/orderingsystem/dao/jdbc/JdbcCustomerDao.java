package com.onb.orderingsystem.dao.jdbc;

import java.util.Set;

import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.domain.Customer;

public class JdbcCustomerDao implements CustomerDao {

	@Override
	public Set<Customer> getCustomersWithCreditLimitNotExceeded() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Customer> getCustomersWithUnpaidOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
