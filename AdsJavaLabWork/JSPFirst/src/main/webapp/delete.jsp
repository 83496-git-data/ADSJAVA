<%@page import="com.election.pojos.User"%>
<%@page import="com.election.javabeans.DeleteBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
  <jsp:useBean id="delete" class="com.election.javabeans.DeleteBeans"></jsp:useBean>
      <jsp:setProperty name="delete" property="*" />
    <% int count = delete.deleteCandidate(); %>
    <c:choose>
		<c:when test="${count >0}">
			<c:redirect url="result.jsp"/>
		</c:when>
		<c:otherwise>
			Candidate Delete failed. <br/><br/>
			<a href="result.jsp">Show Result</a>
		</c:otherwise>
	</c:choose>
   
</body>
</html>