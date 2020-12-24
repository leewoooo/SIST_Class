# INDEX

* 검색을 빠르게 하기 위해 생성하는 객체. (레코드가 적을때는 INDEX사용 보다는 FULL SCAN이 빠르다.)
* INDEX의 종류는 자동INDEX, 수동INDEX가 있다.
  * 자동INDEX : Oracle에서 자동으로 생성하는 INDEX
  * 수동INDEX : 개발자가 직접 생성

* USER_INDEXES 에서 생성된 인덱스를 확인할 수 있다.
* UNIQUE INDEX, NON UNIQUE INDEX, BITMAP INDEX, COMPOSIT INDEX 를 지원한다.
* INDEX는 레코드의 주소를 의미한다.(ROWID를 사용한다.)
  * SELECT문으로 조회할 때 ROWID를 사용화면 확인할 수 있다.
  * 18자리로 되어있으며 6(Oracle object 번호)/3(file번호)/6(block번호)/3(row번호) 로 나뉜다

* 인덱스로 설정하는 column 선정조건
  * `where절에 많이 사용되는 column`
  * `자주 변경되지 않는 column`(레코드의 값이 자주 변하면 INDEX를와 틀어진다. INDEX REBIULD를 사용하여 차이를 없애는 것 가능)
* 레코드의 양이 많을 때, 검색의 결과가 전체 레코드의 `약 10~15%`정도가 될 때 효율이 가장 좋다.
* INDEX HINT : / * +HINT  INDEX column명 * /
* `인덱스를 사용하여 정렬의 효과를 얻을 때 column을 INDEX로 부여하고 검색조건에 "column>0"를 사용하면 index를 사용한 정렬 수행할 수 있다.`

```java
//UNIQUE INDEX 기준 문법
//생성
CREATE UNIQUE INDEX INDEX명 ON column명(column명,,,);

//삭제
DROP INDEX INDEX명;

//INDEX 리빌드 (테이블과 INDEX간의 차이를 없애는 것)
ALTER INDEX INDEX명 REBUILD;

//정렬
SELECT column명
FROM 테이블 명
WHERE INDEX로 지정한 column명 > '0';    
```



## UNIQUE INDEX

* 자동 INDEX : 테이블에 PRIMARY KEY, UNIQUE 제약조건을 설정하면 자동으로 생성
* column의 값이 유일할 때 생성하고 사용하는 INDEX
* column명 뒤에 ASC,DESC 정렬 기준을 줄 수 있다.

```java
CREATE UNQUIE INDEX INDEX명 ON 테이블명(column명) //INDEX명은 접두어로 IDX를 대부분 사용한다.
```



## NON UNIQUE INDEX

* 수동 INDEX :  column의 값이 중복될 때 생성하는 INDEX
* column명 뒤에 ASC,DESC 정렬 기준을 줄 수 있다.

```java
CREATE INDEX INDEX명 ON 테이블명(column명)
```



## BITMAP INDEX

* 수동 INDEX : 주로 데이터의 값의 종류가 많고 동일한 데이터가 적을 경우에 사용하는 INDEX
* column명 뒤에 ASC,DESC 정렬 기준을 줄 수 있다.

```java
CREATE BITMAP INDEX INDEX명 ON 테이블명(column명)
```



## COMPOSIT INDEX

* 수동 INDEX : column 여러개가 합쳐져서 INDEX를 구성

```java
CREATE UNIQUE INDEX INDEX명 ON 테이블명(column명,,,,,,)
```

