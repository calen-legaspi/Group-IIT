package com.onb.shoppingcart.domain;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class Product implements Serializable {
	private int id;
	private String name;
	private int quantity;
	private BigDecimal unitPrice = BigDecimal.ZERO;
	private Category category;

	public Product() {
		super();
	}
	
	public Product(int id) {
		this();
		this.id = id;
	}

 	public Product(int id, String name, int quantity, BigDecimal unitPrice, Category category) {
 		this(id);
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity to the parameter's value if the quantity is greater than zero. 
	 * Otherwise the quantity is set to zero.
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity>0?quantity:0;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		if (obj == null || !(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		if (id == 0 && other.id == 0) {
			return name.equals(other.name) && category.equals(other.category);
		}
		return id == other.id;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
