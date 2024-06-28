<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>
		Welcome !
	</h5>
	<h5>
		<%--add c:url tag for URL rewriting --%>
		<c:url var="abc" value="/test1" />
		<a href="${abc}">Test Model And View</a>
	</h5>
	<h5>
		<%--add c:url tag for URL rewriting --%>
		<c:url var="abc" value="/test2" />
		<a href="${abc}">Test Model Map</a>
	</h5>
	
</body>
</html>