--과제 1
--연봉이 1300 초과 3000미만인
--모든 사원의 사원번호,사원명,입사일,연봉을 조회

SELECT EMPNO, ENAME, HIREDATE, SAL
FROM EMP
WHERE SAL > 1300 AND SAL <3000;


--과제 2
--직무가 CLERK,SALESMAN,ANALYST인
--사원의 사원번호, 직무, 사원명, 연봉,월급,실수령액을 조회
--단 월급은 연봉을 12로 나눈값, 실수령액은 연봉에서 세금3.3%를 제외
SELECT EMPNO, JOB, ENAME, SAL	,SAL/12 SALARY	,SAL*(1-0.033) REAL_INCOME
FROM EMP
WHERE JOB IN('CRERK','SALESMAN','ANALYST');

--과제 3
-- 연봉이 2000~3000사이 이면서 부서가 10번이 아닌 부서에서 근무하는
--사원의 사원번호, 사원명, 부서번호, 연봉, 직무, 입사일을 조회
SELECT EMPNO, ENAME, DEPTNO, SAL, JOB, HIREDATE
FROM EMP
WHERE (SAL BETWEEN 2000 AND 3000) AND DEPTNO NOT IN(10);

--과제 4
--사원명이 'A'가 있거나, 'S'가 있으면서 연봉을 1200보다 많이 받는 사원의
--사원번호, 사원명, 연봉, 직무, 부서번호, 입사일을 조회
SELECT EMPNO, SAL, JOB, DEPTNO, HIREDATE
FROM EMP
WHERE ((ENAME LIKE '%A%') OR (ENAME LIKE '%S%')) AND SAL > 1200;

--과제 5
--사원 테이블에서 매니저가 있는 사원의 사원번호, 사원명,연봉,입사일을 조회하여
--아래의 형식으로 출력하고 컬럼명을 대소문자 구분하여 OutPut을 설정.

SELECT ENAME||'('||EMPNO||')님은'||HIREDATE||'에 입사하셨으며 현재 연봉'||SAL||'원입니다' "OutPut"
FROM EMP
WHERE MGR IS NOT NULL;

--과제 6
--사원 테이블에서 7698, 7966, 7902 매니저가 관리하지 않는 사원의
--사원번호, 사원명, 직무, 연봉, 보너스, 부서번호를 조회
SELECT EMPNO, ENAME, JOB, SAL, COMM, DEPTNO
FROM EMP
WHERE MGR NOT IN(7698,7966,7902);

--과제 7
--사원 테이블에서 모든 사원의 사원번호, 사원명, 직무, 연봉,내년연봉을 조회
--내년 연봉은 현재 연봉보다 10% 인상된 금액
SELECT EMPNO, ENAME, JOB, SAL, SAL+(SAL*0.1) NEXTYEAR_SAL
FROM EMP;
