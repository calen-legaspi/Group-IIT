package com.onb.shoppingcart.domain;

import java.math.BigDecimal;

public class OrderDetail {
	private int id;
	private BigDecimal unitPrice;
	private int quantity;
	private Product product;
	private Order order;
}
