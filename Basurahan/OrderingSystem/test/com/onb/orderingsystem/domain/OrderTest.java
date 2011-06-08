/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.domain;

import java.util.Date;
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
public class OrderTest {
    
    public OrderTest() {
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
     * Test of setDate method, of class Order.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Order instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderStatus method, of class Order.
     */
    @Test
    public void testSetOrderStatus() {
        System.out.println("setOrderStatus");
        OrderStatus status = null;
        Order instance = null;
        instance.setOrderStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOrderItem method, of class Order.
     */
    @Test
    public void testAddOrderItem() {
        System.out.println("addOrderItem");
        OrderItem orderItem = null;
        Order instance = null;
        instance.addOrderItem(orderItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrder method, of class Order.
     */
    @Test
    public void testRemoveOrder() {
        System.out.println("removeOrder");
        OrderItem orderItem = null;
        Order instance = null;
        instance.removeOrder(orderItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderNumber method, of class Order.
     */
    @Test
    public void testGetOrderNumber() {
        System.out.println("getOrderNumber");
        Order instance = null;
        int expResult = 0;
        int result = instance.getOrderNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Order.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Order instance = null;
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderItems method, of class Order.
     */
    @Test
    public void testGetOrderItems() {
        System.out.println("getOrderItems");
        Order instance = null;
        Set expResult = null;
        Set result = instance.getOrderItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderStatus method, of class Order.
     */
    @Test
    public void testGetOrderStatus() {
        System.out.println("getOrderStatus");
        Order instance = null;
        OrderStatus expResult = null;
        OrderStatus result = instance.getOrderStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
