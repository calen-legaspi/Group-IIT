package com.onb.orderingsystem.controller.experiment;

import com.onb.orderingsystem.domain.SimpleObject;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExperimentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SimpleObject simpleObject = new SimpleObject();
        
        request.setAttribute("simple", simpleObject);
        request.setAttribute("username", "Mr. Somebody");
        
        if(!session.isNew()) {
            simpleObject.setName(request.getParameter("name"));
            simpleObject.setDog(request.getParameter("dog"));
        }
        
        RequestDispatcher view = request.getRequestDispatcher("/experiment_form");
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
