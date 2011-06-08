package com.onb.orderingsystem.domain;

import java.math.BigDecimal;

/**
 * @author The Architect
 * @version 1.0
 * @created 07-Jun-2011 10:43:56 AM
 */
 /**
  * A constant representing a discount status of an order.
  * Orders by default shall have no discount.
  * Customers who have already paid more than/equal to 1 Million Php shall have a 10% discount for the current order.
  * An Order shall indicate if it is discounted using this enum.
  */
public enum DiscountStatus {
	
	NO_DISCOUNT(new BigDecimal("0.00")),
	TEN_PERCENT(new BigDecimal("0.10"));

	private BigDecimal discountRate;
	
	DiscountStatus(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}
	
	public BigDecimal applyDiscount(BigDecimal originalAmount) {
		return originalAmount.subtract(originalAmount.multiply(discountRate));
	}
}