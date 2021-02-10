파일 다운로드
===

먼저 서버에 파일이 저장되어 있는 디렉토리의 경로를 구한 후 파일 안에 있는 file명의 list를 구한 후 다운로드를 처리할 서블릿으로 file명을 query문자열로 넘겨준다.<br>

```java
<%
    //upload를 파일로 생성해 안에 있는 파일list를 얻어낸다.
    String path = application.getRealPath("/upload");
    String files[] = new File(path).list();
    
    //얻어낸 list를 가지고 for문을 돌려서 다운로드로 할 a태그 생성
    for(String file : files){
        out.write("<a href=\""+request.getContextPath()+"/downloadAction?file="
                +URLEncoder.encode(file, "UTF-8")+"\">"+file+"</a></br>");
    System.out.println(request.getContextPath());
    }
%>
```

<Br>

현재 다운로드를 처리하는 서블릿의 mapping 주소는 /downloadAction으로 설정되어 있다. 서블릿으로 fileName을 넘겨줘서 처리한다.

<br>

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    //1. 파라미터로 넘어온 file명을 받아온다.
    String fileName = request.getParameter("file");
    
    //2.경로를 가져온다.
    String path = this.getServletContext().getRealPath("/upload");
    File file = new File(path+File.separator+fileName);
    
    System.out.println("파일명 : " + fileName);
    
    //3. MIMETYPE 설정하기
    String mimeType = getServletContext().getMimeType(file.toString());
    if(mimeType == null)
    {
        response.setContentType("application/octet-stream");
    }
    
    //4. 다운로드용 파일명을 설정 (브라우저 마다 설정이 다르기 때문)
    String downName = null;
    if(request.getHeader("user-agent").indexOf("MSIE") == -1)
    {
        downName = new String(fileName.getBytes("UTF-8"), "8859_1");
    }
    else
    {
        downName = new String(fileName.getBytes("EUC-KR"), "8859_1");
    }
    
    //5. 무조건 다운로드하도록 설정
    response.setHeader("Content-Disposition","attachment;filename=\"" + downName + "\";");
    
    //6. 요청된 파일을 읽어서 클라이언트쪽으로 저장한다.
    FileInputStream fileInputStream = new FileInputStream(file);
    ServletOutputStream servletOutputStream = response.getOutputStream();
    
    byte b [] = new byte[1024];
    int data = 0;
    
    while((data=(fileInputStream.read(b, 0, b.length))) != -1)
    {
        servletOutputStream.write(b, 0, data);
    }
    
    servletOutputStream.flush();
    servletOutputStream.close();
    fileInputStream.close();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
}
```

<br>

이후 파일 다운로드를 처리한다.