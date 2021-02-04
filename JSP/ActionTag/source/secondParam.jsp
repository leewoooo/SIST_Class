<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>이 파일은 secondParam.jsp 이며 firstParam에서 받은 값을 사용합니다.</h3>
		<%
			String date = request.getParameter("date");
		%>
		<%=date%> &lt;= firstParame에서 전달 받은 값
	</body>
</html>