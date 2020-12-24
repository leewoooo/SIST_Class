--INDEX 조회
SELECT * FROM USER_INDEXES
WHERE TABLE_NAME = 'CP_EMP4';

--REBUILD
ALTER INDEX PK_EMP REBUILD;

--INDEX 생성
--CP_EMP4테이블에서 사원번호 column을 INDEX로 설정
select * from CP_EMP4;
CREATE UNIQUE INDEX IDX_CP_EMP4 ON CP_EMP4(EMPNO);

-- INDEX HINT : /*+HINT*/
SELECT /*+ EMPNO */EMPNO,ENAME,JOB
FROM CP_EMP4
WHERE EMPNO = '7902';

--INDEX 삭제
DROP INDEX IDX_CP_EMP4;

--인덱스를 사용하여 정렬의 효과를 얻을 때
--column을 INDEX로 부여하고 검색조건에 "column>0"를 사용하면 
--index를 사용한 정렬 수행