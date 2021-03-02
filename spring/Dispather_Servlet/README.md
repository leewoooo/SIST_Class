Dispather-Servlet
===

## Dispather-Servlet의 개념

Dispather-Servlet은 Servlet Container에서 HTTP 프로토콜을 통해 들어오는 모든 요청을 제일 앞에서 처리하는 프론트 컨트롤러를 이야기한다. 그래서 작업을 Dispather-Servlet가 처리 한 후 세부 컨트롤러로 작업을 위임해준다. Dispather-Servlet를 처리하는 url패턴을 지정해주여야 한다.

>프론트 컨트롤러는 주로 서블릿 컨테이너 제일 앞에서 서버로 들어오는 클라이언트의 모든 요청을 받아서 처리해주는 컨트롤러(MVC구조에서 함께 사용되는 패턴)

<br>

## Dispather-Servlet의 장점

Spring MVC는 Dispather-Servlet이 등장함에 따라 web.xml의 역할을 축소시켜주었다. 기존에는 모든 서블릿에 대해 URL mapping을 활용하기 위해 web.xml에 모드 등록해주어야 했지만 **Dispather-Servlet이 지정한 URL에 들어오는 모든 요청을 핸들링한다.** 

<br>

## 사용의 흐름

* 흐름도

    <img src = https://user-images.githubusercontent.com/74294325/109606098-7e8ec380-7b69-11eb-92c5-b7a001a5585b.PNG>

---

## 사용해보기

1. 먼저는 web.xml에 등록을 한다. 서블릿 등록과 등록방법은 동일하다. init-param으로 name에 contextConfigLocation(약속) value에 WebApplicationContext파일의 경로를 입력해준다. 현재 예제에서 나는 fornt라는 서블릿 이름으로 Dispather-Servlet를 등록하였다. (경로는 WebContent부터 시작하며 만일 WebApplicationContext가 web.xml에 같은 위치에 있다면 서블릿 이름과 동일하게 서블릿명-servlet.xml로 생성하면 init-param를 생략해도 된다.)

```xml
<!-- .do에 해당하는 프론트 컨트롤러를 생성한다. DispatcherServlet 스프링에서 지원 -->
<servlet>
<servlet-name>front</servlet-name>
<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
<!--이 요청으로 들어올 때 사용될 config를 param으로 입력(WebApplicationContext)-->
<init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/front-servlet.xml</param-value>
</init-param>
</servlet>

<servlet-mapping>
<servlet-name>front</servlet-name>
<url-pattern>*.do</url-pattern>
</servlet-mapping>
```

이제 *.do에 해당하는 요청은 front-servlet.xml이라는 WebApplicationContext에서 처리를 하게 된다. (한개 이상의 WebApplicationContext설정도 가능하다.)

<br>

2. 그 이후 WebApplicationContext에 viewResolver를 설정해준다. bean을 등록할 때와 동일하고 property로 적용할 view의 위치와 확장자를 받게된다.

```xml
<!-- view 리졸버 설정 prefix는 view 파일이 있는 파일 위치 suffix는  해당 view의 확장자-->
<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/view/" />
    <property name="suffix" value=".jsp" />
</bean>
```

<br>

이렇게 설정이 끝나면 WebApplicationContext에 bean을 등록하고 contoller를 이용하여 view를 처리할 수 있게 된다.