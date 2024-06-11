<%@page import="com.sunbeam.pojos.Candidate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="cs" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Candidate List </title>
</head>
<body>
	<%-- <h3>Online voting</h3>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"/>
	Hello, <jsp:getProperty property="email" name="lb" /> <hr/>
	--%>
	
	
	<h3>${ initParam.appTitle }</h3>
	Hello, ${lb.user.firstName} ${lb.user.lastName } <hr/>
	<jsp:useBean id="clb" class="com.sunbeam.beans.CandidateListBean"/>
	<%--  <% clb.fetchCandidate(); %> --%>
	
	
	${clb.fetchCandidates() } <%-- JSP EL --%>
 	<%-- <% for(Candidate c : clb.getCandidateList()) { %>
			<input type="radio" name="candidate" value="<%= c.getId() %>"/> <%= c.getName() %> - <%= c.getParty() %> <br/>
		<% } %>	 --%>
		
		 <form method="post" action="vote.jsp"/>
		<c:forEach var="c" items="${clb.candidateList }">
			<input type="radio" name="candidate" value="${c.id}"/> ${c.name} - ${c.party} <br/>
		</c:forEach>
		<br/> <input type="submit" value="Vote"/>
		 </form>
				
</body>
</html>