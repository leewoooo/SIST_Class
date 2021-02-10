<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일을 업로드하는 방법을 익혀봅시다.</title>
	</head>
	<body>
		<form action="fileUpload.jsp" method="POST" enctype="multipart/form-data">
			<p>제목: <input type="text" name="title"></p>
			<p>파일: <input type="file" name="fileName"></p>
			<input type="submit" value="파일 업로드">
		</form>
	</body>
</html>