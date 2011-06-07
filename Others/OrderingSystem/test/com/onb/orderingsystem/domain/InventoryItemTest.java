/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.domain;

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
public class InventoryItemTest {
    
    public InventoryItemTest() {
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
     * Test of getQuantity method, of class InventoryItem.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        InventoryItem instance = null;
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduct method, of class InventoryItem.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        InventoryItem instance = null;
        Product expResult = null;
        Product result = instance.getProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class InventoryItem.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        InventoryItem instance = null;
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
