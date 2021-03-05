<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>저장되어 있는 상품 목록</title>
	</head>
	<body>
	
		<h2>상품 목록</h2>
		
		<a href="insertGoods.do">상품 등록</a>
		
		<table border="1">
			<thead>
				<tr>
					<td>상품번호</td>
					<td>상품이름</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="good" items="${goodsList}">
					<tr>
						<td>${ good.no }</td>
						<td><a href="detailGoods.do?no=${ good.no }">${ good.name }</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>