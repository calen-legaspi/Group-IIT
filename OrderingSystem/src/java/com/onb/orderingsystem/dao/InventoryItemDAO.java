/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.InventoryItem;
import java.util.Set;

/**
 *
 * @author The Architect
 */
public interface InventoryItemDAO {
    public Set<InventoryItem> getAvailableInventoryItems();
    public void updateInventoryItem(InventoryItem inventoryItem);
}
