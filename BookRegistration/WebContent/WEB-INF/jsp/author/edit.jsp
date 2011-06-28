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
	<c:url var="editSubmit" value="/author/edit"/>
	
	<h1>Edit Author</h1>
	<a href="${listAuthor}">Back</a>
	<springform:form action="${editSubmit}" method="POST" commandName="author">
		<springform:hidden path="id"/>
		<springform:label path="name">Name</springform:label>
		<springform:input path="name" />
		<springform:errors path="name" cssStyle="color:red"/>
		<input type="submit" value="Edit"/>
	</springform:form>
</body>
</html>