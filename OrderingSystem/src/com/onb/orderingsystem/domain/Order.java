package com.onb.orderingsystem.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class represents an Order of the Customer. An Order can be cancelled
 * and/or modified by default. Editing of certain details is locked when the
 * status is elevated to provide data integrity.
 */
public class Order implements Serializable {

	private static final long serialVersionUID = -832643700388115957L;
	private int orderNumber;
	private Date date = new Date();
	private Set<OrderItem> orderItems = new LinkedHashSet<OrderItem>();
	private OrderStatus orderStatus = OrderStatus.PROCESSING;
	private DiscountStatus discountStatus = DiscountStatus.NO_DISCOUNT;
	private Customer customer;
	/*
	 * Amount recorded during the time when it was ordered.
	 */
	private BigDecimal amount = BigDecimal.ZERO;
	
	/**
	 * Creates a new instance of an order.
	 * @param orderNumber the unique identifier of the order.
	 */
	public Order(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	/**
	 * A constructor to reconstruct an instance from the database (probably).
	 * 
	 * @param orderumber
	 *            Should be unique, equality checks are based on this.
	 * @param date
	 *            The date when the order was recorded.
	 * @param orderItems
	 *            The set of OrderItems to add to the order.
	 * @param orderStatus
	 *            The status of the order.
	 * @param discountStatus
	 *            the discount status of the order.
	 * @param amount
	 *            the computed amount after a discount has been applied. A field
	 *            is necessary to avoid the price fluctuation discrepancy.
	 */
	public Order(int orderumber, Date date, Set<OrderItem> orderItems, OrderStatus orderStatus, DiscountStatus discountStatus, BigDecimal amount) {
		this(orderumber);
		this.date = date;
		this.orderItems = orderItems;
		this.orderStatus = orderStatus;
		this.discountStatus = discountStatus;
		this.amount = amount;
		updateAmount();
	}

	/**
	 * Sets the order date to the date parameter.
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("Date is null.");
		}
		this.date = date;
	}

	/**
	 * Updates the orderStatus of the order. Allowed transition is PROCESSING ->
	 * UNPAID -> PAID or PROCESSING -> CANCELLED
	 * 
	 * @param orderStatus
	 * @throws IllegalStateException
	 *             Throws this exception when the transition from one state to
	 *             the next is prohibited.
	 */
	public void setOrderStatus(OrderStatus orderStatus) throws IllegalStateException {
		if (this.orderStatus == OrderStatus.PROCESSING
				&& orderStatus == OrderStatus.UNPAID) {
			this.orderStatus = orderStatus;
		} else if (this.orderStatus == OrderStatus.UNPAID
				&& orderStatus == OrderStatus.PAID) {
			this.orderStatus = orderStatus;
		} else if (this.orderStatus == OrderStatus.PROCESSING
				&& orderStatus == OrderStatus.CANCELLED) {
			this.orderStatus = orderStatus;
		} else {
			throw new IllegalStateException("Illegal state transition: From "
					+ this.orderStatus + " to " + orderStatus);
		}
	}

	/**
	 * 
	 * @param discountStatus
	 */
	public void setDiscountStatus(DiscountStatus discountStatus) {
		this.discountStatus = discountStatus;
	}

	/**
	 * Adds a new OrderItem to the Order. Updates the amount due after adding an
	 * order. Existing OrderItems are treated as an increment to the quantity of
	 * the existing Order in the list. Orders are identified uniquely by the
	 * Product they represent. <br/>
	 * <b>Note</b>: This method can only be used if the orderStatus is set to
	 * "PROCESSING".
	 * 
	 * @param orderItem
	 *            The OrderItem to add to the Order
	 */
	public void addOrderItem(OrderItem orderItem) {
		if (orderItem == null) {
			throw new IllegalArgumentException("OrderItem cannot be null.");
		}
		if (orderStatus == OrderStatus.PAID) {
			throw new IllegalStateException(
					"Orders can no longer be added on paid orders.");
		}
		if (orderItems.contains(orderItem)) {
			for (OrderItem o : orderItems) {
				if (o.equals(orderItem)) {
					o.setQuantity(o.getQuantity() + orderItem.getQuantity());
					break;
				}
			}
		} else {
			orderItems.add(orderItem);
		}
		updateAmount();
	}

	private void updateAmount() throws IllegalStateException {
		if (this.orderStatus != OrderStatus.PROCESSING) {
			return;
		}
		BigDecimal rawAmount = BigDecimal.ZERO;
		for (OrderItem o : orderItems) {
			rawAmount = rawAmount.add(o.getAmount());
		}

		BigDecimal discountedAmount = discountStatus.applyDiscount(rawAmount);

		amount = discountedAmount;
	}

	/**
	 * Removes on OrderItem from the Order. When non-existing orders are handed
	 * as parameter to the exception, this will throw an exception. <br/>
	 * <b>Note</b>: This method can only be used if the orderStatus is set to
	 * "PROCESSING".
	 * 
	 * @param orderItem
	 */
	public void removeOrder(OrderItem orderItem) {
		if (orderItem == null) {
			throw new IllegalArgumentException("Parameter orderItem is null.");
		}
		if (orderStatus != OrderStatus.PROCESSING) {
			throw new IllegalStateException("You cannot modify the contents of the Order items at this state.");
		}
		this.orderItems.remove(orderItem);
		updateAmount();
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
	 * Gets the discount status of the order.
	 * 
	 * @return the discount status of the order.
	 */
	public DiscountStatus getDiscountStatus() {
		return discountStatus;
	}

	/**
	 * @return The OrderStatus of this order.
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Get the amount to pay for the order. Calculated during the date when the
	 * order was recorded.
	 * 
	 * @return the amount due.
	 */
	public BigDecimal getAmount() {
		updateAmount();
		return amount.setScale(2);
	}

	/**
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException("Customer cant be null.");
		}
		if (orderStatus != OrderStatus.PROCESSING) {
			throw new IllegalStateException( "Customer cannot be modified at this state." );
		}
		this.customer = customer;
	}

	/**
	 * Gets the customer reference.
	 * 
	 * @return the customer who ordered this order.
	 */
	public Customer getCustomer() {
		if (customer == null) {
			throw new NullPointerException("The customer was not yet set.");
		}
		return customer;
	}

	/**
	 * The human readable form of the Order
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return date + "#" + orderNumber + " Amount: " + amount;
	}
}
