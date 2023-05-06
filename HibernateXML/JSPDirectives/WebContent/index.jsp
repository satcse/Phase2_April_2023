<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Directives</title>
</head>
<body>
	This is content from the main file.
	<%@ include file="included.jsp"%>
	<hr>
	Example of using JSTL taglibs for formatting output
	<br>

	<%
		// Please Refer this below content
		//<%@ page --> Page Directive
		//<%@ include --> Include Directive
		//<%@ taglib --> Taglib Directive
		//<%=  --> JSP Expressions
	%>	
</body>
</html>