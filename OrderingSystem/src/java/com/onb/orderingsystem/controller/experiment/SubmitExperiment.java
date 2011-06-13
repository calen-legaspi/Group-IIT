/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.controller.experiment;

import com.onb.orderingsystem.domain.SimpleObject;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitExperiment extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleObject simpleObject = new SimpleObject();
        
        simpleObject.setName(request.getParameter("name"));
        simpleObject.setDog(request.getParameter("dog"));

        request.setAttribute("simple", simpleObject);

        RequestDispatcher view = request.getRequestDispatcher("/experiment_show");
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
