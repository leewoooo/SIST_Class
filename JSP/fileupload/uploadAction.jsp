<%@page import="com.sist.dao.FileDAO"%>
<%@page import="com.sist.vo.FileVO"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일 업로드 메인 페이지</title>
	</head>
	<body>
		<%
			
			String path = application.getRealPath("/upload");
			int maxSize = 1024*1024*100; //10MB로 제한
			String encoding = "UTF-8";
			MultipartRequest multipartRequest = new MultipartRequest(
					request,
					path,
					maxSize,
					encoding,
					new DefaultFileRenamePolicy()
					);
			
			String fileRealName = multipartRequest.getOriginalFileName("file");
			String fileSystemName = multipartRequest.getFilesystemName("file");
			
			//secure coding
			// 사용자가 업로드를 하고자 확장자를 검증한 이후 아니면 해당 파일 삭제
			if(!fileRealName.endsWith(".doc") && !fileRealName.endsWith(".hwp") && !fileRealName.endsWith(".pdf") && !fileRealName.endsWith(".xls")){
				File file = new File(path+fileSystemName);
				file.delete();
				out.write("업로드가 불가능한 확장자 입니다.");
			}else{
				//저장이 완료되면 DB에 파일 명을 저장한다.
				FileVO fVO = new FileVO(fileRealName, fileSystemName);
				FileDAO fDAO = FileDAO.getInstance();
				fDAO.insertFileName(fVO);
				
				out.write("<h2>"+fileRealName+"</h2>");
				out.write("<h2>"+fileSystemName+"</h2>");
			}
		%>
	</body>
</html>