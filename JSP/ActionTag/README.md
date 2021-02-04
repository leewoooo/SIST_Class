액션태그
===

서버나 클라이언트에게 어떠한 행동을 하도록 명령을 하는 태그이며 jsp 페이지에서 페이지와 페이지 사이를 제어한다. <br>

다른 페이지의 실행 결과를 내용을 현재 페이지에 포함시킬 수도 있으며 자바 Bean등과 같은 기능들을 제공한다. <br>

## 주요 액션태그의 종류

액션 태그 | 형식 | 설명
:--- | :--- | :---
forward | &lt;jsp:forward.../&gt;| 다른 페이지로 이동과 같은 페이지 흐름을 제어한다.
include | &lt;jsp:include.../&gt; | 외부 페이지의 내용을 포함하거나 페이지를 모듈화 합니다.
useBean | &lt;jsp:useBean.../&gt; | jsp 페이지에 자바Bean을 설정합니다.
param | &lt;jsp:param.../&gt; |&lt;jsp:forward.../&gt;,&lt;jsp:include.../&gt; 태그에 인자를 추가합니다.(값을 전달하는 역할)

<br>

---

<br>

## forward
* 현재 jsp 페이지에서 다른 페이지로 이동하는 태그이다. 
* jsp컨테이너는 현재 jsp페이지에서 **forward 액션 태그를 만나면 그 전까지 출력 버퍼에 저장되어 있던 내용을 모두 삭제하고** forward 액션태그에 설정된 페이지로 프로그램의 제어가 이동
* <mark>상황에 따라 각각의 페이지로 이동시킬 때 사용이 가능하다</mark>

<br>

```jsp
<jsp:forward page="파일명"/> <!--param의 값이 없을 때는 혼자 닫을 수 있다.-->
또는
<jsp:forward page="파일명">이동되면서 전달될 값</jsp:forward>
```

<br>

page의 속성값
* 현재 jsp에서 이동될 페이지의 외부 파일명을 넣어줄 수 있다.
* 외부파일은 현재 jsp페이지와 같은 디렉토리에 있으면 파일명만 설정이 가능하고, 그렇지 않다면 URL 혹은 상대경로로 설정해준다.

<br>

* 예제 코드
```jsp
	<body>
		<h3>첫번 째 페이지 입니다.</h3>
		<jsp:forward page="./secondForward.jsp" />
		<p>현재 페이지에서  secondForward.jsp로 이동</p>
	</body>
```
```jsp
	<body>
		<h3>두번 째 페이지 입니다.</h3>
		<p>첫번째 페이지인 firstForward.jsp의 내용은 보여지지 않고
		페이지가 이동된 후 현재 페이지의 내용이 보여집니다. url상에서는 firstForward.jsp가 표시됩니다.</p>
	</body>
```

<br>

* 결과

    <img src = https://user-images.githubusercontent.com/74294325/106834693-436bb280-66d9-11eb-9817-d98ba5c65a17.PNG>

<br>

같은 결과를 response의 sendRedirect method를 사용하면 url상에서는 이동된 페이지가 표시된다.
<br>
```jsp
	<body>
		<h3>첫번 째 페이지 입니다.</h3>
		<%
			response.sendRedirect("http://localhost/jsp_prj/day0204/secondsendRedirect.jsp");
		%>
		<p>현재 페이지의 내용은 표시되지 않은 상태로 secondForward.jsp로 이동</p>
	</body>
```
```jsp
	<body>
		<h3>두번 째 페이지 입니다.</h3>
		<p>sendRedirect를 사용할 경우는 url에 이동된 페이지가 표시됩니다.</p>
	</body>
```

<br>

* 결과

    <img src = https://user-images.githubusercontent.com/74294325/106837394-d1499c80-66dd-11eb-8800-59fe6191f227.PNG>

---

<br>

## include

* include 디렉티브 태그처럼 현재 jsp 페이지의 특정 영역에 외부파일의 내용을 포함하는 태그

