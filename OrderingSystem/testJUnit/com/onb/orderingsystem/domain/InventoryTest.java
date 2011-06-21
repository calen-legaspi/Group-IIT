package com.onb.orderingsystem.domain;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryTest {
    private Inventory inventory;
    Product rocketLauncher;
    Product rocket;
 
    @Before
    public void setUp() {
        inventory = new Inventory(1, new LinkedHashSet<InventoryItem>());
        rocketLauncher = new Product(5, "Rocket Launcher", BigDecimal.ONE);
        rocket = new Product(6, "Rocket", BigDecimal.ONE);
        
        inventory.addInventoryItem(new InventoryItem(5, rocketLauncher, 10));
        inventory.addInventoryItem(new InventoryItem(6, rocket, 100));
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
        
        int expected_count = 3;
        int actual_count = inventory.getInventoryItems().size();
        
        assertEquals(expected, actual); //assert that the inventoryItem count is correct
        assertEquals(expected_count, actual_count); //assert that the number of inventory items is correct
    }
    
    @Test
    public void testRemoveItemsFromInventorySuccess() throws DomainException {
    	OrderItem orderItem = new OrderItem(rocket, 100);
    	Order order = new Order(1);
    	order.addOrderItem(orderItem);
    	
    	inventory.removeItemsFromInventory(order);
    	
    	for(InventoryItem i: inventory.getInventoryItems()) {
    		if(i.getProduct().equals(rocket)) {
    			assertEquals(0, i.getQuantity());
    		}
    	}
    }
    
    @Test(expected=DomainException.class)
    public void testRemoveItemsFromInventoryFailure() throws DomainException {
    	OrderItem orderItem = new OrderItem(rocketLauncher, 11);
    	Order order = new Order(1);
    	order.addOrderItem(orderItem);
    	
    	inventory.removeItemsFromInventory(order);
    }
    
    @Test
    public void testIsAvailableForOrder() throws DomainException {
    	OrderItem orderItem = new OrderItem(rocketLauncher, 10);
    	Order order = new Order(1);
    	order.addOrderItem(orderItem);
    	
    	OrderItem orderItem2 = new OrderItem(rocket, 101);
    	Order order2 = new Order(2);
    	order2.addOrderItem(orderItem2);
    	
    	boolean actual = inventory.isAvailableForOrder(order);
    	boolean actual2 = inventory.isAvailableForOrder(order2);
    	
    	assertTrue(actual);
    	assertFalse(actual2);
    }
}
