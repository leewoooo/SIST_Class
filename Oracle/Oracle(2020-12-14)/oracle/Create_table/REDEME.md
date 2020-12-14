테이블 생성
===

* DDL의 CREATE를 사용하여 작성한다.

* 생성된 table은 DBF(TABLE SPACE에 들어간다.)

* 문법

    ```
    CREATE TABLE "테이블명" (
        "column명" Datatype(크기) constraint "제약사항명 제약사항"
        "column명" Datatype(크기) constraint "제약사항명 제약사항"
        ,
        ,
        constraint "제약사항명 제약사항종류(적용 column명)
        ,
        ,
    );
    ```

---

## DataType (Oracle에서 지원하는 Data type)

* datatype

    값 종류 | datatype명 | 크기 | 사용법
    :--- | :-- | :--- | :--- 
    숫자(정수) | NUMBER | 숫자 22개 | column명 number(크기)
    숫자(실수) | NUMBER | 숫자 22개 | column명 number(전체크기, 실수크기)
    문자열(고정길이형) | CHAR  | 2000byte의 문자 (영문자로 2000자) | column명 CHAR(크기) , 데이터형의 길이가 같을 때
    문자열(가변길이형) | VARCHAR2 | 4000byte의 문자 (영문자로 4000자) | column명 VARCHAR2(크기) , 데이터형의 길이가 가변일 때
    날짜 | DATE | 크기설정 x | column명 DATE , 현재 날짜를 추가할 때에는 SYSDATE
    긴 숫자 | LONG | 2GB의 숫자를 저장 | column명 LONG , 입력되는 숫자까지 저장된다.
    긴 문자열 | CLOB | 4GB의 문자열을 저장 | column명 CLOB, 입력되는 문자열을 저장한다.
    파일 | BLOB | 4GB의 파일을 저장 | column명 BLOB
    
    <BR>

    * 고정길이형 : 최초 설정한 크기를 유지하는 데이터 형. 
        
        * 검색속도가 빠르다. (검색의 key로 사용한다. 기본키(primary key)로 설정하여 사용하게된다.)
        * 값이 설정한 크기보다 적게 입력되더라도 최초 설정된 크기를 유지하기에 저장공간의 낭비로 이어질 수 있다.


    * 가변길이형 : 최초 설정한 크기를 유지하지 않는 데이터 형.

        * 검색속도가 느리다.
        * 값이 설정한 크기보다 적게 입력되면 저장공간의 크기가 줄어든다. (저장공간의 낭비는 일어나지 않는다.)
        * 값이 설정한 크기보다 적게 입력되면 저장공간의 크기는 줄어들지만 큰 값이 들어오면 error 

* ex
    
    ```
    age NUMBER(3) // 0~999
    height NUMBER(4,1) //0~999.9 총 4자리 중 정수 3자리 실수 1자리
    name CHAR(10) //영문자로 10자를 넣을 수 있다.
    name VARCHRT2(10) //영문자로 10자를 넣을 수 있다. 10자보다 적은 값이 들어오면 저장공간은 줄어든다.
    ```

---

## Table의 구조알기

    ```
    desc "Table명"
    ```