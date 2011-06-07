package com.onb.orderingsystem.domain;

/**
 * @author The Architect
 * @version 1.0
 * @created 07-Jun-2011 8:42:58 AM
 */
import java.math.BigDecimal;

/**
 * OrderItems represent the items included in the Order.
 * Duplication check is done through Product comparison, 
 * So no two OrderItems with the same Product can exist on the same Set.
 */
public class OrderItem {

	private int quantity;
	private Product product;
	
	/**
	 * @param product
	 * @param quantity
	 * @throws IllegalArgumentException Throws this exception when the product parameter is null.
	 */
	public OrderItem(Product product, int quantity) throws IllegalArgumentException {
		if(product == null) {
			throw new IllegalArgumentException("The product cant be null.");
		}
		this.product = product;
		this.quantity = quantity;
	}
	
	/**
	 * Sets the quantity of the OrderItem to the specified argument.
	 * @param quantity The new quantity of the ordered item.
	 * @throws IllegalArgumentException Throws this exception when the argument is less than zero.
	 */
	public void setQuantity(int quantity) throws IllegalArgumentException {
		if(quantity < 0) {
			throw new IllegalArgumentException("Quantity cant be less than zero.");
		}
		this.quantity = quantity;
	}
	
	/**
	 * Computes and returns the amount of this order item,
	 * by multiplying the quantity and the product price.	
	 * @return
	 */
	public BigDecimal getAmount() {
		throw new UnsupportedOperationException("Not yet implemented.");
	}
}
