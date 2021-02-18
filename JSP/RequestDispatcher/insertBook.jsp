<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert Book</title>
	</head>
	<body>
		Insert Book
		<%
			String test = (String)request.getAttribute("pageName");
		%>
		
		<%=test %>
	</body>
</html>