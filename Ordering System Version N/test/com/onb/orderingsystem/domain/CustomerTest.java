package com.onb.orderingsystem.domain;

import java.math.BigDecimal;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
   
    private Set<Order> ordersUnpaid10000;
    private Set<Order> ordersPaid10000;
    private Set<Order> creditLimit10000;
    private Set<Order> creditLimit30000;
    private Set<Order> creditLimit75000;
    private Set<Order> creditLimit150000;
    
    @Before
    public void setUp() {
        /*
         * Setup a new Batch of Orders
         */
    }
    
    /**
     * Tests the precision and result or Order.getAmountOfUnpaidOrders
     */
    @Test
    public void testGetAmountOfUnpaidOrders() {
        Customer c = new Customer(1, "Customer 1", ordersUnpaid10000);
        
        BigDecimal actual = c.getAmountOfUnpaidOrders();
        BigDecimal expected = new BigDecimal("10000.00");
        
        int actual_scale = c.getAmountOfPaidOrders().scale();
        int expected_scale = 2;
        
        assertEquals(expected_scale, actual_scale);
        assertEquals(expected, actual);
    }

    /**
     * Tests if the method getAmountOfPaidOrders returns the correct amount and scale
     */
    @Test
    public void testGetAmountOfPaidOrders() {
        Customer c = new Customer(1, "Customer 1", ordersPaid10000);
        
        BigDecimal actual = c.getAmountOfPaidOrders();
        BigDecimal expected = new BigDecimal("10000.00");
        
        int actual_scale = c.getAmountOfPaidOrders().scale();
        int expected_scale = 2;
        
        assertEquals(expected_scale, actual_scale);
        assertEquals(expected, actual);
    }
    
     /**
     * Tests the correctness and precision of the Customer.getCreditLimit method
     */
    @Test
    public void testGetCreditLimit() {
        Customer c10000 = new Customer(1, "Customer 1", creditLimit10000);
        Customer c30000 = new Customer(1, "Customer 1", creditLimit30000);
        Customer c75000 = new Customer(1, "Customer 1", creditLimit75000);
        Customer c150000 = new Customer(1, "Customer 1", creditLimit150000);
        
        assertEquals(new BigDecimal("10000"), c10000);
        assertEquals(new BigDecimal("30000"), c30000);
        assertEquals(new BigDecimal("75000"), c75000);
        assertEquals(new BigDecimal("150000"), c150000);
    }
    
}
