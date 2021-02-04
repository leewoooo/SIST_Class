<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			String id = null;
			if( session.getAttribute("userID")!=null){
				id = (String)session.getAttribute("userID");
			}else{
				response.sendRedirect("login.html");
			}
		%>
	
		<h1>로그인 성공</h1>
	</body>
</html>