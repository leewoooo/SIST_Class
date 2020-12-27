DDL 
===

## CREATE

* DDL의 CREATE를 사용하여 작성한다.

* 생성된 table은 DBF(TABLE SPACE에 들어간다.)

* 계정 내에 Table명은 유일하다.

* 문법

    ```java
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

### DataType (Oracle에서 지원하는 Data type)

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


```java
* 가변길이형 : 최초 설정한 크기를 유지하지 않는 데이터 형.

    * 검색속도가 느리다.
    * 값이 설정한 크기보다 적게 입력되면 저장공간의 크기가 줄어든다. (저장공간의 낭비는 일어나지 않는다.)
    * 값이 설정한 크기보다 적게 입력되면 저장공간의 크기는 줄어들지만 큰 값이 들어오면 error 
```

* ex)
  
    ```java
    age NUMBER(3) // 0~999
    height NUMBER(4,1) //0~999.9 총 4자리 중 정수 3자리 실수 1자리
    name CHAR(10) //영문자로 10자를 넣을 수 있다.
    name VARCHRT2(10) //영문자로 10자를 넣을 수 있다. 10자보다 적은 값이 들어오면 저장공간은 줄어든다.
    ```

<br>    

### DATATYPE 추가내용(2020-12-27)

* NCHAR(크기) : CHAR와 기능은 같고 다국어 입력할 때 주로 사용 , 가변 길이를 갖는 아스키코드 문자 데이터형

* NVARCHAR2(크기) : 가변 길이를 갖는 유니코드 문자 데이터형
```
UTF-8 에서는 영어 이외 각국의 언어는 1글자에 3byte씩 사용한다.
NCHAR은 UTF16을 사용하기 때문에 각국의 언어 1글자에 2byte를 사용한다.
속성값의 byte크기를 알고싶으면 LENGTHB()함수를 사용한다.
```
```
char/varchar 와 nchar/nvarchar 비교
한글(유니코드)은 2바이트의 자리를 차지하기 때문에
char/varchar 형식으로 정의할 경우에는 2배의 자릿수를 준비해야한다.
최대 3글자의 한글을 저장하고자 한다면 char(6) /varchar(6)로 데이터 형식을 지정해야한다.
반면, nchar(3)/nvarchar(3)으로 지정하면 한글이든 영문이든 무조건 3글자를  저장할수 있어서
더 단순하고 명료하게 문자 데이터를 입력할 수 있다.
```

### Table의 구조알기

* 테이블이 어떠한 column을 가지고 있으며 column값의 속성값의 Datatype,정보를 알 수 있다.

    ```
    DESC "Table명"
    ```


### 테이블 만들기 예제

* ex)

    <img src = https://user-images.githubusercontent.com/74294325/102157680-41e4f180-3ec3-11eb-8d08-00d1acf7591c.png>


---

## DROP

* DBMS의 객체(TABLE, SEQUENCE, INDEX, FUNCTION,,,)를 삭제할 때 사용.

* 문법

    ```java
    DROP 대상 대상명;
    
    //테이블을 지울때
    DROP TABLE 테이블명; //ORACLE 11g 이후 부터 삭제된 테이블은 휴지통으로 이동
    
    //휴지통 OPTION
    
        //휴지통 보기 (SQLplus에서 지원하는 문법)
        SHOW RECYCLEBIN; // 삭제 전 이름, 휴지통으로 이동된 이름의 정보가 보여진다.
    
        //휴지통 비우기
        PURGE RECYCLEBIN;
    
        //복구하기 (같은 이름의 테이블이 생성되어 있다면 복구할 수 없다.)
        FLASHBACK TABLE 테이블명 TO BEFORE DROP;
    ```

* 예제

    * ex)

        <img src = https://user-images.githubusercontent.com/74294325/102185147-f139bc80-3ef3-11eb-969b-0b56bca2dbc2.png>



## ALTER

* 테이블의 조작, 계정처리, 제약사항을 처리할 수 있다.

---

### 테이블의 조작

* column의 Datatype을 변경 ( 레코드가 존재하지 않으면 Datatype까지 변경 가능, 레코드가 존재하면 Datatype는 바꾸지 못하고 크기만 변경이 가능하다.)

```java
ALTER TABLE 테이블 명 MODIFY column명 Datatype(크기) column단위 제약사항을 추가할 수 있다.
```

* column의 추가 (추가되는 column은 `제일 마지막에만 추가 가능하다.`)

```java
ALTER TABLE 테이블 명 ADD column명 Datatype(크기) column단위 제약사항을 추가할 수 있다.
```

* column의 삭제 (column의 값들과 제약사항이 전부 지워진다.)

```java
ALTER TABLE 테이블 명 DROP COLUMN column명
```

* column명 변경

```java
ALTER TABLE 테이블 명 RENAME COLUMN 이전 column명 TO 바꿀 column명
```



### 제약사항 설정

* 제약사항 추가 (테이블 단위 제약사항의 문법을 사용하여 처리)

```java
ALTER TABLE 테이블명 ADD CONSTRAINT 제약사항명 제약사항(적용 column명);
```

* 제약사항 삭제 

```java
ALTER TABLE 테이블명 DROP CONSTRAINT 제약사항명;
```

* 제약사항 활성화(비 활성화)

```java
//비 활성화 후 활성화는 column의 값이 제약사항에 위배되는 값이 없어야만 가능하다.
ALTER TABLE 테이블명 ENABLE CONSTRAINT 제약사항명 //활성화
ALTER TABLE 테이블명 DISABLE CONSTRAINT 제약사항명 //비활성화
```



### 계정 관리

* 관리자 계정에서만 가능하다.
* 계정 생성 ( 생성된 계정은 접속 및 DBMS의 서비스를 사용할 수 없다.)
  * Oracle 12c 부터는 계정명 앞에 c##형태로 시작해야한다.

```java
//c##형식의 계정을 사용하지 않으려면 "_ORACLE_SCRIPT"를 활성화
ALTER SESSION SET "_ORACLE_SCRIPT"=true;
//계정 생성
CREATE USER 계정 명 IDENTIFIED BY 비밀번호; //생성된 계정은 아무 권한을 가지고 있지 않기에 로그인 불가.
```

* 계정에 권한 부여 (GRANT : DCL)
  * Oracle 12c부터는 resource 권한 이후에 tablespace 사용권한을 ALTER로 변경해야 한다.

```java
//CONNECT - 접속 권한
//RESOURCE - DBMS를 사용할 수 있는 권한
//DBA - 관리자 권한
//CREATE VIEW - VIEW 생성 권한 ,,,,등 여러가지가 있다

