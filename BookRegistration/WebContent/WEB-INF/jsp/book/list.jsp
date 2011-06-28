<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book List</title>
</head>
<body>
<c:url var="addBook" value="/book/add"/>
<c:url var="home" value="/home"/>

<h1>Books:</h1>
<a href="${home}">Back</a> | <a href="${addBook}">Add</a>
<table>
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Author</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="book" items="${books}">
		<c:url var="editBook" value="/book/edit/${book.id}"/>
		<c:url var="deleteBook" value="/book/delete/${book.id}"/>
		
		<tr>
			<td><c:out value="${book.id}" /></td>
			<td><c:out value="${book.title}" /></td>
			<td><c:out value="${book.author}" /></td>
			<td><a href="${editBook}">Edit</a></td>
			<td><a href="${deleteBook}">X</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>