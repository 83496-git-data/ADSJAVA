<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Successful</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        text-align: center;
        padding-top: 50px;
    }
    .message {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border-radius: 5px;
        margin: 20px;
        display: inline-block;
    }
    .logout-link {
        text-decoration: none;
        color: #333;
        font-weight: bold;
        margin-top: 10px;
        display: block;
    }
</style>
</head>
<body>
    <div class="message">
        <h1>${login.user.firstName} Logout Successful!</h1>
    </div>
    <% session.invalidate(); %>
    <a href="index.jsp" class="logout-link">Login Again</a>
</body>
</html>
