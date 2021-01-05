# Procedure를 사용한 조회



## 한행 조회

* PL/SQL 에서는 query문을 사용할 수 있는데, **SELECT은 INTO절이 사용되며 한 행만 조회 가능.**

* INTO절을 사용하여 조회한다.

* 문법
    ```
    SELECT column명,,,
    INTO 변수명,,,,
    FROM 테이블명
    WHERE 조건
    ```

    * INTO절의 사용은 조회 column의 값을 변수에 저장하기 위한 부분이다.<br>
    (**column명과 변수명의 갯수는 1:1 대응되어야 한다.**)

    * 한행이 아니면 예외가 발생한다.

## 여러행 조회 

* 조회결과가 0~n행이 조회된다.

* **cursor**를 사용하여 조회한다.

    * PL/SQL에서는 선언,열기,인출,닫기 의 생명주기를 가진 cursor를 사용하여 여러 행을 조회.
    * Procedure에서는 조회결과를 Procedure 내부에서 사용하는 것이 아닌 조회결과를 Procedure 외부에서(Java)에서 사용하게된다.<br>
    (커서의 제어권을 반환해야 한다. **SYS_REFCURSOR**를 사용하여 반환)

    * SYS_REFCURSOR를 SQL에서는 REFCURSOR를 사용하여 받고 Java에서는 ReseultSet을 사용하여 받는다.

### 사용법

1. out parameter로 cursor를 선언
```
CREATE OR REPLACE PROCEDURE Procedure명 (변수명 out SYS_REFCURSOR)
```

2. Procedure 안에서 Cursor를 열고 query를 실행
```
OPEN Cursor명 FOR 
SELECT,,,
FROM ,,,
WHERE ,,,
```

3. 사용
```
//sqlplus
//1.바인드 변수를 선언
var CUR REFCURSOR;
//2.Procedure 실행
EXECUTE Procedure명(:CUR);
//3.출력( 조회결과가 출력 )
PRINT CUR;

//java
// java.sql.Types에서 제공하는 REF_CURSOR를 사용하면 ERROR 발생.
// oracle.jdbc.OracleTypes에서 제공하는 CURSOR를 사용한다.

//1. query 실행 객체 얻기
CallableStatement cstmt = con.preparedCall("{CALL Procedure명(?)}");

//2. 바인드 변수에 값 할당.
cstmt.registerOutparameter(1.orcleType.CURSOR);

//3. query실행
cstmt.execute();

//4. out parameter에 설정된 값 받기. object은 전부 다 받을수 있지만 넣을 수는 없다.
ResultSet rs = (ResultSet)cstmt.getObject(index);

//5. 조회하기
rs.next()
```

