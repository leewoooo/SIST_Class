스프링 부트 환경에서 JSP사용하기
===

현재 스프링 부트에서는 JSP를 사용하는 것을 권장하지 않고 있지만 학원 강의 커리큘럼과 파이널 프로젝트를 JSP를 사용하기 때문에 정리하려 합니다. 왜 JSP를 사용하는 것을 권장하지 않고 있냐면 간단하게 JSP는 WAR로 밖에 빌드 되지 않고 스프링 부트는 내장 톰캣을 지원 하여 빠르고 쉽게 배포하는 환경과는 조금 거리가 있기 때문이라고 스프링 공식 홈페이지에 나와있습니다. JSP를 사용하기 때문에 처음 프로젝트를 만들때에도 Packaing 옵션을 WAR로 설정해야합니다. <br>

현재 maven 환경에서 개발하고 있기 때문에 pom.xml에 jsp를 사용하기 위한 의존성을 추가해줍니다.

```java
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```

gradle을 사용시에는 아래와 같이 추가해줍니다.

```java
dependencies {
    compile('javax.servlet:jstl') 
    compile("org.apache.tomcat.embed:tomcat-embed-jasper")
}
```

추가해 주는 이유는 spring-boot-starter-web 에 포함된 tomcat 은 JSP 엔진을 포함하고 있지 않기 때문에 jsp 파일은 Springboot 의 templates 폴더안에서 작동하지 않습니다. 그래서 jsp를 적용하기 위해서는 아래와 같은 의존성을 추가해야합니다. <br>

이후 application.properties에서 view의 경로를 설정해 주어야 합니다. 

```java
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

이렇게 설정이 모두 완료가 되면 아래와 같은 사진의 구조로 폴더를 만들고 view 경로에 따라 jsp를 만들어 사용하면 됩니다.

* 구조 

    <img src = https://user-images.githubusercontent.com/74294325/109898779-20ccb980-7cd8-11eb-87b9-b4cd79fa2b2f.PNG>

