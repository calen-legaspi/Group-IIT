/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service;
import com.onb.orderingsystem.dao.*;
import com.onb.orderingsystem.dao.impl.CustomerDAOimp;
import com.onb.orderingsystem.domain.*;
/**
 *
 * @author juliusmercons
 */
public class AddCustomer {
    public void addCustomerData(String name){
        Customer cust = new Customer(name);
        CustomerDAO dao =new CustomerDAOimp();
        dao.create(cust);
    }
}
