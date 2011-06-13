/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.controller.createorders;

import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.InventoryItem;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.service.OrderService;
import com.onb.orderingsystem.service.ServiceException;
import com.onb.orderingsystem.service.impl.OrderServiceImpl;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateOrder extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService os = new OrderServiceImpl();
        Set<Customer> availableCustomer = new LinkedHashSet<Customer>();
        Set<InventoryItem> availableItems = new LinkedHashSet<InventoryItem>();
        Order order = new Order();
        
        HttpSession session = request.getSession();
        if(session.isNew()) {
            try {
                availableCustomer = os.getAvailableCustomers();
                availableItems = os.getAvailableInventoryItems();
            } catch (ServiceException e) {
                //TODO: exception handling codes here
            }
        } else {
            //TODO: retrieve session
        }
        
        request.setAttribute("customers", availableCustomer);
        request.setAttribute("order", order);
        
        RequestDispatcher view = request.getRequestDispatcher("/order_form");
        view.forward(request, response);
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
