# JOIN

* 정규화가 진행되어 `서로 다른 테이블로 분산되어 저장된 테이블의 데이터를 모아서 조회할 때`.
* JOIN의 종류는 `INNER JOIN, OUTER JOIN, SELF JOIN`이 있다.
* `조인 조건(WHERE)을 잘못 설정하면 모든 레코드의 곱이 조회되는 "Cartesian Product"이 발생할 수 있다.`
  * 조회된 결과의 레코드를 `사용하기 어렵다`( but Cartesian Product을 의도적으로 사용할 때도 있다.)
* `ANSI문법과 Oracle문법` 두가지를 사용할 수 있다.
* `Driving Table(조인의 기준이 되는 테이블)선정에 따라 Join속도가 달라진다.`
  * **JOIN시 먼저 액세스 돼서 ACCESS PATH를 주도하는** **테이블**이다.
  * Driving Table은 join에서 key의 역할을 한다.
  * join 관계식에서 뒤에 위치한다.
  * Driving Table의 선정 조건
    * 부모 ,자식 관계가 설정 되어 있다면 PRIMARY KEY가 설정된 테이블이 Driving Table이 되는 것이 좋다.
    * 관계가 없는 테이블이 JOIN된다면 레코드의 다양성이 적은 테이블이 Driving Table이 되는 것이 좋다.
    * 관계가 없고 다양성이 비슷 할 때에는 레코드의 수가 적은 테이블을 Driving Table이 되는 것이 좋다.

* JOIN 조건에 따라 '=' 를 사용하면 EQUI-JOIN 과 비교연산자를 쓰는 NON-EQUI_JOIN으로 구분

## INNER JOIN

* 서로 다른 테이블의 같은 값이 존재하는 레코드만 조회.
* `같은 column명이 존재하면 어떠한 테이블에 존재하는지 알 수 없기 때문에 ERROR 발생`
  * 테이블 명.column명으로 column을 식별하도록 만든다.
  * 테이블 명이 길다면 Alias를 사용하여 테이블 명을 새로 지정해 Alias.column명으로 사용 `INLINE VIEW에는 Alias가 표기되지 않는다.`

```java
//ANSI 문법
SELECT 			column 명
FROM 			테이블 명
INNER JOIN 		조인할 테이블 명
ON 				조인 조건
INNER JOIN 		조인할 테이블 명
ON 				조인 조건
,
,
WHERE 			검색조건
    
//EX
//사원번호,사원명,입사일,부서번호,부서명,위치 조회
//연결 column (조인조건)= DEPTNO    
SELECT e.EMPNO,e.ENAME,e.HIREDATE,d.DEPTNO,d.DNAME,d.LOC
FROM DEPT d 
INNER JOIN EMP e
ON d.DEPTNO = e.DEPTNO ;
   
//Oracle 문법
SELECT 	alias.column명,,,
FROM 	테이블 명 alias, 조인할 테이블 명 alias,,,
WHERE 	(조인조건) AND 검색조건
    
//EX
SELECT e.EMPNO,e.ENAME,e.HIREDATE,d.DEPTNO,d.DNAME,d.LOC
FROM DEPT d , EMP e   
WHERE (d.DEPTNO = e.DEPTNO);
```



## OUTER JOIN

* 한쪽 테이블만 레코드가 존재하더라도 조회 가능한 조인.
* `left outer join, right outer join, full outer join 지원`
  * Oracle 문법으로는 full outerjoin을 지원하지 않는다.

```java
//ANSI
SELECT	column명
FROM	테이블 명 (LEFT | RIGHT) OUTER JOIN 조인할 테이블 명 //outer는 생략가능
ON		조인조건

//EX
//모든 부서에 근무하는 사원 정보 조회
SELECT d.DEPTNO,d.DNAME,d.LOC,e.EMPNO,e.ENAME,e.JOB,e.HIREDATE
FROM DEPT d LEFT JOIN EMP e
ON e.DEPTNO = d.DEPTNO;

//Oracle
//조인 조건에 (+)기호를 사용하여 OUTER JOIN을 구현
//레코드가 존재하지 않는 column에 기호를 사용한다.
SELECT	column명 
FROM	테이블명 alias, 조인할 테이블 명 alias ,,,,,,,,,
WHERE	(alias.column명(+) = alias.column명) AND 검색조건

//EX
SELECT d.DEPTNO,d.DNAME,d.LOC,e.EMPNO,e.ENAME,e.JOB,e.HIREDATE
FROM DEPT d , EMP e
WHERE e.DEPTNO(+) = d.DEPTNO;
```



## SELF JOIN

* 하나의 테이블을 조인 하는 것
* 검색출력용 테이블과 조건 비교용 테이블 구분하여 사용할 것.

```java
SELECT column명,,,
FROM 검색출력용 테이블 명 Alias, 조인할 비교용 테이블명 Alias// 검색출력용은 SELECT문에 비교용 테이블명은 WHERE절에 
WHERE (조인 조건) 검색 조건

//EX
SELECT e1.EMPNO, e1.ENAME ,e1.SAL, e1.JOB
FROM  EMP e1 , EMP e2
WHERE (e1.SAL > e2.SAL) AND e2.ENAME = 'ALLEN';
```

