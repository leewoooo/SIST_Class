# DATABASE


## SQL의 구분

1. DDL ( CREAT, ALTER, DROP )

2. DML ( INSERT, SELECT, UPDATE, DELETE )

3. DCL ( GRANT, REVOKE )

---

## DDL

<br>

### 테이블 정의하기(CREATE)

* 데이터 구조를 정의하기 : 개념상의 데이터 정의하기 (ENTITY 정의하기)

* Oracle의 예약어와 정의하고자 하는 테이블명 혹은 column명과 겹칠 경우 " "를 사용하여 정의 할 수 있다.<br> " " 안에 있는 문자는 소,대문자 구분이 가능하며 공백 또한 허용한다.

```java
//ex
CREATE TABLE MEMBER(
ID VARCHAR2(50),
PWD VARCHAR(50),
NAME VARCHAR(50),
GENDER VARCHAR2(50),
AGE NUMBER,
BIRTHDAY VARCHAR2(50),
PHONE VARCHAR2(50),
REGDATE DATE
);
```
<br>

---

## DATATYPE (자료형)

* Oracle에서 자료형의 범주는 문자,숫자,날짜,큰 DATA로 나뉘어진다.

<br>

### 표현방식

```Java
//문자
//' '를 사용하여 문자를 사용하며 소, 대문자를 구분한다.
'leewoo'
'A'
'148'

//숫자
25
26
3.85F

//날짜
//DATE
'2020-12-27'
//TIMESTEMP
'2020-12-27 21.27.29.00000'
```

<br>

## 문자


1. CHAR(크기 | char) : 고정길이 문자일 때 사용한다 (데이터가 입력되었을 때 공간을 다 사용하지 않아도 공간이 할당되어 있다.), 고정 길이를 갖는 아스키코드 문자 데이터형 

2. VARCHAR2(크기 | char) : 가변길이 문자일 때 사용한다. (데이터가 입력되었을 때 사용하지 않는 공간을 반납한다.) ,고정 길이를 갖는 유니코드 문자 데이터형

    * 구분자로 사용하기 때문에 고정길이 문자열에 비해 검색 속도가 느리다.

3. NCHAR(크기) : CHAR와 기능은 같고 다국어 입력할 때 주로 사용 , 가변 길이를 갖는 아스키코드 문자 데이터형

4. NVARCHAR2(크기) : 가변 길이를 갖는 유니코드 문자 데이터형

5. CLOB : 대용량 텍스트 데이터 타입(최대 4GB)

6. NCLOB : 대용량 텍스트 유니코드 데이터 타입(최대 4GB)

<br>


* UTF-8 에서는 영어 이외 각국의 언어는 1글자에 3byte씩 사용한다.
* NCHAR은 UTF16을 사용하기 때문에 각국의 언어 1글자에 2byte를 사용한다.
* 속성값의 byte크기를 알고싶으면 LENGTHB()함수를 사용한다.

        char/varchar 와 nchar/nvarchar 비교

        한글(유니코드)은 2바이트의 자리를 차지하기 때문에

        char/varchar 형식으로 정의할 경우에는 2배의 자릿수를 준비해야한다.

        최대 3글자의 한글을 저장하고자 한다면 char(6) /varchar(6)로 데이터 형식을 지정해야한다.

        반면, nchar(3)/nvarchar(3)으로 지정하면 한글이든 영문이든 무조건 3글자를  저장할수 있어서

        더 단순하고 명료하게 문자 데이터를 입력할 수 있다.

<br>        

## 숫자

* 정수와 실수의 표현방법
```java
NUMBER(4) //최대 4자로 이루어진 숫자
NUMBER(6,2) //소수점 2자리를 포함하는 최대 6자리의 숫자(소수 둘째 자리에서 반올림)
NUMBER(6,-2) //소수점-2자리에서 반올림하는 최대 6자리 숫자
NUMBER //MAX값인 38자리
```
<br>

## 날짜

* 종류

    1. DATE : 년 월 일 까지 표기

    2. TIMESTAMP : 년 월 일 시 분 초 까지 표기

* query를 통해 얻어내면 지역정보에 맞춰 문자로 조회된다.
---

<br>


## 테이블 수정하기 (ALTER)

* 수정하기 전 데이터가 입력되어 있다면 확인 후 수정해야 한다.

    * **이미 입력된 데이터가 수정사항에 적용되지 않을 경우 수정 불가**

* 추가된 column은 가장 밑에 추가된다.

