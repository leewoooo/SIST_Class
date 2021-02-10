<%@page import="java.io.File"%>
<%@page import="com.sist.dao.GoodsDAO"%>
<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
			String oldFname = multipartRequest.getParameter("oldFname");
			String fname = multipartRequest.getFilesystemName("fname");
			
			//사진 수정을 하지 않는다면 이전 사진의 이름을 넣어준다.
			if(fname == null){
				fname = oldFname;
			}
			
			GoodsVO gVO = new GoodsVO(no,name,qty,price,fname);
			GoodsDAO gDAO = GoodsDAO.getInstance();
			int result = gDAO.updateGood(gVO);
			
			switch(result){
			case 1:{
				if(fname != null){
					File oldImgFile = new File(path + File.separator + oldFname);
					oldImgFile.delete();
				}
				out.println("<script>");
				out.println("alert('상품정보가 수정 되었습니다.')");
				out.println("location.href='./goodsList.jsp'");
				out.println("</script>");
				break;
			}default:{
				out.println("<script>");
				out.println("alert('상품정보 수정에 실패하였습니다.')");
				out.println("location.href='./goodsList.jsp'");
				out.println("</script>");
			}
			}
		%>
	</body>
</html>