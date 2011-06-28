package com.onb.orderingsystem.service;

import com.onb.orderingsystem.domain.InventoryItem;
import java.util.Set;

public class InsufficientSupplyException extends ServiceException {
    private Set<InventoryItem> undersuppliedInventoryItems;
    
    public InsufficientSupplyException(String message, Set<InventoryItem> undersuppliedInventoryItems) {
        super(message);
        this.undersuppliedInventoryItems = undersuppliedInventoryItems;
    }
    
    public Set<InventoryItem> getUndersuppliedInventoryItems() {
        return undersuppliedInventoryItems;
    }
}
