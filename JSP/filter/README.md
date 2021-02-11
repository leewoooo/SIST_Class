fiter
===

filter는 클라이언트와 서버 사이에서 request와 response 객체를 먼저 받아 사전/사후 작업 등 공통적으로 필요한 부분을 처리한다. <br>

클라이언트가 서블릿이나 jsp와 같은 페이지에 도달하기 전과, 페이지의 결과가 클라이언트에게 응답되기 전에 필요한 처리를 할 수 있다. <br>

필터는 HTTP 요청과 응답을 변경할 수 있는 코드로 재사용이 가능하며 클라리언트와 정적 리소스 사이에 여러개의 필터로 이루어진 필터체인을 제공한다. <br>

* 필터의 구조

    <img src = https://user-images.githubusercontent.com/74294325/107609908-961e0f00-6c83-11eb-9e3f-75555eea101c.png>

<br>

request 필터에서는 주로 사용자의 인증, 인코딩, 로그파일 작성등의 역할을 하며 response 필터에서는 응답 결과 데이터를 압축하거나 서비스 시간을 측정한다.

<br>

## filter 만들기

필터 기능을 구현하기 위해서는 Filter interface를 필터 역할을 하는 class에서 구현을 해야한다. 

```java
public class filterTest implements Filter{
    ,,,
}
```

<br>

filter interface는 method를 3가지 가지고 있다.

1. init()
2. doFilter()
3. destory()

<Br>

### init()

주로 필터를 초기화 할 때 사용을 하며 구조는 이러하다.
```java
@Override
public void init(FilterConfig filterConfig) throws ServletException {
    //여기서 필터를 초기화 때 필요한 코드들을 구현
}
```
<br>

### destory()

필터 인스턴스를 종료하기 전에 호출되는 method이다. 필터를 삭제하기 전 청소 작업을 수행하는데 사용되며 **주로 필터에서 사용된 리소스를 닫는 역할을 한다.**
```java
@Override
public void destroy() {
    //필터에서 사용한 자원들을 해제시키는 역할을 주로 한다.
}
```

<br>

### doFilter()

필터 method에서 가장 중요한 method이다. 먼저 구조를 보자면 
```java
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    //이것을 기준으로 위에 request 아래는 response 
    chain.doFilter(request, response); 
}
```

<br>

매개변수로 request와 response를 받으며 **'chain.doFilter(request, response);' 를 기준으로 위에서 request에대한 처리를 하고 밑에서 response에 대한 처리를 한다.**

<br>

이렇게 생성한 filter를 web.xml에서 mapping를 해줘야한다.
```xml
<filter>
    <filter-name>filter이름</filter-name>
    <filter-class>filter class의 경로</filter-class>
</filter>
<filter-mapping>
    <filter-name>위에서 지정한 filter이름과 동일</filter-name>
    <url-pattern>여기서 지정한 주소로 요청시 filter적용</url-pattern>
</filter-mapping>
```

<br>

또한 filter를 mapping할 때 param값을 지정할 수 있다.
```xml
<filter>
    <filter-name>filter이름</filter-name>
    <filter-class>filter class의 경로</filter-class>
    <init-param>
        <param-name>파라미터 이름</param-name>
        <param-value>파라미터 값</param-value>
    </init-param>
</filter>
```

<br>

param값은 FilterConfig의 getIninParameter("파라미터이름");으로 가져올 수 있다 다음 코드를 통해 확인해보자.

```java
public class TestFilter implements Filter{
	
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String test = filterConfig.getInitParameter("파라미터 이름");
        chain.doFilter(request, response); 
    }
```

<br>

이와같이 필드에 FilterConfig를 선언해주고 init() method에서 들어오는 FilterConfig를 할당해준 후 값을 얻어올 수 있다.<br>

나와같은 경우에는 filter의 url을 /*로 설정하여 모든 요청으로 부터 request의 encoding의 charset을 utf-8로 설정하여 사용하고 있다. post방식으로 값을 받을 경우 매번 charset을 설정해줘야 됬지만 filter를 사용하면 작성하지 않아도 된다ㅎㅎ

```java
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
    
    request.setCharacterEncoding("UTF-8");
    chain.doFilter(request, response); //이것을 기준으로 위에 request 아래 response
}
```