* 현재 jsp페이지에 포함할 수 있는 외부파일은 HTML, JSP, 서블릿 페이지 등이 있다.

* <mark>include 디렉티브 태그는 외부파일이 포함되도 하나의 서블릿을 생성했다면 액션태그의 include는 각각의 서블릿을 생성한다.</mark>

<br>

```jsp
<jsp:include page="파일명" flush="false"/>
```

<br>

page의 속성값
* 현재 jsp페이지 내에 포함할 내용을 가진 외부 파일명
* 외부파일은 현재 jsp페이지와 같은 디렉토리에 있으면 파일명만 설정이 가능하고, 그렇지 않다면 URL 혹은 상대경로로 설정해준다.

<br>

flush의 속성값
* 설정한 외부 파일로 제어가 이동할 때 현재 jsp 페이지가 지금까지 출력 버퍼에 저장한 결과를 처리, 기본값은  false
* true로 설정하면 외부 파일로 제어가 이동할 때 현재 jsp페이지가 지금까지 출력버퍼에 저장된 내용을 웹 브라우저에 출력하고 출력 버퍼를 비움
<br>

* 예제 코드
```jsp
<body>
    <h3>이 페이지는 firstInclude.jsp 페이지의 내용입니다.</h3>
    <jsp:include page="./secondInclude.jsp"/>
</body>
```
```jsp
<body>
    <h3>이 페이지는 secondInclude.jsp 페이지의 내용입니다</h3>
</body>
```

<br>

* 결과

    <img src= https://user-images.githubusercontent.com/74294325/106852180-fc8eb480-66fa-11eb-9d82-7df4ae5ff10a.PNG>

    이와 같이 디렉티브 태그와 달리 각각의 jsp에 해당하는 서블릿이 포함된다.

* 결론 

include 액션태그와 include 디렉티브 모두 다른 페이지를 현재 페이지에 포함시킬 수 있는 기능을 가지고 있다 <br>

하지만, include 디렉티브는 단순하게 소스의 내용이 텍스트로 포함되지만, include 액션태그는 포함시킬 페이지의 처리 결과를 포함시킨다는 점이 차이점이다. <br>

포함되는 페이지는 HTML, JSP, Servlet 페이지 모두 가능다.

<mark>쉽게 말해서 include 디렉티브는 포함될 파일의 내용(소스코드)을 복사해서 붙여넣기 하여 하나의 파일로 합치는 정적 방식이라고 보면 되고,
include 액션태그는 포함될 페이지의 결과가 원래 페이지의 결과와 합쳐서 보이게 된다.</mark>

<br>

---

<br>

## prarm

* 현재 jsp 페이지에서 다른 페이지에 정보를 전달하는 태그

* 이 태그는 **단독으로 사용하지 못하며 forword나 include태그의 내부에서 사용**

* 다른 페이지에 여러 개의 정보를 전송해야 할 때는 다중의 param 액션태그를 사용.

<br>

```jsp
<jsp:forward page="파일명">
    <jsp:param name="매개변수명1" value="매개변수값1" />
</jsp:forward>
```
```jsp
<!--값을 받아올 때는 name의 값을 사용하여 request.getParameter()를 사용한다.-->
String value = request.getParameter("name");
```

<Br>

* 예제코드

```jsp
<h3>이 파일은 firstParam.jsp입니다.</h3>
<jsp:include page="secondParam.jsp">
    <jsp:param value="<%=new Date()%>" name="date"/>
</jsp:include>
```
```jsp
<body>
    <h3>이 파일은 secondParam.jsp 이며 firstParam에서 받은 값을 사용합니다.</h3>
    <%
        String date = request.getParameter("date");
    %>
    <%=date%> &lt;= firstParame에서 전달 받은 값
</body>
```

<br>

* 결과

    <img src = https://user-images.githubusercontent.com/74294325/106853502-25b04480-66fd-11eb-82bf-a97a7d458912.PNG>

<br>

---

<br>

## 자바BEAN

* 동적 content를 개발하기 위해 자바 코드를 사용하여 자바 class로 로직을 작성