```
//현재 테이블 
CREATE TABLE MEMBER(
ID VARCHAR2(50), 
PWD VARCHAR(50),
NAME NVARCHAR2(50),
GENDER NCHAR(2), --남성,여성
AGE NUMBER(3),
BIRTHDAY CHAR(10), --1996-11-27
PHONE CHAR(13), --010-1234-5678 
REGDATE DATE
);

//자료형 수정하기
//ALTER TABLE 테이블명 MODIFY column명 자료형(크기);
ALTER TABLE MEMBER MODIFY ID NVARCHAR2(50);

//속성 지우기
//ALER TABLE 테이블명 DROP COLUMN column명;
ALTER TABLE MEMBER DROP COLUMN AGE;

//속성 추가하기
//ALTER TABLE 테이블명 ADD column명 자료형(크기);
ALTER TABLE MEMBER ADD  EMAIL VARCHAR2(200);
```
---

<br>

## DML


### INSERT

* INSERT 명령의 규칙
    ```
    INSERT INTO 테이블 명 (column명,,,,) VALUES (값,,,)
    ```

    * 모든 column의 값을 입력 할 때는 INSERT문에 column 명은 생략한 후 column차례대로 값 입력

    * 선택적으로 값을 입력했을 경우 입력되지 않은 경우 null값이 들어간다.<br>
    (null은 값이 없는 것이 아닌 사용하지 못하는 값이 들어있다.)    

<br>

## UPDATE

* UPDATE 명령의 규칙

    ```
    UPDATE 테이블 명 SET column명 = 변경할 값,,, WHERE 조건;
    ```

    * UPDATE문에 조건(WHERE 절)을 사용하지 않으면 모든 속성 값이 변경된다.

    * 여러 column의 값을 변경 가능하다.

<br>

## DELETE

* DELETE 명령의 규칙

    ```
    DELETE FROM 테이블명 WHERE 조건;
    ```

    * DELETE문에 조건(WHERE 절)을 사용하지 않으면 모든 속성 값이 삭제된다.

---

<br>

## 트랜잭션 (COMMIT , ROLLBACK)

<br>

* 트랜잭션이란? 

    * 업무적인 단위

    * 물리적인 명령어 단위 

    EX)계좌이체라는 업무적인 단위는 보내는사람 UPDATE,받는사람 UPDATE 라는 물리적인 명령어 단위로 이루어 져 있다.

* 작업방식

    1. 현재 세션을 위한 임시저장소에서 test  (임시 테이블 스페이스에서 작업)
    2. 세션을 처리하는 동안 끼어들지 못하게 LOCK와 UNLOCK 처리가 된다. 
    3. test가 정상적이면 commit, 아니라면 전부 다 ROLLBACK. 

* 작업이 정상적으로 완료 후 commit를 하게되면 모든 사용자 session에서 변경내용을 확인 할 수 있다.<br>
(임시 테이블 스페이스에서 작업되었던 것을 적용)

---

## 연산자를 이용한 조회

<br>

* **주로 column을 조회할 때 연산자를 사용하면 Alias를 이용하여 column의 별칭을 준다.**

* 산술연산자 (+ , - , * , /)

    * 산술연산자는 숫자만 연산해주는 연산자이다. 숫자형식의 문자에 사용을 하면 문자를 숫자로 변환하여 연산한다.

    * 문자더하기연산자 (||)

        * java에서 문자열에 +를 하면 덧붙임의 역할을 하듯이 oracle에서도 문자에 ||를 사용하면 덧붙임이 가능하다.

* 비교연산자 (=, !=, <>, >, <, >=, <=, IS NULL, IS NOT NULL)

    * WHERE절에서 조건을 줄 때 사용한다.

    * IS NULL, IS NOT NULL은 다른 비교연산자와 같이 사용되지 않고 WHERE절에서 column명 뒤에 바로 사용된다.

* 관계연산자 (AND, OR, BETWEEN, IN, NOT IN)

    * 두 개 이상의 조건을 사용하고 두 개 이상의 조건에 관계를 부여하기 위해 사용

    * 연속되어 있는 범위로 조건을 줄 때에는 AND 조건으로 범위를 지정해주거나 BETWEEN을 사용하여 조건 부여

        * AND는 자기자신을 포함하지않을 때, BETWEEN은 자기자신을 포함할 경우

    * 연속되지 않는 값들로 조건을 줄 때에는 OR , IN, NOT IN을 사용하여 조건을 부여한다.

        * IN, NOT IN 연산자는 "WHERE column명 IN | NOT IN (값,,,,,,);"

