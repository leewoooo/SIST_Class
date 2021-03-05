<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 디테일</title>
	</head>
	<body>
		<h2>상품 상세</h2>
		<hr>
	
		이미지 : <br>
		<img alt="" src="images/${good.fname}"> <br>
		번호 : ${good.no} <br>
		재고 : ${good.qty }<br>
		가격 : ${good.price}<br>
		
		<hr>
		
		<a href="updateGoods.do?no=${good.no}">상품 수정</a> <br>
		<a href="deleteGoods.do?no=${good.no}">상품 삭제</a>
	</body>
</html>