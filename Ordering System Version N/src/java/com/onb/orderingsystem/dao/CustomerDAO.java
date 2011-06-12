package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.Customer;
import java.util.Set;

public interface CustomerDAO {
    
    public Customer findById(int id);
    public Set<Customer> getAllCustomers();
    public Set<Customer> getAllUnpaid();
    
    
}
