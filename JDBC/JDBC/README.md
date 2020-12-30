# JDBC (Java Database Connectivity)

* Java에서 DBMS를 사용(연동)하기 위한 방법을 제공하는 저수준의 API.

* Driver Loading방식을 사용하여 Driver만 제공된다면 모든 DBMS와 연결이 가능하다.(확장성이 좋다.)
* Driver는 Java에서 제작 배포하는 것이 아닌 DB제조사에서 Driver를 제작하여 배포한다.

* JDBC 기술로 구현하는 java 프로그램의 연동과정

  * JDBC프로그램 - JDBC 인터페이스 - JDBC드라이버 - DB

  * JDBC 인터페이스는 JDBC 프로그램을 하기 위한 API들로서, SE에서 제공하는 java.sql 패키지를 의미

  * JDBC 드라이버는 java.sql의 인터페이스들을 상속하여 메소드의 몸체를 구현할 class파일들을 의미한다.


* Driver는 4가지 형으로 제공한다.

  * JDBC-ODBC Bridge Driver (Type1)
    *  windows운영체제만 사용되는 Driver이다. (DB연동 관리를 OS의 ODBC에서 수행하고 Java는 ODBC와 연결) ,속도가 느리다.

  

  * Native Driver (Type2 : OCI Driver)
    * 모든 운영체제에서 사용이 가능하다.
    * DB쪽의 연결 언어가 Java언어가 아닌 언어로 개발된 Driver. (언어간의 충돌에 대한 issue가 발생 할 수 있다.)

  

  * Network Protocol Driver (Type3)
    * Middle ware에서 사용하는 Driver

  

  * Native Protocol Driver  (Type4 : Thin)
    * 모든 운영체제에서 사용이 가능하다.
    * 연결에 필요한 모든 부분이 Java 로 개발 된 Driver 

---

## PLAGIN해서 DB를 eclipes에 사용하기.

* sourceforge.net에서 quantum database utily을 다운받아서 eclipes 설치 경로에서 plugins폴더에 넣어준 후 등록해서 사용하기.

* JDBC Driver를 등록한 후 DB사용자 인증 후 사용할 수 있다.

* quantum db에서 기본적인 INSERT,DELETE,UPDATE, row 전체삭제 등 기능을 사용할 수 있다.

---

## JDBC의 전체적인 구조

<img src = https://user-images.githubusercontent.com/74294325/103075729-8d0faa80-460f-11eb-9a5c-a96e2d6f9f1e.PNG>


---

## 각자의 역할

1. DriverManager : 로딩된 드라이버를 사용하여, DB연결하고 연결 반환

2. Connection : DB연결유지, Transaction처리, query문 생성객체를 반환

3. Statement : query문을 실행할 때마다 생성하여 처리하는 객체.

4. PreparedStatement : query문을 미리 생성하여 처리하는 객체

5. CallableStatement : Procedure를 호출 객체.

6. ResultSet : 조회결과를 사용하기위해 Cursor의 제어권을 받는 객체.

7. Cursor : Procedure를 호출할 때 SYS_REFCURSOR가 OUT Parameter로 전달되는 Cursor를 받기위한 사용하는 객체


---

## JDBC연동 순서

1. 드라이버 로딩(build path를 설정하여 jar file을 가져온다.)

2. 로딩된 드라이버를 사용하여 DB와 연결을 얻는다.

    * thin은 porcedure을 만들 수 없다.

    * DB의 위치를 입력할 때 Server의 IP를 입력한다.

3. query 생성 객체 얻기

4. query 수행 후 결과 얻기

    - INSERT,UPDATE,DELETE : query문이 실행되고 난 후 행의 수를 얻어야한다. ( executeUpdate(sql) 사용 )

    - SELECT : query문이 실행되고 난 후 조회된 행을 받아와야 한다.( executeQuery(sql) 사용 )

    - 수행 후 결과를 얻을 때 AutoCommit이 default이다. (query문 하나당 1commit) <br>
    setAutoCommit()로 AutoCommit를 관리할 수 있다.

5. 연결 끊기

    - try~catch문에서 finally구문을 이용하여 끊어준다.

---

## DTO (Data Transfer Object)

* 데이터가 포함된 객체를 한 시스템에서 다른 시스템으로 전달하는 작업을 처리하는 객체. 
* Vo와 dto의 차이점은 vo는 특정한 비즈니스 값을 담는 객체를 vo라 하고 dto는 레이어간의 통신용도로 오가는 객체를 dto라고 한다.

## VO (Value Object)
Value Object는 DTO와 동일한 개념이나 차이 점은 read only 속성을 갖는다. Value Object는 관계데이터베이스의 레코드에 대응되는 자바클래스이다.형태는 db레코드를 구성하는 필드들을 Value Object의 Attribute로 하고 해당 변수에 접근 할 수 있는 Getter Setter 메소드의 조합으로 클래스를 형성되어진 클래스이다. 특성은 대체로 불변성이고 equals()로 비교할 때 객체의 모든 값을 비교해야 한다.

* 값을 저장하고, 사용할 목적으로 제작하는 class

* 여러 개의 분할된 값을 묶어서 관리하기 위해 작성

* 분할된 값이 묶여서 어떤 값으로 사용되는지 알 수 있으므로 가독성이 향상된다.

* 작성규칙
```java
//Framework 사용
매개변수 있는 생성자를 만들지 않는다.(Framework에서 VO를 생성하여 setter method를 호출하여 값을 넣어준다.)
//Framework 사용 x
매개변수 있는 생성자를 만든다.(개발자가 VO를 생성하여 값을 넣어준다.)

//1. class명에 VO를 붙여준다.
public class testVO{
  //2.instance 변수를 선언한다.
  private int test1;
  private String tes2;

  public void setTest1(매개변수){ //값을 설정하기 위한 목적.
    this.test1 = argument;
  }

  public int getTest1(){ //값을 얻기 위한 목적.
    return this.test1;
  }

}
```

## DAO (Data Access Oject)

* Database의 data에 access하는 트랜잭션 객체를 의미한다.

* **DB를 사용해 data를 조회하거나 조작하는 기능을 전담하도록 만든 객체**

* 사용자는 자신이 필요한 Interface를 DAO에게 던지고 DAO는 Inteface를 구현한 객체를 사용자에게 편리하게 사용할 수 있도록 반환한다.

* DB에 대한 접근을 DAO가 담당하도록 하여 DB access를 DAO에서만 하게 되면 다수의 원격 호출을 통한 오버해드를 VO나 DTO를 통해 줄일 수 있고 다수의 DB 호출 문제를 해결 할 수 있다.

---


