package com.onb.orderingsystem.domain;

import java.math.BigDecimal;

/**
 * Represents a product with its current price on it.
 */
public class Product {

    private int skuNumber;
    private String name;
    private BigDecimal amount;
    
    /**
     * Default constructor.
     * For creating a new instance.
     * @param name
     * @param amount
     * @throws IllegalArgumentException 
     */
    public Product(String name, BigDecimal amount) throws IllegalArgumentException {
        if (name == null || name.equals("") || amount == null || amount.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("One of the parameter is null or contains an illegal value.");
        }
        this.name = name;
        this.amount = amount;
    }

    /**
     * Database reconstructor requires all three parameters.
     * @param skuNumber A unique identifier of the Product.
     * @param name The name of the Product.
     * @param amount The unit price of the Product.
     */
    public Product(int skuNumber, String name, BigDecimal amount) throws IllegalArgumentException {
        this(name, amount);
        if(skuNumber == 0) {
            throw new IllegalArgumentException("Skunumber cannot be zero.");
        }
        this.skuNumber = skuNumber;
    }

    /**
     * Sets the unit price/amount of the product.
     * @param amount The new unit price that you want to change this amount into.
     * @throws IllegalArgumentException Throws this exception when the parameter is null, zero, or negative.
     */
    public void setAmount(BigDecimal amount) throws IllegalArgumentException {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) >= 0) {
            throw new IllegalArgumentException("Amount cant be null, zero, or negative.");
        }
        this.amount = amount;
    }

    /**
     * @param name The new name of the product.
     * @throws IllegalArgumentException Throws this exception when the parameter is empty/null.
     */
    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name cant be null or empty.");
        }
        this.name = name;
    }

    /**
     * @return The stock-keeping unit number. This uniquely identifies a product. Equality operations are dependent on this.
     */
    public int getSkuNumber() {
        return skuNumber;
    }

    /**
     * @return The product name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The amount (price per unit) of the product.
     */
    public BigDecimal getAmount() {
        return amount;
    }
    
    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Product)) {
            throw new IllegalArgumentException("The parameter is not a product");
        }
        Product p = (Product)o;
        if(p.getSkuNumber() == getSkuNumber()) {
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hashCode = 8;
        hashCode += getSkuNumber();
        return hashCode;
    }
}
