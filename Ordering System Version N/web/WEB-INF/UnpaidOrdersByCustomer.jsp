<%-- 
    Document   : UnpaidOrdersByCustomer
    Created on : 06 11, 11, 2:48:06 PM
    Author     : juliusmercons
--%>
<%@page import="com.onb.orderingsystem.domain.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.onb.orderingsystem.domain.Customer"%>

<%
   Customer customerWithUnpaidOrders = (Customer)request.getAttribute("CustomerWithUnpaidOrders"); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordering System | <%=customerWithUnpaidOrders.getName()%>'s Unpaid Orders</title>
        <script type="text/javascript">
            function confirmPayment(id, price){
                var confirmed = confirm("Confirm Payment:\n\nOrder Number: "+id+"\nAmount: "+price)
                if(confirmed){
                    location.href="PayOrder?id="+id
                }
            }
        </script>
    </head>
    <body>
        <a href="UnpaidCustomers">Back to List of Unpaid Customers</a>
        <h3><%=customerWithUnpaidOrders.getName()%>'s Unpaid Orders</h3>
        <table>
            <tr>
                <th>Number</th>
                <th>Date of Order</th>
                <th>Amount</th>
                <th>&nbsp;</th>
            </tr>
            <% for(Order order: customerWithUnpaidOrders.getOrders()){ %>
            <tr>
                <td><%= order.getOrderNumber() %></td>
                <td><%= order.getDate() %></td>
                <td><%= order.getAmount() %></td>
                <td><input type="button" value="Set As Paid" onclick="confirmPayment(<%=order.getOrderNumber()%>,'<%=order.getAmount()%>')" /></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
