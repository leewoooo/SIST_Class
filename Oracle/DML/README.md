DML (기본적인 사용법)
===

## INSERT

* 테이블에 레코드르 삽입할 때 사용한다.

* 기존에 레코드 사이에 값이 들어간다,(순차적으로 입력되지 않는다.)

* 값의 종류에 따라 작성하는 방법

    값의 종류 | 기입방법
    :----|:---
    숫자 | 12 15 11.14 (숫자 그대로 입력)
    문자열 | '입력할 값' (고정길이형,가변길이형 동일)
    현재날짜 | SYSDATE(날짜-년,월,일,시,분,초가 추가된다.)
    다른날짜 | 문자열을 날짜형식으로 작성 추가. ex) '2020-12-16' or to_date()함수 사용.

## 문법

* column을 생략하여 사용.( `입력되는 값은 반드시 Table의 column의 순서대로 입력.` )

    ```
    INSERT INTO TABLE명
    VALUES (값,,,,,,);
    ```

    * ex)

        <img src = https://user-images.githubusercontent.com/74294325/102161776-457c7680-3ecb-11eb-9046-99bc2cb5258c.png>


* `column을 명시하여 사용.` (이 방법을 지향한다.)

    ```
    INSERT INTO TABLE명
    (columm명1,columm명2,,,,,,,)
    VALUES
    (값,값,,,,,,,)
    ```

    * column의 명은 꼭 CREATE할 때 입력한 순서대로 입력하지 않아도 가능하다.
    * 명시되지 않는 column에는 null이 들어간다.
    * Oracle에서 null은 숫자도 문자열도 아닌 사용할 수 없는 값이 들어간다.

    * ex)

        <img src = https://user-images.githubusercontent.com/74294325/102161805-562cec80-3ecb-11eb-94bb-2cb1f9b3fcca.png>

---

## SELECT

* 모든 레코드의 원하는 column을 조회할 때 사용.

* SELECT, FROM은 필수로 입력해야 한다.

* 나머지 option들을 사용하면 조건에 맞는 레코드만 조회가 된다.

* SELECT 조회 column에 * 을 사용하면 모든 column을 조회한다.

## 문법

* 기존 SELECT 문법

    ```
    SELECT column 명 //column 연산자, 함수명(column명)
    FROM TABLE명
    WHERE 원하는 column을 찾기 위한 조건문
    GROUP BY //그룹으로 묶어 레코드만 조회 ( 그룹으로 묶일 column명 )
    HAVING // 그룹으로 묶일 조건을 부여 
    ORDER BY // 정렬 (ASC-오름차순, DESC-내림차순)
    ```

* 예제

    * ex1)
        
        <img src = https://user-images.githubusercontent.com/74294325/102173784-37d0ec00-3edf-11eb-913a-486524b11323.png>

    * ex2)

        <img src = https://user-images.githubusercontent.com/74294325/102173811-48816200-3edf-11eb-8052-750fb0ba592d.png>

    


---

## UPDATE

* 조건(WHERE)에 맞는 column의 값을 변경할 때 사용한다.

* Transaction의 대상 query이다.

* WHERE절을 사용하지 않으면 모든 레코드값이 변경된다.

    * `UPDATE를 사용할 때 조건을 더 자세하게 부여함으로 원하는 값만 바꾸도록 사용해야 한다.`

* 문법

    ```
    UPDATE Table명
    SET 값을 변경할 column명 = '변경할 값' ,,,,,
    WHERE '원하는 column을 찾기 위한 조건문'
    ```

* 예제

    * Update 전 table
        <img src = https://user-images.githubusercontent.com/74294325/102174938-d8c0a680-3ee1-11eb-913e-f090b921c136.png>

    * Update 사용 후 

        <img src = https://user-images.githubusercontent.com/74294325/102174965-eaa24980-3ee1-11eb-9422-ad331102703f.png>


---

## DELETE

* TABLE에서 조건(WHERE)에 맞는 레코드를 삭제합니다.

* truncate로 절삭하는 것보다 속도가 느리다.

* Transaction의 대상 query이다.


* 문법

    1. 모든 레코드를 삭제

        ```
        DELETE FROM '테이블명';
        ```

        <img src = https://user-images.githubusercontent.com/74294325/102177832-a9149d00-3ee7-11eb-8ca5-5c663b7cd1a6.png>


    2. 조건(WHERE)에 맞는 레코드를 삭제

        ```
        DELETE FROM 테이블명
        WHERE column명 = 삭제할 값;
        ```

        <img src = https://user-images.githubusercontent.com/74294325/102177855-b6318c00-3ee7-11eb-95a6-15bd7bbf23eb.png>
