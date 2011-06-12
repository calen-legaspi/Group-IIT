package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.InventoryItem;
import java.util.Set;

/**
 * Database CRUD for the InventoryItem object.
 */
public interface InventoryItemDao {
    
    /**
     * Gets all the inventory items that are available for order.
     * Available InventoryItems refers to items that have quantities greater than zero.
     * @return the Set of InventoryItems that are available for Order.
     * @throws DaoException if something goes wrong with the data retrieval.
     */
    public Set<InventoryItem> getAvailableInventoryItems() throws DaoException;
    
    /**
     * Updates the inventory item into the database.
     * @param inventoryItem the inventory item to update.
     * @throws DaoException if something goes wrong with the database.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void updateInventoryItem(InventoryItem inventoryItem) throws DaoException, IllegalArgumentException;
}