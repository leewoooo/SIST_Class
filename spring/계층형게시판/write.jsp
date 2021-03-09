<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>그림일기</title>
	</head>
	<body>
		<%@include file="header.jsp"%>
		<div class="container" style="margin-top: 15px">
		<form action="write.do" method="post" enctype="multipart/form-data">
		  <table class="table table-bordered" style="text-align: center;">
		    <thead>
		      <tr>
		      	<c:choose>
		      		<c:when test="${diayNO>0}">
				        <th colspan="2">그림일기 추가하기</th>
		      		</c:when>
		      		<c:otherwise>
				        <th colspan="2">그림일기 작성</th>
		      		</c:otherwise>
		      	</c:choose>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
				<td>
					<input type="text" class="form-control" placeholder="글 제목" name="diaryTitle" maxlength="50" required="required" >
				</td> 
			  </tr>
			  <tr>
				<td><textarea class="form-control" placeholder="글 내용" name="diaryContent" style="height: 400px" required="required"></textarea></td>
			  </tr>
			  <tr>
				<td><input type="file" name="uploadFile" required="required"></td>
			  </tr>
		    </tbody>
		  </table>
		  <!-- param으로 넘어온 diaryNO값을 hidden으로 넘긴다 -->
		  <input type="hidden" name="diaryNO" value="${diaryNO}">
		  diaryNO = ${diaryNO} <Br>
		  <input type="submit" class="btn btn-dark pull-right" value="글 작성">
		  <a href="listDiary.do" class="btn btn-dark">목록</a>
		</form>
		</div>
	</body>
</html>