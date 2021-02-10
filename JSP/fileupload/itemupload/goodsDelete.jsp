<%@page import="java.io.File"%>
<%@page import="com.sist.dao.GoodsDAO"%>
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
			//해당상품을 삭제한 후 파일도 삭제하려면 실제경로를 알아야한다.
			String path = application.getRealPath("/upload");
			GoodsDAO gDAO = GoodsDAO.getInstance();
			int no = Integer.parseInt(request.getParameter("no"));
					
			//상품을 삭제하기 전에 해당 상품의 파일명을 알아야 한다.
			String fname = gDAO.findGood(no).getFname();
			String imgPath = path + File.separator + fname;			
			
			int result = gDAO.deleteGood(no);
			
			switch(result){
			case 1:{
				//만약 이번 사진파일의 이름과 현재파일의 이름이 다르다면 이전 사진명을 삭제한다.
				File img = new File(imgPath);
				img.delete();
				out.println("<script>");
				out.println("alert('상품이 삭제되었습니다.')");
				out.println("location.href='./goodsList.jsp'");
				out.println("</script>");
				break;
			}
			default:{
				out.println("<script>");
				out.println("alert('상품이 삭제에 실패하였습니다.')");
				out.println("location.href='./goodsList.jsp'");
				out.println("</script>");
			}
			}
		%>
	</body>
</html>