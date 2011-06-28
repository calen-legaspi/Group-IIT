package com.onb.shoppingcart.domain;

import java.math.BigDecimal;
import java.util.Set;

public class Order {
	private int id;
	private BigDecimal amount;
	private User user;
	private Set<OrderDetail> orderDetails;
}
