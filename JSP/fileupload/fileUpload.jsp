<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일을 업로드를 처리하는 페이지</title>
	</head>
	<body>
	
		<%
			String path = application.getRealPath("/upload");
			int maxSize = 1024*1024*100; //10MB로 제한
			String encoding = "UTF-8";
			MultipartRequest multipartRequest = new MultipartRequest(
					request,
					path,
					maxSize,
					encoding,
					new DefaultFileRenamePolicy()
					);
			
			String title = multipartRequest.getParameter("title");
			out.print("<h2>"+title+"</h2>");
			
			
			String originName = multipartRequest.getOriginalFileName("fileName");
			String fileName = multipartRequest.getFilesystemName("fileName"); //파일명이 중복될 경우 파일명 +1이된다.
			out.print("<h2>"+originName+"</h2>");
			out.print("<h2>"+fileName+"</h2>");
			
		%>
	</body>
</html>