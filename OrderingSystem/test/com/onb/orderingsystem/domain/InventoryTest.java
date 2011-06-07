/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.domain;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author The Architect
 */
public class InventoryTest {
    
    public InventoryTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addInventoryItem method, of class Inventory.
     */
    @Test
    public void testAddInventoryItem() {
        System.out.println("addInventoryItem");
        InventoryItem inventoryItem = null;
        Inventory instance = new Inventory();
        instance.addInventoryItem(inventoryItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInventoryItems method, of class Inventory.
     */
    @Test
    public void testGetInventoryItems() {
        System.out.println("getInventoryItems");
        Inventory instance = new Inventory();
        Set expResult = null;
        Set result = instance.getInventoryItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
