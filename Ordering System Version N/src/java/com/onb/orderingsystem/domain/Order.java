package com.onb.orderingsystem.domain;

/**
 * @author The Architect
 * @version 1.0
 * @created 07-Jun-2011 8:11:10 AM
 */
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class represents an Order of the Customer. 
 * An Order can be cancelled and/or modified by default. 
 * Editing of certain details is locked when the status is elevated to provide data integrity.
 */
public class Order {
	//TODO: perform calculations on the discount

	private int orderNumber;
	private Date date;
	private Set<OrderItem> orderItems;
	private OrderStatus orderStatus;
	private DiscountStatus discountStatus;
	
	/*
	 * The record to the amount paid at the time of payment.
	 * You're pretty much screwed if you don't keep tabs on the amount.
	 * The payment may vary depending on the amount previously paid.
	 */
	private BigDecimal amountPaid;
	
	/**
	 * A constructor that creates a new Order instance.
	 * Sets the date field to the current date and the OrderStatus to "PROCESSING".
	 * @param orderNumber Should be unique, equality checks are based on this.
	 */
	public Order() {
		this.date = new Date();
		this.orderItems = new LinkedHashSet<OrderItem>();
		this.orderStatus = OrderStatus.PROCESSING;
	}
	
	/**
	 * A constructor to reconstruct an instance from the database (probably).
	 * @param orderumber Should be unique, equality checks are based on this.
	 * @param date The date when the order was recorded.
	 * @param orderItems The set of OrderItems to add to the order.
	 * @param orderStatus The status of the order.
	 * @throws IllegalArgumentException Throws this exception when one of the argument has an illegal value.
	 */
	public Order(int orderumber, Date date, Set<OrderItem> orderItems, OrderStatus orderStatus) throws IllegalArgumentException {
		this();
		this.orderNumber = orderumber;
		this.date = date;
		this.orderItems = orderItems;
		this.orderStatus = orderStatus;
	}
	
	/**
	 * Sets the order date to the date parameter. 
	 * @param date 
	 * @throws IllegalArgumentException Throws this exception when the parameter is null.
	 */
	public void setDate(Date date) throws IllegalArgumentException {
		if(date == null) {
			throw new IllegalArgumentException();
		}
		this.date = date;
	}
	
	/**
	 * 
	 * @param status
	 * @throws IllegalStateException Throws this exception when the transition from one state to the next is prohibited.
	 */
	public void setOrderStatus(OrderStatus status) throws IllegalStateException {
		throw new UnsupportedOperationException("Operation not yet implemented!");
	}
	
	/**
	 * Adds a new OrderItem to the Order. 
	 * Existing OrderItems are treated as an increment to the quantity of the existing Order in the list.
	 * Orders are identified uniquely by the Product they represent. 
	 * <br/><b>Note</b>: This method can only be used if the orderStatus is set to "PROCESSING".
	 * @param orderItem The OrderItem to add to the Order
	 * @throws IllegalArgumentException Throws this exception when the argument is null.
	 * @throws IllegalStateException Throws this exception when the orderStatus is not "PROCESSING".
	 */
	public void addOrderItem(OrderItem orderItem) throws IllegalArgumentException, IllegalStateException {
		throw new UnsupportedOperationException("Operation not yet implemented!");
	}
	
	/**
	 * Removes on OrderItem from the Order.
	 * When non-existing orders are handed as parameter to the exception, this will throw an exception.
	 * <br/><b>Note</b>: This method can only be used if the orderStatus is set to "PROCESSING".
	 * @param orderItem
	 * @throws IllegalArgumentException Throws this exception when the argument is null or does not exist in the Order.
	 * @throws IllegalStateException Throws this exception when the orderStatus is not "PROCESSING".
	 */
	public void removeOrder(OrderItem orderItem) throws IllegalArgumentException, IllegalStateException {
		throw new UnsupportedOperationException("Operation not yet implemented!");
	}
	
	/**
	 * @return The unique identifier of the Order.
	 */
	public int getOrderNumber() {
		return orderNumber;
	}
	
	/**
	 * @return The date when the order was made.
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * @return The Set of OrderItems owned by this Order.
	 */
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	/**
	 * @return The OrderStatus of this order.
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
}
