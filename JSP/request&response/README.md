request, response , 인코딩, 디코딩
===

## request

request 기본 객체는 JSP에서 가장 맣이 사용되는 기본 객체이다. <mark>웹 브라우저의 요청과 관련이 있는 객체이다</mark> <br>

request 객체가 제공하는 기능은 다음과 같다.

1. 클라이언트와 관련되 정보 읽기 기능.
2. 서버와 관련된 정보 읽기 기능.
3. 클라이언트가 전송한 요청 파라미터 읽기 기능
4. 클라이언트가 전송한 요청 헤더 읽기 기능
5. 클라이언트가 전송한 쿠키 읽기 기능

<br>

### request객체의 요청 파라미터 관련 method

request 객체는 웹 브라우저가 전송한 파라미터를 읽어올 수 있다.

method | return type | 설명
:--- | :--- | :---
getParameter(String name) | String | 이름이 name인 파라미터의 값을 구한다 존재하지 않을 경우 null을 리턴
getParameterValues(String name) | String[] | 이름이 name인 모든 파라미터의 값을 배열로 구한다. 존재하지 않을 경우 null을 반환
getParameterNames() | java.util.Enumeration | 웹 브라우저가 전송한 파라미터의 이름 목록을 구한다.
getParameterMap() | java.util.Map | 웹 브라우저가 전송한 파라미터의 맵을 구한다. 맵은 <파라미터 이름, 값> 쌍으로 구성

<br>

* 예제 코드
```jsp
<!--요청하는 쪽-->
<form action="process.jsp" method="get">
    <label for="id">
        아이디 :<input type="text" name="id" id="id">
    </label>
    <label for="pwd">
        비밀번호 :<input type="password" name="pwd" id="pwd">
    </label>
    <input type="submit" value="전송">
</form>

<!--process.jsp-->
<body>
    <%
        //input 중 name의 속성값이 id와 pwd의 값을 받아온다.
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
    %>
    id parameter : <%=id%>
    pwd parameter : <%=pwd%>
</body>
```

<br>

체크박스나 라디오 버튼은 값을 아무것도 선택하지 않은 상태로 요청을 하게 되면 null값이 리턴되지만 **텍스트인 경우는 빈 문자열이("")반환된다.**

<br>


---


<br>

## response

response 객체는 request객체와 반대의 기능을 수행한다. request 객체가 웹 브라우저가 전송한 요청 정보를 담고 있다면, response 기본객체는 웹 브라우저에 보내는 응답 정보를 담고 있다.<br>

response 객체가 제공하는 기능은 다음과 같다.

1. 헤더 정보 입력
2. 리다이렉트 하기

<br>

### 리다이렉트

response 객체에서 **가장 많이 사용되는 기능 중 하나는 리다이렉트 기능이다.** 리다이렉트는 웹 서버가 웹 브라우저에게 다른 페이지로 이동하라고 응답하는 기능이다. 예를 들어 로그인에 성공을 하면 메인 페이지로 자동으로 이동하는 사이트가 많은데 이렇게 특정 페이지를 실행한 후 지정한 페이지로 이동하길 원할 때 리다이렉트 기능을 사용한다. <br>

예를 들어 보면 웹 브라우저가 a.jsp를 요청을 하면 a.jsp에서 b.jsp로 리다이렉트를 하라고 응답을 한다. 그러면 웹 브라우저는 b.jsp를 다시 요청한 후 서버가 b.jsp에 대한 응답을 한다. 간단하게 이야기 하자면 **리다이렉트를 지시한 jsp 페이지가 있을 경우 웹 브라우저는 서버로 2번 요청을 하게 된다**<br>

코드로 확인해보자.

```jsp
<%
    response.sendRedirect("이동할 페이지");
%>

<!--예제 코드-->

<%
    //로그인 페이지에서 이미 아이디에 대한 세션이 존재한다면 로그인페이지가 아닌 메인 페이지로 이동
    String userID = (String)session.getAttribute("userID");
    if(userID != null){
        response.sendRedirect("main.jsp");
    }
%>
```

