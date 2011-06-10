package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.Customer;
import java.util.Set;

public interface CustomerDAO {
    public void create(Customer t);
    public void update(Customer t);
    public void delete(Customer t);
    public Customer findById(int id);
    public Set<Customer> getAll();
    
    
}
