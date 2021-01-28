Ajax (Asynchronouse Javascript And XML)
===

Ajax란 Javascript의 라이브러리중 하나이며 브라우저가 가지고 있는 XMLHttpRequest 객체를 이용하여 전체 페이지를 새로고치지 않고 페이지의 일부만을 위한 데이터를 로드하는 기법이다. **Javascript를 사용한 비동기 통신,클라이언트와 서버간의 데이터를 주고 받는 기술이다.**<br>

간단하게 이야기 하자면 **자바스크립트를 통해 서버에 데이터를 요청하고 받아오는 것이다.**

<br>

---

<br>

## 비동기 방식이란?

비동기 방식은 웹페이지를 리로드하지 않고 데이터를 불러오는 방식이다. Ajax를 통해 서버에 요청을 한 후 **응답이 오기 전까지 페이지에 대한 조작을 할 수 없는 것이 아니라 응답을 기다리면서도 계속해서 작업을 할 수 있게 된다.** <br>

따라서 사용하는 이유를 정리하자면 HTTP 프로토콜을 사용하면 클라이언트가 요청을 하고 서버쪽에서 응답을 하면 연결이 끊기게 되어 있다. 그렇기 때문에 화면의 내용을 갱신하기 위해서는 다시 요청하고 응답하는 과정을 통해 페이지 전체를 갱신해야 했다. **하지만 ajax을 통해 페이지의 전체가 아닌 일부분만 갱신할 수 있기 때문이다.**<br>

<br>

---

<br>

## Ajax의 장단점

### 장점 

1. 웹 페이지의 속도 향상

2. 서버의 처리가 완료 될때 까지 기다리지 않고 처리가 가능.

3. 서버에서 Data만 전송하면 되기 때문에 코드 양이 줄어든다.

<br>

### 단점

1. 히스토리 관리가 안된다. (보안에 신경써야한다.)

2. 연속으로 데이터를 요청하면 서버에 부하가 걸릴 수 있다.

<br>

---

<br>

## Ajax 진행

1. XMLHttpRequest 객체를 만든다.

    * request를 보낼 준비를 브라우저에게 시키는 과정
    * 이것을 위해서 필요한 method를 갖춘 객체가 필요하다.

    <br>

    ```javascript
    let request = new XMLHttpRequest();
    ```

<br>

2. callback함수를 만든다.

    * 서버에서 reponse가 왔을 때 실행 시키는 함수
    * HTML 페이지를 업데이트 함

<br>

3. Open a request

    * 서버에서 reponse가 왔을 때 실행시키는 함수
    * HTML 페이지를 업데이트함

<br>

4. send() 

	* 서버에 요청

<br>

---

<br>

## 코드로 확인해보자.

먼저는 jquery를 사용하지 않고 자바스크립트로만 사용하는 것을 알아보자.. <br>

서버에 데이터가 이렇게 있다고 가정을 해보자.

```jsp
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

{"name" : "이우길", "age": 26 }
```

<br>

이 데이터를 요청하는 클라이언트 쪽 코드이다.
```html
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
		</head>
		<body>
			이름 : <span id="name"></span><br>		
			나이 : <span id="age"></span><br>		
			<button id="buttonOK">Ajax통신하기</button>
			<hr>
			<script type="text/javascript">
				document.querySelector("#buttonOK").onclick=function(){
					let request = new XMLHttpRequest(); 
                    //자바스크립트로 ajax을 하기 위해 XMLHttpRequest를 생성
					//요청이 완료되고 서버에서 응답할 준비가 된 이후 실행하도록 처리해줘야 한다. 
					request.onreadystatechange = function () {
						if(request.readyState == 4 && request.status == 200){ 
                            //모든 데이터를 받았을 경우 4
						    //서버에 오류 없이 정상적을 작동했을 경우 200
                            //JSON으로 넘어온 data를 객체로 변환하는 JSON.parse()
							const data = JSON.parse(request.responseText); 
							document.querySelector("#name").innerText = data.name;
							document.querySelector("#age").innerText = data.age;
						}//end if
					}//function
					request.open("get","helloServer.jsp",true); 
					request.send(); 
				}//function
			</script>			
		</body>
</html>
```
<br>

* onreadystatechange : 비동기 통신시 서버와 통신이 이루어진 후 동작 될 함수

* send : 데이터 교환을 요청하는 함수

* open(method, url, async) : 서버와 데이터를 교환할 때 필요한 정보를 입력한다. 첫번째 인자로는 get,post를 지정해주며 두번째 인자 값은 데이터를 교환할 서버의 url을 지정해주고 세번째 인자값은 비동기로 진행할 것인지 동기식으로 진행할 것인지 결정해준다. (true:비동기, false:동기식) -> 동기식으로 진행할 경우 onreadystatechange가 필요 없고 응답이후 코드를 send()뒤에 작성해준다.

* status : 데이터 수신의 성공 여부를 판단해주는 속성이다.

    * 200 : 해당 url로 접근 성공
    * 403 : 접근이 거부 되었음
    * 404 : 해당 url이 존재하지 않음.
    * 500 : 서버 ERROR

<br>

위의 코드를 정리하자면 helloServer페이지로 비동기방식과 get method를 이용하여 데이터를 요청하게 된다. 요청이 발생하고 server와의 통신중 이상이 없다면(readyState ==4 && status == 200)이라면 helloServer의 {"name" : "이우길", "age": 26 } 값을 가져와 body에 있는 span 태그에 넣어준다.

<br>

다음은 jquery를 사용한 경우를 확인해보자.<br>

이와같이 jquery는 ajax통신을 하는데 있어 편리성을 가져다 준다.

```javascript
$.ajax({//비동기식 Ajax를 이용하여 HTTP 요청을 전송함.
    url: "helloServer.jsp", // 클라이언트가 요청을 보낼 서버의 URL 주소
    //data: { 서버로 보낼 데이터 },             
    type: "get",  // HTTP 요청 방식(GET, POST)
    dataType: "json" // 서버에서 보내줄 데이터의 타입
})

// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
.done(function(data) {
    //성공을 했을 경우 실행 될 스크립트
	$("#name").text(data.name);
	$("#age").text(data.age);
})

// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.

.fail(function(request, status, errorThrown) {
    alert("오류명: " + errorThrown)
    alert("상태: " + status);
})

// HTTP 요청이 성공하거나 실패하는 것에 상관없이 언제나 always() 메소드가 실행됨.
.always(function(request, status) {
    
});
```