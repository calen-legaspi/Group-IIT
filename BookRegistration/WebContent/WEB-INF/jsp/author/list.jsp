<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Author List</title>
</head>
<body>

<c:url var="addAuthor" value="/author/add"/>
<c:url var="home" value="/home"/>

<h1>Authors:</h1>
<a href="${home}">Back</a> | <a href="${addAuthor}">Add</a>
<table>
	<tr>
		<th>ID</th>
		<th>Author</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="author" items="${authors}">
		<c:url var="editAuthor" value="/author/edit/${author.id}"/>
		<c:url var="deleteAuthor" value="/author/delete/${author.id}"/>
		
		<tr>
			<td><c:out value="${author.id}" /></td>
			<td><c:out value="${author.name}" /></td>
			<td><a href="${editAuthor}">Edit</a></td>
			<td><a href="${deleteAuthor}">X</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>