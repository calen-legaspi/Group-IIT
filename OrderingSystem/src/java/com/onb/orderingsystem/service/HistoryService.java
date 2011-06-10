/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service;

import com.onb.orderingsystem.domain.Customer;
import java.util.Set;

/**
 *
 * @author The Architect
 */
public interface HistoryService {
    public Set<Customer> getCustomers();
}
