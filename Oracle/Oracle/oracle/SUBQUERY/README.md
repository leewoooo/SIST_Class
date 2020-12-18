# SUBQUERY

* query문 안에 ()를 사용하여 SELECT query문을 작성하는 것.
* 단수행 subquery (subquery가 실행되었을 때 한행이 반환되는 query)
  * 한 query에 반환값이 한개
* 복수행 subquery(subquery가 실행 되었을 때 여러 행이 반환되는 query)
  * query가 실행되었을 때 반환값이 여러개

* subquery는 ()안의 SELECT문이 가장 먼저 실행되고, 외부query가 실행된다.
  * `()안에 SELECT문을 먼저 실행해보고 그 다음 외부 SELECT문을 작성후 조회하자.`

* subquery를 가질 수 있는 query문은 `CREATE TABLE, INSERT, UPDATE, DELETE, SELECT`이다.

---

## CREATE SUBQUERY

* 조회된 결과로 테이블을 생성할 때.(테이블 복사)
  * `주로 원천 데이터에서 필요한 데이터를 조회 후 테이블을 만들어 만들어진 테이블로 작업`

* columun명, datatype, 크기, 조회된 레코드는 복사가 되지만 제약사항(USER_CONSTRAINTS에서 확인)은 복사되지 않는다.<br>(NOT NULL이 따로 설정되어 있는것은 복사 가능하고 기본키에 걸려있는 NOT NULL은 복사가 되지 않는다.)

* 단수행subquery, 복수행subquery 모두 사용이 가능합니다.

* 문법

```java
CREATE TABLE 테이블명 as(SELECT,,,,,) //()안에 SELECT문으로 INLINE VIEW가 생성되고 생성된 INLINE VIEW로 TABLE생성
    
//EX
ALTER TABLE EMP MODIFY JOB VARCHAR(9) NOT NULL;

//emp테이블에서 사원번호 사원명 직무 연봉 보너스 입사일 부서번호를 조회하여 cp_emp2생성
//테이블을 만들면 JOB에는 제약사항 NOT NULL이 붙어있기에 새로 만든 CP_EMP2 테이블에도 제약사항이 적용된다.
CREATE TABLE CP_EMP2
AS(SELECT EMPNO,ENAME,JOB,SAL,COMM,HIREDATE FROM EMP);

//테이블의 구조만 복사할 때
CREATE TABLE 테이블명 as(SELECT * FROM 테이블명 WHERE 1=0)
```

---



## INSERT SUBQUERY

* 조회된 결과로 column의 값을 추가할 때 사용한다.
* 단수행, 복수행 subquery 둘다 사용이 가능하다.

### 단수행

```java
INSERT INTO 테이블명(column명,,,) VALUES (값,(SELECT,,,,))
    
//ex  
//cp_emp3 테이블에 아래와 같은 레코드를 추가해라.
//사원번호 : 1111
//사원명 : 이우길
//입사일 : 오늘
//부서번호 : 10
//직무 : 사원
//연봉 : emp테이블에 사원번호가 7788인 사람과 동일

INSERT INTO CP_EMP3
(EMPNO,ENAME,HIREDATE,DEPTNO,JOB,SAL)
VALUES
(1111,'이우길',SYSDATE,10,'직원',(SELECT SAL FROM EMP WHERE EMPNO = 7788));
```



### 복수행

```java
INSERT INTO 테이블명(column명,,,)(SELECT,,,)

//EX
//EMP 테이블에서 사원번호가 7566인 사원의  사원번호, 사원이름, 입사일, 부서번호, 직무 , 연봉을
//cp_emp3에 추가 
INSERT INTO CP_EMP3
(EMPNO,ENAME,HIREDATE,DEPTNO,JOB,SAL)
(SELECT EMPNO,ENAME,HIREDATE,DEPTNO,JOB,SAL FROM EMP WHERE EMPNO = 7566);
```

---

## UPDATE SUBQUERY

* 조회된 결과로 값을 변경할 때.
* 단수행만 사용이 가능하다. (IN을 쓰는 경우에서 한정적으로 복수행 가능)

```java
UPDATE 테이블명
SET column명 = (SELECT,,,,)
WHERE column명 = (SELECT,,,,)
    
//EX
//cp_emp3테이블에서 사원명이 이우길 인 사원의 연봉을
//emp 테이블의 사원번호가 7698인 사원의 연봉과 동일한 연봉으로 변경
UPDATE CP_EMP3
SET SAL = ( SELECT SAL
			FROM EMP
			WHERE EMPNO = 7698)
WHERE ENAME = '이우길';
```

---

## DELETE SUBQUERY

* 조회된 결과로 값을 삭제할 때
* 단수행만 사용이 가능하다. (IN을 쓰는 경우에서 한정적으로 복수행 가능)

```java
DELETE FROM 테이블명 
WHERE column명 = (SELECT,,,,)

//EX
//emp TABLE의 사원명이 'SCOTT'인 사원의 사원번호와 일치하는 사원을
//cp_emp3에서 삭제
DELETE FROM CP_EMP3
WHERE EMPNO = (
				SELECT EMPNO
				FROM EMP
				WHERE ENAME = 'SCOTT');
```

