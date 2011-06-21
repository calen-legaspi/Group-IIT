package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.Order;

public interface OrderDao {

	public Order generateNewOrder();
	
	public void updateOrder(Order order);
	
}
