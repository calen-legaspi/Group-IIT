<%-- 
    Document   : index
    Created on : Jun 9, 2011, 10:03:16 PM
    Author     : The Architect
--%>
<%@page import="com.onb.orderingsystem.util.EnvironmentEntry"%>
<% 

String str = EnvironmentEntry.getAsString("testString");     
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordering System</title>
    </head>
    <body>
        <h1>Ordering System Welcome Page!!! <%= str %></h1>
    </body>
</html>
