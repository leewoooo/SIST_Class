파일 업로드
===

웹 브라우저에서 서버로 파일을 전송하여 서버에 저장하는 것을 의미하며 서버로 업로드 할 수 있는 파일의 종류는 다음과 같다. <br>

1. 텍스트 파일
2. 파이너리 파일
3. 이미지 파일
4. 문서

<br>

이외에도 여러 종류들이 있다. 웹 브라우저에서 서버로 파일을 전송하기 위해 JSP페이지에서 form태그를 사용한다. 전송된 파일을 저장하기 위해 오픈 라이브러리를 이용한다. <br>

파일업로드를 위해 jsp페이지에 form 태그를 작성할 때는 몇가지 규칙이 있다.
```jsp
<form action="요청을 처리할 서버경로" method="post" enctype="multipart/form-data">
    <input type="file" name="요청 파라미터 이름">
</form>
```

<br>

1. form 태그의 method 속성은 반드시 post방식으로 설정한다.
2. form 태그의 enctype 속성은 반드시 multipart/form-data로 설정
3. 파일 업로드를 위해 input 태그의 type속성은 file로 설정 (만약 여러 파일을 업로드 하려면 2개 이상의 iuput을 만든 후 name속성을 다른 값으로 한다.)

<br>

기본적은 파일 입력 form 태그
```jsp
<form action="#" method="POST" enctype="mutipart/form-data">
    <p>제목: <input type="text" name="title"></p>
    <p>파일: <input type="file" name="fileName"></p>
    <input type="submit" value="파일 업로드">
</form>
```

<br>

---

<br>

## MultipartRequest

* 웹 페이지에서 서버로 업로드 되는 파일 자체만 다루는 class이다.
* 웹 브라우저가 전송한 multipart/form-data 유형과 POST방식의 요청 파라미터 등을 분석한 후 일반 데이터와 파일 데이터를구분하여 파일 데이터에 접근한다.
* 한글 인코딩 값을 얻기 쉽고 서버의 파일 저장 폴더에 동일한 파일명이 있으면 파일명을 자동으로 변경한다.
* 오픈 라이브러리 cos.jar를 사용해 파일업로드를 진행해 보자.

<br>

MultipartRequest class 생성
```java
MultipartRequest(javax.servlet.http.HttpServletRequest request,
    java.lang.String saveDirectory,
    int maxPostSize,
    java.lang.String encoding,
    FileRenamePolicy policy)

//절대 경로를 사용하지 않고 application의 method를 이용하여 서버의 위치가
//변경되더라도 사용가능하도록
String path = application.getRealPath("/upload/");
int maxSize = 1024*1024*100 //10MB로 제한
String encoding = "UTF-8"
MultipartRequest multi = new MultipartRequest(
    request,
    path,
    maxSize,
    encoding,
    new DefaultFileRenamePolicy()
)
```

* request : Request 내장 객체를 설정한다.
* saveDirectory : 서버의 파일 저장 경로를 설정한다.
* maxPostSize : 파일의 최대 크기(바이트 단위)를 설정 (최대 크기를 초과하면 IO Excption 발생)
* encoding : 인코딩 유형을 설정한다.
* policy : 파일명 변경 전책을 설정한다. saveDirectory에 파일명이 중복되는 경우 덮어쓰기 여부를 설정하며 설정하지 않으면 덮어쓴다.

<br>

MultipartRequest의 method

method | return 값 | 설명
:--- | :--- | :---
getContentType(String) | String | 업로된 파일의 content 유형을 반환
getFile(String name) | java.io.File | 서버에 업로드 된 파일에 대한 객체를 반환
getFileName() | Enurmeration | form 페이지에 input 태그 내 type 속성 값이 file로 설정된 파라미터의 이름을 얻어온다.
getFilesystemName(String name) | String | 서버에 실제로 업로드된 파일명
getOriginFileName(String name) | String | 사용자가 업로드한 실제 파일명

<br>

* 예제 코드

```java
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

    //파일의 저장을 시도했을때의 이름
    String fileRealName = multipartRequest.getOriginalFileName("file");
    //파일이 실제 저장된 이름
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
```

<br>

이후 DAO와 VO를 통해 파일의 명을 DB에 저장해서 추 후 필요할 때 조회해서 사용한다.