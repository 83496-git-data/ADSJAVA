<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <h3>New User Register</h3>
   <form method="post" action=" register.jsp">
   First Name: <input type="text" name="fname"> <br/><br/>
   last name: <input type="text" name="lname"> <br/><br/>
    Date of Birth: <input type="date" name="dob"> <br/><br/>
   email: <input type="text" name="email"> <br/><br/>
   Password: <input type="email" name="passwd">  <br/><br/>
  
  <input type="submit" value="Register"/>
  <a href="index.jsp">Sign In</a>
   </form>
</body>
</html>