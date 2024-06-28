<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <jsp:useBean id="register" class="com.election.javabeans.RegisterBeans"></jsp:useBean>
      <jsp:setProperty property="firstName" name="register" param="fname"/>
      <jsp:setProperty property="lastName" name="register" param="lname"/>
      <jsp:setProperty property="email" name="register" param="email"/>
      <jsp:setProperty property="password" name="register" param="password"/>
      <jsp:setProperty property="dob" name="register" param="dob"/>
      
      <% int result = register.registerUser(); %>
      
      <%if(result >0 ) {%> <jsp:forward page="login.jsp"/>
      <% }else  {%> <h1>register Failure</h1><%} %>
</body>
</html>