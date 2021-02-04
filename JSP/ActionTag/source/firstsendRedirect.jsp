<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>첫번 째 페이지 입니다.</h3>
		<%
			response.sendRedirect("http://localhost/jsp_prj/day0204/secondsendRedirect.jsp");
		%>
		<p>현재 페이지의 내용은 표시되지 않은 상태로 secondForward.jsp로 이동</p>
	</body>
</html>