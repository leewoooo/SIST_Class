<%@page import="com.sist.dao.GoodsDAO"%>
<%@page import="com.sist.vo.GoodsVO"%>
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
			String oldFname = request.getParameter("fname");
			GoodsDAO gDAO = GoodsDAO.getInstance();
			GoodsVO gVO = gDAO.findGood(no);
		%>
		<h2>상품 수정</h2>
		<form action="goodsUpdateOk.jsp" method="post" enctype="multipart/form-data">
			상품번호 : <input type="hidden" name="no" value="<%=gVO.getNo()%>"><br>
			상품이름 : <input type="text" name="name" value="<%=gVO.getName()%>"><br>
			상품수량 : <input type="text" name="qty" value="<%=gVO.getQty()%>"><br>
			상품가격 : <input type="text" name="price" value="<%=gVO.getPrice()%>"><br>
			현재 등록된 사진 : <br><img src ="./upload/<%=gVO.getFname()%>"><br>
			<input type="hidden" name="oldFname" value="<%=gVO.getFname()%>">
			수정할 상품사진 : <input type="file" name="fname"><br>
			<input type="submit" value="수정">
			<input type="reset" value="취소">
		</form>
	</body>
</html>