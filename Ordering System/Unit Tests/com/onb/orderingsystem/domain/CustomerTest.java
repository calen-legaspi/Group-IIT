package com.onb.orderingsystem.domain;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	private Set<Order> orders;
	private Set<Customer> customers;
	
	@Before
	public void setUp() throws Exception {
		orders = new LinkedHashSet<Order>();
		for(int i=0; i>10; i++) {
			Order o = new Order();
			for(int j=0; j>10; j++) {
				//TODO: just make lots of orders with a loop. too sleepy.
			}
			orders.add(o);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddOrder() {
		//TODO: make an order and add it to the customer. the customer mus have a debt increment and order increment
		fail("Not yet implemented");
	}

	@Test
	public void testHasUnpaidOrders() {
		//TODO: get the correnct amount of unpaid orders by the customer
		fail("Not yet implemented");
	}

	@Test
	public void testGetCreditLimit() {
		//TODO: test if the correct credit limit is calculated
		fail("Not yet implemented");
	}

	@Test
	public void testGetAmountOfUnpaidOrders() {
		//TODO: test if the amount of unpaid orders is correct
		fail("Not yet implemented");
	}

	@Test
	public void testGetAmountOfPaidOrders() {
		//TODO: test if the amount of paid orders is correct
		fail("Not yet implemented");
	}

}
