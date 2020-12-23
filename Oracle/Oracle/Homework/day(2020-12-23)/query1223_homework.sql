--숙제1.
--사원테이블에서 부서번호가 10, 30번 부서의 사원을  정보를 조회하여
--조회한결과로  emp_work 테이블을 생성합니다.

CREATE TABLE EMP_WORK AS
(SELECT * FROM EMP WHERE DEPTNO IN(10,30));

SELECT * FROM EMP_WORK;

--숙제2. 테이블 변경
--2-1. 위에서 생성된 테이블의  empno 컬럼명을 emp_no로 변경합니다.
ALTER TABLE EMP_WORK RENAME COLUMN EMPNO to EMP_NO;
SELECT * FROM EMP_WORK;

--2-2. 위에서 생성된 테이블의 ename 컬럼을 한글 30자 까지 입력가능하도록
--컬럼의 길이를 변경합니다.
ALTER TABLE EMP_WORK MODIFY ENAME VARCHAR2(90);
SELECT * FROM EMP_WORK;

--2-3. 위에서 생성된 테이블에 ename 컬럼을 null을 저장하지 않도록 변경합니다.
ALTER TABLE EMP_WORK MODIFY ENAME VARCHAR2(90) NOT NULL;

-- 2-4. 위에서 생성된 테이블에  empno컬럼에 primary key 제약사항을 설정합니다.
ALTER TABLE EMP_WORK ADD CONSTRAINT PK_EMP_WORK PRIMARY KEY(EMP_NO);

-- 2-5. 위에서 생성된 테이블에 deptno 컬럼에 foreign key 제약사항을 설정합니다.(부모테이블은 dept)
ALTER TABLE EMP_WORK ADD CONSTRAINT FK_EMP_WORK FOREIGN KEY(DEPTNO) REFERENCES DEPT;

-- 2-6. 위에서 설정된 2-5번 제약을 삭제하세요.
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP_WORK';
ALTER TABLE EMP_WORK DROP CONSTRAINT FK_EMP_WORK;

--2-7. 위에서 설정된 2-4 번 제약을 비활성화 하세요.
ALTER TABLE EMP_WORK DISABLE CONSTRAINT PK_EMP_WORK;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP_WORK';

--3. 관리자계정으로 로그인 하여
--아이디와 비밀번호를 test/test1234인 계정을 생성하고
--접속가능하도록 권한을 설정하세요.

ALTER SESSION SET "_ORACLE_SCRIPT"=true;
CREATE USER test IDENTIFIED BY test1234;
GRANT CONNECT to test;

-- 4. 위의 계정을 삭제 합니다.
DROP USER test;

--5.user_cons_columns 테이블과  user_constraints을 사용하여
-- 'EMP'테이블에 설정된 컬럼명, 제약사항타입(constraint_type), 제약사항명을
--  조회하세요.

SELECT * FROM USER_CONS_COLUMNS;
SELECT * FROM USER_CONSTRAINTS;

SELECT ucc.COLUMN_NAME,uc.CONSTRAINT_TYPE,uc.CONSTRAINT_NAME
FROM USER_CONS_COLUMNS ucc, USER_CONSTRAINTS uc
WHERE (ucc.CONSTRAINT_NAME = uc.CONSTRAINT_NAME) AND uc.TABLE_NAME = 'EMP';
