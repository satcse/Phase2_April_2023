<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Bean Properties</title>
</head>
<body> 
	<jsp:useBean id="productBean" class="com.ecommerce.ProductBean"
		scope="session"></jsp:useBean>
	Product Name:
	<jsp:getProperty name="productBean" property="productName" />
	<br> Product Price:
	<jsp:getProperty name="productBean" property="price" />
	<br>
</body>
</html>