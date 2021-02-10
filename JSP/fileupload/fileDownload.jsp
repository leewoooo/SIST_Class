<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
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
			//upload를 파일로 생성해 안에 있는 파일list를 얻어낸다.
			String path = application.getRealPath("/upload");
			String files[] = new File(path).list();
			
			//얻어낸 list를 가지고 for문을 돌려서 다운로드로 할 a태그 생성
			for(String file : files){
				out.write("<a href=\""+request.getContextPath()+"/downloadAction?file="
						+URLEncoder.encode(file, "UTF-8")+"\">"+file+"</a></br>");
			System.out.println(request.getContextPath());
			}
		%>
	</body>
</html>