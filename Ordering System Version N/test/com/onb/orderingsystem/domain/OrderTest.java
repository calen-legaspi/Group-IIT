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
        Product p = new Product(1, "Product 1", new BigDecimal("10000.00")); 
        
        /*
         * Setup a normal order amounting to 10,000
         */
        normalOrder = new Order();
        normalOrder.addOrderItem(new OrderItem(1, p, 1));
        
        
        /*
         * Setup a discounted (10%) order from 10,000 (expecting 9,000)
         */
        discountedOrder = new Order();
        discountedOrder.addOrderItem(new OrderItem(2, p, 1));
        discountedOrder.setDiscountStatus(DiscountStatus.TEN_PERCENT);
    }

    /**
     * Tests if Order.getOrderAmount returns the correct value and precision
     */
    @Test
    public void testGetOrderAmount() {
        BigDecimal actualAmount = normalOrder.getAmount();
        BigDecimal expectedAmount = new BigDecimal("10000.00");
        
        assertEquals(2, actualAmount.scale());
        assertEquals(expectedAmount, actualAmount);
    }

    /**
     * Tests if Order.getOrderAmount returns the correct value and precision with discount applied
     */
    @Test
    public void testGetOrderAmountWithDiscount() {
        BigDecimal actualAmount = discountedOrder.getAmount();
        BigDecimal expectedAmount = new BigDecimal("9000.00");
        
        assertEquals(2, actualAmount.scale());
        assertEquals(expectedAmount, actualAmount);
    }
}
