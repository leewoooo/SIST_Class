# SYNONYM

* 테이블의 별명.
* 테이블을 다른 이름으로 호출 할 수 있는 객체.(계정이 달라도 사용할 수 있다.)
* SYNONYM을 조회할 때 USER_SYNONYMS 사용

* 권한이 설정된 계정만 SYNONYM을 생성할 수 있다.
  * 관리자 계정으로 권한을 확인할 수 있다.
  * 시스템 권한 (접속,자원사용 권한 등...): DBA_ROLE_PRIVS 
  * query 생성 권한 : DBA_SYS_PRIVS
* 권한 부여 (관리자 계정에서)

```java
//해당 계정만 사용할 수 있는 SYNONYM
GRANT CREATE SYNONYM TO 계정명;

//모든 계정이 사용할 수 있는 SYNONYM
GRANT CREATE PUBLIC SYNONYM TO 계정명;
```



* 생성 문법

```java
CREATE SYNONYM SYNONYM명 FOR (테이블 명);
```



* 삭제

```java
DROP SYNONYM SYNONYM명;
```



