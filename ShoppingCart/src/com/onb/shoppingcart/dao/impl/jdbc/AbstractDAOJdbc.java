package com.onb.shoppingcart.dao.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDAOJdbc {
	private JdbcTemplate jdbcTemplate;
	/**
	 * All synchronizing methods for create should use this as a lock.
	 */
	protected Object insertionLock = new Object();

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired(required = true)
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * Retrieves the last inserted id.
	 * Use this for the create methods to update the object's id.
	 * @return
	 */
	protected int getLastInsertId() {
		return getJdbcTemplate().queryForInt("SELECT MAX(id) FROM "+getTableName());
	}
	
	protected abstract String getTableName();
}
