<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

이름: <%= request.getParameter("name1") %> <br>
readonly: <%= request.getParameter("name2") %> <br>
disable: <%= request.getParameter("name3") %> <br>

</body>
</html>