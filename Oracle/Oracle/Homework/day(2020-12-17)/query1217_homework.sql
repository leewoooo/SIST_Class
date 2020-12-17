--숙제 1
-- 사원 테이블에서 모든 사원의 사원번호,사원명,입사일,연봉,월급을 조회
-- 단 월급은 연봉을 12로 나눈 값으로 소수점 첫번째 자리에서 반올림
SELECT EMPNO, ENAME, HIREDATE, SAL, ROUND(SAL/12,0)
FROM EMP;

-- 숙제 2
-- 사원 테이블에서 입사월이 12월인 사원들의 사원번호, 사원명, 입사일,연봉, 실수령액을 조회
--단 실수령액은 연봉과 보너스를 합산한 금액으로 연산
-- 세금은 실 수령액에서 3.3%를 제외한 금액으로 연산하여 원단위 절사하여 출력
SELECT EMPNO, ENAME, HIREDATE, SAL, TRUNC(((SAL*(1-0.033))+NVL(COMM,0)),0) Real_Money
FROM EMP
WHERE TO_CHAR(HIREDATE,'mm')=12;

-- 숙제 3
--사원테이블에서 10번 부서와 30번 부서에 근무하면서 매니저가 있는 사원의
--사원번호, 매니저번호, 입사일,연봉,사원명,직무를 조회
-- 단 입사일은 "년-월-일-분기-요일"의 형식으로 출력하되 년도는 2자리만 출력
--사원명은 모두 소문자로 출력 직무는 앞자리만 대문자로 출력
SELECT EMPNO, MGR, TO_CHAR(HIREDATE,'yy-mm-dd-q"분기"-day'), SAL, LOWER(ENAME) ENAME, INITCAP(JOB) JOB
FROM EMP
WHERE (DEPTNO IN (10,30)) AND (MGR IS NOT NULL);

-- 숙제 4
-- 아래의 값을 입력할 수 있는 테이블을 생성하고 데이터를 추가하세요.
CREATE TABLE STUDENT_HOMEWORK(
NUM NUMBER(5),
NAME CHAR(9),
SCNUMBER CHAR(14)
);

INSERT INTO STUDENT_HOMEWORK
(NUM, NAME, SCNUMBER)
VALUES
(12345,'김현규','880101-1234567');

INSERT INTO STUDENT_HOMEWORK
(NUM, NAME, SCNUMBER)
VALUES
(4326,'남혜진','980101-2234567');

INSERT INTO STUDENT_HOMEWORK
(NUM, NAME, SCNUMBER)
VALUES
(51,'민병권','991217-1234567');

INSERT INTO STUDENT_HOMEWORK
(NUM, NAME, SCNUMBER)
VALUES
(98762,'배우리','991212-1234567');

INSERT INTO STUDENT_HOMEWORK
(NUM, NAME, SCNUMBER)
VALUES
(961,'정예진','001212-4234567');

select * from STUDENT_HOMEWORK;

-- 숙제 5
-- 4번에서 생성한 테이블을 사용하여 번호,이름,주민번호 - 앞자리만, 성별을 조회하세요
SELECT CONCAT('I_',LPAD(NUM,8,0)), NAME, SUBSTR(SCNUMBER,1,INSTR(SCNUMBER,'-')-1) SCNUMBER,
DECODE(SUBSTR(SCNUMBER,INSTR(SCNUMBER,'-')+1,1),'1','남','2','여','4','여') GENDER
FROM STUDENT_HOMEWORK;

-- 숙제 6
-- 4번에서 생성된 테이블에서 이름이 배우리인 사람의
-- 주민번호를 991212-2234567로 변경
UPDATE STUDENT_HOMEWORK
SET SCNUMBER = '991212-2234567'
WHERE NAME = '배우리';

COMMIT;

select * from STUDENT_HOMEWORK;
