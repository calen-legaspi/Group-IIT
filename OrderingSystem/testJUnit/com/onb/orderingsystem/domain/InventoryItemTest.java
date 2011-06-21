package com.onb.orderingsystem.domain;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryItemTest {
	Product product;
    InventoryItem invItem;
	
	@Before
	public void setUp() {
		product = new Product(1, "Rifle", BigDecimal.ONE);
		invItem = new InventoryItem(1, product, 10);
		invItem.setQuantity(200);
	}
    
    @Test
    public void testSetQuantity() {
        
        int expected = 200;
        int actual = invItem.getQuantity();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testRemoveQuantityByOrderItemSuccess() throws DomainException {
    	OrderItem orderItem = new OrderItem(product, 10);
    	invItem.removeQuantityByOrderItem(orderItem);
    	
    	int expectedQuantity = 190;
    	int actualQuantity = invItem.getQuantity();
    	
    	assertEquals(expectedQuantity, actualQuantity);
    }

    @Test(expected=DomainException.class)
    public void testRemoveQuantityByOrderItemFailure() throws DomainException {
    	OrderItem orderItem = new OrderItem(product, 201);
    	invItem.removeQuantityByOrderItem(orderItem);
    	
    }
}
