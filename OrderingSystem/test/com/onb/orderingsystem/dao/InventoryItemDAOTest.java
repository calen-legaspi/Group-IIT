/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.InventoryItem;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lyndon
 */
public class InventoryItemDAOTest {
    private InventoryItemDao inventoryItemDAO;

    @Before
    public void setUp() throws Exception {
        /*
         * Setup an inventory with 10 items.
         * Five of which is available*
         * 
         */
        //TODO: insert codes for the db setup
        //TODO: insert codes for instantiating a new inventoryItemDAO
    }

    @After
    public void tearDown() throws Exception {
        /*
         * Cleanup database
         */
        //TODO: insert code for cleaning the database
        inventoryItemDAO = null;
    }

    @Test
    public void testGetAvailableInventoryItems() throws DaoException {
        Set<InventoryItem> inventoryItems = inventoryItemDAO.getAvailableInventoryItems();
        
        int expected = 5;
        int actual = inventoryItems.size();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testUpdateInventory() {
        /*
         * Update the inventory
         */
        //TODO: write a test to verify if the dao really did the update
    }
}
