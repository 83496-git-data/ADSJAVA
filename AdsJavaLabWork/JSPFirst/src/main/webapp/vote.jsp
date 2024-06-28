<%@page import="com.election.pojos.User"%>
<%@page import="com.election.javabeans.VotesBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	width: 80%;
	margin: 50px auto;
	background: #fff;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	text-align: center;
}

h1, h3 {
	color: #333;
}

a {
	color: #4CAF50;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<h1>Votes SuccessFul!!!</h1>
	<h3>Hello, ${login.user.firstName}</h3>
	<hr/>
	<jsp:useBean id="vote" class="com.election.javabeans.VotesBeans" />
	<jsp:setProperty property="userId" name="vote" value="${login.user.id}" />
	<jsp:setProperty property="id" name="vote" param="candidateId" />
	<%--  <h1>vote id = ${ vote.id}</h1>
  <h1>vote userId = ${ vote.usereId}</h1>--%>

	<%
	vote.giveVote();
	%>
	<c:choose>
		<c:when test="${vote.flag}">
					Your vote is registered successfully. <br />
			<br />
					Thank You!!!
		</c:when>
		<c:when test="${!vote.flag}">
			Your vote is already registered successfully. <br />
			<br />
			Thank You!!!	
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<a href="index.jsp">Login Again</a>
</body>
</html>