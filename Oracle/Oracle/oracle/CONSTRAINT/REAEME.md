# CONSTRAINT

* 개발자(DBA : database administrator)가 원하는 값만 받기 위해 테이블에 설정하는 것
* 종류는 primary key,  foregin key,  unique, check, not null,  default(제약사항 x)
* 테이블에 설정된 제약사항은 user constraints(Data Dictionary: 정보저장용 테이블 ) 테이블에서 확인할 수 있다.
* Table단위 제약사항, column 제약사항, ALTER문으로 설정할 수 있다.
  1. 테이블 단위 제약사항(table level constraints): 테이블 생성시 column의 정의가 종료되고 나서 정의하는 제약사항
  2. column 단위 제약사항( column level constraints): 테이블 생성시 column의 정의 뒤에 붙여서 정의하는 제약사항

* 제약사항은 ALTER문을 사용하여 활성화, 비활성화를 수행할 수 있습니다.

## PRIMARY KEY(기본 키)

* NULL을 허용하지 않으면서 column의 값을 유일하게 관리해야 할 때 사용한다. (NOT NULL을 주지 않아도 자동으로 적용된다.)
* column단위 제약사항, table단위 제약사항 둘 다 사용가능하다.
* PRIMARY KEY는 테이블에서 한개만 설정 할 수 있다.
* 테이블의 관계를 설정할 때에도 사용된다.
* 테이블 단위 제약사항문법과 column단위 제약사항 문법이 모두 사용가능하다.
* PRIMARY KEY를 설정하면 Oracle에서 자동으로 INDEX를 생성한다.
* `반드시 존재하면서 유일한 값을 설정할 때 사용.`
  * 개체 무결성 제약조건이 적용되어 NULL값이 들어가면 안되며 중복 값이 올 수 없다.
* user_constraints에서 검색하면 constraints type은 P로 나온다.

```java
//테이블 단위 제약사항 (하나 또는 여러개의 column으로 PK가 구성될 수 있다.)
CREATE TABLE 테이블명(
column명 datatype(크기),
,
,
CONSTRAINT 제약사항명 PRIMARY KEY(기본키를 설정 할 column명)
); //제약사항명은 대부분 PK_테이블명 으로 설정한다.

//EX
CREATE TABLE PRIMARY_TABLE(
	NUM NUMBER,
	NAME VARCHAR2(10),
	SSN CHAR(14),
	CONSTRAINT PK_PRIMARY_TABLE PRIMARY KEY(SSN)
);

//column 단위 제약사항 (column 하나만 pk로 구성할 수 있다.)
CREATE TABLE 테이블명(
column명 datatype(크기) CONSTRAINT 제약사항명 PRIMARY KEY,
,
,
);

//EX
CREATE TABLE PRIMARY_COLUMN(
	NAME VARCHAR2(15),
	ID VARCHAR2(20) CONSTRAINT PK_PRIMARY_COLUMN PRIMARY KEY,
	ADDR VARCHAR2(300)
);

//여러개의 column이 하나의 PRIMARY KEY로 구성될 때 (복합키가 기본기인경우)
//번호, 아이템명,설명, 생산일
CREATE TABLE PRIMARY_MULTI(
	NUM NUMBER,
	ITEM VARCHAR2(50),
	INFO VARCHAR2(4000),
	PRD_DATE VARCHAR(20),
	CONSTRAINT PK_PRIMARY_MULTI PRIMARY KEY(ITEM,PRD_DATE) //아이템과 생산일 두 column으로 기본키 설정
	);
```



## FOREIGN KEY(외래 키, 참조 키)

* 다른 테이블(부모테이블)의 column의 값과 동일한 값으로 column이 저장되어야 할 때.
* column단위 제약사항, table단위 제약사항 둘 다 사용가능하다.
* Null을 허용한다. 같은 값을 여러개 넣을 수 있다.
* 값이 입력될 때에는 부모 테이블에 존재하는 column의 값으로만 존재(참조 무결성 제약조건)
* FOREIGIN KEY가 설정된 테이블을 자식 테이블이라 하며 FOREIGIN KEY는 여러개가 될 수 있다.
* FROEIGIN KEY는 부모 테이블의 PRIMARY KEY column만 참조가 가능하다.
* user_constraints에서 검색하면 constraints type은 R로 나온다.
* 부모테이블의 레코드가 자식테이블에서 참조되고 있다면 자식테이블의 참조되는 레코드를 지워야 부모테이블의 레코드를 지울 수 있다.

