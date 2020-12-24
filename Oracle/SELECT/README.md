# SELECT(DML)

* `테이블에서 모든 레코드, 특정 column을 조회 할 때 사용하게 된다.`

* Transaction의 대상 query가 아니다.(사용후 commit나 rollback를 사용할 필요가 없다.)

* SELECT의 query문을 사용하여 만들어진 view를 Inline View라고 한다.

  * Inline View에는 Alias가 적용되지 않는다.

* SELECT문에서 SUBQUERY로 여러 SELECT문이 겹쳐 있다면 사용자에게 보여주는 함수는 가장 바깥 SELECT문에 적용한다.
  ```
  SELECT 사용자에게 보여주는 함수의 위치 
    SELECT(
      SELECT(

      )
    );
  ```

  

## SELECT의 문법

* 문법

  * ```java
    SELECT column명
    FROM 테이블명
    WHERE절 // 특정 레코드를 검색할 조건을 부여한다.(연산자가 사용된다.)
    GROUP BY절 // GROUP화 (여러개의 레코드를 하나로 묶어서 하나로 만드는 것이다.)
    HAVING절 // GROUP로 묶일 조건을 설정.(단독으로 사용 될 수 없으며 GROUP BY와 같이 사용되어야 한다.)
    ORDER BY절 // 정렬 (레코드를 순서대로 조회할 때 기본값은 오름차순이다.)
    ```

    `SELECT와 FROM은 필수적으로 사용해야 한다.` (이 두가지만 사용하면 검색 대상은 전체 레코드이다.)

    SELECT와 FROM을 제외한 나머지 Option들은 생략 될 수 있지만 `사용될 때에는 반드시 순서를 지켜서 사용해야 한다.`

### Alias

* `column, table명에 대한 별명`
* 긴 column , table명에 별명을 부여하여 사용자지정으로 사용할 수 있다.
* column명의 Alias는 조회할 때 column이 변경되어 Inline View가 생성된다.
* SELECT에서 선언된 column명의 Alias는 붙어있는 WHERE절에서 사용할 수 없다. (`WHERE절에서 검색할 때 Alias를 넣어 검색할 수 없다.`) 
* Alias의 대,소문자를 구분해서 사용하려면 "Alias"를 사용하면 된다.

* 문법

```java
//방법 1
column명 Alias
//방법 2
colunm명 as Alias
//대,소문자 구분
column명 "Alias"
```



### SELECT절의 사용

* 예제 EMP TABLE

  

  ![](https://user-images.githubusercontent.com/74294325/102292473-900ff880-3f88-11eb-88b3-e0530ed52678.png)



### 테이블에서 특정 레코드만 조회하기 (WHERE절 과 연산자)

* ### 사원 테이블에서 직무가 'SALESMAN'인  사원의 사원명, 사원번호, 입사일, 연봉, 보너스, 직무를 조회하자.

```java
SELECT ENAME,EMPNO,HIREDATE,SAL,COMM,JOB
FROM EMP
WHERE JOB = 'SALESMAN';
```

* ### 논리 연산자를 여러개 사용할 때 비교대상끼리 ()를 사용하여 묶어서 사용할 수 있다.

  * 사원 테이블에서 부서번호가 10번, 20번이면서 연봉이 1000이상인 사원들의 사원번호, 사원명, 부서번호, 연봉, 입사일을 조회하자.

```java
SELECT EMPNO, ENAME, DEPTNO, SAL, HIREDATE
FROM EMP
WHERE (DEPTNO = 10 OR DEPTNO = 20) AND SAL > 1000;
```

* ### `NULL을 비교할 때에는 관계연산자로 비교가 불가능하다. IS NULL 과 IS NOT NULL을 이용하여 비교할 수 있다.`

  * 사원 테이블에서 보너스를 수령하지 않는 사원들의 사원번호 , 사원명 , 연봉, 보너스, 부서번호를 조회하자.

```java
SELECT EMPNO, ENAME, SAL, COMM, DEPTNO
FROM EMP
WHERE COMM IS NULL;
```

* ### `Between A AND B`를 사용할 수 있지만 속도면에서 논리연산자를 사용하는 것이 더 좋다.

  * 사원 테이블에서 연봉이 1000에서 3000사이인 사원의 사원번호, 사원명, 부서번호, 연봉, 입사일을 조회하자.

```java
SELECT EMPNO, ENAME, DEPTNO, SAL, HIREDATE
FROM EMP
WHERE SAL >= 1000 AND SAL <= 3000; // WHERE SAL BETWEEN 1000 AND 3000;
```

* ### WHERE절에 `함수 IN()을 사용하여 조건을 부여할 수도 있다. `(NOT IN() 함수도 있다.)

  * `IN() : 포함하는 , NOT IN() : 포함하지 않는`
  * 사원 테이블에서 7902, 7698, 7566 매니저가 관리하는 사원의 사원번호, 사원명, 매니저번호, 부서번호을 조회하자.

```java
SELECT EMPNO,ENAME,MGR,DEPTNO
FROM EMP
WHERE MGR IN(7902,7698,7566);
```

* ###  `같지 않음을 조회할 때에는 != , <>`

  * 사원 테이블에서 직무가 CLERK 가 아닌 사원의 사원번호, 사원명, 직무, 연봉, 입사일을 조회하자.

```java
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE
FROM EMP
WHERE JOB != 'CLERK'; // WHERE JOB <> 'CLERK';
```

* ### `SELECT문에서 산술연산자를 통해 연산 결과를 조회할 수 있다.`(SELECT문에서만 산술연산자 사용가능.)

  * null은 연산되면 결과가 null이 된다. (NVL함수로 이를 해결할 수 있다.)
  * Alias(별명)을 사용하여 column명을 지정하여 가독성을 높여주자
  * 사원 테이블에서  모든사원의 사원번호, 사원명, 부서번호, 연봉,  세금(연봉에 3.3%를 연산)을 조회하자.

```java
SELECT EMPNO,ENAME,DEPTNO,SAL,SAL*0.033 TAX
FROM EMP;
```

* ### || 문자열을 붙임. 조회결과를 문자열로 출력할 때.
  * 사원테이블에서 사원명, 사원번호를 조회하자.(출력은 [xxx]사원의 사원번호는[xxx]이다. 형식으로 출력)

```java
SELECT '['||ENAME||']사원의 사원번호는['|| EMPNO ||']'
FROM EMP;
```

* ### 문자열 연산자 LIKE

  * column의 값의 일부분만 알고 있어도 검색이 가능하다.
  * 대부분 '%' , '_'  와 같이 사용된다.
    * '%'는 문자열의 자릿수와 상관없이 사용이 가능하다.
    * '_'는 문자열의 자릿수를 알고 사용해야 한다.
  * 사원 테이블에서 사원명의 첫글자가 'A'로 시작하는 사원의 사원명, 사원번호를 조회하자.

```java
SELECT ENAME,EMPNO
FROM EMP
WHERE ENAME LIKE 'A%';
```


---

## DISTINCT

* SELECT문을 사용할 때 조회되는 `레코드의 중복값을 제거하는 명령어이다.`
* 중복 값을 가지고 있는 column 앞에 정의합니다.
* 중복값을 가진 column과 중복값을 가지지 않은 column을 함께 조회하면 중복배제가 되지 않는다.
  * DISTINCT를 사용할때에는 중복을 배재할 column만 사용한다.
* 문법

```java
SELECT DISTINCT COLUMN명
FROM TABLE명
,,,;
```

---

## GROUP BY

* GROUP BY절을 정의하여 그룹화할 column을 선택한다.
  * GROUP BY를 사용하여 중복값을 제거할 수도 있다.
  * 여러 행이 조회되는 Column과 같이 사용되면 그룹으로 묶여지지 않는다.
* `ERROR이 발생할 가능성이 있다.`
  * GROUP으로 묶이지 않은 column이 조회column에 직접 정의되면 ERROR)
  * `즉 GROUP BY에 정의된 column과 SELECT문에서의 column과 동일해야 한다.`
