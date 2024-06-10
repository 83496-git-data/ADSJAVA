<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
    <jsp:useBean id="lb" class="com.sunbeam.beans.RegistrationBeam"/>
	
	<jsp:setProperty name="lb" property="firstname" param="fname"/>
	<jsp:setProperty name="lb" property="lastname" param="lname"/>
	<jsp:setProperty name="lb" property="date" param="dob"/>
	<jsp:setProperty name="lb" property="email" param="email"/>
	<jsp:setProperty name="lb" property="password" param="passwd"/>
	<% lb.newRegister(); %>
	<% if(lb.getUser() != null   ) { %>
	 
		<jsp:forward page="index.jsp"/> 
	<% } else { %>
	   Fill valid details.
	<% } %>
</body>
</html>