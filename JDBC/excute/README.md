# excuteUpdate()

* query문이 실행 되었을 때 변경되는 행의 수를 반환하는 method이다.

* SQLException을 throws 하고 있다.

* 주로 DML (INSERT, UPDATE, DELETE) 에 사용된다.
 
```java
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

# excuteQuery(), ResultSet

* ResulSet은 executeQuery( ) 메소드에서 실행된 select 문의 결과값을 가지고 있는 객체.

* query문으로 조회하면 InlineView가 생성되고 ResultSet은 cursor의 제어권을 받는다.

  * cursor는 레코드의 유무를 반환하는 pointer개념이다.

* SELECT문을 사용할 때(조회할 때) 사용한다.

* **조회할 때 Alias를 사용했다면 get method를 사용해 조회 column을 가져올 때 Alias를 입력해야 한다.**

* data를 처리하는 면에서 Oracle 함수를 써서 가져올 수도 있고 java로 가지고 들어온 값을 java에서 처리 할 수도 있다.

  * 상황에 맞게 사용하면 된다. Oracle함수를 쓰는것은 oracle의 자원을 이용, java에서 처리하는것은 java 자원을 이용
  * 가독성이 좋은 것을 선택하면 된다. 

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
