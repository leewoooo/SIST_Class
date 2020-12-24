--수치 함수

--절대값
SELECT ABS(-12),ABS(12)
FROM DUAL;

--반올림
SELECT ROUND(555.555,2), ROUND(555.553,2)
FROM DUAL;

--사원 테이블에서 모든 사원의 사원번호 사원명 연봉 세금을 조회
-- 단 세금은 소수점 첫번째 자리에서 반올림하여 양수부만 출력
SELECT EMPNO, ENAME, SAL, ROUND((SAL*0.033),0)
FROM EMP;

--올림
SELECT CEIL(15.7)
FROM DUAL;

--내림
SELECT FLOOR(10.9)
FROM DUAL;

--절삭
--실수부 해당 인덱스 다음부터 자르고
SELECT TRUNC(15.79,1)
FROM DUAL;
--정수부는 해당 인덱스부터 자른다.
SELECT TRUNC(15.79,-1)
FROM DUAL;

--사원테이블에서 모든 사원의 사원번호 사원명 연봉 세금을 조회
--단 세금은 연봉에 3.3%로 계산 후 원단위 절삭하여 출력
SELECT EMPNO, ENAME, SAL, TRUNC((SAL*0.033),-1) tax
FROM EMP;

--null

SELECT NVL('','널')
FROM DUAL;

--사원테이블에서 사원번호 사원명 입사일 연봉 보너스 총수령액을 조회
--단 보너스가 없다면 0으로 출력 총 수령액은 연봉+보너스
SELECT EMPNO, ENAME, HIREDATE, SAL, NVL(COMM,0) COMM, (SAL+NVL(COMM,0)) TOTAL
FROM EMP;


--우편번호 테이블에서 '공덕동' 인 동을 조회하여
--우편번호 시도, 구군, 동, 번지를 조회
--단 번지가 없는 경우 '번지없음을 출력'
SELECT ZIPCODE, SIDO, GUGUN, DONG, NVL(BUNJI,'번지없음')
FROM ZIPCODE
WHERE DONG  LIKE '공덕동%';

SELECT NVL2('','있다','없다'),NVL2('A','있다','없다')
FROM DUAL;

--사원테이블에서 사원명, 사원번호, 연봉, 보너스,인센티브를조회
-- 단 인센티브는 보너스가 있다면 일괄 50으로출력하고 없다면 100

SELECT ENAME, EMPNO, SAL, NVL(COMM,0), NVL2(COMM,50,100) INCETIVE
FROM EMP;

--문자열

--길이
SELECT LENGTH('오늘은 목요일 입니다')
FROM DUAL;

--사원 table에서 사원명이 4글자인 사원의 사원명 사원명의 글자수
--사원번호 입사일 조회

SELECT ENAME, LENGTH(ENAME), EMPNO, HIREDATE
FROM EMP
WHERE LENGTH(ENAME)=4;


--문자열 합치기
SELECT CONCAT('오늘은','목요일') ,'오늘은'||'목요일'
FROM DUAL;

--첫글자를 대문자로
SELECT INITCAP('hello')
FROM DUAL;

SELECT INITCAP('HELLO'),INITCAP('i am a boy')
FROM DUAL;


--UPPER, LOWER
--사원테이블에서 사원명이 'scott'인 사원의 사원번호, 사원명,연봉
--보너스, 매니저번호 조회
SELECT EMPNO, ENAME, SAL, COMM, MGR
FROM EMP
WHERE ENAME=UPPER('scott');
--WHERE LOWER(ENAME) = 'scott';


--index얻기
SELECT INSTR('AbcdE','A')
FROM DUAL;

--사원명에서 A가 포함된 사원을 조회
SELECT ENAME
FROM EMP
WHERE INSTR(ENAME,'A') <>0;

--글자자르기
SELECT SUBSTR('AbcdeF',2,4)
FROM DUAL;

SELECT SUBSTR('AbcdeF',3,1)
FROM DUAL;

--학생테이블에서 학생의 이름, 이메일, 이메일주소 조회
SELECT NAME, EMAIL, SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1),
SUBSTR(EMAIL,INSTR(EMAIL,'@')+1)
FROM STUDENT;

--문자열 치환
SELECT REPLACE('오늘은 금요일 입니다','오늘은','내일은')
FROM DUAL;


--trim
SELECT TRIM('  A B C  ')
FROM DUAL;

SELECT LTRIM('  A B C  ')
FROM DUAL;

SELECT RTRIM(' A B C  ')
FROM DUAL;

--LPAD
SELECT LPAD('AbcD',10,'#')
FROM DUAL;

