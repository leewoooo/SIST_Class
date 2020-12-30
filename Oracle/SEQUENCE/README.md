# SEQUENCE

* 순차적인 번호를 관리하는 객체.
* NEXTVAL, CURRVAL 번호를 얻는 PSUEDO column을 제공한다.
* USER_SEQUENCES에서 조회 할 수 있다.
* NEXTVAL : File영역에 존재하는 SEQUENCE의 값을 변경하고 ,접속자 세션에 SEQUENCE 객체를 올리고 다음번호를 얻는다.
* CURRVAL : 접속자 세션에 올라와 있는 SEQUENCE 객체의 현재 번호를 얻는 일을 한다. NEXTVAL이 불려진 후 사용
  * CURRVAL은 메모리에 올라와있는 SEQUENCE의 현재값을 얻는 일만 수행
* query문이 실패한다면 번호가 사라진다.

## SEQUENCE 생성

```java
CREATE SEQUENCE SEQUENCE명
INCREMENT BY 증가하는 수
START WITH 시작 수
MAXVALUE 끝 값
CACHE 메모리에 올려 놓을 수 //작성하지 않으면 DEAFULT값은 20개이다. 메모리에 먼저 올려놓고 소진되기 전까지는 HDD 접근을 하지 않음.
CYCLE | NOCYCLE 	반복여부 //작성하지 않으면 DEFAULT값은 NOCYCLE이다.
```

## SEQUENCE 수정
```java
ALTER SEQUENCE SEQUENCE명
INCREMENT BY 증가하는 수
START WITH 시작 수
MAXVALUE 끝 값
CACHE | NOCACHE 메모리에 올려 놓을 수
CYCLE | NOCYCLE 	반복여부 
```

* 번호얻기

```java
//다음 번호
SEQUENCE명.NEXTVAL
//현재 번호
SEQUENCE명.CURRVAL
```

* SEQUENCE 삭제

```java
DROP SEQUENCE SEQUENCE명
```

