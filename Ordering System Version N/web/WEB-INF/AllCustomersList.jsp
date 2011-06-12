<%-- 
    Document   : AllCustomersList
    Created on : 06 12, 11, 12:57:41 PM
    Author     : juliusmercons
--%>

<%@page import="java.util.HashSet"%>
<%@page import="com.onb.orderingsystem.domain.Customer"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   Set<Customer> listOfCustomers = (HashSet<Customer>) request.getAttribute("ListOfCustomers");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordering System | List of Customers</title>
    </head>
    <body>
        <h3>List of Customers</h3>
        <table>
            <tr>
                <th>Customer ID</th>
                <th>Name</th>
                <th>&nbsp;</th>
            </tr>
            <% for(Customer customer: listOfCustomers){ %>
            <tr>
                <td align="center"><%=customer.getId()%></td>
                <td><%=customer.getName()%></td>
                <td><input type="button" value="View Order History" /></td>
            </tr>
            <% } %>
        </table>
        
    </body>
</html>
