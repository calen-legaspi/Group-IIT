package com.onb.shoppingcart.dao.impl.jdbc;

import org.springframework.stereotype.Repository;

import com.onb.shoppingcart.dao.OrderDAO;
import com.onb.shoppingcart.domain.Order;

@Repository("orderDAO")
public class OrderDAOJdbc extends AbstractDAOJdbc implements OrderDAO {
	private static final String INSERT = "INSERT INTO orders(user_id, amount) VALUES(?,?)";

	@Override
	public void create(Order order) {
		Object[] params = {order.getUser().getId(), order.getAmount()};
		synchronized (insertionLock) {
			getJdbcTemplate().update(INSERT, params);
			order.setId(getLastInsertId());
		}
	}

	@Override
	protected String getTableName() {
		return "orders";
	}
	
}
