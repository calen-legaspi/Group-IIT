package com.onb.orderingsystem.domain;

import java.math.BigDecimal;

/**
 * A constant representing a discount status of an order.
 * Orders by default shall have no discount.
 * Customers who have already paid more than/equal to 1 Million Php shall have a 10% discount for the current order.
 * An Order shall indicate if it is discounted using this enum.
 */
public enum DiscountStatus {

    /**
     * No discount.
     */
    NO_DISCOUNT(new BigDecimal("0.00")), 
    
    /**
     * 10% Discount.
     * For customers who have reached the 1-million-peso-paid status.
     */
    TEN_PERCENT(new BigDecimal("0.10"));
    
    private BigDecimal discountRate;

    DiscountStatus(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * Performs a calculation on the parameter to retreive the amount when this discount is applied.
     * @param originalAmount The amount without a discount.
     * @return The amount after this discount is applied.
     */
    public BigDecimal applyDiscount(BigDecimal originalAmount) {
        return originalAmount.subtract(originalAmount.multiply(discountRate));
    }
}