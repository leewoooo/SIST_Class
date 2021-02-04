<%@page import="com.sist.dao.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			LoginDAO lDAO = LoginDAO.getInstance();
			boolean flag = lDAO.login(id, pwd);
			
			if(flag){
				session.setAttribute("userID", id);
		%>
			<jsp:forward page="main.jsp"></jsp:forward>
		<%
			}else{
		%>
			<jsp:forward page="login.html"></jsp:forward>
		<%
			}
		%>
		
	</body>
</html>