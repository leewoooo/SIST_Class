--1. 프로시저 코딩  사원번호 사원명 연봉을 입력받아 해당사원의 사원명 연봉을 변경
-- * update, delete, select 사용하는 column명과 in parameter명은 다르게 설정해야 한다.
CREATE OR REPLACE PROCEDURE UPDATE_PROC(IN_EMPNO NUMBER, IN_ENAME VARCHAR2, IN_SAL NUMBER, CNT OUT NUMBER, MSG OUT VARCHAR2)
IS

BEGIN

	UPDATE TEST_PROC
	SET ENAME = IN_ENAME, SAL=IN_SAL
	WHERE EMPNO = IN_EMPNO;

	CNT := SQL%ROWCOUNT;

	if CNT != 0 THEN
		MSG := IN_EMPNO||'번 사원정보가 변경되었습니다.';
		COMMIT;
	ELSE
		MSG := IN_EMPNO||'번 사원은 존재하지 않습니다.';
	END IF;

	EXCEPTION
	WHEN OTHERS THEN
		MSG := SQLERRM||'문제가 발생했습니다.';

END;
/

--2. 저장 proc_update.sql
--
--3. 컴파일 sql>@파일명.sql (show error 컴파일 에러 확인)
--SELECT * FROM USER_PROCEDURES;
--
--4. 바인드 변수
--VAR CNT NUMBER;
--VAR MSG VARCHAR2(300);
--
--VAR;
--5. 실행 (직접실행)
--EXECUTE UPDATE_PROC(1,'우길',3100, :CNT, :MSG);
--
--6. 바인드 변수에 값 출력
--SELECT * FROM TEST_PROC;
--
--PRINT CNT;
--PRINT MSG;