GRANT 권한,,,,,TO 계정;

//tablespqce
ALTER USER 계정명 DEFAULT TABLESPACE TABLESPACE명 QUOTA UNLIMTED ON TABLESPACE명
```

* 계정에 부여한 권한 회수(REVOKE : DCL)
  * 관리자 계정에서만 가능하다.
  * 12c 부터는 계정을 삭제하려면 "_ORACLE_SCRIPT"를 사용해야한다.

```java
REVOKE 권한,,,,,FROM 계정;
```

* 계정의 비밀번호 변경
  * 비밀번호를 변경하면 계정 파기 시간이 늘어난다.
  * 관리자 계정의 다른 계정의 비밀번호를 변경할 수 있다.

```java
ALTER USER 계정명 INDETIFIED BY 비밀번호; //관리자가 아니어도 모든 계정이 비밀번호 변경 가능
```

* 계정의 활성화 (비 활성화)
  * 계정 풀기 | 계정 잠구기

```java
ALTER USER 계정명 ACCOUNT LOCK //잠금
ALTER USER 계정명 ACCOUNT UNLOCK //풀기
```

* 계정 삭제
  * 계정 정보는 DBA_USERS에서 확인이 가능하다.
  * 접속중인 계정은 삭제할 수 없다. 접속이 종료된 계정만 삭제 가능
  * 12c 부터는 계정을 삭제하려면 "_ORACLE_SCRIPT"를 사용해야한다.
  * 계정이 생성한 Oracle Object이 있다면 CASCADE 옵션을 사용하여 삭제(Object이 있으면 CASCADE옵션 없이 삭제 불가능)

```java
ALTER SESSION SET "_ORACLE_SCRIPT"=true;
DROP USER 계정명 CASCADE;
```

