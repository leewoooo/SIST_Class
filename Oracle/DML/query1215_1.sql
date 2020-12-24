--Comment


/*
1.
Edit (ED) : SQLplus에서 제공하는 편집기이다.
방법1)실행 : Edit 경로/파일명.sql
방법2)실행 : ed 경로/파일명.sql

2.
Edit안에서 SQL문을 작성한다. (SQL Schema 작성)
-SQL문은 대,소문자는 가리지 않는다.(DBMS에서는 대문자 처리)
-SQL문의 끝에는 종료 표시인 ;를 붙인다.

3. 작성된 SQL문 실행
 @경로/파일명.sql
*/

SELECT * FROM DEPT;

DESC DEPT;


/*
	테이블 작성
  학생정보를 저장하는 테이블을 생성.
  학번(숫자5), 이름(가변길이형15), 나이(숫자2), e-mail(가변 길이형 50자),전화번호(가변길이형 13),
	주소(가변길이형 200), 주민번호(고정길이형 14),반(고정길이형 1),입력일(날짜)
*/

-- 테이블명이나 컬럼명은 유일해야한다
-- 테이블명이나 컬럼명이 두단어로 만들어질 경우 _를 활용해라.
CREATE TABLE student(
	num NUMBER(5),
	name VARCHAR2(15),
	age NUMBER(2),
	email VARCHAR2(50),
	phone VARCHAR2(13),
	addr VARCHAR2(200),
	ssn VARCHAR2(14),
	class CHAR(1),
	inputDate DATE
);

--테이블의 구조 보기
DESC student;

--계정이 가지고 있는 테이블의 목록을 조회
-- select * from tab;
-- tab는 DBMS에서 제공하는 테이블로 DataDictionary라고 한다.
SELECT * FROM TAB;


SELECT * FROM student;


/*
생성된 테이블에 record 추가하기
*/
--column을 생략해서 추가. (값이 정확히 들어갔는지 확인이 어렵다)
INSERT INTO student
VALUES
(1,'이우길', 25, 'lee@gmail.com','010-1234-5678','서울시 구로구','961111-1234567','S',SYSDATE);

SELECT * FROM STUDENT WHERE num=1;

INSERT INTO student
VALUES
(2,'이우순', 25, 'woo@gmail.com','010-5678-1234','서울시 구로구','961212-2345678','S',SYSDATE);


select * from student where num=2;


select * from student;

--column을 명시하여 추가. (입력되는 값이 어던 column으로 추가 되는지 알수 있다.)
INSERT INTO student(
num,name,age,email,phone,addr,ssn,class,inputdate)
VALUES
(3,'이루길',25,'ru@gmail.com','010-7894-1234','서울시 서대문구','961225-1456789','S',SYSDATE);

select * from student;

INSERT INTO student(
num,name,age,email,phone,addr,ssn,class,inputdate)
VALUES
(4,'이루라',25,'ra@gmail.com','010-4567-1234','서울시 서대문구','961225-2456786','S',SYSDATE);


select * from student;

commit;

/*
	검색 : 모든 레코드의 특정 컬럼을 검색한다.
*/

SELECT * FROM student;

--학생 테이블에서 번호,이름,이메일,주소를 검색한다.

select num,name,email,addr
FROM student;

-- 이우길의 주소를 서울시 서대문구로 변경
UPDATE student
SET ADDR = '서울시 서대문구'
WHERE name = '이우길';

commit;

select * FROM student;

--나이가 25인 학생들의 CLASS를 A로 변경
UPDATE student
SET CLASS = 'A'
WHERE AGE = 25;

select * FROM student;

--UPDATE OPTION 취소
ROLLBACK;

select * FROM student;

--학생 테이블에서 학번이 4번이며 반이 S 강의장인 학생의 나이를 27로 주소를 '서울시 강서구',입력일을 query가 실행된 시간으로

UPDATE student
SET AGE = 27, ADDR = '서울시 강서구',INPUTDATE = SYSDATE
WHERE NUM = 4 AND CLASS = 'S';

select * FROM student;

COMMIT;

select * FROM student;


DELETE
FROM STUDENT;

SELECT * FROM STUDENT;

ROLLBACK;

SELECT * FROM STUDENT;

-- 학생테이블에서 번호가 1번인 학생의 레코드를 삭제
DELETE
FROM STUDENT
WHERE AGE = 25;

SELECT * FROM STUDENT;

--TRUNCATE
TRUNCATE TABLE STUDENT;




--savapoint를 이용한 rollback

SAVEPOINT INSERT_A;

INSERT INTO STUDENT(
NUM,NAME,ADDR)
VALUES
(1,'이우길','서울시 구로구');

SAVEPOINT B;

UPDATE STUDENT
SET ADDR = '서울시 서대문구'
WHERE NAME = '이우길';


ROLLBACK TO B;

SELECT * FROM STUDENT;

--테이블 삭제 : 레코드의 유뮤에 상관없이 테이블이 삭제된다.
DROP TABLE STUDENT;

SELECT * FROM TAB;

-- 휴지통에 버려진 테이블 확인하기
SHOW RECYCLEBIN;

-- 테이블 복구
FLASHBACK TABLE student TO BEFORE DROP;

DROP TABLE STUDENT;

-- 휴지통비우기
PURGE RECYCLEBIN;

