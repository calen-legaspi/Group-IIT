
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
        <title>Experiment with Beans</title>
    </head>
    <body>
        <h1>Hello <%= request.getAttribute("username") %> </h1>
        <form method="POST">
            Name: <input type="text" value="<%= so.getName() %>" name="name" /><br />
            Dog: <input type="text" value="<%= so.getDog() %>" name="dog"/><br />
            <input type="submit" value="Submit" action="experiment_submit"/>
            <input type="button" value="Refresh" action="experiment"/>
        </form>
    </body>
</html>
