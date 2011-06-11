<%-- 
    Document   : showUnpaidCustomers
    Created on : 06 10, 11, 9:39:22 AM
    Author     : juliusmercons
--%>

<%@page import="java.util.HashSet"%>
<%@page import="com.onb.orderingsystem.domain.Customer"%>
<%@page import="java.util.Set"%>
<%@page import="com.onb.orderingsystem.service.CustomerService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   Set<Customer> listOfCustomers = (HashSet<Customer>) request.getAttribute("ListOfCustomers");
%>
<!DOCTYPE html>
<html>
<head>
<title>Ordering System | List of Unpaid Customers</title>
</head>
<body>
<h3>Customers With Unpaid Orders</h3>
<table>
<tr>
<th>Name</th>
<td>&nbsp;</td>
</tr>
<% for(Customer cust: listOfCustomers){ %>
<tr>
    <td><%= cust.getName() %></td>
<td><input type="button" name="showOrders" value="Show Orders" onclick="location.href='UnpaidOrders?customer_id=<%= cust.getId() %>'"/></td>
</tr>
<% } %>
</table>
</body>
</html>
