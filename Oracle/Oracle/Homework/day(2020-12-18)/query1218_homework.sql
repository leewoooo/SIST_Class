--숙제 1
--아래의 데이터를 추가할 수 있는 테이블을 만들고 데이터를 추가
--column명,데이터형,크기는 입력값을 유추하여 설정

CREATE TABLE HOMEWORK(
NAME CHAR(9),
AGE NUMBER(2),
GENDER NUMBER (1),
BLOODTYPE CHAR(1),
EMAIL VARCHAR(40));

INSERT INTO HOMEWORK
(NAME,AGE,GENDER,BLOODTYPE,EMAIL)
VALUES
('김은비', 22,2,'A','kim@test.com');

commit;

INSERT INTO HOMEWORK
(NAME,AGE,GENDER,BLOODTYPE,EMAIL)
VALUES
('김현규',23,1,'B','hyunkyu@test.com');

commit;

INSERT INTO HOMEWORK
(NAME,AGE,GENDER,BLOODTYPE,EMAIL)
VALUES
('남혜진',27,2,'A','nam@eun.co.kr');

commit;

INSERT INTO HOMEWORK
(NAME,AGE,GENDER,BLOODTYPE,EMAIL)
VALUES
('문혜원',24,2,'B','moon@sist.co.kr');

commit;

INSERT INTO HOMEWORK
(NAME,AGE,GENDER,BLOODTYPE,EMAIL)
VALUES
('민병권',25,1,'A','kwon@daum.net');

commit;

INSERT INTO HOMEWORK
(NAME,AGE,GENDER,BLOODTYPE,EMAIL)
VALUES
('박권익',25,1,'A','park_ki@eun.co.kr');

commit;

select * from HOMEWORK;

--숙제 2
--위의 테이블을 사용하여 이름,나이,성별,태어난 해를 조회
--성별1은 남자, 2는 여자로 조회
--태어난해는 올해-나이+1로연산.
SELECT NAME, AGE,
DECODE(GENDER,1,'남자',2,'여자') GENDER,
(TO_CHAR(SYSDATE,'yyyy')-AGE+1) BORNYEAR
FROM HOMEWORK;


--숙제 3
--위의 테이블을 사용해서 이름,메일주소,도메인 주소를 조회
SELECT NAME,
SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1) EMAIL,
SUBSTR(EMAIL,INSTR(EMAIL,'@')+1) DOMAIN
FROM HOMEWORK;

--숙제 4
--혈액형별 이름 나이 나이순위를 조회하세요.
--나이의 순위는 중복되지 않습니다.
SELECT BLOODTYPE,NAME,AGE,
ROW_NUMBER()OVER(PARTITION BY BLOODTYPE ORDER BY AGE DESC) AGERANK
FROM HOMEWORK;


--숙제 5
--혈액형별 인원수,나이의합 평균나이 최고나이를 조회
--단 혈액형의 소계가 데이터 출력후 출력되도록 정리
SELECT BLOODTYPE,NAME,COUNT(NAME),TRUNC(AVG(AGE)) "AVG(AGE)",MAX(AGE)
FROM HOMEWORK
GROUP BY ROLLUP(BLOODTYPE,NAME);
