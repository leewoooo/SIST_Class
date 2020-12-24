# VIEW

* 실제 테이블을 사용하지 않고 조회를 수행 할 때.
* 단순 VIEW, 복합 VIEW를 지원.
  * 단순 View : 테이블 하나에서 도출 된 view (함수나 수식을 포함하지 않고 단순한 column으로만 도출 된 view), `DML수행 가능` 수행 결과가 실제 도출된 테이블에 반영된다.(만약 DML 사용이 안된다면 WITH CHECK OPTION 을 부여하여 DML을 사용)
  * 복합 View :  여러 테이블에서 도출 된 view (함수나 수식을 포함하여 도출된 view). DML불가

* 복잡한 query를 단순화 하여 조회 할 수 있다.
* 실제 테이블에 DML작업이 발생하면 View에 바로 반영된다.
* 권한이 부여된 계정만 VIEW를 생성할 수 있다.
* VIEW를 조회할 때 USER_VIEWS를 이용
* 생성 및 변경

```java
CREATE OR REPLACE VIEW VIEW명(column명,,,) AS (SELECT,,,) //새로 생성 or 존재하면 수정
```

* 삭제

```java
DROP VIEW VIEW명;
```

