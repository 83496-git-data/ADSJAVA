<%@page import="com.election.pojos.User"%>
<%@page import="com.election.javabeans.EditBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <jsp:useBean id="edit" class="com.election.javabeans.EditBeans"></jsp:useBean>
      <jsp:setProperty name="edit" property="*" />
    <% edit.updateCandidate(); %>
    <c:choose>
		<c:when test="${edit.count == 1}">
			<c:redirect url="result.jsp"/>
		</c:when>
		<c:otherwise>
			Candidate update failed. <br/><br/>
			<a href="result.jsp">Show Result</a>
		</c:otherwise>
	</c:choose>
</body>
</html>