package com.onb.orderingsystem.domain;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryItemTest {
    
    @Test
    public void testSetQuantity() {
        Product product = new Product(1, "Rifle", BigDecimal.ONE);
        InventoryItem invItem = new InventoryItem(1, product, 10);
        invItem.setQuantity(200);
        
        int expected = 200;
        int actual = invItem.getQuantity();
        
        assertEquals(expected, actual);
    }

 
}
