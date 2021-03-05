<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>상품 수정</h2>
		<hr>
		<form action="updateGoods.do" method="post" enctype="multipart/form-data">
			상품번호 : ${good.no} <br>
			<input type="hidden" name="no" value="${good.no}"><br>
			상품이름 : <input type="text" name="name" value="${good.name}"><br>
			상품수량 : <input type="text" name="qty" value="${good.qty }"><br>
			상품가격 : <input type="text" name="price"value="${good.price}"><br>
			수정사진 : <input type="file" name="uploadFile"><br>
			<input type="submit" value="수정하기">
			<input type="reset" value="다시입력">
			<hr>
			현재 등록되어 있는 사진 <br>
			<input type="hidden" name="fname" value="${good.fname}">
			<img alt="" src="images/${good.fname}"> <br>
		</form>	
	</body>
</html>