package com.onb.shoppingcart.web.binder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class JdbcExtractorConverter {
	protected JdbcTemplate jdbcTemplate;

	@Autowired(required = true)
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
