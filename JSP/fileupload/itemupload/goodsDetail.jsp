<%@page import="com.sist.vo.GoodsVO"%>
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
			int no = Integer.parseInt(request.getParameter("no"));
			GoodsDAO gDAO = GoodsDAO.getInstance();
			GoodsVO gVO = gDAO.findGood(no);
		%>
		<h2>상품 상세 보기</h2>
		<hr>
		상품번호 : <%=gVO.getNo()%><br>
		상품이름 : <%=gVO.getName()%><br>
		상품수량 : <%=gVO.getQty()%><br>
		상품가격 : <%=gVO.getPrice()%><br>
		<img src="./upload/<%=gVO.getFname()%>">
		<hr>
		<a href="./goodsList.jsp">상품목록으로 이동</a>
		<a href="./goodsInsert.jsp">상품등록으로 이동</a>
		<a href="./goodsUpdate.jsp?no=<%=gVO.getNo()%>&fname=<%=gVO.getFname()%>">상품수정하기</a>
		<a href="./goodsDelete.jsp?no=<%=gVO.getNo()%>">상품삭제하기</a>
	</body>
</html>