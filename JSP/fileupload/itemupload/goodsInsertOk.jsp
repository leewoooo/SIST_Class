<%@page import="com.sist.dao.GoodsDAO"%>
<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 등록 DB연동</title>
	</head>
	<body>
		<%
			//현재 어플리케이션의 upload폴더의 경로
			String path = application.getRealPath("/upload");
			int maxSize = 1024*1024*100; //10MB로 설정
			String encoding = "UTF-8";
			
			MultipartRequest multipartRequest = new MultipartRequest(request,path,maxSize,encoding,new DefaultFileRenamePolicy());
			
			//MultipartRequest를 사용할 때는 파일이외 나머지 값을 MultipartRequest객체에서 받는다.
			int no = Integer.parseInt(multipartRequest.getParameter("no"));
			String name= multipartRequest.getParameter("name");
			int qty = Integer.parseInt(multipartRequest.getParameter("qty"));
			int price = Integer.parseInt(multipartRequest.getParameter("price"));
			String fname = multipartRequest.getFilesystemName("fname");
			
			GoodsVO gVO = new GoodsVO(no,name,qty,price,fname);
			GoodsDAO gDAO = GoodsDAO.getInstance();
			int result = gDAO.insert(gVO);
			
			switch(result){
			case 1:{
				response.sendRedirect("./goodsList.jsp");
				break;
			}
			default :{
				out.println("<h2>파일 등록 실패</h2>");
			}
			} 
		%>
	</body>
</html>