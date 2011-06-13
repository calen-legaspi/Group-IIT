/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service;

import java.math.BigDecimal;

/**
 *
 * @author The Architect
 */
public class CreditLimitExceededException extends ServiceException {
    private BigDecimal creditLimit;
    private BigDecimal exceededAmount;
   
    public CreditLimitExceededException(String message, BigDecimal creditLimit, BigDecimal exceededAmount) {
        super(message);
        this.creditLimit = creditLimit;
        this.exceededAmount = exceededAmount;
    }
    
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }
    
    public BigDecimal getExceededAmount() {
        return exceededAmount;
    }
}
