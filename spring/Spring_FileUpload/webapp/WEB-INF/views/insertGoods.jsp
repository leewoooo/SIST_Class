<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>상품 등록</h2>
		<form action="insertGoods.do" method="post" enctype="multipart/form-data">
			상품번호 : <input type="text" name="no"><br>
			상품이름 : <input type="text" name="name"><br>
			상품수량 : <input type="text" name="qty"><br>
			상품가격 : <input type="text" name="price"><br>
			상품사진 : <input type="file" name="uploadFile"><br>
			<input type="submit" value="등록하기">
			<input type="reset" value="다시입력">
		</form>		
	</body>
</html>