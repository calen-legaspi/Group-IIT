package com.onb.orderingsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onb.orderingsystem.service.CreateOrderService;

public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CreateOrderService createOrderService;
       
	/**
	 * Display the Order Form. 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher view = request.getRequestDispatcher("order_form");
		
		if(session.isNew()) {
			
		}
		
		view.forward(request, response);
	}

	/**
	 * Receive Data.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
