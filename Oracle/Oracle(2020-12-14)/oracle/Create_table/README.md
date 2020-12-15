테이블 생성
===

* DDL의 CREATE를 사용하여 작성한다.

* 생성된 table은 DBF(TABLE SPACE에 들어간다.)

* 계정 내에 Table명은 유일하다.

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

* ex)
    
    ```
    age NUMBER(3) // 0~999
    height NUMBER(4,1) //0~999.9 총 4자리 중 정수 3자리 실수 1자리
    name CHAR(10) //영문자로 10자를 넣을 수 있다.
    name VARCHRT2(10) //영문자로 10자를 넣을 수 있다. 10자보다 적은 값이 들어오면 저장공간은 줄어든다.
    ```

---

## Table의 구조알기

* 테이블이 어떠한 column을 가지고 있으며 column값의 속성값의 Datatype,정보를 알 수 있다.

    ```
    DESC "Table명"
    ```
---

## 주석 (Comment)

* 한 줄 주석은 -- (--뒤에만 주석이 되는 것이 아니라 --앞 내용도 주석이 된다.) 

    * 되도록 한 줄 주석은 주석으로 표시되어야 할 내용만 그 줄에 표기한다.

* 여러줄 주석은 /* 주석내용 */

    ```
    -- 한줄 주석의 내용.
    한줄 주석 내용 --

    /*
    여러줄 주석
    */
    ```

---

## EDIT

* SQLplus에서 제공하는 편집기이다.

* 사용하는 sql문을 저장하기위해 주로 사용되며 지정된 경로에 파일을 생성한다.

* 사용예제

    * EDIT로 SQL작성

        <img src = https://user-images.githubusercontent.com/74294325/102155332-b5d0cb00-3ebe-11eb-8698-7249a32ab08a.png>


    * 결과

        <img src = https://user-images.githubusercontent.com/74294325/102155378-ce40e580-3ebe-11eb-87c2-6abc03007653.png>

---


## 테이블 만들기 예제

* ex)

    <img src = https://user-images.githubusercontent.com/74294325/102157680-41e4f180-3ec3-11eb-8d08-00d1acf7591c.png>