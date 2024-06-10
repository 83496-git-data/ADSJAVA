<%@page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page Demo</title>
</head>
<body>
	
	<% Random r = new Random(); %>
	<%
			int num = r.nextInt(5);
			out.println("Divisin: 100 / " + num + " = " +(100 / num));
	%>
</body>
</html>