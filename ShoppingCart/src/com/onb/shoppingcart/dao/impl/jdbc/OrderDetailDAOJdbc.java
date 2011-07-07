package com.onb.shoppingcart.dao.impl.jdbc;

import org.springframework.stereotype.Repository;

import com.onb.shoppingcart.dao.OrderDetailDAO;
import com.onb.shoppingcart.domain.OrderDetail;

@Repository("orderDetailDAO")
public class OrderDetailDAOJdbc extends AbstractDAOJdbc implements OrderDetailDAO {
	private static final String INSERT = "INSERT INTO order_details(id, order_id, product_id, quantity, unit_price) VALUES(?,?,?,?,?)";

	@Override
	public void create(OrderDetail orderDetail) {
		Object[] params = {orderDetail.getId(), orderDetail.getOrder().getId(), orderDetail.getProduct().getId(), orderDetail.getQuantity(), orderDetail.getUnitPrice()};
		synchronized (insertionLock) {
			getJdbcTemplate().update(INSERT, params);
			orderDetail.setId(getLastInsertId());
		}
	}

	@Override
	protected String getTableName() {
		return "order_details";
	}

}
