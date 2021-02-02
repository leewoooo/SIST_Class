JSP 스크립트
===

## Goal

* html 파일에 java 관련 코드를 삽입하여 jsp파일을 만드는 방법을 학습한다.


1. JSP 주요 스크립트

<br>

---

<br>

## JSP 주요 스크립트


### 선언 태그

JSP페이지에서 Java의 멤버변수나 메서드를 선언하기 위해 선언태그를 사용한다. (<%! %>)

```jsp
<%!
int num = 10;
String str = "jsp";
ArrayList<String> list = new ArrayList<String>();

public void jspMethod(){
	System.out.println("jspMethod");
}

%>
```

코드로 확인해보면 <br>

jsp 파일 <br>

<img src = https://user-images.githubusercontent.com/74294325/106543574-5485b980-6549-11eb-9d65-d038a03a09af.PNG>

<br>

현재 count와 makeItLower를 <%! %>안에 선언을 했다. jsp를 실행하며 생성 된 java code를 확인해 보자면 <br>

<img src = https://user-images.githubusercontent.com/74294325/106543661-80a13a80-6549-11eb-864f-2786b210e0ba.PNG> <br>

생성된 servlet의 멤버로 추가되는 것을 확인 할 수 있다.

<br>

---

<br>

### 주석 태그

JSP 주석은 jsp파일이 서블릿 파일로 변환 될 때 제외된다.

```jsp
<!--HTML 주석 태그 -->
<!-- 주석입니다. 서블릿 파일로 변환 될 때 주석 부분은 제외가 됩니다.>

<%-- JSP 주석 태그 --%>
<%-- JSP 주석 태그입니다. 서블릿 파일로 변환 될 때 주석 부분은 제외가 됩니다. --%>
<%-- JSP 주석 태그는 JSP가 JAVA->Class 파일로 될 때 컴파일 대상에서 제외되고 응답으로 오는 HTML에서도 표현되지 않는다 %-->
```

<br>

---

<br>

### 스크립트릿 태그

JSP 페이지에서 JAVA코드를 넣기 위해서 사용한다. servlet에 _jspServlet method안 local에 작성1 ( <%  %>)

```jsp
<%
	if(num>0){
%>
	<p>num > 0 </p>
<%		
	}else{
%>
	<p>num <= 0 </p>
<%
	}
%>
```

<br>

코드로 확인해보자면 <br>

jsp 파일 <br>

<img src = https://user-images.githubusercontent.com/74294325/106543756-b0e8d900-6549-11eb-96d6-4626b26e7e24.PNG>

<br>

현재 year과 반복문이 <% %> 안에 선언되어있다. jsp를 실행하며 생성 된 java code를 확인해 보자면<br>

<img src = https://user-images.githubusercontent.com/74294325/106543835-d70e7900-6549-11eb-9e70-ad5ae4be66cb.PNG> <br>

이와 같이 _jspServise method 안 local에 속한 것을 확인할 수 있다.

<br>

---

<br>

### 표현식 태그

java의 변수 및 메서드의 반환값을 출력하는 태그

```jsp
<p>num의 값은<%=num%>입니다.</p>
```

<br>

## 지시어

서버에서 JSP페이지를 처리하는 방법에 대한 정의

1. page : 페이지 기본설정 -> <%@ page 속성="속성값">

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.lang.ArrayList" %>
```
<br>

페이지에서 사용하는 언어 혹은 charset등 페이지의 기본 설정을 Server에 알려주는 역할을 한다. <br>

또한 자바의 class들을 import 할 때 사용한다.

2. include : 외부의 파일을 현재 JSP에 추가할 때 사용한다. -> <%@ include file ="외부 파일의 url" %>

```jsp
<%@ include file= "../headr.jsp" %>
<%@ include file= "../footer.jsp" %>
```
<br>

웹페이지 프로젝트를하나 만들데 웹프로젝트에는 수많은 페이지가 나올수 있는다. <br>

주로 header와 footer은 모든 페이지에 들어가게 되는데 모든 페이지마다 동일한 코드로 header와 footer를 작성하는 것이 아니라 include를 사용하여 하나의 header와 footer를 가져다가 사용함으로 생산성을 높일 수 있다.

<br>

3. taglib : 외부라이브러리 태그 설정 -> <%@ taglib url="url" prefix="네임스페이스명">

```jsp
<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```