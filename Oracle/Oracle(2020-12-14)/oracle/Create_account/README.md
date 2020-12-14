Oracle
===

## SQLPlus 사용법

- Oracle에서 제공하는 Oracle Client

- Server Process접속, SQL문 작성 실행, 서버가 경과를 받아서 출력하는 일을 한다.

- 대,소문자 구분은 없지만 모두 대문자로 저장이 된다.

    - 컬럼명, 테이블명, 쿼리문, 데이터형이 이에 속한다.

    - 도메인의 값은 대,소문자가 구분된다.

- oracle 11g와 11g 이후 버전의 계정 차이

    - 11g - scott
    - 11g 이후 버전 - ##scott

    - 11g 버전으로 사용하는 방법 (ORACLE SCRIPT의 사용)
        ```
        // 계정명 앞에 특수문자가 붙지 않는 계정을 사용.
        ALTER session set "_ORACLE_SCRIPT"=ture;
        ```

---

## 접속

* 접속

    ```
    //관리자 계정
    sqlplus "/as sysdba"

    //사용자 접속
    //방법 1
    sqlplus "ID/PassWord"

    //방법 2
    sqlplus (enter)
    Id 입력 (enter)
    PassWord (enter)
    ```

---

## 계정 생성 방법 

* 생성 (관리자로 접속해야 가능합니다.)

    ```
    //생성된 계정에는 권한이 아무것도 없다.(접속 및 Table생성 불가)
    CREATE USER "계정명" IDENTIFIED BY "비밀번호";

    //ex 
    CREATE USER scott IDENTIFIED BY tiger;
    ```

---

## 계정에 권한 부여 

* 권한 부여 (GRANT) / 관리자로 접속해야 가능합니다.

    ```
    GRANT "권한,,,," TO "계정명"

    //ex
    GRANT CONNECT,RESOURCE TO scott;
    ```

     - 권한의 종류
        - CONNECT : 접속권한.
        - RESOURCE : 자원사용권한.


* `tablespace 사용권한 (table을 생성할 수 있다.)`

    ```
    ALTER USER "계정명" DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

    //ex
    ALTER USER scott DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
    ```

---

## 현재 접속 된 user를 확인하기

* 유저확인

    ```
    SHOW USER
    ```

---