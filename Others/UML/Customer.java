package com.onb.orderingsystem.domain;

/**
 * @author The Architect
 * @version 1.0
 * @created 07-Jun-2011 8:28:59 AM
 */
import java.math.BigDecimal;
import java.util.HashSet;

import java.util.Set;

/**
 * The Customer class represents the Customer. 
 * A customer owns a list of orders, a name, and an id to uniquely identify itself.
 */
public class Customer {

	private int id;
	private String name;
	private Set<Order> orders;
	
	/**
	 * Use this to instantiate a new Customer.
	 * @param id The customer's serial number.
	 * @param name The name of the customer.
	 * @exception IllegalArgumentException Throws this exception when at least one of the argument has invalid values such as null.
	 */
	public Customer(int id, String name) throws IllegalArgumentException {
		if(name == null || name.equals("")) {
			throw new IllegalArgumentException("Name cannot be null or empty.");
		}
		this.id = id;
		this.name = name;
		this.orders = new HashSet<Order>();
	}
	
	/**
	 * Probably be used to re-instantiate an existing Customer from the database.
	 * @param id The unique id of the Customer.
	 * @param name The full name of the Customer.
	 * @param orders The Set of Orders owned by the Customer. 
	 * @exception IllegalArgumentException Throws this exception when at least one of the argument is contains an illegal value such as null.
	 */
	public Customer(int id, String name, Set<Order> orders) throws IllegalArgumentException {
		this(id,name);
		if(name == null || orders == null) {
			throw new IllegalArgumentException("One of the parameter is null.");
		}
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
	 * @return A human-readable String representation of the Customer. Do not parse this for computations. Return format may change in future updates.
	 */
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Adds the new Order to the list of orders by the customer. If the Order already exists in the customer's list of orders, the former is updated with the value of the new one.
	 * @param newOrder an Order to be added later
	 */
	public void addOrder(Order newOrder) {
		throw new UnsupportedOperationException("Operation Not Yet Implemented.");
	}
	
	/**
	 * @return The Set of Orders owned by the Customer.
	 */
	public Set<Order> getOrders() {
		return orders;
	}
	
	/**
	 * @param o The object to compare the equality of this Customer.
	 * @return True if the Customer is equivalent to the parameter, otherwise false.
	 * @exception IllegalArgumentException Throws this exception when the parameter is either null of not a Customer instance.
	 */
	@Override
	public boolean equals(Object o) throws IllegalArgumentException {
		if(o == null) {
			throw new IllegalArgumentException("The customer cannot be null.");
		}
		if(!(o instanceof Customer)) {
			throw new IllegalArgumentException("Customers can only be compared to other Customers.");
		}
		return ((Customer) o).id == id;
	}
	
	/**
	 * @return True if the Customer has Orders which have not yet been paid.
	 */
	public boolean hasUnpaidOrders() {
		throw new UnsupportedOperationException("Operation Not Yet Implemented.");
	}
	
	/**
	 * Calculates the credit limit of the Customer.
	 * The Credit limit represents the amount (in money) of the Customer.<br/>
	 * The computation is based on the total amount of orders paid by the Customer:<br/>
	 * Amount Range based on the paid orders by the Customer:
	 * <ol>
	 * <li>Php 0.00 to Php 100,000.00 => Php 10,000</li>
	 * <li>Php 100,000.00 to Php 500,000.00 => Php 30,000</li>
	 * <li>Php 500,000.00 to Php 1,000,000.00 => Php 75,000</li>
	 * <li>Php 1,000,000.00 to Infinity => Php 150,000</li>
	 * </ol>
	 * @return The credit limit of the Customer in BigDecimal rounded to two decimal point.
	 */
	public BigDecimal getCreditLimit() {
		throw new UnsupportedOperationException("Operation Not Yet Implemented.");
	}
	
	/**
	 * @return The sum of the amount of all the unpaid orders of this customer rounded off to two decimal places. 
	 */
	public BigDecimal getAmountOfUnpaidOrders() {
		throw new UnsupportedOperationException("Operation Not Yet Implemented.");
	}
	
	/**
	 * @return The sum of the amount of all paid orders of this customer rounded off to two decimal places.
	 */
	public BigDecimal getAmountOfPaidOrders() {
		throw new UnsupportedOperationException("Operation Not Yet Implemented.");
	}
}