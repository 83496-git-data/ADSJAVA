<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.sunbeam.beans.CandidateBeans" %>
<%@ page import="com.sunbeam.pojos.Candidate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidates list</title>
</head>
<body>
	<% 
	CandidateBeans candidateListBean = new CandidateBeans();
        candidateListBean.candidateList();
        List<Candidate> list = candidateListBean.getList();
    %>
    <form method='post' action='vote'>
        <% for(Candidate c : list) { %>
            <input type='radio' name='candidate' value='<%= c.getId() %>'/> <%= c.getName() %> (<%= c.getParty() %>) <br/>
        <% } %>
        <input type='submit' value='Vote'/>
    </form>
</body>
</html>