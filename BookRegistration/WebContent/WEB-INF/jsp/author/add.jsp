<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="listAuthor" value="/author/list"/>
	
	<h1>Add New Author</h1>
	<a href="${listAuthor}">Back</a>
	<springform:form method="POST" commandName="author">
		<springform:label path="name">Name</springform:label>
		<springform:input path="name" />
		<springform:errors path="name" cssStyle="color:red"/>
		<input type="submit" />
	</springform:form>
</body>
</html>