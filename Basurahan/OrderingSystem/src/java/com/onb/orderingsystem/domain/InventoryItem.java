package com.onb.orderingsystem.domain;

/**
 * @author The Architect
 * @version 1.0
 * @created 07-Jun-2011 8:45:52 AM
 */
/**
 * This class represents an item in the inventory. 
 * An InventoryItem primarily consists of the Product and its quantity.
 */
public class InventoryItem {

	private int quantity;
	private Product product;
	
	/**
	 * Creates an instance of a new InventoryItem, both parameters are required.
	 * @param product The Product to add to the inventory. Can't be changed.
	 * @param quantity The quantity of the item to store in the inventory.
	 * @throws IllegalArgumentException Throws this exception when the argument product is null.
	 */
	public InventoryItem(Product product, int quantity) throws IllegalArgumentException {
		if(product == null) {
			throw new IllegalArgumentException("Product can't be null.");
		}
		this.product = product;
		this.quantity = quantity;
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
	 * Sets the quantity of the inventory item to a specific amount.
	 * @param quantity Set The quantity of the InventoryItems to set this to.
	 * @exception IllegalArgumentException Throws this exception when the quantity is less than zero.
	 */
	public void setQuantity(int quantity) throws IllegalArgumentException {
		if(quantity<0) {
			throw new IllegalArgumentException("Quantity cannot be less than zero.");
		}
		this.quantity = quantity;
	}
}
