<%-- JSP Directive --%>
<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Syntax</title>
</head>
<body>
	<h1>JSP Syntax Demo</h1>
	<!-- HTML comment -->
	<%-- JSP comment --%>
	
	<%-- JSP Declaration --%>
	<%!
		int count = 0;
	
		public void jspInit(){
			System.out.println("demo1 jsInit() called");
		}
		
		public void jspDestroy(){
			System.out.println("demo01 jspDestroy() called");
		}
	%>
	
	<%-- JSP Scriptlet --%>
	<%
		Date now = new Date();
		out.println("Server Time:" + now);
	%>
	
	<br/><br/>
	
	<% count++; %>
	<% if(count % 2 == 0){ %>
	 	even Count: <%= count %>
	 <% } else { %>
	 		odd Count: <%=count %> <%-- JSP Expression --%>
	 <% } %>
	 <br/> <br/>
	 
	 <%
	 	if(count % 2 == 0)
	 		out.println("Even Count:" + count);
	 	else
	 		out.println("Odd Count" + count);
	 %>
</body>
</html>