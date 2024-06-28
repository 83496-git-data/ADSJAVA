<%@page import="com.election.pojos.User"%>
<%@page import="com.election.javabeans.CandidateList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Candidates</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h3 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        input[type='submit'] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-decoration: none;
            cursor: pointer;
            margin-top: 20px;
        }
        input[type='submit']:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<jsp:useBean id="CandidateList" class="com.election.javabeans.CandidateList"/>
    <div class='container'>
        <h3>Candidate List</h3>
        <h3>Hello , ${login.user.firstName }</h3>
        <!-- Announcement will be dynamically inserted here -->
        <form method='post' action='vote.jsp'>
            <table>
                <thead>
                    <tr>
                        <th>Select</th>
                        <th>Candidate Name</th>
                        <th>Party</th>
                    </tr>
                </thead>
                <tbody>
                     ${CandidateList.fetchCandidateList()}
                     <c:forEach var="c" items="${CandidateList.candidateList }">
                     <tr>
                        <td><input type='radio' name='candidateId' value='${c.id}'/></td>
                        <td>${c.name }</td>
                        <td>${c.party}</td>
                     </tr>   
                      </c:forEach>  
                </tbody>
            </table>
            <input type='submit' value='Vote'/>
        </form>
    </div>
</body>
</html>
