package com.onb.orderingsystem.dao.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import com.onb.orderingsystem.dao.InventoryDao;
import com.onb.orderingsystem.domain.Inventory;

public class JdbcInventoryDao implements InventoryDao {
	private final JdbcTemplate jdbcTemplate;
	
	public JdbcInventoryDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Inventory getInventory() {
		
		return null;
	}

	@Override
	public void updateInventory(Inventory inventory) {
		
	}

}
