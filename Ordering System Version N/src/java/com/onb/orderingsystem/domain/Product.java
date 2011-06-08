package com.onb.orderingsystem.domain;

/**
 * @author The Architect
 * @version 1.0
 * @created 07-Jun-2011 8:48:45 AM
 */
import java.math.BigDecimal;

/**
 * Represents a product with its current price on it.
 */
public class Product {

	private int skuNumber;
	private String name;
	private BigDecimal amount;
	
	/**
	 * Default constructor requires all three parameters.
	 * @param skuNumber A unique identifier of the Product.
	 * @param name The name of the Product.
	 * @param amount The unit price of the Product.
	 */
	public Product(int skuNumber, String name, BigDecimal amount) throws IllegalArgumentException {
		if(name == null || name.equals("") || amount == null || amount.compareTo(BigDecimal.ZERO) >= 0) {
			throw new IllegalArgumentException("One of the parameter is null or contains an illegal value.");
		}
		this.skuNumber = skuNumber;
		this.name = name;
		this.amount = amount;
	}
	
	/**
	 * Sets the unit price/amount of the product.
	 * @param amount The new unit price that you want to change this amount into.
	 * @throws IllegalArgumentException Throws this exception when the parameter is null, zero, or negative.
	 */
	public void setAmount(BigDecimal amount) throws IllegalArgumentException {
		if(amount == null || amount.compareTo(BigDecimal.ZERO) >= 0) {
			throw new IllegalArgumentException("Amount cant be null, zero, or negative.");
		}
		this.amount = amount;
	}

	/**
	 * @param name The new name of the product.
	 * @throws IllegalArgumentException Throws this exception when the parameter is empty/null.
	 */
	public void setName(String name) throws IllegalArgumentException {
		if(name == null || name.equals("")) {
			throw new IllegalArgumentException("Name cant be null or empty.");
		}
		this.name = name;
	}
	
	/**
	 * @return The stock-keeping unit number. This uniquely identifies a product. Equality operations are dependent on this.
	 */
	public int getSkuNumber() {
		return skuNumber;
	}
	
	/**
	 * @return The product name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return The amount (price per unit) of the product.
	 */
	public BigDecimal getAmount() {
		return amount;
	}
}
