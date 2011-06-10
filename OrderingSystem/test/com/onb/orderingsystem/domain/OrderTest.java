package com.onb.orderingsystem.domain;

import java.util.Set;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {
    private Order normalOrder;
    private Order discountedOrder;
    private Order orderWithConsolidation;
    
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
        
        /*
         * Order the same product twice. 
         * Quantity should be added instead of creating a new entry.
         */
        orderWithConsolidation = new Order();
        orderWithConsolidation.addOrderItem(new OrderItem(p, 10));
        orderWithConsolidation.addOrderItem(new OrderItem(p, 20));
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
    
    @Test
    public void testOrderItemConsolidation() {
        Set<OrderItem> orderItems = orderWithConsolidation.getOrderItems();
       
        int expected = 1;
        int actualSize = orderItems.size();
        
        assertEquals(expected, actualSize);
    }
}
