package com.onb.orderingsystem.domain;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * The Customer class represents the Customer. A customer owns a list of orders,
 * a name, and an id to uniquely identify itself.
 */
public class Customer implements Serializable {
	private static final long serialVersionUID = -2680052503116815283L;
	private static final BigDecimal K100 = new BigDecimal("100000.00");
	private static final BigDecimal K500 = new BigDecimal("500000.00");
	private static final BigDecimal M1 = new BigDecimal("1000000.00");

	private int id;
	private String name;
	private Set<Order> orders = new HashSet<Order>();

	/**
	 * Use this to instantiate a new Customer.
	 * 
	 * @param name
	 *            The name of the customer.
	 */
	public Customer(String name) {
		if (name == null || name.equals("")) {
			throw new IllegalArgumentException("Name cannot be null or empty.");
		}
		this.name = name;
	}

	/**
	 * Probably be used to re-instantiate an existing Customer from the
	 * database.
	 * 
	 * @param id
	 *            The unique id of the Customer.
	 * @param name
	 *            The full name of the Customer.
	 * @param orders
	 *            The Set of Orders owned by the Customer.
	 */
	public Customer(int id, String name, Set<Order> orders) {
		this(name);
		if (name == null || orders == null) {
			throw new IllegalArgumentException("One of the parameter is null.");
		}
		this.id = id;
		this.orders = orders;
	}

	/**
	 * @return The id of the customer
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return The name of the customer
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return A human-readable String representation of the Customer. Do not
	 *         parse this for computations. Return format may change in future
	 *         updates.
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Adds the new Order to the list of orders by the customer. If the Order
	 * already exists in the customer's list of orders, the former is updated
	 * with the value of the new one.
	 * 
	 * @param newOrder
	 *            an Order to be added
	 */
	public void addOrder(Order newOrder) {
		orders.add(newOrder);
	}

	/**
	 * @return The Set of Orders owned by the Customer.
	 */
	public Set<Order> getOrders() {
		return orders;
	}

	/**
	 * @param o
	 *            The object to compare the equality of this Customer.
	 * @return True if the Customer is equivalent to the parameter, otherwise
	 *         false.
	 * @exception IllegalArgumentException
	 *                if the parameter is either null of not a Customer
	 *                instance.
	 */
	@Override
	public boolean equals(Object o) throws IllegalArgumentException {
		if (o == null) {
			throw new IllegalArgumentException("The customer cannot be null.");
		}
		if (!(o instanceof Customer)) {
			throw new IllegalArgumentException("Customers can only be compared to other Customers.");
		}
		return ((Customer) o).id == id;
	}

	/**
	 * Id-based hashCode override.
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 53 * hash + this.id;
		return hash;
	}

	/**
	 * @return True if the Customer has Orders which have not yet been paid.
	 */
	public boolean hasUnpaidOrders() {
		for (Order o : orders) {
			if (o.getOrderStatus() == OrderStatus.UNPAID) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Calculates the credit limit of the Customer. The Credit limit represents
	 * the amount (in money) of the Customer.<br/>
	 * The computation is based on the total amount of orders paid by the
	 * Customer:<br/>
	 * Amount Range based on the paid orders by the Customer:
	 * <ol>
	 * <li>Php 0.00 to Php 100,000.00 => Php 10,000</li>
	 * <li>Php 100,000.00 to Php 500,000.00 => Php 30,000</li>
	 * <li>Php 500,000.00 to Php 1,000,000.00 => Php 75,000</li>
	 * <li>Php 1,000,000.00 to Infinity => Php 150,000</li>
	 * </ol>
	 * 
	 * @return The credit limit of the Customer in BigDecimal rounded to two
	 *         decimal point.
	 */
	public BigDecimal getCreditLimit() {
		BigDecimal paidAmount = BigDecimal.ZERO;
		
		for (Order o : orders) {
			if (o.getOrderStatus() == OrderStatus.PAID) {
				paidAmount = paidAmount.add(o.getAmount());
			}
		}

		if (paidAmount.compareTo(K100) <= 0) {
			return new BigDecimal("10000.00");
		}
		if (paidAmount.compareTo(K500) <= 0) {
			return new BigDecimal("30000.00");
		}
		if (paidAmount.compareTo(M1) <= 0) {
			return new BigDecimal("75000.00");
		}
		return new BigDecimal("150000.00");
	}
	
	/**
	 * 
	 * @return
	 */
	public BigDecimal getRemainingCredits() {
		return getCreditLimit().subtract(getAmountOfUnpaidOrders());
	}

	/**
	 * @return The sum of the amount of all the unpaid orders of this customer
	 *         rounded off to two decimal places.
	 */
	public BigDecimal getAmountOfUnpaidOrders() {
		return getAmountByStatus(OrderStatus.UNPAID);
	}

	/**
	 * @return The sum of the amount of all paid orders of this customer rounded
	 *         off to two decimal places.
	 */
	public BigDecimal getAmountOfPaidOrders() {
		return getAmountByStatus(OrderStatus.PAID);
	}
	
	private BigDecimal getAmountByStatus(OrderStatus status) {
		BigDecimal amount = BigDecimal.ZERO;
		for (Order o : orders) {
			if (o.getOrderStatus() == status) {
				amount = amount.add(o.getAmount());
			}
		}
		return amount;
	}

	/**
	 * Checks if this customer has not yet reached his credit limit.
	 * 
	 * @return true if the customer has not yet exceeded his credit limit,
	 *         otherwise false.
	 */
	public boolean isCreditLimitNotExceeded() {
		return getCreditLimit().compareTo(getAmountOfUnpaidOrders()) >= 0;
	}

	/**
	 * 
	 * @param ascending
	 * @return
	 */
	public List<Order> getOrdersByOrderedByDate(final boolean ascending) {
		List<Order> unsortedOrderList = new LinkedList<Order>(this.orders);
		
		Collections.sort(unsortedOrderList, new Comparator<Order>() {
			@Override
			public int compare(Order arg0, Order arg1) {
				int orderMultiplier = ascending?1:-1;
				return arg0.getDate().compareTo(arg1.getDate())*orderMultiplier;
			}
		});
		
		return unsortedOrderList;
	}
	
	/**
	 * 
	 * @param toTest
	 * @return
	 */
	public boolean checkOrderIfAllowed(Order toTest) {
		return toTest.getAmount().compareTo(getRemainingCredits()) <= 0;
	}
}