package com.onb.orderingsystem.dao.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import com.onb.orderingsystem.dao.OrderDao;
import com.onb.orderingsystem.domain.Order;

public class JdbcOrderDao implements OrderDao {
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * @param jdbcTemplate
	 */
	public JdbcOrderDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @see OrderDao
	 */
	@Override
	public Order generateNewOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see OrderDao
	 */
	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

}
