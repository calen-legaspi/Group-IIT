package com.onb.orderingsystem.domain;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class represents an inventory to contain the inventory items of a
 * certain warehouse, storage area, etc.
 */
public class Inventory implements Serializable {

	private static final long serialVersionUID = 832317836245522694L;
	private int id;
	private Set<InventoryItem> inventoryItems = new LinkedHashSet<InventoryItem>();

	/**
	 * Default constructor. No big deal.
	 */
	public Inventory() {
	}

	/**
	 * This constructor will serve its purpose on reconstruction of a persisted
	 * instance.
	 * 
	 * @param inventoryItems
	 *            The Set of InventoryItems to add to the inventory.
	 * @param id
	 *            The id of the inventory, auto-generated after inserting into
	 *            the database.
	 * @exception IllegalArgumentException
	 *                Throws this exception when the argument is null.
	 */
	public Inventory(int id, Set<InventoryItem> inventoryItems)
			throws IllegalArgumentException {
		this();
		if (inventoryItems == null) {
			throw new IllegalArgumentException("Inventory items cant be null.");
		}
		this.id = id;
		this.inventoryItems = inventoryItems;
	}

	/**
	 * Add the new InventoryItem to the contents of the Inventory.<br/>
	 * InventoryItem with the same Product (as evaluated by
	 * Products.equals(Object)) will not be added to the list, instead it will
	 * just update the quantity of the inventory.
	 * 
	 * @param inventoryItem
	 *            The InventoryItem object to be added to the Inventory
	 * @exception IllegalArgumentException
	 *                Throws this exception when the parameter is null.
	 */
	public void addInventoryItem(InventoryItem inventoryItem) throws IllegalArgumentException {
		if (inventoryItem == null) {
			throw new IllegalArgumentException("Parameter cant be null.");
		}
		if (inventoryItems.contains(inventoryItem)) {
			for (InventoryItem i : inventoryItems) {
				if (i.equals(inventoryItem)) {
					i.setQuantity(i.getQuantity() + inventoryItem.getQuantity());
				}
			}
		} else {
			inventoryItems.add(inventoryItem);
		}
	}

	/**
	 * @return The Set of InventoryItems stored by this inventory.
	 */
	public Set<InventoryItem> getInventoryItems() {
		return this.inventoryItems;
	}

	/**
	 * Checks for the availability of the items in an inventory.
	 * 
	 * @param order
	 * @return true if the inventory has enough items to supply the order.
	 */
	public boolean isAvailableForOrder(Order order) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Reduces the quantity of inventory items by the quantity specified in the
	 * order.
	 * 
	 * @param order
	 * @throws DomainException
	 *             if the order exceeds the amount available in the inventory
	 */
	public void removeItemsFromInventory(Order order) throws DomainException {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
}
