스프링에서 파일 업로드 하기
===

스프링에서 먼저 파일 업로드를 하기 위해서는 라이브러리가 두가지 필요합니다. 

1. commons-io
2. commons-fileupload

이 라이브러리들을 [MavenRepository](https://mvnrepository.com/)에서 찾아 현재 실습환경이 maven이니 pom.xml에 의존성을 추가해 줍니다.(gradle과 같은 경우에는 build.gradle)에 추가해주면 됩니다.

<br>

이 후 객체 하나를 Bean에 등록을 해주어야 하는데 "CommonsMultipartResolver"를 Springconfig파일을 만들어 스프링이 로딩될 때 Bean으로 자동등록되게 해줍니다.

```java
@Configuration
public class SpringConfig {
	//파일 업로드를 하기위해 필요한 객체를 config파일로 Bean등록
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
}
```

<Br>

이렇게 준비가 끝나면 form을 작성해야하는데 form의 enctype="multipart/form-data"로 설정을 해줍니다.

* 예제
```html
<form action="insertBoard.do" method="post" enctype="multipart/form-data">
,,,
파일 : <input type="file" name="uploadFile"><Br>
```

이렇게 form태그까지 작성을 완료하면 사용자가 form을 통해 요청을 할 때 파일을 받아 올 수 있게 됩니다. 현재 예제에서는 VO를 통해 form의 입력값들을 모두 받는데 VO에서 사용자가 요청할 때 등록한 파일을 받아오는 필드를 선언해주어야 합니다. 이 때 필드의 자료형은 "MultipartFile"로 설정을 하게 됩니다. 

```java
private MultipartFile uploadFile;
```

<br>

이렇게 받아온 uploadFile을 통해 파일을 원하는 장소에 저장을 할 수 있는데 기본적으로 webapp의 주소를 먼저 알아온 후 그 하위에 있는 파일에 저장을 하게 됩니다. 그럴려면 Request객체가 필요한데 Request객체는 사용자가 요청할 때 Controller의 매개변수로 입력받을 수 있습니다. 예제를 통해 확인을 해보자면 

```java
@PostMapping("/insertBoard.do")
public String save(BoardVO boardVO,Model model,HttpServletRequest request){
    
    //프로젝의 webapp의 경로를 request를 통해 얻는다.
    String path = request.getServletContext().getRealPath("/files");
    
    //사용자가 업로드한 파일을 가져오고
    MultipartFile uploadFile = boardVO.getUploadFile();
    
    //파일의 이름을 얻는다.
    String fname = uploadFile.getOriginalFilename();
    //파일을 업로드 하지 않을 경우도 있기 때문에 먼저 기본값을 입력
    boardVO.setFname("");
    boardVO.setFsize(0);
    boardVO.setIp(request.getRemoteAddr());
    if(fname != null && !fname.equals("")) {
        
        try {
            //파일의 내용을 가져오고
            byte[] data = uploadFile.getBytes();
            //파일 이름 중복 검사하고
            fname = FnameUtil.getFileName(fname, path);
            //파일쓰기
            FileOutputStream outputStream = new FileOutputStream(path + "/" + fname);
            outputStream.write(data);
            //자원 반납
            outputStream.close();
            
            //파일을 업로드 했다면 데이터 입력
            boardVO.setFname(fname);
            boardVO.setFsize(data.length);
            
        } catch (IOException e) {
            e.printStackTrace();
        }//end catch
        
    }//end if
```

위의 코드처럼 먼저 webapp의 경로를 얻어옵니다. 매개변수로 받은 request로 바로 getRealPath를 통해 얻어낼 수 도 있지만 deprecate되어 있기에 getServletContext를 통해 얻습니다. 

```java
String path = request.getServletContext().getRealPath("/files");
```

이 후 사용자에게 입력받은 값을 통해 VO에서 사용자가 입력한 파일을 가져온다.

```java
MultipartFile uploadFile = boardVO.getUploadFile();
```

가져온 파일의 데이터를 가져 온 후 

```java
//파일의 내용을 가져오고
byte[] data = uploadFile.getBytes();
```

얻어온 데이터를 지정한 경로에 저장을 합니다.

```java
FileOutputStream outputStream = new FileOutputStream(path + "/" + fname);
outputStream.write(data);
//자원 반납
outputStream.close();
```

<br>

