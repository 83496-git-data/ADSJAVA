<%@page import="com.election.pojos.User"%>
<%@page import="com.election.javabeans.EditBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    h1 {
        color: #333;
    }
    form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #f9f9f9;
    }
    input[type="text"] {
        width: calc(100% - 22px);
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 3px;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
   
    <jsp:useBean id="edit" class="com.election.javabeans.EditBeans"></jsp:useBean>
    <jsp:setProperty property="id" name="edit" param="id"/>
    <% edit.fetchCandidate(); %>
    <form method="post" action="update.jsp">
     <h1>Edit Form</h1>
        <input type="hidden" name="id" value="${edit.candidate.id}"/>
        Name: <input type="text" name="name" value="${edit.candidate.name}"/> <br/><br/>
        Party: <input type="text" name="party" value="${edit.candidate.party}"/> <br/><br/>
        Votes: <input type="text" name="votes" value="${edit.candidate.votes}" readonly="readonly"/> <br/><br/>
        <input type="submit" value="Update Candidate"/>
    </form>  
</body>
</html>
