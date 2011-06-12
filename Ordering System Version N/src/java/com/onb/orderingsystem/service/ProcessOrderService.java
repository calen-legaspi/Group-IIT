/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.service;

import com.onb.orderingsystem.dao.OrderDAO;
import com.onb.orderingsystem.dao.impl.OrderDAOImp;

/**
 *
 * @author juliusmercons
 */
public class ProcessOrderService {
    
    public void processUnpaidOrder(int order_number){
        OrderDAO order_dao = new OrderDAOImp();
        order_dao.payCustomerOrder(order_number);
    }
    
    public int getCustomerIdAssocWithOrder(int order_number){
        OrderDAO order_dao = new OrderDAOImp();
        return  order_dao.getCustomerIdAssocWithOrder(order_number);
    }
}
