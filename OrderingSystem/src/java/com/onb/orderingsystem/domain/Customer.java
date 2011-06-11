package com.onb.orderingsystem.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * The Customer class represents the Customer. 
 * A customer owns a list of orders, a name, and an id to uniquely identify itself.
 */
public class Customer implements Serializable {
    private int id;
    private String name;
    private Set<Order> orders;

    /**
     * Use this to instantiate a new Customer.
     * @param name The name of the customer.
     * @throws IllegalArgumentException if at least one of the argument has invalid values such as null.
     */
    public Customer(String name) throws IllegalArgumentException {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
        this.orders = new HashSet<Order>();
    }

    /**
     * Probably be used to re-instantiate an existing Customer from the database.
     * @param id The unique id of the Customer.
     * @param name The full name of the Customer.
     * @param orders The Set of Orders owned by the Customer. 
     * @throws IllegalArgumentException if at least one of the argument is contains an illegal value such as null.
     */
    public Customer(int id, String name, Set<Order> orders) throws IllegalArgumentException {
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
     * @return A human-readable String representation of the Customer. Do not parse this for computations. Return format may change in future updates.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Adds the new Order to the list of orders by the customer. If the Order already exists in the customer's list of orders, the former is updated with the value of the new one.
     * @param newOrder an Order to be added
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
     * @param o The object to compare the equality of this Customer.
     * @return True if the Customer is equivalent to the parameter, otherwise false.
     * @exception IllegalArgumentException if the parameter is either null of not a Customer instance.
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
        for(Order o: orders) {
            if(o.getOrderStatus() == OrderStatus.UNPAID) {
                return true;
            }
        }
        return false;
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
        BigDecimal paidAmount = BigDecimal.ZERO;
        for(Order o: orders) {
            if(o.getOrderStatus() == OrderStatus.PAID) {
                paidAmount = paidAmount.add(o.getAmount());
            }
        }
        
        BigDecimal K100 = new BigDecimal("100000.00");
        BigDecimal K500 = new BigDecimal("500000.00");
        BigDecimal M1 = new BigDecimal("1000000.00");
        
        if(paidAmount.compareTo(K100) <= 0) {
            return new BigDecimal("10000.00");
        } 
        if(paidAmount.compareTo(K500) <= 0) {
            return new BigDecimal("30000.00");
        }
        if(paidAmount.compareTo(M1) <= 0) {
            return new BigDecimal("75000.00");
        }
        return new BigDecimal("150000.00");
    }

    /**
     * @return The sum of the amount of all the unpaid orders of this customer rounded off to two decimal places. 
     */
    public BigDecimal getAmountOfUnpaidOrders() {
        BigDecimal unpaidOrderAmount = BigDecimal.ZERO;
        for(Order o: orders) {
            if(o.getOrderStatus() == OrderStatus.UNPAID) {
                unpaidOrderAmount = unpaidOrderAmount.add(o.getAmount());
            }
        }
        return unpaidOrderAmount;
    }

    /**
     * @return The sum of the amount of all paid orders of this customer rounded off to two decimal places.
     */
    public BigDecimal getAmountOfPaidOrders() {
        BigDecimal paidOrderAmount = BigDecimal.ZERO;
        for(Order o: orders) {
            if(o.getOrderStatus() == OrderStatus.PAID) {
                paidOrderAmount = paidOrderAmount.add(o.getAmount());
            }
        }
        return paidOrderAmount;
    }
}