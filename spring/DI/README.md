DI
===

스프링 컨테이너가 지원하는 핵심 개념 중의 하나로 객체간의 의존 관계를 객체 자신이 아닌 외부의 조립기가 수행 해 준다는 개념.

>컨테이너에 Bean으로 등록해 놓고 필요할 때 가져다가 사용하는 개념!

<br>

DI이의 장점으로는 객체간의 느슨한 결합을 이용할 수 있다는 장점이 있다. 객체끼리 IS-A 관계를 가지고 있다면 관계가 되어있는 객체의 코드가 조금이라도 수정이 된다면 큰 영향을 받게 된다. 하지만 DI를 이용하면 주입을 해줄 때 주입해주는 객체만 수정해서 바꿔줄 수 있다는 장점을 가지고 있다.

DI는 ApplicatinContext에서 객체를 생성해주고 필요한 객체를 주입해준다. ApplicatinContext에서 관리하는 객체를 Bean이라고 불리며 Bean과 Bean끼리도 의존성을 가질 수 있다. <br>

* 하나의 오브젝트가 변경이 일어 날 때 관계를 맺고 있는 다른 오브젝트에게 변화를
요구하는 정도->결합도

* 결합도가 높아지면 변경에 따른 작업량이 많아 지고, 변경으로 인해 버그가 발생할
가능성이 높아진다.

* 사진 

    <img src =https://user-images.githubusercontent.com/74294325/108964935-7d6c1b00-76bf-11eb-8835-d6ce7a2e0a35.PNG>


<Br>

위의 사진을 보면<br>

sample1은 객체간의 관계가 is-a관계로 되어있다. 이 경우에는 객체간의 결합도가 높다. A객체를 B객체에서 생성을 해서 사용할 때 A객체의 수정이 일어나면 B객체에도 영향이 크게되며 많은 수정이 있는 경우 유지보수가 어려워 진다. <br>

sample2는 interface를 하나 생성하고 interface를 구현한 class를 사용하여 객체간의 결합도를 낮출수 있다. 만약 interface를 구현한 class가 A이고 B에서 A를 통해 interface를 구현해서 사용하다가 나중에 수정이 필요하면 interface를 구현하는 C class를 만들어 바꿔 끼워주기만 하면 된다.(조립되는 부분에만 코드를 수정해주면 쉽게 유지보수가 가능하다)<br>

sample3은 spring에서 사용하는 DI개념이다. Spring Bean Configuration file등과 같은 설정 파일에 객체를 Bean으로 등록해놓고 사용하는 객체에서 가져다 사용하는 개념이다. 이렇게 된다면 소스파일을 변경하지 않고 설정파일을 수정함으로써 의존이 필요한 객체를 교체해줄 수 도 있다.

>정리해서 이야기하자면 DI로 객체를 주입받으려면 먼저 그 객체가 Bean으로 등록이 되어있어야 한다. (config file이나 component로 등록이 가능하다.) 그 후 주입을 받는 방법은 3가지가 있는데 field주입과 setter주입, 생성자 주입이 존재한다. 주로 생성자 주입을 사용하며 spring에서도 생성자 주입을 권장한다. 이렇게 등록된 Bean은 기본 값으로 singleton으로 생성이 되며 여기저기서 사용되어도 단 하나의 객체를 가지고 사용하는 것이다.

<br>

---

<Br>


## Bean 등록

<Br>

## XML로 등록

오늘 수업에서는 xml을 통한 Bean을 등록하는 방법을 교육받았다(02/24) 등록하는 방법을 코드로 확인해보자면 <br>

아래와 같은 Spring Bean Configuration file(xml)을 통해 Bean을 등록하였다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">


</beans>
```

<br>

예제를 통해 더 간단하게 확인해보자면 현재 book 이라는 class와 bookDAO라는 class가 있다고 가정을 하고 bookDAO는 book에 대해 의존적인 관계이다. 


* book.java

```java
public class Book {	
    private int no;
    private String name;
    private String price;
    private String publisher;


    public Book(int no, String name, String price, String publisher) {
        super();
        this.no = no;
        this.name = name;
        this.price = price;
        this.publisher = publisher;
    }
}
```

* bookDAO.java
```java
public class BookDAO {
	
	private final int cnt;
	private final Book book;
	
	public BookDAO(Book book, int cnt) {
		super();
		this.book = book;
		this.cnt = cnt;
	}
}
```

이 때 Book과 BookDAO를 Bean으로 등록하기 위해서는 xml에 Bena으로 등록하겠다는 코드를 작성해주어야 하는데 다음과 같다.

```xml
<bean id="book" class="com.sist.exam07.Book">
		<constructor-arg value="1"/>
		<constructor-arg value="이우길자서전"/>
		<constructor-arg value="45000"/>
		<constructor-arg value="이우길출판사"/>
</bean>
	
<bean id="bookDAO" class="com.sist.exam07.BookDAO">
    <constructor-arg value="99"/>
    <constructor-arg ref="book"/>