---

## TRUNCATE (DDL)

* TABLE에 레코드를 절삭할 때 사용한다.

* 특정 레코드만 절삭할 수 없다. 모든 레코드를 삭제할 때 사용

* Transaction의 대상 query가 아니므로 COMMIT, ROLLBACK를 사용할 수 없다. (DELETE보다 속도가 빠름)

    * 절삭된 레코드는 rollback로 복구를 할 수 없다.

* 문법

    ```
    TRUNCATE TABLE 테이블명;
    ```

---


## ORACLE 연산자 (Where절에 사용)

* 연산자 

    연산자 | 종류
    :--- | :---
    산술 연산자 | + , -, *, /  (Select문의 검색 column에 사용할 수 있다.)
    관계 연산자 | > , < , >= , <= , = , != (<> 또한 같지않다를 의미) 
    논리 연산자 | AND, OR, NOT
    문자열 연산자 | LIKE (% / _) %는 글자수 지정x , _는 글자수 지정
    null 비교연산자 | Is NULL, IS NOT NULL
    범위 연산자 | Between A and B
    문자열 붙임 연산자 | ㅣㅣ (Select문의 검색 column에 사용할 수 있다.)

---


## Transaction

* DBMS의 작업 단위.

* 하나의 query문으로 구성되는 경우도 있고, 여러 개의 query문으로 구성되는 경우도 있다.

* Transaction의 대상query는 INSERT,UPDATE,DELETE 대부분 DML이 이에 해당된다.

* Transaction이 `정상적으로 완료되는 경우에는 COMMIT`을 하여 `작업상태를 HDD에 저장`한다.

* Transaction이 `비 정상적으로 종료되는 경우 ROLLBACK`을 하여 `작업상태를 취소`해야 합니다.

### COMMIT

* 현재 접속자 세션 momory의 Transaction 작업상태를 HDD에 기록하고 모든 접속자에게 변경상황을 통지한다.<br>
(commit 된 데이터는 ROLLBACK으로 작업을 취소할 수 없다.)

* ` INSERT,UPDATE,DELETE을 사용하고 commit 명령어를 사용하기 전까지는 지금 접속한 접속자가 할당 받은 memory에만 적용`되어 있다.

* `File영역(HDD)에 있는 Table에 현재 memory에 있는 Table의 상태를 적용시키려면 commit 명령어를 사용합니다.` 

* 문법

    ```
    commit;
    ```

### ROLLBACK

* 현재 접속자 세션 memory의 Transaction 작업상태를 취소하는 일.

* SAVEPOINT를 사용하여 ROLLBACK하는 위치를 설정하고, 해당 지점까지의 작업을 취소할 수 있다.

    * SAVEPOINT는 COMMIT를 수행하면 모두 사라진다.
    * Oracle에만 존재한다.
    * 같은 이름의 SAVEPOINT를 생성하면 덮어쓰여진다.
    * `query문 작성 전에 SAVEPOINT를 지정 후 query를 작성한다.`

* 문법

    ```
    //저장점 사용
    SAVEPOINT 저장점명;
    ROLLBACK TO 저장점명;

    //제일 마지막 commit의 이후까지 작업을 되돌려 준다.
    ROLLBACK;
    ```

    <img src = https://user-images.githubusercontent.com/74294325/102179790-1b3ab100-3eeb-11eb-9f59-a2f6943fe22f.png>


### 트랜잭션 추가내용(2020-12-27)

* 트랜잭션이란? 

    * 업무적인 단위

    * 물리적인 명령어 단위 
```
EX)
계좌이체라는 업무적인 단위이며
보내는사람 UPDATE,받는사람 UPDATE 라는 물리적인 명령어 단위로 이루어져 있다.
```

* 트랜잭션 작업방식

    1. 현재 세션을 위한 임시저장소에서 test  (임시 테이블 스페이스에서 작업)
    2. 세션을 처리하는 동안 끼어들지 못하게 LOCK와 UNLOCK 처리가 된다. 
    3. test가 정상적이면 commit, 아니라면 전부 다 ROLLBACK. 

* 작업이 정상적으로 완료 후 commit를 하게되면 모든 사용자 session에서 변경내용을 확인 할 수 있다.<br>
(임시 테이블 스페이스에서 작업되었던 것을 적용)
---