package com.onb.orderingsystem.dao.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import com.onb.orderingsystem.dao.OrderItemDao;
import com.onb.orderingsystem.domain.OrderItem;

public class JdbcOrderItemDao implements OrderItemDao {
	private final JdbcTemplate jdbcTemplate;
	
	public JdbcOrderItemDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void createOrderItem(OrderItem orderItem) {
		
	}

}
