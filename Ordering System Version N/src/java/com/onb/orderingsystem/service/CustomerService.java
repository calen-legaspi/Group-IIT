/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service;

import com.onb.orderingsystem.dao.CustomerDAO;
import com.onb.orderingsystem.dao.impl.CustomerDAOimp;
import com.onb.orderingsystem.domain.Customer;
import java.util.Set;

/**
 *
 * @author juliusmercons
 */
public class CustomerService {
 
    public Customer getCustomerById(int customer_id){
        return new CustomerDAOimp().findById(customer_id);
    }
    
    public Set<Customer> getUnpaidCustomers(){    
        CustomerDAO dao =new CustomerDAOimp();
        return dao.getAllUnpaid();
    }
    
    public Set<Customer> getAllCustomers(){
        CustomerDAO dao = new CustomerDAOimp();
        return dao.getAllCustomers();
    }
}