* JSP 페이지에서 화면을 표현하기 위한 계산식이나 자료의 처리를 담당하는 자바코드를 따로 분리하여 작성하는 것

* JSP에서는 일반적으로 정보를 표현할 때에 주로 사용을 하게 된다.

### 자바Bean을 작성할 때 규칙

1. 자바 class는 Serializable 인터페이스를 구현한다. (현재 Bean을 파일로 출력하지 않을 경우 구현하지 않아도 된다.)

2. 매개변수가 없는 생선자를 선언한다.(useBean을 이용하여 객체를 생성할 때 사용된다.)

3. 모든 멤버변수의 접근지정자는 private으로 설정되어야 한다.

4. 모든 멤버변수인 프로퍼티는 getter/setter() method가 존재해야한다.

5. 자바bean은 특정 pacakge에 속해있어야 한다.

<br>

### useBean 태그

JSP에서 자바Bean을 사용하기 위해 실제 자바 class를 선언하고 초기화 하는 태그(이때 매개변수가 없는 생성자를 사용하게된다.) id 속성과 scope속성을 바탕으로 자바Bean 객체를 검색하고, 객체가 발견되지 않으면 빈 객체를 생성한다.

<br>

```jsp
<jsp:useBean id="자바Bean 식별이름" class="자바빈즈 이름" scope="범위" />
```

<br>

* id : 자바 bean을 식별하기 위한 이름.

* class: 패키지 이름을 포함한 자바Bean의 이름. 자바Bean의 위치를 나타내는 경로를 적어준다.

* scope : 자바bean가 저장되는 영역을 설정한다. 값으로는 page, request,session,application중 하나의 값을 사용합니다.

<br>

## setProperty

useBean 액션 태그와 함께 자바Bean의 setter() method에 접근하여 자바Bean의 멤버변수에 값을 저장

<br>

```jsp
<jsp:setProperty name="자바Bean 식별이름" property="프로퍼티 이름" value="값"/>
```

<br>

* name : useBean 태그에 id속성 값으로 설정된 자바Bean을 식별

* property : 자바Bean의 프로퍼티의 이름 만약 프로퍼티의 속성값에 *를 사용하면 모든 요청 파라미터가 자바Bean의 setter()로 전달

* value : 변결할 자바빈즈의 프로퍼티의 값. 

<br>

요청을 하는 page의 form태그의 각각의 name값과 자바Bean의 멤버변수명을 동일하게 설정하면 요청으로 넘어오는 form태그의 값들이 자바Bean의 setter()에 의해 값이 설정된다.

<br>

## getProperty

useBean 액션 태그와 함께 자바Bean의 getter() method에 접근하여 자바Bean의 멤버변수에 값을 가져온다.

<br>

```jsp
<jsp:getProperty name="자바Bean 식별이름" property="프로퍼티 이름"/>
```

<br>

* name : useBean 태그에 id속성 값으로 설정된 자바Bean을 식별
* property : 자바Bean의 프로퍼티의 이름 만약 프로퍼티의 속성값에 *를 사용하면 모든 요청 파라미터가 자바Bean의 getter()로 전달

<br>

### 예제 코드

```java
package com.sist.bean;

public class MemberBean {
	private String id;
	private String pwd;
	private String name;
	private String email;
	public MemberBean() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
```
```jsp
<!--클라이언트-->
<form action="joinOk.jsp" method="post">
    아이디 : <input type="text" name="id"><br>
    비밀번호 : <input type="password" name="pwd"> <br>
    이름 : <input type="text" name="name"><br>
    이메일 : <input type="email" name="email"><br>
    <input type="submit" value="가입하기">
    <input type="reset" value="다시입력">
</form>
<!--서버-->
<jsp:useBean id="member" class="com.sist.bean.MemberBean" scope="page" />
    <!--한번에 다 가져오기-->
<jsp:setProperty property="*" name="member"/><!--form의 입력값으 모두 가져온다.-->
    <!--특정 값 가져오기-->
<jsp:setProperty property="name" name="member"/>
```