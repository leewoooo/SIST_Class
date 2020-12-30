# Statement

* Query문이 반복 실행되더라도 query문을 한번만 생성하고 다음번 사용할 때에는 **값을 변경하여 실행한다.**<br>
(바인드 변수를 사용하여 값을 변경하며 같은 query문을 반복 실행할 때 효율이 좋다.)

* 실행할 query문을 지정하고 query문의 값을 동적을 지정해야 할 때 사용한다.

* Connection으로부터 query를 가지고 생성이 된다.(query문을 알고 있다.)

* SQL Injection의 취약점을 보완할 수 있다.

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
//SLEECT
String sql = SELECT column명 FROM 테이블명 WHERE column명 연산자 ?;

//INSERT (Update , DELETE)
String sql =  INSERT INTO 테이블명 (column명,column명,,,) VALUES (? , ? ,,,);

PreparedStatement pstmt = con.PreparedStatement(sql);
```

4. 바인드 변수에 값을 넣는다.(PreparedStatement의 set method이용)

* query문에 값을 넣어주는 bind variable을 사용하게 된다. (? 로 표기되는 bind variable)
* **query문과 값을 입력하는 것을 분리 할 수 있다.**
* query문 작성시에 문자열을 감싸는 ' '를 사용하지 않는다.
* INDEX를 이용하여 값을 집어 넣는다. **INDEX는 1부터 시작한다. 0번은 cursor INDEX**
* **column명, table명에 대해서는 bind variable을 사용할 수 없다.**

```java
pstmt.set데이터형(bind INDEX,넣어줄 값);

//자주 쓰이는 데이터형
pstmt.setint(bind Index, 정수);
pstmt.setString(bind Index, 문자열);
pstmt.setDate(bind Index, 날짜);
```

5. query문을 실행 후 결과를 얻는다.

* **생성된 PreparedStaetmentf로 query문을 실행할 때 매개변수는 넣지 않는다.(이미 가지고 있다.)**
```java
ResultSet rs =pstmt.executeQuery(); //조회된 Inline View가 ResultSet으로 반환된다.
//값을 가져올 때는 rs의 get method를 사용한다.
int cnt= pstmt.executeUpdate(); //변경된 행의 갯수가 반환
```

6. 연결 끊기
```java
rs.close();
stmt.close();
con.close();
```

* **자바의 바인드변수와 Oracle의 검색용 문자(%,_)가 함께 사용될 때 자바에서는 바인드 변수를 인식하지 못한다.**

* 해결방법은 검색용 문자를 단순 문자로 만들고 바인드 변수에 붙인다.
```java
//ex
SELECT ZIPCODE,SIDO,GUGUN,DONG,BUNJI
FROM ZIPCODE
WHERE DONG LIKE ?||'%' ;
```
  
