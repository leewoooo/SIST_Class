<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일 업로드 메인</title>
	</head>
	<body>
		<form action="uploadAction.jsp" method="post" enctype="multipart/form-data">
			파일:<input type="file" name="file">
				<input type="submit" value="업로드">
		</form>
		<hr>
		<a href="fileDownload.jsp">파일 다운로드 페이지</a>
	</body>
</html>