package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.Inventory;

public interface InventoryDao {
	
	public Inventory getInventory();
	
	public void updateInventory(Inventory inventory);
	
}
