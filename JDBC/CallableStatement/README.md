# CallableStatement

## Procedure (PL / SQL)

* DBMS에서 자주 사용될 Query문을 미리 구현해두고 필요한 곳에서 호출하여 사용할 때. (제어문과 query문을 갖는다.)

* 직접 호출하여 사용. (sqlplus에서 실행기(exec | execute)를 사용하여 호출)

* 함수보다 개선된 매개변수를 지원한다.(return 값이 여러 개가 될 수 있다.)

* 컴파일(@파일명.sql)후 실행을 수행. (exec Procedure명(값,,,))을 수행.

* 매개변수는 외부의 값을 받아들이는 in parameter와 Procedure의 처리결과를 반환하는 out parameter가 존재.

    * out parameter: Procedure가 처리한 결과가 바인드 변수에 저장

* Procedure를 조회할 때 DD는 USER_PROCEDURES을 사용한다.
```
SELECT * FROM USER_PROCEDURES;
```

## Procedure 작성방법

1. 생성 (변경)
```
Create [or replace] Procedure Procedure명(Datatype 매개변수명,,,,)
is
-- 변수 선언, record의 선언(VO와 비슷함), table의 선언(배열과 비슷함),cursor선언(여러행 조회시)

begin
-- 코드 작성: 연산, 제어, query문(transaction을 개발자가 처리해주어야 한다.)

-- 예외처리
end;
/
```

2. compile (sqlplus에서 수행)
```
sql> @경로/파일명.sql;
```

3. 실행 sqlpluse에서 수행 (바인드 변수 선언 -> Procedure실행 -> 바인드 변수 출력)
```
//바인드 변수 선언(값과 변수가 따로 떨어져있으나 묶여서 같이 사용되는 변수)를 선언
sql> var 변수명 Datatype(크기)

//Procedure 실행
sql> exec | execute Procedure명(값(in parameter에 입력되는 값),,, :바인드변수명(out parameter에 전달되는 변수), :바인드변수명,,,)

//바인드 변수 출력
sql> print 바인드변수명 바인드변수명 바인드변수명 ,,,,
```

* 예제
```
//1. 프로시저 작성 (in 1개 out 2개)
Create or replace procedure age_proc(year in number, age out number, zodiac out varchar2) 
is
 
begin
    age := to_char(sysdate,'yyyy')-year+1;
    zodiac : ='소띠';
end;
/

//2. 저장 : c:/dev/test.spl

//3. 컴파일 : @c:/dev/test.sql

//4. out parameter값을 저장하기 위한 바인드 변수를 선언
sql> var age number
sql> var zodiac varchar2(200)

//5. 실행기를 사용하여 실행
sql> exec age_proc(2021, :age, :zodiac)

//6. 바인드 변수의 값을 출력한다.
sql> print age,zodiac;
```

# CallableStatement

* DBMS에서 제작된 Procedure를 호출하기위해 만들어진 객체

* PreparedStatement의 하위 interface. (bind변수를 사용한다.)

* java에서 발생한 값을 oracle에 던지고 oracle에서 값을 처리하여 다시 java로 가져온다


## CallableStatement 사용순서

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

3. query문 실행 객체 얻기
```java
String callProcedure="{call Procedure명(바인드변수,,,,,,)}";
CallableStatement cstmt = con.prepareCall(query문);
```

4. 바인드 변수에 값 설정.
```java
//in parameter : Procedure안에 값을 넣는 것.
cstmt.set데이터타입(index, 값);
//ex
cstmt.setint(index, 값);
cstmt.setString(index,값);

//out parameter : Procedure가 처리한 결과를 받는 것. (out parameter 등록)
cstmt.registerOutParameter(index, java.sql.Types.상수);
//상수는 특정 DB에 귀속되는 데이터형을 제공하지 않는다, API java.sql.types참조
//상위 개념을 제공한다. (number -> NUMERIC, varchar2 -> VARCHAR,,,)
```

5. query를 실행 (Procedure를 실행 / 부모의 method execute를 사용) -> out parameter에 값이 저장
```java
cstmt.execute();
```

6. out parameter의 저장된 값받기

    * **위의 registerOutParameter에 index와 동일한 index를 사용하여 값을 받게 된다.**
```java
cstmt.get데이터형(index);
//ex
int temp = cstmt.getint(index);
```