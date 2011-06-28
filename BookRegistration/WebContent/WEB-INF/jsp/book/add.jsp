<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Registration</title>
</head>
<body>
<h1>Register Book</h1>
	<springform:form method="POST" commandName="book">
		<springform:label path="title">Book Title:</springform:label>
		<springform:input path="title" />
		<springform:errors path="title" cssStyle="color:red"/>
		<br/>
		<springform:label path="author">Author:</springform:label>
		<springform:select path="author">
			<springform:option value="0" label="Select Author" />
			<springform:options items="${authors}" itemValue="id" itemLabel="name"/>
		</springform:select>
		<springform:errors path="author" cssStyle="color:red"/>
		<br/>
		<input type="submit" />
	</springform:form>
</body>
</html>