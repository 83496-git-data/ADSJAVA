<%@page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<h3>Error Page</h3>
	Some error occurred. Please contact your vendor. <br/>
	Email: nilesh@sunbeaminfo.com <br/><br/>
sss	Error: <%= exception.getMessage() %>
</body>
</html>