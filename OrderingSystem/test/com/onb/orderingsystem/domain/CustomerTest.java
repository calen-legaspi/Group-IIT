/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.domain;

import java.math.BigDecimal;
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
public class CustomerTest {
    
    public CustomerTest() {
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
     * Test of getId method, of class Customer.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Customer instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Customer instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Customer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Customer instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOrder method, of class Customer.
     */
    @Test
    public void testAddOrder() {
        System.out.println("addOrder");
        Order newOrder = null;
        Customer instance = null;
        instance.addOrder(newOrder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrders method, of class Customer.
     */
    @Test
    public void testGetOrders() {
        System.out.println("getOrders");
        Customer instance = null;
        Set expResult = null;
        Set result = instance.getOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Customer.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Customer instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasUnpaidOrders method, of class Customer.
     */
    @Test
    public void testHasUnpaidOrders() {
        System.out.println("hasUnpaidOrders");
        Customer instance = null;
        boolean expResult = false;
        boolean result = instance.hasUnpaidOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreditLimit method, of class Customer.
     */
    @Test
    public void testGetCreditLimit() {
        System.out.println("getCreditLimit");
        Customer instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getCreditLimit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmountOfUnpaidOrders method, of class Customer.
     */
    @Test
    public void testGetAmountOfUnpaidOrders() {
        System.out.println("getAmountOfUnpaidOrders");
        Customer instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getAmountOfUnpaidOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmountOfPaidOrders method, of class Customer.
     */
    @Test
    public void testGetAmountOfPaidOrders() {
        System.out.println("getAmountOfPaidOrders");
        Customer instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getAmountOfPaidOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
