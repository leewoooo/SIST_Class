--SUBQUERY
-- CREATE SUBQUERY
-- 제약사항은 USER_CONSTRAINTS DATA DICTIONARY에서 검색 가능

--emp테이블에서 사원번호, 사원명, 연봉, 부서번호를 조회하여 cp_emp1 테이블 생성
CREATE TABLE CP_EMP1
AS (SELECT EMPNO,ENAME,SAL,DEPTNO FROM EMP);
select * from CP_EMP1;


--emp테이블에서 사원번호 사원명 직무 연봉 보너스 입사일 부서번호를 조회하여
--cp_emp2생성
CREATE TABLE CP_EMP2
AS(SELECT EMPNO,ENAME,JOB,SAL,COMM,HIREDATE FROM EMP);

SELECT * FROM USER_CONSTRAINTS;


--사원테이블에서 사원번호, 사원명, 입사일,부서번호,직무,연봉을
--레코드가 조회되지 않도록 조회하여 cp_emp3테이블에 생성. 구조만 복사
CREATE TABLE CP_EMP3 AS(
SELECT EMPNO, ENAME, HIREDATE, DEPTNO, JOB, SAL
FROM EMP
WHERE 1=0);


--WHERE 1=1 은 모든 레코드를 검색하는 것.
select * from CP_EMP3;


--사원테이블에서 입사년도가 1981년인 사원들의 사원번호, 사원명, 직무, 매니저번호 , 연봉
--입사일, 부서번호를 조회하여 cp_emp4 테이블 생성
CREATE TABLE CP_EMP4 AS
(SELECT EMPNO, ENAME, JOB, MGR, SAL, HIREDATE, DEPTNO
 FROM EMP
 WHERE TO_CHAR(HIREDATE,'yyyy') = '1981');

 select * from CP_EMP4;


 --INSERT SUBQUERY
 --cp_emp3 테이블에 아래와 같은 레코드를 추가해라.
 --사원번호 : 1111
 --사원명 : 이우길
 --입사일 : 오늘
 --부서번호 : 10
 --직무 : 사원
 --연봉 : emp테이블에 사원번호가 7788인 사람과 동일

 INSERT INTO CP_EMP3
 (EMPNO,ENAME,HIREDATE,DEPTNO,JOB,SAL)
 VALUES
 (1111,'이우길',SYSDATE,10,'직원',(SELECT SAL FROM EMP WHERE EMPNO = 7788));

select * from CP_EMP3;

DELETE FROM CP_EMP3 WHERE SAL IS NULL;

commit;


--EMP 테이블에서 사원번호가 7566인 사원의  사원번호, 사원이름, 입사일, 부서번호, 직무 , 연봉을
--cp_emp3에 추가
INSERT INTO CP_EMP3
(EMPNO,ENAME,HIREDATE,DEPTNO,JOB,SAL)
(SELECT EMPNO,ENAME,HIREDATE,DEPTNO,JOB,SAL FROM EMP WHERE EMPNO = 7566);


--사원번호 1112 사원명 이우순 입사일 이번달 마지막날 부서번호 10
--직무 emp테이블에서 사원명 scott인 사원과 동일한 직무
--연봉 emp테이블에서 사원번호가 7566인 사원의 연봉과 동일한 연봉
INSERT INTO cp_emp3
(EMPNO,ENAME,HIREDATE,DEPTNO,JOB,SAL)
VALUES
(1112,'이우순',LAST_DAY(SYSDATE),10,
(SELECT JOB FROM EMP WHERE ENAME = 'SCOTT'),
(SELECT SAL FROM EMP WHERE EMPNO = 7566));

select * from CP_EMP3;
commit;

CREATE TABLE INSERT_SUB(
JOB VARCHAR2(9),
TOTAL_SAL NUMBER,
INPUT_DATE DATE);

--사원테이블에서 입사년도가 1981이면서 직무가 SALESMAN인
--모든 사원의 합산연봉을 INSERT_SUB TOTAL_SAL column 에 추가
--JOB은 SALESMAN
--INPUTDATE는 현재일

INSERT INTO INSERT_SUB (JOB,TOTAL_SAL,INPUT_DATE)
VALUES
('SALESMAN',(SELECT SUM(SAL) FROM EMP WHERE JOB = 'SALESMAN' AND TO_CHAR(HIREDATE,'yyyy') = 1981),SYSDATE);

select * from INSERT_SUB;

--1981년에 입사한 직무별 연봉합을 INSERT_SUB테이블에 오늘날짜로 추가
INSERT INTO INSERT_SUB (JOB, TOTAL_SAL,INPUT_DATE)
(SELECT DISTINCT JOB ,SUM(SAL),SYSDATE FROM EMP WHERE TO_CHAR(HIREDATE,'yyyy') = '1981'GROUP BY JOB);

--update subquery

SELECT * FROM CP_EMP3;

--cp_emp3테이블에서 사원명이 이우길 인 사원의 연봉을
--emp 테이블의 사원번호가 7698인 사원의 연봉과 동일한 연봉으로 변경

UPDATE CP_EMP3
SET SAL = (
SELECT SAL
FROM EMP
WHERE EMPNO = 7698)
WHERE ENAME = '이우길';

SELECT * FROM CP_EMP3;

commit;

--delete subquery
--emp TABLE의 사원명이 'SCOTT'인 사원의 사원번호와 일치하는 사원을
--cp_emp3에서 삭제

SELECT * FROM CP_EMP3;

DELETE FROM CP_EMP3
WHERE EMPNO = (
								SELECT EMPNO
								FROM EMP
								WHERE ENAME = 'SCOTT');


SELECT * FROM CP_EMP3;

--emp테이블에서 부서번호가 20번인 부서의 사원번호와 일치하는 모둔 사원을 cp_emp3테이블에서 삭제

DELETE FROM CP_EMP3
WHERE EMPNO IN (
SELECT EMPNO
FROM EMP
WHERE DEPTNO = 20);

commit;
