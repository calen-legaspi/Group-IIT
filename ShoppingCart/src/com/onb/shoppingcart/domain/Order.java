package com.onb.shoppingcart.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.onb.shoppingcart.domain.exception.DomainException;

@SuppressWarnings("serial")
public class Order implements Serializable {
	private int id;
	private BigDecimal amount = BigDecimal.ZERO;
	private User user;
	private List<OrderDetail> orderDetails = new LinkedList<OrderDetail>();
	
	public Order() {
		super();
	}

	public Order(int id, BigDecimal amount, User user, List<OrderDetail> orderDetails) {
		super();
		this.id = id;
		this.amount = amount;
		this.user = user;
		this.orderDetails = orderDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	/**
	 * Adds an order detail to the order.
	 * If the order already contains the product, only the quantity will be augmented.
	 * @param product
	 * @param quantity
	 * @throws DomainException 
	 */
	public void setOrderDetail(OrderDetail orderDetail) throws DomainException {
		if(!orderDetails.contains(orderDetail)) {
			orderDetails.add(orderDetail);
		}
	}
	
	/**
	 * Remove the entirety of the order details.
	 * @param orderDetail
	 */
	public void removeOrderDetail(OrderDetail orderDetail) {
		orderDetails.remove(orderDetail);
	}
	
	public BigDecimal getTotalAmount() {
		BigDecimal total = BigDecimal.ZERO;
		for(OrderDetail od: orderDetails) {
			total = total.add(od.getSubtotal());
		}
		amount = total;
		return total;
	}
	
	/**
	 * Empties the list of order details.
	 */
	public void clearOrderDetails() {
		for(OrderDetail orderDetail: orderDetails) {
			orderDetail.clear();
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Order)) {
			return false;
		}
		Order other = (Order) obj;
		if (id == 0 && other.id == 0) {
			return amount.equals(other.amount) && orderDetails.equals(other.orderDetails);
		}
		return id == other.id;
	}
	
	
}
