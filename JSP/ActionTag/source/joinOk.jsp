<%@page import="com.sist.dao.MemberBeanDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="member" class="com.sist.bean.MemberBean" scope="page" />
<jsp:setProperty property="*" name="member"/><!--form의 입력값으 모두 가져온다.-->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			MemberBeanDAO mDAO = MemberBeanDAO.getInstance();
			System.out.println(member);
			int flag = mDAO.insert(member);
		%>
		
		<%=flag %>
	</body>
</html>