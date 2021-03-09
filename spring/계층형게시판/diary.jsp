<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>그림일기</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	</head>
	<body>
		<%@include file="header.jsp"%>
		<div class="container" style="margin-top: 10px">
		  <h2>나의 일기장</h2>
		  <table class="table table-bordered">
		    <thead>
		      <tr>
		        <th>글 번호</th>
		        <th>글 제목</th>
		        <th>작성 일자</th>
		        <th>수정 일자</th>
		      </tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="diary" items="${diaryList}">
		    		<tr>
		    			<td>${ diary.diaryNO }</td>
		    			<td>
		    				<c:if test="${diary.b_level>0}">
		    					<c:forEach var="i" begin="1" end="${diary.b_level}">
		    						&nbsp;&nbsp;
		    					</c:forEach>
		    					-->
		    				</c:if>
			    				<a href="detailDiary.do?diaryNO=${ diary.diaryNO }">
			    					${ diary.diaryTitle }
			    				</a>
		    			</td>
		    			<td>${ diary.createdAt }</td>
		    			<td>${ diary.modifiedAt }</td>
		    		</tr>
		    	</c:forEach>
		    </tbody>
		  </table>
		  <div style="display: flex; justify-content: center" >
		  	<ul class="pagination">
		  		<c:forEach var="i" begin="1" end="${totalPage}">
			  		<li class="page-item"><a class="page-link" href="listDiary.do?pageNumber=${i}">${i}</a></li>
		  		</c:forEach>
			</ul>
		  </div>
		  <div class="p-2 ml-auto">
		    <a href="write.do" class="btn btn-dark p-2 ml-auto">글쓰기</a>
	  	  </div>
		</div>
	</body>
</html>