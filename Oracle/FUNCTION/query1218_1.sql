--사원테이블에서 연봉의 평균
SELECT TRUNC(AVG(SAL))
FROM EMP;

--사원테이블에서 최고 연봉
SELECT MAX(SAL)
FROM EMP;

--사원테이블에서 최저 연봉
SELECT MIN(SAL)
FROM EMP;

--사원테이블에서 평균 연봉보다 많이 받는 사원의 사원번호, 사원명,연봉,입사일 조회
--WHRER절에서는 집계함수를 사용할 수 없습니다.
SELECT EMPNO,ENAME,SAL,HIREDATE
FROM EMP
WHERE AVG(SAL) < SAL;

--집계함수와 group by


--사원테이블에서 부서번호,부서별 인원조회 , 부서별 연봉의 합
SELECT DEPTNO,COUNT(ENAME),SUM(SAL)
FROM EMP
GROUP BY DEPTNO;


--사원테이블에서 매니저 번호, 매니저별 관리하는 사원수
--최고연봉
SELECT MGR ,COUNT(EMPNO),MAX(SAL)
FROM EMP
WHERE MGR IS NOT NULL
GROUP BY MGR;

--사원 테이블에서 사원수가 4명 이상인 부서의 부서번호,부서벌 사원수,
--연봉의 합
SELECT DEPTNO,COUNT(DEPTNO),SUM(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(EMPNO)>4;

--사원테이블에서 매니저가 관리하는 사원이 2명 이상인 매니저의
--매니저 번호, 관리사원수, 평균 연봉, 최고연봉,최저연봉의 차이를 조회
SELECT MGR,COUNT(EMPNO),TRUNC(AVG(SAL),0),(MAX(SAL)-MIN(SAL))
FROM EMP
GROUP BY MGR
HAVING COUNT(EMPNO) > 1;

--사원 테이블에서 부서번호, 부서별 사원수, 연봉 합, 전체연봉합 조회
SELECT DEPTNO, COUNT(EMPNO),SUM(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO);

--여러column이 그룹으로 묶이면 그룹별 결과, 중간결과 , 총합결과를 출력한다.
--각각 부서에 해당하는 사원의 사원수 및 직무를 조회
SELECT DEPTNO,JOB,COUNT(EMPNO)
FROM EMP
GROUP BY ROLLUP(DEPTNO,JOB);

SELECT DEPTNO,JOB,COUNT(EMPNO)
FROM EMP
GROUP BY CUBE(DEPTNO,JOB);

--- ORDER BY

-- 사원명의 오름차순 정렬.
--컬럼은 오름차순 정렬 (ASC)이 기본설정
SELECT EMPNO, ENAME
FROM EMP
ORDER BY ENAME;

-- 사원명의 내림차순 정렬.
SELECT EMPNO, ENAME
FROM EMP
ORDER BY ENAME DESC;

--사원번호 사원명 연봉을 조회
-- 연봉이 가장 높은 순으로 조회
SELECT ENAME ,SAL
FROM EMP
ORDER BY SAL DESC, ENAME;


--문자열의 정렬 자릿수의 정렬
CREATE TABLE TEST_ORDERBY(
NUM VARCHAR2(10)
);

INSERT INTO TEST_ORDERBY(NUM) VALUES (1);
INSERT INTO TEST_ORDERBY(NUM) VALUES (11);
INSERT INTO TEST_ORDERBY(NUM) VALUES (201);
INSERT INTO TEST_ORDERBY(NUM) VALUES (10009);
INSERT INTO TEST_ORDERBY(NUM) VALUES (2005);
INSERT INTO TEST_ORDERBY(NUM) VALUES (3);
INSERT INTO TEST_ORDERBY(NUM) VALUES (4);
INSERT INTO TEST_ORDERBY(NUM) VALUES (321);
INSERT INTO TEST_ORDERBY(NUM) VALUES (30001);

commit;

--문자열(varchar2,char)데이터형이 숫자를 가지면 자릿수의 정렬을 수행.
SELECT NUM
FROM TEST_ORDERBY
ORDER BY TO_NUMBER(NUM);

select * from TEST_ORDERBY ;



--RANK 함수 : 순위를 부여할 때 사용된다.
--ORDER BY절과 함께 쓰이지 않는다.

--사원테이블에서 사원번호 사원명 연봉 연봉의 순서를 조회
SELECT EMPNO,ENAME,SAL,RANK() OVER(ORDER BY SAL)
FROM EMP;

SELECT EMPNO,ENAME,SAL,ROW_NUMBER() OVER(ORDER BY SAL DESC)
FROM EMP;

SELECT ENAME,RANK()OVER(ORDER BY ENAME)
FROM EMP;



-- 사원테이블에서 직무 직무별 연봉순위 연봉 사원명 조회
--단 같은 연봉이 존재한다면 같은 순위를 가진다.
SELECT JOB, RANK()OVER(PARTITION BY JOB ORDER BY SAL),SAL,ENAME
FROM EMP;

-- 날짜 함수
-- 날짜에 +연산을 사용하면 현재 날짜에서 +한 값만큼의 일이 증가한 날짜를 얻을 수 있다.
-- 날짜에 -연산을 사용하면 현재 날짜에서 -한 값만큼의 일이 감소한 날짜를 얻을 수 있다.
SELECT SYSDATE, SYSDATE+1 ,ADD_MONTHS(SYSDATE,101)
FROM DUAL;