<br>

---

<br>

## 요청 파라미터 인코딩

웹 브라우저는 웹 서버에 파라미터를 전송할 때 알맞은 캐리터 셋을 이용해서 파라미터의 값을 인코딩 한다. 반대로 웹 서버는 알맞은 캐릭터 셋을 이용해서 웹 브라우저가 전송한 파라미터 데이터를 디코딩한다. **예를 들어 웹 브라우저가 UTF-8 캐릭터 셋을 사용하여 파라미터 값을 인코딩 했다면 웹 서버는 UTF-8 캐릭터 셋을 이용해서 파라미터 값을 디코딩 해야 올바른 파라미터의 값을 얻을 수 있다.** <br>

어떠한 캐릭터 셋을 사용할지의 여부는 전송방식(GET,POST)에 따라 달라진다.<br>

### POST

POST방식에서는 입력 폼을 보여주는 응답화면이 사용하는 캐릭터 셋을 사용한다(브라우저) 예를 들어 응답 결과에서 사용한 캐릭터 셋이 UTF-8이면 UTF-8을 이용하여 파라미터의 값을 인코딩한다. **서버에서 파라미터의 값을 알맞게 사용하려면 웹 브라우저가 인코딩할 대 사용한 캐릭터 셋을 이용해서 디코딩해야 하는데 이 때 request의 setCharacterEncoding() method를 이용하여 파라미터의 값을 디코딩 할 때 사용할 캐릭터 셋을 지정할 수 있다.** 캐릭터 셋을 지정해주지 않으면 DEFAULT 값으로 "ISO-8859-1"을 사용하게 된다.<br>

* 예제 코드 
```jsp
<!--웹 브라우저-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--웹 서버 -->

<%
    //웹 브라우저에서 UTF-8로 인코딩을 진행했기 때문에 서버쪽에서도 캐릭터 셋을 맞춰줘야된다.
    request.setCharaterEncoding("UTF-8");
%>
```

<br>

<mark>주의해야 할 점은 setCharacterEncoding()는 파라미터의 값을 사용하기 전에 실행해야 한다. 파라미터의 값을 사용한 후 지정을 하게되면 사용하는 파라미터의 값은 기본 DEFAULT값으로 디코딩하게 된다.</mark> 따라서 페이지의 가장 윗 부분에 캐릭터 셋을 지정해서 사용하는 것이 좋을 것 같다.

<br>

### GET

get방식으로 파라미터 전송시 인코딩 결정 규칙 <br>

get 방식 이용 시 파라미터 전송 방법 | 인코딩 결정
&lt;a&gt; 태그의 링크 태그에 쿼리 문자열 추가 | 웹 페이지 인코딩 사용
HTML form의 method 속성값을 GET으로 지정해서 폼을 전송 | 웹 페이지 인코딩 사용
웹 브라우저 주소에 직접 쿼리 문자열을 포함하는 URL 입력 | 웹 브라우저마다 다름

<br>

tomcat에서 get방식의 파라미터를 위한 인코딩 처리는 server.xml에서 &lt;Connector&gt;에 속성을 추가함으로 처리할 수 있다.

1. useBodyEncodingForURI="true"

    * get방식에서는 setCharaterEncoding()를 사용할 수 없지만 useBodyEncodingForURI="true"를 추가하면 setCharaterEncoding()에서 지정한 캐릭터 셋을 사용할 수 있다.

2. URIEncoding

    * URI의 값을 구할 때 사용할 캐릭터 셋을 지정할 수 있다.

```xml
<!--useBodyEncodingForURI-->
<Connector useBodyEncodingForURI="true" connectionTimeout="20000" port="80" protocol="HTTP/1.1" redirectPort="8443"/>

<!--URIEncoding-->
<Connector URIEncoding="UTF-8" connectionTimeout="20000" port="80" protocol="HTTP/1.1" redirectPort="8443"/>
```

<br>

