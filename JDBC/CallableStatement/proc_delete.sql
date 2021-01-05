--사원 번호를 입력받아 해당 사원을 삭제
--1. 프로시저 작성
CREATE OR REPLACE PROCEDURE DELETE_PROC(IN_EMPNO NUMBER, CNT OUT NUMBER, MSG OUT VARCHAR2)
IS

BEGIN

	DELETE FROM TEST_PROC
	WHERE EMPNO = IN_EMPNO;

	-- 위의 쿼리문이 실행한 행의 수를 암시적 커서(SQL)의 속성(ROWCOUNT)을 사용하여 얻을 수 있다.
	CNT :=SQL%ROWCOUNT; --암시적 커서 + 실행할 행의 수

	IF CNT != 0 THEN
		MSG := IN_EMPNO||'번 사원의 정보가 삭제되었습니다.';
	ELSE
	  MSG := IN_EMPNO||'번 사원은 존재하지 않습니다.';
		COMMIT;
	END IF;

	EXCEPTION
	WHEN OTHERS THEN
		MSG := SQLCODE||'QUERY 실행 중 문제가 발생했습니다.';
END;
/

----2. 저장 : proc_delete.sql
--
----3. 컴파일
--SELECT * FROM USER_PROCEDURES;
--
----4. 바인드 변수 선언
--VAR CNT NUMBER;
--VAR MSG VARCHAR2(200);
--
--VAR;
----5. 실행
--EXECUTE DELETE_PROC(1 , :CNT, :MSG);
--
----6. 바인드 변수 값 출력
--PRINT CNT;
--PRINT MSG;
