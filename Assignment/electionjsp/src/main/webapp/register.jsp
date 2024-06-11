
<%@page import="com.sunbeam.beans.RegistrationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h3>${initParam.appTitle }</h3>
	<%-- --%>
	<%--
		RegistrationBean rb = new RegistrationBean();
		rb.setFirstName(request.getParameter("firstName"));
		rb.setLastName(request.getParameter("lastName"));
		rb.setEmail(request.getParameter("email"));
		rb.setPassword(request.getParameter("passwd"));
		rb.setBirth(request.getParameter("birth"));
		rb.setStatus(0);
		rb.setRole("voter");
		rb.registerUser();
		if(rb.getCount()==1)
				out.println("Registration successfull");
		else
			
			out.println("Registration failed");

	--%>

	<%-- Jsp --%>
	
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegistrationBean" />
	<%--
	<jsp:setProperty name="rb" property="firstName" param="firstName" />
	<jsp:setProperty name="rb" property="lastName" param="lastName" />
	<jsp:setProperty name="rb" property="email" param="email" />
	<jsp:setProperty name="rb" property="passwd" param="passwd" />
	<jsp:setProperty name="rb" property="birth" param="birth" />
	--%>
	 
	<jsp:setProperty name="rb" property="*" />   <%-- reduce code --%>
	<jsp:setProperty name="rb" property="status" param="0" />
	<jsp:setProperty name="rb" property="role" param="voter" />
	<%--<% rb.registerUser(); --%>
	
	${rb.registerUser() }
	
	<% if(rb.getCount() == 1) { %>
		Registration successful.
		<a href="index.jsp">Sign In</a>
	<% } else { %>
		Registration failed.
		<a href="newuser.jsp">Sign Up</a>
	<% } %>
	  
</body>
</html>