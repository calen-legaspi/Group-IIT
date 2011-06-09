<%-- 
    Document   : showcust
    Created on : 06 9, 11, 4:16:38 PM
    Author     : juliusmercons
--%>
<%@page import="com.onb.orderingsystem.service.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello</h1>
        <% AddCustomer add = new AddCustomer(); %>
        <% add.addCustomerData(request.getParameter("cust_name")); %>
        Successful!!!
    </body>
</html>
