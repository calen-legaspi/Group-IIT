/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.domain;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {
    private Order normalOrder;
    private Order discountedOrder;
    
    @Before
    public void setUp() {
        /*
         * Setup a normal order amounting to 10,000
         */
        
        /*
         * Setup a discounted (10%) order from 10,000 (expecting 9,000)
         */
    }

    /**
     * Tests if Order.getOrderAmount returns the correct value and precision
     */
    @Test
    public void testGetOrderAmount() {
        BigDecimal actualAmount = normalOrder.getAmount();
        BigDecimal expectedAmount = new BigDecimal("10000.00");
        
        assertEquals(expectedAmount, actualAmount);
    }

    /**
     * Tests if Order.getOrderAmount returns the correct value and precision with discount applied
     */
    @Test
    public void testGetOrderAmountWithDiscount() {
        BigDecimal actualAmount = discountedOrder.getAmount();
        BigDecimal expectedAmount = new BigDecimal("9000.00");
        
        assertEquals(expectedAmount, actualAmount);
    }
}
