package com.onb.orderingsystem.domain;

import java.math.BigDecimal;

/**
 * OrderItems represent the items included in the Order.
 * Duplication check is done through Product comparison, 
 * So no two OrderItems with the same Product can exist on the same Set.
 */
public class OrderItem {

    private int id;
    private int quantity;
    private Product product;
    private Order order;

    /**
     * @param product
     * @param quantity
     * @throws IllegalArgumentException Throws this exception when the product parameter is null.
     */
    public OrderItem(Product product, int quantity) throws IllegalArgumentException {
        if (product == null) {
            throw new IllegalArgumentException("The product cant be null.");
        }
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * A constructor designed for reconstructing an instance stored in the database.
     * @param id The id generated after this has been inserted into the database.
     * @param product
     * @param quantity
     * @throws IllegalArgumentException if the product is null.
     */
    public OrderItem(int id, Product product, int quantity) throws IllegalArgumentException {
        this(product, quantity);
        this.id = id;
    }

    /**
     * Sets the quantity of the OrderItem to the specified argument.
     * @param quantity The new quantity of the ordered item.
     * @throws IllegalArgumentException Throws this exception when the argument is less than zero.
     */
    public void setQuantity(int quantity) throws IllegalArgumentException {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cant be less than zero.");
        }
        this.quantity = quantity;
    }

    /**
     * Computes and returns the amount of this order item,
     * by multiplying the quantity and the product price.	
     * @return
     */
    public BigDecimal getAmount() {
        return product.getAmount().multiply(new BigDecimal(getQuantity()));
    }
    
    /**
     * Gets the quantity of this order item.
     * @return the quantity of this item.
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * 
     * @return the hash code of the OrderItem.
     */
    @Override
    public int hashCode() {
        return product.hashCode();
    }

    /**
     * 
     * @param obj the order item to compare this to.
     * @return true if the OrderItem contains the same product.
     * @throws IllegalArgumentException if the parameter is null or not an OrderItem.
     */
    @Override
    public boolean equals(Object obj) throws IllegalArgumentException {
        if(obj == null) {
            throw new IllegalArgumentException("Parameter cant be null.");
        }
        if(!(obj instanceof OrderItem)) {
            throw new IllegalArgumentException("Parameter must be an OrderItem.");
        }
        OrderItem oi = (OrderItem)obj;
        if(oi.product == product) {
            return true;
        }
        return true;
    }
    
    /**
     * Sets the order reference to the order conatining this orderitem.
     * @param order the order reference to the order containing this orderitem.
     * @throws IllegalArgumentException if the parameter is null.
     * @throws IllegalStateException if the order is in an unmodifiable state.
     */
    public void setOrder(Order order) throws IllegalArgumentException, IllegalStateException{
        if(order == null) {
            throw new IllegalArgumentException("Order cant be null.");
        }
        if(this.order == null) {
            this.order = order;
        } else {
            if(order.getOrderStatus() == OrderStatus.PROCESSING) {
                this.order = order;
            } else {
                throw new IllegalStateException("Order item cannot be modified at this state.");
            }
        }
    }
    
    /**
     * Gets the order containing the order item.
     * @return the reference to the order containing this orderitem.
     * @throws NullPointerException 
     */
    public Order getOrder() throws NullPointerException {
        if(order == null) {
            throw new NullPointerException("Order was not yet set.");
        }
        return order;
    }
}
