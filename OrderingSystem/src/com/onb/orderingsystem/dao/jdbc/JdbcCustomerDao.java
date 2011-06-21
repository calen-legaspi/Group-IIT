package com.onb.orderingsystem.dao.jdbc;

import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.domain.Customer;

public class JdbcCustomerDao implements CustomerDao {
	private final JdbcTemplate jdbcTemplate;
	
	public JdbcCustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

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
