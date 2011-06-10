package com.onb.orderingsystem.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class represents an Order of the Customer. 
 * An Order can be cancelled and/or modified by default. 
 * Editing of certain details is locked when the status is elevated to provide data integrity.
 */
public class Order implements Serializable {
    //TODO: perform calculations on the discount

    private int orderNumber;
    private Date date;
    private Set<OrderItem> orderItems;
    private OrderStatus orderStatus;
    private DiscountStatus discountStatus;
    private Customer customer;
    /*
     * Amount recorded during the time when it was ordered.
     */
    private BigDecimal amount;

    /**
     * A constructor that creates a new Order instance.
     * Sets the date field to the current date and the OrderStatus to "PROCESSING".
     * @param orderNumber Should be unique, equality checks are based on this.
     */
    public Order() {
        this.date = new Date();
        this.orderItems = new LinkedHashSet<OrderItem>();
        this.orderStatus = OrderStatus.PROCESSING;
        this.discountStatus = DiscountStatus.NO_DISCOUNT;
        this.amount = new BigDecimal("0.00");
    }

    /**
     * A constructor to reconstruct an instance from the database (probably).
     * @param orderumber Should be unique, equality checks are based on this.
     * @param date The date when the order was recorded.
     * @param orderItems The set of OrderItems to add to the order.
     * @param orderStatus The status of the order.
     * @param discountStatus the discount status of the order.
     * @param amount the computed amount after a discount has been applied. A field is necessary to avoid the price fluctuation discrepancy. 
     * @throws IllegalArgumentException Throws this exception when one of the argument has an illegal value.
     */
    public Order(int orderumber, Date date, Set<OrderItem> orderItems, OrderStatus orderStatus, DiscountStatus discountStatus, BigDecimal amount) throws IllegalArgumentException {
        this();
        this.orderNumber = orderumber;
        this.date = date;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
        this.discountStatus = discountStatus;
        this.amount = amount;
        updateAmount();
    }

    /**
     * Sets the order date to the date parameter. 
     * @param date 
     * @throws IllegalArgumentException Throws this exception when the parameter is null.
     */
    public void setDate(Date date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException();
        }
        this.date = date;
    }

    /**
     * Updates the orderStatus of the order.
     * Allowed transition is PROCESSING -> UNPAID -> PAID
     * @param orderStatus
     * @throws IllegalStateException Throws this exception when the transition from one state to the next is prohibited.
     */
    public void setOrderStatus(OrderStatus orderStatus) throws IllegalStateException {
        if(this.orderStatus == OrderStatus.PROCESSING && orderStatus == OrderStatus.UNPAID) {
            this.orderStatus = orderStatus;
        } else if(this.orderStatus == OrderStatus.UNPAID && orderStatus == OrderStatus.PAID) {
            this.orderStatus = orderStatus; //duplicate code alert. 
            //TODO: refactor
        } else {
            throw new IllegalStateException("Illegal state transition: From "+this.orderStatus+" to "+orderStatus);
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
     * Adds a new OrderItem to the Order. 
     * Updates the amount due after adding an order.
     * Existing OrderItems are treated as an increment to the quantity of the existing Order in the list.
     * Orders are identified uniquely by the Product they represent. 
     * <br/><b>Note</b>: This method can only be used if the orderStatus is set to "PROCESSING".
     * @param orderItem The OrderItem to add to the Order
     * @throws IllegalArgumentException Throws this exception when the argument is null.
     * @throws IllegalStateException Throws this exception when the orderStatus is not "PROCESSING".
     */
    public void addOrderItem(OrderItem orderItem) throws IllegalArgumentException, IllegalStateException {
        if(orderItem == null) {
            throw new IllegalArgumentException("OrderItem cannot be null.");
        }
        if(orderStatus == OrderStatus.PAID) {
            throw new IllegalStateException("Orders can no longer be added on paid orders.");
        }
        if(orderItems.contains(orderItem)) {
            for(OrderItem o: orderItems) {
                if(o.equals(orderItem)) {
                    o.setQuantity(o.getQuantity()+orderItem.getQuantity());
                    break;
                }
            }
        } else {
            orderItems.add(orderItem);
        }
        updateAmount();
    }
    
    //updates the total amount field during changes (works only in the PROCESSING state
    private void updateAmount() throws IllegalStateException {
        if(this.orderStatus != OrderStatus.PROCESSING) {
            return;
        }
        BigDecimal rawAmount = BigDecimal.ZERO;
        for(OrderItem o: orderItems) {
            rawAmount = rawAmount.add(o.getAmount());
        }
        
        BigDecimal discountedAmount = discountStatus.applyDiscount(rawAmount);
        
        amount = discountedAmount;
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
        if(orderItem == null) {
            throw new IllegalArgumentException("Parameter orderItem is null.");
        }
        if(orderStatus != OrderStatus.PROCESSING) {
            throw new IllegalStateException("Edit lock: You cannot modify the contents of the Order items.");
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
     * Get the amount to pay for the order.
     * Calculated during the date when the order was recorded.
     * @return the amount due.
     */
    public BigDecimal getAmount() {
        updateAmount();
        return amount.setScale(2);
    }
    
    /**
     * 
     * @param customer
     * @throws IllegalArgumentException
     * @throws IllegalStateException 
     */
    public void setCustomer(Customer customer) throws IllegalArgumentException, IllegalStateException {
        if(customer == null) {
            throw new IllegalArgumentException("Customer cant be null.");
        }
        if(orderStatus != OrderStatus.PROCESSING) {
            throw new IllegalStateException("Customer cannot be modified at this state.");
        }
        this.customer = customer;
    }
    
    /**
     * Gets the customer reference.
     * @return the customer who ordered this order.
     * @throws NullPointerException if the customer was not yet set.
     */
    public Customer getCustomer() throws NullPointerException {
        if(customer == null) {
            throw new NullPointerException("The customer was not yet set.");
        }
        return customer;
    }
}