</bean>
```

<br>

Spring Bean Configuration file(xml)안에서 bean tag를 이용하여 class를 등록해준다. constructor-arg는 기본생성자가 존재하지 않고 매개변수가 있는 생성자가 있는 경우에 값을 넣어주어서 생성을 해줘야한다. 넣어주는 값은 생성자에서 매개변수를 선언해준 순서대로 입력을 해주면 된다. <br>

이 때 기본자료형인 경우 constructor-arg의 option중 value의 속성값에 넣어주면 되고 객체를 넣어줘야 한다면 ref라는 속성값에 넣어주면 된다. <br>

**여기서 중요한 점은 BookDAO가 Book을 의존하고 있고 생성자를 통해 주입받고 있는데 Spring Bean Configuration file(xml)안에서 Book을 먼저 등록하고 BookDAO를 등록해줘야한다는 점이다.** <br>

만약 Bean으로 등록하는 객체에서 기본 생성자가 없이 매개변수가 있는 생성자만 존재할 경우 매개변수에 대한 값을 전부 지정을 해줘야 생성이 된다. <Br>

이제 등록을 했으니 Bean을 사용하는 방법은 2가지가 존재한다. ApplicationContext를 이용하는 방법과 BeanFactory를 이용하는 방법이 있다. BeanFactory를 이용할 경우에는 Resource가 필요하다. 

1. BeanFactory
```java
Resource resource = new ClassPathResource("xml파일경로");
BeanFactory factory = new XmlBeanFactory(resource);
//getBean은 Object 타입을 반환하기 떄문에 casting을 해줘야한다.
Bean으로 등록한 class class명 = (Bean으로 등록한)factory.getBean("등록할 때 사용한 id")
```

2. ApplicatinContext (위의 book,bookDAO를 가지고 예제)
```java
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/sist/exam07/bookBean.xml");
BookDAO bookDAO = (BookDAO)applicationContext.getBean("bookDAO");
bookDAO.insertBook();
```

ApplicatinContext는 BeanFactory interface를 상속하고 있다.

<BR>

---

## Annotation으로 등록

XML대신 자바의 Class가 그 역할을 대신 해주는 것을 이야기 한다. <br>

이전 공부했던 [DI](https://github.com/LeeWoooo/TIL/tree/main/spring/DI)안에 '@Configuration를 이용한 Bean등록' 를 참조해서 공부를 해보자. <br>

XML에서 &lt;bean/>으로 빈을 등록해줬었는데 Annotation으로는 @Bean으로 등록을 할 수 있다. <br>

단 **환경설정으로 사용할 자바 Class는 Class위에 @Configuration을 선언해주어야 한다.** 코드로 한번 확인해보자! <br>

* xml 방법

```xml
<bean id="bookDAO" class="com.sist.exam07.BookDAO">
    <constructor-arg value="99"/>
    <constructor-arg ref="book"/>
</bean>
```

* Annotation 방법

```java
@Configuration
public class Config{
    @Bean
    public BookDAO bookDAO(){
        return new BookDAO(99,"book");
    }
}
```

<br>

여기서도 Bean으로 등록된 객체끼리 의존성을 가지고 있을 수 도 있는데 다음과 같이 처리해주면 된다 예제 코드로 확인을 해보자. UpdateInfo라는 class가 있고 MeberServicec라는 class는 UpdateInfo를 의존하고 있다. 

* UpdateInfo
```java
public class UpdateInfo {

	private final String id;

	public UpdateInfo(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	};
	
}
```

* MeberServicec
```java
public class MemberService {

	private final UpdateInfo info;

	public MemberService(UpdateInfo info) {
		this.info = info;
	}

	public void update(String memberID) {
		System.out.println(memberID + "의 정보를 " + info.getId() + "로 수정하였습니다.");
	}
}
```

* @Configuration
```java
@Configuration
public class SpringConfig {

	@Bean
	public UpdateInfo info() {
		return new UpdateInfo("이우길");
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(info());
	}
}
```

<br>

이와 같이 memberService가 생성이 되는 시점에 의존하고 있는 객체의 생성자를 넣어줌으로 의존관계를 설정할 수 있다. 이제 잘 엮였는지 test를 하기 위해 Main class를 생성했다.
```java
public class MainTest {
	public static void main(String[] args) {	
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		MemberService memberService = (MemberService)context.getBean("memberService");
		memberService.update("백엔드 개발자");
	}
}
```

<Br>

등록되어 있는 Bean을 가져올 때는 똑같이 ApplicationContext을 이용하지만 AnnotationConfigApplicationContext로 생성을 하고 매개변수로 config class를 넣어준다. getBean으로 가져올 때는 Bean으로 등록하는 method의 method명을 매개변수로 넣어준다.(xml의 id = config의 method 명) <br>

* 결과

    <img src = https://user-images.githubusercontent.com/74294325/109113236-48bf9880-777f-11eb-9248-3b9b450bdfda.PNG>
