<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>그림일기</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	</head>
	<body>
		<%@include file="header.jsp"%>
		<div class="container" style="margin-top: 15px">
			<table class="table table-bordered" style="text-align: center">
			    <thead>
			      <tr>
			        <th colspan="3">그림 일기</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td colspan="3"><img alt="그림일기사진" src="images/${diary.fname}"></td>
			      </tr>
			      <tr>
			        <td style="width: 20%">글 제목</td>
			        <td colspan="2">${diary.diaryTitle}</td>
			      </tr>
			      <tr>
			        <td style="width: 20%">작성자</td>
			        <td colspan="2">${diary.userID }</td>
			      </tr>
			      <tr>
			        <td style="width: 20%">작성일자</td>
			        <td colspan="2">${diary.createdAt }</td>
			      </tr>
			      <tr>
					<td>내용</td>
					<td colspan="2" style="min-height: 200px; text-align: left;">${diary.diaryContent }</td>
				  </tr>
			    </tbody>
			  </table>
		<a href="listDiary.do" class="btn btn-dark">목록</a>
		<a href="write.do?diaryNO=${diary.diaryNO}" class="btn btn-dark">답글쓰기</a>
		<a href="update.do?diaryNO=${diary.diaryNO}" class="btn btn-dark">수정</a>
		<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="delete.do?diaryNO=${diary.diaryNO}" class="btn btn-dark">삭제</a>
		</div>
	</body>
</html>