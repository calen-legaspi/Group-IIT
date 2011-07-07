package com.onb.shoppingcart.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.onb.shoppingcart.domain.exception.DomainException;
import com.onb.shoppingcart.domain.exception.InvalidQuantityException;

@SuppressWarnings("serial")
public class OrderDetail implements Serializable {
	private int id;
	private BigDecimal unitPrice = BigDecimal.ZERO;
	private int quantity;
	private Product product;
	private Order order;
	
	public OrderDetail() {
		super();
	}

	public OrderDetail(int id, BigDecimal unitPrice, int quantity, Product product, Order order) {
		super();
		this.id = id;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public BigDecimal getSubtotal() {
		return unitPrice.multiply(new BigDecimal(quantity));
	}

	public void setQuantity(int quantity) throws DomainException {
		if(quantity<0) {
			throw new InvalidQuantityException("Order Detail containing "+product+" was set to an invalid quantity:"+quantity);
		}
		this.quantity += quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
		if (obj == null || !(obj instanceof OrderDetail)) {
			return false;
		}
		OrderDetail other = (OrderDetail) obj;
		if (id == 0 && other.id == 0) {
			return product.equals(other.product);
		}
		return id == other.id;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", product=" + product
				+ ", order=" + order + "]";
	}
	
	public void remove(int quantity) {
		this.quantity -= quantity;
	}
	
	public void clear() {
		this.quantity = 0;
	}
}
