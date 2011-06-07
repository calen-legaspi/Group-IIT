package com.onb.orderingsystem.domain;

/**
 * @author The Architect
 * @version 1.0
 * @created 07-Jun-2011 8:50:24 AM
 */
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class represents an inventory to contain the inventory items of a certain warehouse, storage area, etc.
 */
public class Inventory {

	private int id;
	private Set<InventoryItem> inventoryItems;

	/**
	 * Default constructor. No big deal.
	 */
	public Inventory() {
		this.inventoryItems = new LinkedHashSet<InventoryItem>();
	}
	
	/**
	 * This constructor will serve its purpose on reconstruction of a persisted instance.
	 * @param inventoryItems The Set of InventoryItems to add to the inventory.
	 * @param id The id of the inventory, auto-generated after inserting into the database.
	 * @exception IllegalArgumentException Throws this exception when the argument is null.
	 */
	public Inventory(int id, Set<InventoryItem> inventoryItems) throws IllegalArgumentException {
		this();
		if(inventoryItems == null) {
			throw new IllegalArgumentException("Inventory items cant be null.");
		}
		this.id = id;
		this.inventoryItems = inventoryItems;
	}
	
	/**
	 * Add the new InventoryItem to the contents of the Inventory.<br/>
	 * InventoryItem with the same Product (as evaluated by Products.equals(Object)) will not 
	 * be added to the list, instead it will just update the quantity of the inventory. 
	 * @param inventoryItem The InventoryItem object to be added to the Inventory
	 * @exception IllegalArgumentException Throws this exception when the parameter is null.
	 */
	public void addInventoryItem(InventoryItem inventoryItem) throws IllegalArgumentException {
		throw new UnsupportedOperationException("Operation Not Yet Implemented.");
	}
	
	/**
	 * @return The Set of InventoryItems stored by this inventory.
	 */
	public Set<InventoryItem> getInventoryItems() {
		throw new UnsupportedOperationException("Operation Not Yet Implemented.");
	}
}
