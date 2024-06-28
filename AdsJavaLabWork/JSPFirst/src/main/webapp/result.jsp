<%@page import="com.election.pojos.User"%>
<%@page import="com.election.javabeans.CandidateList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        margin: auto;
        overflow: hidden;
        padding: 20px;
        background: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h3 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        margin: 20px 0;
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 12px;
        text-align: center;
    }
    th {
        background-color: #f2f2f2;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    a {
        text-decoration: none;
        color: #009879;
        font-weight: bold;
    }
    a:hover {
        color: #006f56;
    }
    input[type="submit"] {
        display: block;
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        margin-top: 20px;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<jsp:useBean id="CandidateList" class="com.election.javabeans.CandidateList"/>
<div class='container'>
    <h3>Candidate List</h3>
    <h3>Hello, ${login.user.firstName}</h3>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Candidate Name</th>
                <th>Party</th>
                <th>Votes</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            ${CandidateList.fetchCandidateList()}
            <c:forEach var="c" items="${CandidateList.candidateList}">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.party}</td>
                <td>${c.votes}</td>
                <td><a href="edit.jsp?id=${c.id}">Edit</a> | <a href="delete.jsp?id=${c.id}">Delete</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <form method="get" action="logout.jsp">
        <input type="submit" value="LogOut"/>
    </form>
</div>
</body>
</html>
