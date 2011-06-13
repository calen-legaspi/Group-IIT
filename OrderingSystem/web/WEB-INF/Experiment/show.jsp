<%--
//TODO: use scripting, not java codes you lame programmer...:P
--%>
<%@page import="com.onb.orderingsystem.domain.SimpleObject"%>
<% SimpleObject so = (SimpleObject) request.getAttribute("simple"); %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show the Person with a Dog</title>
    </head>
    <body>
        <h1>Hello <%= so.getName() %> your dog's name is <%= so.getDog() %></h1>
    </body>
</html>