* 집계함수와 같이 사용되면 그룹별 집계를 얻을 수 있다.
  * ROLLUP 과 CUBE를 사용하여 중간 집계를 얻을 수 있다.
* HAVING절과 함께 사용되면 GROUP로 묶을 조건을 설정 할 수 있다.
* 문법

```java
GROUP BY GROUP으로 묶일 column명,,,,,,
```

## 집계의 총 집계를 얻을때

* 여러column이 그룹으로 묶이면 그룹별 결과, 중간결과 , 총합결과를 출력한다. 

## ROLL UP

* 집계 후 전체결과를 출력

```java
GROUP BY ROLLUP(column 명)
    
//EX
//사원 테이블에서 부서번호, 부서별 사원수, 연봉 합, 전체연봉합 조회
SELECT DEPTNO, COUNT(EMPNO),SUM(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO); //주어진 조건을 출력 후 마지막 레코드에 총합의 결과를 출력
```

* 예제

  <img src = https://user-images.githubusercontent.com/74294325/102568823-a43e2c00-4127-11eb-9c40-979d583a6179.png>

## CUBE

* 전체 결과 후 집계를 출력

```java
GROUP BY CUBE(column 명)
//EX
//사원 테이블에서 부서번호, 부서별 사원수, 연봉 합, 전체연봉합 조회
SELECT DEPTNO, COUNT(EMPNO),SUM(SAL)
FROM EMP
GROUP BY CUBE(DEPTNO); //총합의 결과를 출력 후 주어진 조건으로 출력
```
* 예제

  <img src = https://user-images.githubusercontent.com/74294325/102568845-b28c4800-4127-11eb-8005-aa2934380dfe.png>

---

## HAVING

* GROUP BY를 사용할때 같이 사용되며 묶인 GROUP가 조회될 때 조건을 부여할 수있다.

* HAVING절에서 집계함수를 이용하여 GROUP BY의 조건을 부여한다.

---

### ORDER BY

* 조회된 레코드를 오름차순(ASC), 내림차순(DESC)로 만들어 조회하는 것.

* 모든 Date는 정렬할 수 있다.

* Default 값은 오름차순이다.

* 문법

```java
ORDER BY COLUMN명 (ASC or DESC) , COLUMN명 (ASC or DESC),,,,
```

* 문자열이 숫자를 가질 때에는 자릿수 정렬.
```java
정렬 전   정렬 후
1         1
21        100001
1001      1001
300       21
29999     29999
100001    300
```
---





