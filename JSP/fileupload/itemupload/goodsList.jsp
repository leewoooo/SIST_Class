<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.dao.GoodsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 list 조회</title>
	</head>
	<body>
		<%
			GoodsDAO gDAO = GoodsDAO.getInstance();
			List<GoodsVO> list = gDAO.findAll();
		%>		
		<a href="./goodsInsert.jsp">상품등록</a>
		<table width="80%" border="1">
			<tr>
				<th>상품번호</th>
				<th>상품이름</th>
				<th>상품가격</th>
			</tr>
			<%
				for(GoodsVO gVO : list){
					out.println("<tr>");
					out.println("<td>"+gVO.getNo()+"</td>");
					out.println("<td><a href='goodsDetail.jsp?no="+gVO.getNo()+"'>"+gVO.getName()+"</a></td>");
					out.println("<td>"+gVO.getPrice()+"</td>");
					out.println("</tr>");
				}//end for
			%>
		</table>
	</body>
</html>