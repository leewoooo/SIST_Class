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
		<jsp:forward page="./secondForward.jsp" />
		<p>현재 페이지에서  secondForward.jsp로 이동</p>
	</body>
</html>