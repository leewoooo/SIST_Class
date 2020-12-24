--EXISTS
--사원테이블에서 사원명이 'SCOTT'인 사원이 존재할 때 사원테이블을 조회
--사원 번호 사원명 입사일 연봉 부서번호
--SCOTT이라는 사원이 존재 할 때 모든 사원 정보가 조회 되어져야한다.
SELECT EMPNO,ENAME,HIREDATE,SAL,DEPTNO
FROM EMP
WHERE EXISTS(SELECT * FROM EMP WHERE ENAME = 'SCOTT');

--부서별 직무 연봉을 정산
--부서번호(NUMBER(2) , 직무(VARCHAR2(9) , 연봉 합(NUMBER), 입력일(DATE)을 저장하는 테이블 생성
CREATE TABLE DEPT_ACCOUNT(
DEPTNO NUMBER(2),
JOB VARCHAR2(9),
SAL_TOTAL NUMBER,
INPUT_DATE DATE
);


--위에 생성된 테이블에 30번 부서이면서 1981년에 입사한 사원들의
--직무,연봉합,조회시점의 날짜로 추가
--1981에 입사한 사원이 존재한다면 정산잡업을 수행
--그렇지 않다면 정산 작업을 수행하지 않는다.
INSERT INTO DEPT_ACCOUNT
		(DEPTNO,JOB,SAL_TOTAL,INPUT_DATE)
		(
		SELECT DEPTNO,JOB,SUM(SAL),SYSDATE
		FROM EMP
		WHERE EXISTS(SELECT EMPNO FROM EMP WHERE TO_CHAR(HIREDATE,'yyyy')='1981')
		AND DEPTNO = 10 AND TO_CHAR(HIREDATE,'yyyy')='1981'
		GROUP BY DEPTNO,JOB
		);

select * from DEPT_ACCOUNT;

