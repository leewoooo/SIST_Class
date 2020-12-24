# UNION

* 여러 테이블의을 하나로 합쳐서 조회할 때.
* 여러 테이블의 조회결과를 아래로 붙여 조회할 때 사용.
* `column의 갯수 및 datatype은 반드시 일치해야한다.`
* ERROR
  1. column의 갯수가 맞지 않을 때.
  2. column의 Datatype이 맞이 않을 때. (column명은 서로 달라도 가능하다.)
* UNION의 종류
  1. UNION : 중복 데이터가 존재하면 중복 데이터를 출력하지 않는다.
  2. UNION ALL : 중복데이터가 존재하더라도 모두 출력한다.

```java
SELECT column명,,,,,,
FROM 테이블 명    
UNION 혹은 UNION ALL
SELECT column명,,,,,,
FROM 테이블 명
    
//ex
SELECT EMPNO,ENAME,SAL,DEPTNO
FROM CP_EMP1
UNION
SELECT EMPNO,ENAME,SAL,DEPTNO
FROM EMP; //결과로 CP_EMP1 과 EMP에서 중복되지 않는 EMPNO,ENAME,SAL,DEPTNO가 조회된다.
```

