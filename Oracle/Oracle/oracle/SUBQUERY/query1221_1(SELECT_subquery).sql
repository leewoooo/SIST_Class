--select subquery

--단수행
--사원테이블에서 평균 연봉 보다 많이 받는 사원의 사원번호, 사원명
--입사일, 연봉을 조회하세요.

SELECT EMPNO, ENAME, HIREDATE, SAL
FROM EMP
WHERE SAL > TRUNC((SELECT AVG(SAL) FROM EMP),0);

select * from CP_EMP3;

--cp_emp3에서 사원번호가 1111번인 사원의 부서번호와 같은 부서번호를
--사원을 emp테이블에서 조회해라
--조회 column은 부서번호 사원번호 사원명 입사일 연봉
SELECT DEPTNO, EMPNO, ENAME, HIREDATE, SAL
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM CP_EMP3 WHERE EMPNO = 1111);

-- scalra subquery (단수행): 조회하는 column에 사용.
-- 안쪽 query의 column명과 바깥 query의 column명이 같다면 "테이블 명.column의 문법으로
-- column을 식별하여 사용

-- 사원번호,사원명,부서번호,부서명을 조회
SELECT EMPNO, ENAME, DEPTNO,
(SELECT DNAME FROM DEPT WHERE DEPT.DEPTNO = EMP.DEPTNO) DNAME
FROM EMP;

--사원테이블에서 최고연봉,최고연봉을 수령하는 사원명을 조회
SELECT ENAME, (SELECT MAX(SAL) FROM EMP)
FROM EMP
WHERE SAL = (SELECT MAX(SAL) FROM EMP);

--복수행 subquery : 조회 결과를 가지고 재 조회




--가상번호
--사원 테이블에서 번호,사원번호,사원명 조회
--번호는 조회되는 column의 순서대로 1번부터 순차적으로 부여
SELECT ROWNUM,EMPNO,ENAME
FROM EMP;

--rownum은 orderby보다 먼저 생성
--사원테이블에서 번호,사원번호,사원명조회
--사원명의 오름차순으로 정렬
SELECT ROWNUM,EMPNO,ENAME
FROM EMP
ORDER BY ENAME;

--WHERE절에서 사용하면 1번부터 비교가 되나 1번 이후에는 비교되지 않는다.
--사원테이블에서 번호,사원번호,사원명을 조회
--단, 번호가 1~7번까지의 사원만 출력

SELECT ROWNUM , EMPNO, ENAME
FROM EMP
WHERE ROWNUM >= 1 AND ROWNUM <= 7;


--복수행
SELECT EMPNO, ENAME, SAL, HIREDATE
FROM (
			SELECT EMPNO, ENAME, SAL, HIREDATE
			FROM EMP
			);

--안쪽 query에서 column명에 alias가 부여되면 바깥 query에서는 alias로만 사용가능
SELECT EMPNO, ENAME, SAL, H
FROM (
			SELECT EMPNO, ENAME, SAL, HIREDATE H
			FROM EMP
			);

--rownum은 select마다 생성되고 사용된다.
SELECT a, EMPNO,ENAME,JOB
FROM (SELECT ROWNUM a, EMPNO , ENAME, JOB FROM EMP ORDER BY ENAME)  ;

--사원 테이블에서 가장 마지막에 입사한 사원부터 5명의 사원 정보를 조회
--사원번호 사원명 입사일
SELECT ROWNUM, EMPNO, ENAME, HIREDATE
FROM (SELECT EMPNO , ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC)
WHERE ROWNUM BETWEEN 1 AND 5;

--사원 테이블에서 가장 마지막에 입사한이전 사원부터 5명의 사원 정보를 조회
--사원번호 사원명 입사일
SELECT EMPNO, ENAME, HIREDATE, HIRE
FROM (SELECT EMPNO , ENAME, HIREDATE, ROW_NUMBER()OVER(ORDER BY HIREDATE DESC) HIRE FROM EMP)
WHERE HIRE BETWEEN 2 AND 6;

