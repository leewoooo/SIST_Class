# ResultSetMetaData

* **DataDictionary를 사용하지 않고 조회하는 테이블의 column의 정보를 얻을 때** 사용. <br />
( 특정 DBMS에 귀속되지 않고 사용이 가능하다.)

* 사용법

    1. select query를 실행한 Resultset에서 ResultSetMetaData를 얻는다.
    ```java
    ResultSetMetaData rsmd = rs.getMetaData();
    ```

    2. method 사용
    ```java
    //column의 갯수
    int count = rsmd.getColumnCount();

    //column의 명 (index의 시작은 1번부터 0번은 ROWNUM이 가져간다.)
    String columnName = rsmd.getColumnName(index);

    //column의 데이터형
    String columnTypeName = rsmd.getColumnTypeName(index);

    //column의 크기
    int columnPrecision = rsmd.getPrecision(index);
    
    //null 허용 여부
    int flag = isNullable(index); //0이면 Notnull이고 1이면 Null이다.
    ```


    



