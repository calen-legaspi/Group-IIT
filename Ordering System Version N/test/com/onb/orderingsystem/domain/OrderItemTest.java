/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.domain;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author The Architect
 */
public class OrderItemTest {
    private OrderItem orderItem;
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetAmount() {
        BigDecimal actualAmount = orderItem.getAmount();
        BigDecimal expectedAmount = new BigDecimal("10000.00");
        
        assertEquals(expectedAmount, actualAmount);
    }
}