* 패턴 비교 연산자. (LIKE, %, _)

    * %는 글자 수와 관계 없이 사용한다.

    * _는 글자 수를 지정하여 사용한다.

    * % , _ 는 LIKE와 같이 사용되며 LIKE 앞에 NOT을 사용할 수 있다.

    * ex)

        ```java
        //ex
        WHERE column명 LIKE '%apple%` //column값 중 apple를 포함한 모든 값들을 조회 //주로 제목등을 조회할 때 사용
        WHERE column명 LIKE '_apple_' //column값 중 apple 앞 뒤로 한 글자가 있는 column의 값을 조회
        ```

* 정규식을 이용한 패턴 연산.

    * % , _ 를 사용하는 것보다 조금 더 정밀하게 조회 할 수 있다.

    * 사용자가 패턴 문자를 만들 수 있다.

    * WHERE절에서 REGEXP_LIKE 함수를 사용한다.

        ```java
        //ex
        //전화번호를 포함한 column값을 조회(포함하는 게시글 제목이기에 시작기호(^), 끝기호($)를 사용하지 않는다.)
        SELECT * FROM 테이블명 WHERE REGEXP_LIKE(column명,'010-\d{3,4}-\d{4}');

        //ex
        //이메일을 포함한 column값을 조회(포함하는 게시글 제목이기에 시작기호(^), 끝기호($)를 사용하지 않는다.)
        SELECT * FROM 테이블명 WHERE REGEXP_LIKE(column명,'\D\w*@\D\w*.(org|net|com))
        ```

    * [참조 홈페이지 Reqular Expression Libary](www.regexlib.com)

---

## ROWNUM & 행 제한하기

* 행을 제한하는 것은 페이징 개념을 이용할 수 있다.

* ROWNUM은 Inline View가 만들어 질때 같이 만들어진다. 따라서 ROWNUM을 조건으로 사용할 때 1부터는 가능하지만 2이상부터는 불가능하다.

    * 따라서 미리 만들어진 ROWNUM을 포함한 Inline View를 조회 한 후 이것을 subquery로 다시 select문에 넣어 조회하면 사용이 가능하다.

    ```java
    //subquery안에서 사용된 ROWNUM은 Alias를 사용해야 외부 query에서 사용가능하다.
    SELECT * FROM (SELECT ROWNUM NUM, 테이블명.*) WHERE NUM BETWEEN a AND b;
    ``` 

---

## 중복 값 제거 DISTINCT

* 조회되는 COLUMN의 값중에 중복되는 COLUMN의 값을 제거 후 한 개만 조회가 된다.

* 다른 column과 함께 사용될 경우 중복제거가 되지 않는다.

    ```java
    SELECT DISTINCT column명 FROM 테이블 명
    ``` 

---

## 문자열 함수

* 문자열 추출 함수 
    
    * SUBSTR(문자열, 시작위치 , 길이)
    * SUBSTRB(문자열, 시작위치 , 길이) //byte단위로 추출할 때 사용한다.

* 문자열 덧셈 함수 

    * CONCAT(더할 문자열1.더할문자열2) : 결과로는 문자열1문자열2

    * 성능면에서는 함수보다는 연산자인 ||를 더 자주 사용한다.

* 문자열 트림함수

    * LTRIM(문자열) : 문자열 앞에 있는 공백 제거
    * RTRIM(문자열) : 문자열 뒤에 있는 공백 제거
    * TRIM(문자열)  : 문자열 앞, 뒤에 있는 공백 제거

* 대문자, 소문자 (조회할 때 대,소문자를 가리지 않고 조회해야하는 경우)

    * UPPER(문자열) : 문자열을 모두 대문자로 변환
    * LOWER(문자열) : 문자열을 모두 소문자로 변환

    * 조회할 때는 조회하는 column, 비교하는 조건에 둘다 사용

* 문자열 대치 함수

    * REPLACE(문자열, 바꿔야하는 문자열, 바꿀 문자열)
    * TRANSLATE(문자열, 바꿔야할 문자열, 바꿀 문자열) <br>
    (특수하게 바꾸야할 문자열이 WE 바꿀 문자열이 YO 라면 W는 모두 Y로 E는 모두O로 변경)

* 문자열 패딩 함수

    * LPAD(문자열,지정 글자수, 지정한 글자수가 되지 않을 경우 채워질 문자) : 지정한 글자수가 되지 않을 경우 왼쪽에 채움

    * RPAD(문자열,지정 글자수, 지정한 글자수가 되지 않을 경우 채워질 문자) : 지정한 글자수가 되지 않을 경우 오른쪽에 채움

* 문자열 검색 함수

    * INSTR(문자열, 찾을 문자열, 찾기 시작할 INDEX, 동일한 문자열이 있을 때 찾을 순번) : 찾을 문자열의 가장 처음문자의 INDEX를 반환

* 문자열의 길이를 얻는 함수

    * LENGTH(문자열) : 문자열의 길이를 반환한다.

* 코드값을 반환하는 함수

    * ASCII('A')

    * CHAR(65)

---

## 숫자 함수

* 절대값을 구하는 함수

    * ABS(n) : 절대값을 구해준다.

* 음수, 양수를 알려주는 함수

    * SIGN(n) : 음수인지 양수인지 알려준다. (음수 = -1, 양수 = 0, 0 = 0)

* 반올림 값을 알려주는 함수

    * ROUND(n,i) : 입력된 숫자를 소수점 i번째 자리까지 표현. (i-1번째 에서 반올림)

* 나머지 값을 반환하는 함수

    * MOD(n1, n2) : n1을 n2로 나눈 나머지 값이 조회

* 숫자의 제곱을 구하는 함수와 제곱근을 구하는 함수

    * POWER(n1,n2) : n1의 n2 승을 조회
    * SQRT (n) : n의 제곱근을 조회

---

## 날짜 함수

* 현재 시간을 얻는 함수

    * SYSDATE : 현재 시간을 얻는다. (년, 월 , 일 , 시 , 분 , 초)
    * CURRENT_DATE : SESSION설정에 따른 시간
    * SYSTIMESTAMP : 현재 시간을 얻는다 (년, 월, 일, 시 , 분 , 초 , 밀리sec)

* 날짜 추출 함수 (사용 ex) 1,2,3 월에 가입한 회원을 조회하세요.) 

    * EXTRACT(YEAR FROM 날짜) : 날짜에서 년을 추출
    * EXTRACT(MOUTH FROM 날짜) : 날짜에서 월을 추출
    * EXTRACT(DAY FROM 날짜) : 날짜에서 일을 추출
    * EXTRACT(MINUTE FROM 날짜) : 날짜에서 분을 추출
    * EXTRACT(SECOND FROM 날짜) : 날짜에서 초를 추출

* 날짜를 누적하는 함수 (사용 ex) 가입한 회원중에 가입한지 6개월이 안되는 회원을 조회하세요.)

    * ADD_MONTH(날짜, n) : 입력된 날짜에서 n개월 수를 더하거나 뺀다.
    ```java
    //ex
    SELECT * FROM 테이블명 WHERE ADD_MONTH(SYSDATE,-6) < 비교하고자 하는 날짜.
    ```
* 날짜의 차이를 알아내는 함수 (사용 ex) 가입한 회원중에 가입한지 6개월이 안되는 회원을 조회하세요.)

    * MONTHS_BETWEEN(날짜, 날짜)
    ```java
    //ex
    SELECT * FROM 테이블명 WHERE MONTHS_BETWEEN(SYSDATE,비교하고자 하는 날짜) < 6
    ```

* 다음 요일을 알려주는 함수

    * NEXT_DAY(현재날짜, 다음요일);
    ```java
    //ex
    SELECT NEXT_DAY(SYSDATE,'토요일' | '토' | 7) FROM DUAL // 돌아오는 토요일은 몇일인가?
    ```

* 월의 마지막 날을 알려주는 함수

    * LAST_DAY(현재 날짜);

---

## 변환함수

* 숫자를 문자로 바꿀 때, 문자를 숫자로 바꿀 때

    * TO_CHAR(숫자,패턴) , TO_NUMBER(숫자형식의 문자)

        * **패턴의 길이가 입력된 숫자보다 작으면 안된다.**
        * 0 패턴: 지정한 패턴에 빈자리가 발생 할 시 0을 채움
        * 9 패턴: 빈자리를 채우지 않을 때 사용
        * $ : 앞에 $를 표시
        ```java
        To_CHAR(1234567,'000,000,000') //결과 = 001,234,567
        To_CHAR(1234567,'999,999,999') //결과 = 1,234,567
        TO_NUMBER('1234567') //결과 = 1234567
        ```

* 날짜를 문자로 바꿀 때 ,문자를 날짜로 바꿀 때

    * TO_CHAR(날짜,패턴) ,TO_TIMESTAMP(날짜형식의 문자열, 패턴), TO_DATE(날자형식의 문자열,패턴)

        * 년도 표시 (YYYY,RRRR,YY,YEAR) -> 4자리,Y2K,2자리,영문
        * 월 표시 (MM,MON,MONTH) -> 2자리,영문3자리,영문전체
        * 일 표시 (DD,DAY,DDTH) -> 2자리,영문,2자리ST
        * 오전 오후 (AM,PM)
        * 시간 (HH,HH24) -> 12시간 ,24시간
        * 분표시 (MI)
        * 초 (SS)
        ```java
        TO_CHAR(SYSDATE,'YYYY-MM-DD PM HH24:MI:SS')
        TO_DATE('2020-12-29','YYYY-MM-DD')
        ```

---

## NULL 관련 함수

* column의 값이 null일 경우 default값을 반환

    * NVL(column명, Default값) -> column의 값이 null일 경우 Default값이 나온다.

    * NVL2(column명,Null이 아닐 경우 반환되는 값,Default값) -> null이 아닐경우에 반환되는 값에는 연산도 가능

    * NULLIF(column명,기준값) -> column의 값이 기준값과 동일하다면 null이 조회

 
* column의 값이 비교값과 같을 경우 Default값을 출력

    * DECODE(column명,비교값,출력값,,,,Default값) -> 조회된 column의 값이 비교값과 같을 경우 출력값이 조회 모든 비교값과 같지 않다면 Default값 조회

---

## 집계함수

* 합계를 구하는 함수

    * SUB(column명)

* 갯수를 조회하는 함수 (NULL의 값은 갯수가 COUNT가 되지 않는다.)

    * COUNT(column명)

* 최대값을 조회, 최솟값을 조회하는 함수

    * MAX(column명)
    * MIN(column명)

* 평균값을 조회

    * AVG(column명)

---

## SELECT 구절

* SELECT구문에서 사용되는 OPTION

* SELECT의 순서

    * **SELECT-> FROM-> WHERE-> GROUP BY-> HAVING-> ORDER BY**

* 실행 순서

    * **FROM -> CONNECT BY -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY**

    * 별칭을 사용할 때에도 이 순서에 따라 이전에 정의되지 않은 이후 순서에 사용될 수 없다.

    * 집계함수는 GROUP BY에서 사용되는 것이므로 WHERE절에서는 사용 될 수 없다.(GROUP BY 이후에서는 사용 가능)

    * ROWNUM은 WHERE절에서 만들어진다.

### ORDER BY

* 정렬할 때 사용하며 OPTION은 ASC(오름차순), DESC(내림차순)이 있다.

    * 정렬의 기본값은 ASC입니다.

* SELECT문 제일 뒤에서 사용되며 ROWNUM과 같이 사용될 경우 순서가 맞지 않게 될 수도 있다.

    * ROWNUM이 생성 후 정렬이 진행되기 때문에 ROWNUM이 정렬되어 있지 않다.

* 정렬의 기준이 되는 column을 여러개 지정할 수 있다.

```java
SELECT TEST, TEMP FROM DUAL ORDER BY TEST ASC, TEMP DESC;
``` 

### GROUP BY, HAVING

* GROUP BY는 조회하는 결과를 그룹으로 묶을 때 사용한다.

* **GROUP BY를 사용했을 경우 SELECT 절에서는 그룹으로 지정한 column외에 다른 column이 올 수 없다.** 

* HAVING은 그룹으로 묶여 조회 될 때 조건을 부여한다.

---

## 순위 함수

* 정렬을 한 상태에서 번호를 붙이고 싶을 때

    * ROW_NUMBER()OVER(ORDER BY column명 ASC | DESC) 

* 정렬을 한 상태에서 등수를 붙이고 싶을 때

    * RANK()OVER(ORDER BY column명 ASC | DESC) -> 공동 등수가 조회된다. (1,2,2,4)
    * DENSE_RANK()OVER(ORDER BY column명 ASC | DESC) -> 공동 등수가 조회된 후에도 등수를 이어감 (1,2,2,3)

* GROUP별로 묶어서 번호, 등수를 만들고 싶을 때 

    * ROW_NUMBER()OVER(PARTITION BY 기준 column ORDER BY column명 ASC | DESC) 

    * 기준으로 정한 column은 ASC 정렬이 된다.

---

## 서브쿼리

* 구절의 순서를 변경할 때 사용된다. **먼저 실행되어 실행 결과로 이후 작업을 해야할 때 사용**

* query를 작성 할 때 먼저 서브쿼리를 실행해서 test를 해보고 그다음 전부를 실행하는 방향으로 작업한다.

* **서브쿼리가 사용되면 query문은 서브 query문이 먼저 실행되고 바깥 query문이 실행된다.**

```
//ex
SELECT test 
FROM (SELECT test FROM DUAL);

SELECT *
FROM MEMBER
WHERE AGE >= (SELECT AVG(AGE) FROM MEMBER);
```

---