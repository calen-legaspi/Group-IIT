/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.domain;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author The Architect
 */
public class InventoryTest {
    private Inventory inventory;
 
    @Before
    public void setUp() {
        inventory = new Inventory(1, new LinkedHashSet<InventoryItem>());
    }
    
    @Test
    public void testAddInventoryItemDuplicate() {
        Product gunPowder = new Product(1, "Gunpowder", BigDecimal.ONE);
        
        InventoryItem gp_i1 = new InventoryItem(1, gunPowder, 200);
        InventoryItem gp_i2 = new InventoryItem(2, gunPowder, 200);
        
        inventory.addInventoryItem(gp_i1);
        inventory.addInventoryItem(gp_i2);
        
        int expected = 400;
        int actual = gp_i1.getQuantity();
        
        int expected_count = 1;
        int actual_count = inventory.getInventoryItems().size();
        
        assertEquals(expected, actual); //assert that the inventoryItem count is correct
        assertEquals(expected_count, actual_count); //assert that the number of inventory items is correct
    }
    
}
