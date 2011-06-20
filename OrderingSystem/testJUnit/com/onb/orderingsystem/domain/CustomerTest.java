package com.onb.orderingsystem.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
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
        Product p1 = new Product(1, "Product 01", new BigDecimal("10000.00"));
        
        /*
         * Create an order worth 10,000 credits
         */
        OrderItem orderItem10000 = new OrderItem(p1, 1);
        Set<OrderItem> orderItems10000 = new LinkedHashSet<OrderItem>();
        orderItems10000.add(orderItem10000);
        Order order10000 = new Order(1, new Date(), orderItems10000, OrderStatus.UNPAID, DiscountStatus.NO_DISCOUNT, new BigDecimal("10000.00"));
        ordersUnpaid10000 = new LinkedHashSet<Order>();
        ordersUnpaid10000.add(order10000);
        
        /*
         * Create an order worth 10,000 paid
         */
        Set<OrderItem> paidItems10000 = new LinkedHashSet<OrderItem>();
        paidItems10000.add(orderItem10000);
        Order paid10000 = new Order(2, new Date(), paidItems10000, OrderStatus.PAID, DiscountStatus.NO_DISCOUNT, new BigDecimal("10000.00"));
        ordersPaid10000 = new LinkedHashSet<Order>();
        ordersPaid10000.add(paid10000);
        
        /*
         * Create a set of orders that will yeild a 10,000-peso credit limit
         */
        creditLimit10000 = new LinkedHashSet<Order>();
        
        /*
         * Create a set of orders that will yeild a 30,000-credit limit
         */
        OrderItem orderItem200000 = new OrderItem(3, p1, 20);
        Set<OrderItem> orderItems200000 = new LinkedHashSet<OrderItem>();
        orderItems200000.add(orderItem200000);
        Order orderPaid200000 = new Order(3, new Date(), orderItems200000, OrderStatus.PAID, DiscountStatus.NO_DISCOUNT, new BigDecimal("200000.00"));
        creditLimit30000 = new LinkedHashSet<Order>();
        creditLimit30000.add(orderPaid200000);
        
        /*
         * Create a set of orders that will yeild a 75,000-credit limit
         */
        OrderItem orderItem600000 = new OrderItem(4, p1, 60);
        Set<OrderItem> orderItems600000 = new LinkedHashSet<OrderItem>();
        orderItems600000.add(orderItem600000);
        Order orderPaid600000 = new Order(4, new Date(), orderItems600000, OrderStatus.PAID, DiscountStatus.NO_DISCOUNT, new BigDecimal("600000.00"));
        creditLimit75000 = new LinkedHashSet<Order>();
        creditLimit75000.add(orderPaid600000);
        
        /*
         * Create a set of orders that will yeild a 150,000-credit limit
         */
        OrderItem orderItem1100000 = new OrderItem(5, p1, 110);
        Set<OrderItem> orderItems11000000 = new LinkedHashSet<OrderItem>();
        orderItems11000000.add(orderItem1100000);
        Order orderPaid1100000 = new Order(5, new Date(), orderItems11000000, OrderStatus.PAID, DiscountStatus.NO_DISCOUNT, new BigDecimal("1100000.00"));
        creditLimit150000 = new LinkedHashSet<Order>();
        creditLimit150000.add(orderPaid1100000);
    }
    
    /**
     * Tests the precision and result or Order.getAmountOfUnpaidOrders
     */
    @Test
    public void testGetAmountOfUnpaidOrders() {
        Customer c = new Customer(1, "Customer 1", ordersUnpaid10000);
        
        BigDecimal actual = c.getAmountOfUnpaidOrders();
        BigDecimal expected = new BigDecimal("10000.00");
        
        int actual_scale = c.getAmountOfUnpaidOrders().scale();
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
        
        assertEquals(new BigDecimal("10000.00"), c10000.getCreditLimit());
        assertEquals(new BigDecimal("30000.00"), c30000.getCreditLimit());
        assertEquals(new BigDecimal("75000.00"), c75000.getCreditLimit());
        assertEquals(new BigDecimal("150000.00"), c150000.getCreditLimit());
    }
    
    /**
     * Tests the correct ordering of the list of Orders as ordered by date
     */
    @Test
    public void testGetOrdersByDateDescending() {
    	fail();
    }
    
}
