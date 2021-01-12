# WEB Programming

* web: WWW(world wide web) -> W3

* 정의: Internet에서 문자, 이미지, 소리, 영상(멀티미디어)등을 Hyper Text를 사용하여 전송, 검색 할 수 있게 해주는 서비스.

## Internet

* Hyper text를 이용하여 정보를 검색할 수 있는 program.
* TCP/IP를 이용해 네트워크끼리 연결하는 방식.

<br />

---

<br />

## HTML을 사용하기 위해 알아야 하는 개념

### HTTP(Hyper Text Transfer Protocol)

* HTML문서를 주고 받기 위해 정의한 프로토콜

### URL

* 인터넷에 존재하는 정보(문서,이미지,동영상,,,)를 사용하기 위한 주소체계

    * URL의 구조 -> "프로토콜://호스트이름:포트번호/데이터파일경로/데이터파일의이름"

    * http = 80port를 이용, https = 443 port를 이용

```html
//html
http://localhost:80/day0106/test.html

//jsp (form method 방식중 get방식에 해당될 때 query String가 추가된다.)
http://localhost:80/day0106/test.jsp?이름=값&이름=값... 
```

<br />

---

<br />

## Server와 Client의 구조 (Web의 전체적인 구조)

<img src = https://user-images.githubusercontent.com/74294325/103718775-ebbf2600-500a-11eb-9d10-54055ffa52b9.PNG>

* 어디의 자원을 사용하냐에 따라 Back-End와 Front-End로 구분이 된다.

    * Back-End : Server의 자원을 이용
    * Frount-End : Web 쪽의 자원을 이용


<br />

---

<br />

## Tomcat,아파치 

### 설치방법

1. http://tomcat.apache.org/ 로 접속한다.

2. 사용하고자 하는 Tomcat의 vsrsion을 선택 후 다운받는다.

    * zip : 개발용
    * 윈도우 설치파일 : windows로 web서비스를 열 때 사용.(background 서비스 사용 가능)

3. Path설정을 하여 bin 안에있는 startup.bat를 실행한다.
<br>(Linux에서 사용할 때 필수, window에서 이클립스를 사용할 때는 아파치 디렉토리만 지정해 주면 된다.)

4. 포트를 열어준다 tomcat은 8080포트를 사용한다.(방화벽 설정)

    * 포트는 변경이 가능하다.

### 웹서버(아파치), WAS(tomcat)

* Tomcat은 WAS(Web Application Server)라고 하며 사용목적은 자바코드를 이용해 동적으로 생성해주는 프로그램이다.

    * WAS는 웹서버와 웹 컨테이너의 결합으로 다양한 기능을 컨테이너에 구현하여 다양한 역할을 수행하는 서버를 의미한다.

* 주로 아파치(웹 서버)와 Tomcat을 병행해서 사용하는데 그 이유는 이미지나 CSS같은 정적인 데이터는 아파치로 처리하고 Tomcat은 본 목적인 동적 페이지 생성에 주력하는 것이 효율면에서 좋다.

* 정리

    * 아파치 : 정적인 데이터를 처리, 이미지나 단순한 HTML파일을 아파치를 통해 처리하면 WAS보다 빠르고 안정적.

    * Tomcat(WAS) : 동적인 데이터를 처리, DB와 연결되어 데이터를 주고 받거나 프로그램으로 데이터 조작이 필요할 경우에 사용.

<br />

---

<br />

## HTML (Hyper Text Markup Language)

* web에서 동작하는 문서를 작성하고 표현할 수 있는 표준 언어.

* web Browser안에서만 동작한다.(동일한 모양으로 표현되지 않을 수 있다. -> 웹표준을 사용하여 동일한 서비스를 제공)

    * 하지만 Web Browser마다 지원하는 Tag의 차이가 있다.

* 연산의 기능이 없다. (Java Script는 연산이 가능하다.)


### Hyper Text

* HTML문서 안에서 다른 문서로 연결할 수 있는 연결점을 가진 문서.(Hyper Link를 이용)

### Hyper Link

* HTML문서 간 이동을 위해 사용하는 Link.

### Markup( 본문에서 특정 부분을 강조하여 보여주는 것) Language

* **Tag를 사용하여 문서를 작성한다.** &lt;태그명&gt;를 이용하여 작성한다.

* 작성 된 Tag는 Web Browser가 그려서 보여준다.

* SGML(태그를 제작하는 언어)를 사용하여 웹에서 필요한 기능을 정의한 언어.

    * HTML : 사용자에게 보여줄 목적으로 사용

    * XML : 데이터를 저장할 목적, 이종언어간 데이터 전달용.

<br />

---

<br />

## HTML 형식

* 기본적인 구조

    <img src = https://user-images.githubusercontent.com/74294325/103472121-d2309b00-4dcc-11eb-80a7-38c9f4410452.JPG>


    * &lt;!DOCTYPE html&gt; - 선언부
    * &lt;html&gt;,,,&lt;/html&gt; - HTML 요소

### 사용방법

1. 코드작성
```html
<!DOCTYPE html>
<html>
    <head>
        <meta Charset = "UTF-8"> <!--CharSet을 지정-->
        <title>Browser의 Tab의 이름</title>
        HTML을 작성하는데 필요한 정보들
    </head>
    <body>
        HTML에 표현될 내용들
    </body>
</html>
```

2. 저장

    * 파일명.<b>html</b>

3. 배포(deploy)

    * 제작된 HTML파일을 웹서비스 하기 위해서 정해진 위치(sever.xml | context.xml에 설정)에 놓는다.

        * XML에서는 HTML의 Tag를 Node라 한다.

    * java에서 web Service하기 위한 폴더 구성

    <img src = https://user-images.githubusercontent.com/74294325/103724648-2c716c00-5018-11eb-92c8-2f52ba27c853.PNG>


4. Web Server(Web Container) 실행

5. Web Browser를 열고 HTML을 요청하는 URL을 입력한다.

<br>

---

<br />

## Tag

### Tag의 구조
<img src = https://user-images.githubusercontent.com/74294325/103719541-908e3300-500c-11eb-93c0-6f0c5674006b.PNG>

<br />

### Tag의 형식
```html
<Tag명 속성명1="속성값1" 속성명2="속성값2"> Contents </Tag명>
<!--EX-->
<a href="www.google.com">구글</a>
```
* 예제 code를 보면 a = Tag , href = 속성명 , "www.google.com" = 속성 값, 구글 = Contents

* 속성 값은 **" "를 사용하여 묶어서 사용한다, 속성은 Tag의 부가적인 정보가 들어온다.**

* 열리는 Tag가 있다면 닫히는 Tag가 있어야 한다.(Contents 앞이 열리는 tag 뒤가 닫히는 Tag)

    * 닫히는 Tag가 필요없는 Tag도 있다. 이런경우 <Tag명 /> 형식을 갇는다.
    ```html
    <br /> <!--줄바꿈 Tag-->
    <input type="button"value="버튼" /> <!--버튼을 만들어 주는 Tag-->
    ```
<br />

---

<br />

