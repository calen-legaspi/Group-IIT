package com.onb.orderingsystem.domain;

import java.io.Serializable;

/**
 * This class represents an item in the inventory. An InventoryItem primarily
 * consists of the Product and its quantity.
 */
public class InventoryItem implements Serializable {

	private static final long serialVersionUID = 4580517874680957275L;
	private int id;
	private int quantity;
	private Product product;

	/**
	 * Creates an instance of a new InventoryItem, both parameters are required.
	 * 
	 * @param product
	 *            The Product to add to the inventory. Can't be changed.
	 * @param quantity
	 *            The quantity of the item to store in the inventory.
	 * @throws IllegalArgumentException
	 *             Throws this exception when the argument product is null.
	 */
	public InventoryItem(Product product, int quantity) throws IllegalArgumentException {
		if (product == null) {
			throw new IllegalArgumentException("Product can't be null.");
		}
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * Constructor for reconstructing an instance persisted into the database.
	 * 
	 * @param id
	 *            The id generated after inserting this into the database.
	 * @param product
	 *            The Product to add to the inventory. Can't be changed.
	 * @param quantity
	 *            The quantity of the item to store in the inventory.
	 * @throws IllegalArgumentException
	 *             Throws this exception when the argument
	 */
	public InventoryItem(int id, Product product, int quantity) {
		this(product, quantity);
		this.id = id;
	}

	/**
	 * @return The quantity of the InventoryItem
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return The Product object containing the name and amount of the product.
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Gets the unique and auto generated id of the Inventory Item.
	 * 
	 * @return the auto generated id of the inventory item.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the quantity of the inventory item to a specific amount.
	 * 
	 * @param quantity
	 *            Set The quantity of the InventoryItems to set this to.
	 */
	public void setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity cannot be less than zero.");
		}
		this.quantity = quantity;
	}

	/**
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof InventoryItem)) {
			throw new IllegalArgumentException("Parameter is not an InventoryItem");
		}
		InventoryItem invItem = (InventoryItem) o;
		if (invItem.getProduct().equals(this.getProduct())) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public int hashCode() {
		return product.hashCode();
	}

	/**
	 * 
	 * @return
	 */
	public String toString() {
		return product.toString() + " Qty:" + quantity;
	}

	/**
	 * 
	 * @param orderItem
	 * @throws DomainException if the product compared against this is not equals.
	 * @return
	 */
	public boolean isAvailable(OrderItem orderItem) throws DomainException {
		if(!isSameProduct(orderItem)) {
			throw new DomainException("Product "+orderItem.getProduct()+" cannot be compared to "+product);
		}
		return quantity >= orderItem.getQuantity();
	}
	
	/**
	 * 
	 * @param orderItem
	 * @return
	 */
	public boolean isSameProduct(OrderItem orderItem) {
		return orderItem.getProduct().equals(product);
	}

	/**
	 * 
	 * @param orderItem
	 * @throws DomainException if the attempted quantity deduction results to a negative quantity.
	 */
	public void removeQuantityByOrderItem(OrderItem orderItem) throws DomainException {
		if(!isAvailable(orderItem)) {
			throw new DomainException("Insufficient supply of "+orderItem.getProduct()+" requested "+orderItem.getQuantity()+" but available is "+quantity);
		}
		quantity -= orderItem.getQuantity();
	}
}
