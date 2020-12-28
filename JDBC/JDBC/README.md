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

## Statement

- query문 실행 객체(Statement가 만들어지는 시점에는 query문을 알 수 없다.)

- 실행할 때 마다 query문을 생성하여 실행한다.(query문을 반복실행하면 동일 query를 계속 생성) <br>
동일 query를 실행하면 효율이 떨어지지만 한번만 실행 될 때는 preparedStatement보다 좋다.

- PreparedStatement의 부모 Interface

- 값을 query문에 직접 넣어 query문을 생성한다.

- SQLInjection이 발생할 수 있다. (SQL 주입공격)

- 얻는 문법
```
Statement stmt = con.createStatement();
```

---
## executeUpdate()

* query문이 실행 되었을 때 변경되는 행의 수를 반환하는 method이다.

* SQLException을 throws 하고 있다.

* 주로 DML (INSERT, UPDATE, DELETE) 에 사용된다.
 
```
try{
  int cnt = stmt.executeUpdate(sql)
  if(cnt = 변경한 행의수){
    //변경이 성공 되었을 때 수행될 code
  }
}catch(SQLException e){
  //query문이 수행되지 않을 경우의 실행될 코드 throws로 대부분 처리
} finally{
  //연결된 connection 끊어주기
  stmt.close();
  con.close();
}
```

* Insert를 사용했을 경우에는 반환되는 값이 1 아니면 예외이기 때문에 반환값을 받지 않고 사용.


---

## excuteQuery()

* ResultSet을 반환하는 method이다.

* query문으로 조회하면 InlineView가 생성되고 ResultSet은 cursor의 제어권을 받는다.

  * cursor는 레코드의 유무를 반환하는 pointer개념이다.

* SELECT문을 사용할 때(조회할 때) 사용한다.

* 주로 사용된는 method

  * rs.next() : 조회된 Inlineview에서 레코드가 있다면 cursor다음의 레코드 한개를 가져온다. 반환형은 boolean
  * rs.beforeFirst() : 커서를 시작 빈행으로 위치시키는 method.
  * rs.afterLast() : 커서를 끝 빈 행으로 위치시키는 method.
  * rs.get데이터형() : column값을 조회할 때 사용하는 method
```java
ResultSet rs = Stmt.executeQuery( sql ); //조회된 Inlineview cursor의 제어권을 얻는다.
//조회된 Inlineview에 모든 레코드 조회
while(rs.next()){ //조회된 레코드가 몇개가 있는지 알 수 없기 때문에 while문 사용
  
  //column의 값을 조회할 때
  column의 데이터형에 맞는 java데이터형 변수명 = rs.get데이터형(column명);
  
  //ex
  int deptno = rs.getint(DEPTNO); 
  String dname = rs.getString(DNAME);
}
```
---

## VO (Value Object)

* 값을 저장하고, 사용할 목적으로 제작하는 class

* 여러 개의 분할된 값을 묶어서 관리하기 위해 작성

* 분할된 값이 묶여서 어떤 값으로 사용되는지 알 수 있으므로 가독성이 향상된다.

* DTO(Data Transfer Object) - 사용목적은 같으나 DTO는 값이 변경이 가능하다.

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