--숫자가 총 12자로 구성되고 12자가 아니라면 앞에0을 채워넣어
--12자로 만든 후 해당 숫자앞에 SIST문자열을 붙여
--SIST_000000000001의 형식으로 출력
SELECT CONCAT('SIST_',LPAD(1,12,0)) num
FROM DUAL;

SELECT LPAD(LPAD(1,12,0),17,'SIST_') num
FROM DUAL;

SELECT 'SIST_'||LPAD(1,12,0) num
FROM DUAL;


--조건함수
SELECT DECODE(1,1,'일',2,'이''없음')
FROM DUAL;

--부서 테이블에서 부서번호, 부서명 , 한글부서명을 조회
--단 한글부서명은 아래의 표와 같이 설정한다.
--10번 = 개발부 20번 = 유지보수부 30 = 영업부 40 = 총무부
SELECT DEPTNO, DNAME, DECODE(DEPTNO,10,'개발부',20,'유지보수부'
,30,'영업부',40,'총무부') KORDNAME
FROM DEPT;

--사원 테이블에서 사원번호, 사원명, 직무, 한글직무 조회
--한글 직무는 아래의 표와 같이 설정한다.
-- CLERK = 일반사원, SALESMAN = 영업사원, MANAGER = 관리사원, ANALYST = 분석사원, PRESIDENT = 사장

SELECT EMPNO, ENAME, JOB,DEPTNO, DECODE(JOB,'CLERK','일반사원','SALESMAN','영업사원','MANAGER','관리사원','ANALYST','분석사원','PRESIDENT','사장') KORJNAME
FROM EMP;

--사원테이블에서 사원번호, 사원명, 연봉 , 보너스, 부서번호를 조회
--단 보너스는 아래의 표와 같이 부서별로 차등지급한다.
-- 10 = 연봉에 10 20 = 연봉에 15 30 = 연봉에 20 40 = 연봉에 50
SELECT EMPNO, ENAME, SAL, (DECODE(DEPTNO,10,SAL*0.1,20,SAL*0.15,30,SAL*0.2,40,SAL*0.5)) BONUS, DEPTNO
FROM EMP;


--CASE

SELECT CASE 'java' WHEN 'java' THEN '완벽한 OOP언어'
									WHEN 'HTML' THEN 'MARKUP LANGUAGE'
									WHEN 'JavaScript' THEN 'Toy Language'
									ELSE '언어의 정보가 없습니다.'
				END  LANGUAGE
FROM DUAL;

-- 사원테이블에서 사원번호, 사원명, 부서번호, 부서별 보너스,직무를 조회
--단 부서별 보너스는 10 - 100, 20 - 400, 30 - 250, 그 외는 1000
SELECT EMPNO, ENAME, DEPTNO,
			 CASE DEPTNO WHEN 10 THEN 100
			 						WHEN 20 THEN 400
			 						WHEN 30 THEN 250
			 						ELSE 1000
				END DEPT_BONUS
				,JOB
FROM EMP;


--변환함수

SELECT SYSDATE
FROM DUAL;

SELECT TO_CHAR(SYSDATE,'yyyy-mm-dd am(hh24):mi:ss dy day q"분기"')
FROM DUAL;

--사원테이블에서 사원번호 사원명 입사일을 조회
-- 단 입사일은 연-일-년의 형식으로 출력
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'mm-dd-yyyy')
FROM EMP;

-- 사원테이블에서 입사년도가1981 사원의 사원번호 사원명 연봉, 입사일 부서번호를 조회
SELECT EMPNO, ENAME, SAL, HIREDATE, DEPTNO
FROM EMP
WHERE TO_CHAR(HIREDATE,'yyyy') = '1981' ;

--숫자 변환
--0 : 해당자리에 데이터가 존재하지 않으면 0을 출력한다.
SELECT TO_CHAR(2020,'0,000,000')
FROM DUAL;

--9 : 해당자리에 데이터가 존재하는 것만 출력한다.
SELECT TO_CHAR(2020,'9,999,999')
FROM DUAL;

-- 사원테이블에서 사원번호 사원명 입사일 연봉을 조회
-- 단 연봉은 3자리를 초과했을 때만 3자리마다 ,를 넣어 출력
SELECT EMPNO, ENAME, HIREDATE, TO_CHAR(SAL,'9,999')
FROM EMP;


--TO_DATE
SELECT TO_DATE('2020-12-17' , 'yyyy-mm-dd')
FROM DUAL;

--Insert에 날짜 추가
select * from STUDENT;

INSERT INTO STUDENT(
NUM,NAME,INPUTDATE)
VALUES
(5,'릴루길',TO_DATE('2020-12-17','yyyy-mm-dd'));