```java
//테이블 단위 제약사항 
CREATE TABLE 테이블명(
column명 datatype(크기),
,
,
CONSTRAINT 제약사항명 FOREIGN KEY(적용할 column명) REFERENCES 부모테이블명 (참조할 column명)
); //제약사항명은 대부분 FK_column명 으로 설정한다.


//column 단위 제약사항 
CREATE TABLE 테이블명(
column명 datatype(크기) CONSTRAINT 제약사항명 REFERENCES 부모테이블명 (참조할 column명)
,
,
);
```

* 식별 관계, 비 식별관계
  	1. 식별 관계 : `부모 테이블에서의 기본 키가 자식 테이블의 기본키 일 경우`
   	2. 비 식별 관계 :` 부모 테이블에서의 기본키가 자식 테이블의 일반 속성일 경우` (1:n관계)

### FROEIGN KEY OPTION

1. NO ACTION
   * 데이터베이스 엔진에서는 오류가 발생하며 부모 테이블의 행에 대한 삭제 또는 업데이트 동작이 롤백 된다.
2. CASCADE
   * 부모 테이블에서 해당 행이 업데이트 되거나 삭제될 때 참조 테이블에서도 해당 행이 업데이트 되거나 삭제된다.
   * 참조키 제약조건을 설정 후 뒤에 `ON DELETE CASCADE`를 입력해 사용한다.
3. SET NULL
   * 부모 테이블에서 행을 업데이트 하거나 삭제하면 해당 참조 키를 구성하는 모든 값이 NULL로 설정된다.
   * 참조키 제약조건을 설정 후 뒤에 `ON DELETE SET NULL`를 입력해 사용한다.
4. SET DEFAULT
   * 부모 테이블에서 해당 행을 업데이트 하거나 삭제하면 참조키를 구성하는 모든 값이 기본값(DEFAULT로 지정 한 값으로 설정)
   * 참조키 제약조건을 설정 후 뒤에 `ON DELETE SET DEFAULT 값`을 입력해 사용한다.
5. RESTRICT
   * 자식테이블에서 참조하고 있는경우 부모테이블에서 데이터를 삭제 혹은 수정할 수 없다.



## UNIQUE

* 값이 없을 수도 있고, 있다면 유일해야 한다
  * null을 허용하면서 값이 있다면 유일해야 할 때 사용한다.
* column단위 제약사항, table단위 제약사항 둘 다 사용가능하다.
* 하나의 테이블에서 unique 제약조건은 여러 column이 가질 수 있다.
* user_constraints에서 검색하면 constraints type은 U로 나온다.

```java
//column단위 제약사항
CREATE TABLE 테이블명(
column명 datatype(크기) CONSTRAINT 제약사항명 UNIQUE,//제약사항명은 대부분 UK_column 으로 설정 
,
,
)

//테이블 단위 제약사항
CREATE TABLE 테이블명(
column명 datatype(크기),
,
,
CONSTRAINT 제약사항명 UNIQUE(적용할 column명)
)
```



## CHECK

* column의 값을 원하는 형태로 받을 때 사용한다.

* 조건에 부합하는 데이터만 입력을 받을 때 사용하는 제약조건이다.
* 조건에는 기본연산자, 비교연산자등을 사용하여 CHECK에 조건을 부여할 수 있다.
* 제약사항명을 설정하지 않고, column 단위 제약사항으로만 설정
* user_constraints에서 검색하면 constraints type은 C로 나온다.

```java
column명 datatype(크기) CHECK (조건)
```



## NOT NULL

* column의 값을 반드시 입력해야 할 때 사용
* data를 입력할 때 column값을 입력하지 않으면 error, `입력을 강제한다`
* user_constraints에서 검색하면 constraints type은 C로 나온다.

```java
column명 datatype(크기) NOT NULL
```



## DEFAULT

* 제약사항은 아니지만 NULL이 입력되는 상황이 발생하면, 설정해 놓은 기본 값으로 추가되는 속성

```java
column명 datatype(크기) DEFAULT NULL일 때 입력될 값
```



## 조회

* USER_CONSTAINTS : 테이블에 설정된 제약사항 확인 DICTIONARY
* USER_CONS_COLUMNS : 테이블에 설정된 제약사항column을 확인하는 DICTIONARY
* USER_TAB_COLS : 테이블에 존재하는 COLUMN명, DATATYPE, 크기, DEFAULT 등을 확인할 수 있는 DICTIONARY 