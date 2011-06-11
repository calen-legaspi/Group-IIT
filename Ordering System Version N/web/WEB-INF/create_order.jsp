<%-- 
    Document   : create_order
    Created on : 06 10, 11, 5:39:27 PM
    Author     : juliusmercons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordering System | New Order</title>
    </head>
    <body>
        <h3>New Customer Order</h3>
        <table>
            <tr>
                <td>Order Number:</td>
                <td>1</td>
            </tr>
            <tr>
                <td>Date</td>
                <td><input type="text" name="date" value="June 5, 2011" /></td>
            </tr>
            <tr>
                <td>Customer:</td>
                <td>
                    <select>
                        <option>Maria Aguanta</option>
                        <option>Juan Tamad</option>
                    </select>
                </td>
            </tr>
        </table><br/>
Items:
<table>
    <tr>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>&nbsp;</th>
    </tr>
    
</table>
    </body>
</html>
