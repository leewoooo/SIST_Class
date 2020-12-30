# Statement

* Connection 객체에서 얻을 수 있다.

* Query문 실행 객체 : **Statement가 실행되는 시점에 query문을 넣기 때문에 Statement는 sql의 내용을 알 수 없다.**)

* 실행할 때 마다 query문을 생성하여 실행한다. (query문을 반복실행하면 동일 query를 계속생성)<br>
동일 query를 실행하면 효율이 떨어진다. 한번만 실행 될 경우에는 PreparedStatement보다 효율이 좋다.

* 값을 query문에 직접 넣어 query문을 생성한다.(바인드 변수 사용 X)

* SQL Inject에 취약하다.

## 사용순서

1. Driver를 로딩한다.
```java
Class.forName("oracle.jdbc.OracleDriver");
```

2. 연결한 Driver에서 Connection을 얻는다.
```java
String url="jdbc:oracle:thin:@localhost:1521:orcl"; 
String id="scott";
String pass="tiger";

Connection con = DriverManager.getConnection(url,id,pass);
```

3. Connenction으로 부터 Statement를 얻는다.
```java
Statement stmt = con.CreateStatement();
```
4. query문을 실행 후 결과를 얻는다.


```java
//SLEECT
String sql = SELECT column명 FROM 테이블명;
ResultSet rs = stmt.executeQuery(sql) //조회된 Inline View가 ResultSet으로 반환된다.
//값을 가져올 때는 rs의 get method를 사용한다.


//UPDATE (INSERT, DELETE)
String sql = UPDATE 테이블명 set column명 = 변경될 값 WHERE 조건

int cnt = stmt.executeUpdate(sql); //변경된 행의 갯수가 반환
```

5. 연결 끊기
```java
rs.close();
stmt.close();
con.close();
```

