/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.Customer;
import java.util.Set;

/**
 *
 * @author The Architect
 */
public interface CustomerDAO {
    public Set<Customer> getAvailableCustomers();
    public Set<Customer> getAllCustomers();
}
