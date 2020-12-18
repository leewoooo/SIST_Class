# FUNCTION(함수)

* 자주 사용될 코드를 미리 구현해놓고 필요한 곳에서 호출하여 사용한다.
  * 중복되는 qurey문을 줄일 수 있다.
* Oracle에서 `function은 간접호출을 해 사용한다.`
  * 실행기(excute)를 사용하지 않고 query문에 넣어 사용하는 것.
  * DML( INSERT, UPDATE, DELETE, SELECT )에서 사용할 수 있다.
* Oracle에서 제공하는 함수와 사용자 정의 함수( PL/SQL에서 정의 )가 있다.

---


## 수치 함수

### ABS

* `절대값`을 반환한다.

```java
SELECT ABS(숫자 값)
FROM TABLE명;
```



### ROUND

* 값을 `반올림`해서 반환해준다.
* INDEX를 이용하여 반올림하여 볼 자리수를 지정하여 준다.
  * 자릿수를 지정하지  않으면 소수점 첫번째 자리에서 반올림하여 정수 부를 조회한다.

```java
SELECT ROUND (값, index)
FROM TABLE명;

//EX 실수 반올림
SELECT ROUND(15.193 , 1) //소수점 두번째에서 반올림하여 첫번째 소수점까지 표시
FROM DUAL; //결과로는 15.2가 조회된다.

//EX 정수 반올림
SELECT ROUND(15.193, -1) //일의 자리에서 반올림하여 보여준다.
FROM DUAL; //결과로 20이 조회된다.
```


### CEIL

* 값을 `올림`해서 반환해준다.
  * 올려야 할 자리의 값이 0인 경우 올림 처리를 하지 않는다.

```java
SELECT CEIL(값)
FROM TABLE명;

//EX
SELECT CEIL(15.7)
FROM DUAL; //결과로 16이 조회된다.
```



### FLOOR

* 값을 `내림`해서 반환해준다.
  * 내려야 할 자리의 값이 0인 경우 내림 처리를 하지 않는다.

```java
SELECT FLOOR(값)
FROM TABLE명;

//EX
SELECT FLOOR(10.9)
FROM DUAL;
```



### TRUNC

* `절삭`하여 값을 반환해준다.
  * 소수부 - 절삭할 다음 자리를 버림
  * 정수부 - 해당 자리를 버림

```java
SELECT TRUBC(값,index)
FROM TABLE명;

//EX 소수 절삭
SELECT TRUNC(15.79,1)
FROM DUAL; //결과로 15.7이 조회

//EX 정수 절삭
SELECT TRUNC(15.79,-1)
FROM DUAL; //결과로 10이 조회
```



### MOD

* 나머지 값을 반환해준다.

```java
SELECT MOD(값 , 나눌 수)
FROM DUAL;

//EX
SELECT MOD(10, 3)
FROM DUAL; //결과로는 1이 조회
```

---


## NULL 변환함수

* `column의 값이 null일 때 다른 값으로 변환해주는 함수`

### NVL

* 조회결과가 NULL일 때 다른 값으로 변환하는 일
* `NULL일 때 변환되는 값은 column의 DataType과 동일해야 한다.`

```
NVL(값, null일 때 변환될 값)

//EX
SELECT NVL(COMM , 100)
FROM EMP;//comm의 조회 값이 null이면 100으로 변환하여 조회된다.
```

### NVL2

* `조회결과가 있다면 A을, 조회값이 null인 경우 B를 반환하는 함수`

```java
NVL(값, NULL이 아닐 때 보여줄 값, NULL일 때 보여줄 값)

//EX
SELECT NVL2('','있다','없다'),NVL2('A','있다','없다')
FROM DUAL;//comm의 조회 값이 있으면 '있다'을 조회 null이면 '없다'로 변환하여 조회된다.
```

---

## 문자열 함수

### LENGTH

* `문자열의 길이를 반환하는 함수`

```java
LENGTH('값...')
    
//EX
SELECT LENGTH('오늘은 목요일 입니다')
FROM DUAL; //결과로 11조회
```

### CONCAT

* 두 개의 문자열을 합칠 때 사용하는 함수 (||와 같은 기능)

```java
CONCAT('문자열', '합칠 문자열')
```

### INITCAP

* `첫 글자를 대문자로 변환하는 함수`
  * 입력되는 문자열이`전부 대문자라면 첫글자만 대문자 나머지는 소문자로 반환`
  * `공백이 있는 문자열이 들어가면 공백 이후에 있는 첫글자를 대문자로 변환`

```java
INITCAP('문자열')

//EX
INITCAP('hello') // 결과로 'Hello'가 조회된다
INITCAP('HELLO') // 결과로 'Hello'가 조회된다
INITCAP('i am a boy') // 결과로 'I Am A Boy'가 조회된다    
```

### UPPER / LOWER

* UPPER : 모두 대문자로 변환하는 함수
* LOWER : 모두 소문자로 변환하는 함수

```java
UPPER('문자열')
LOWER('문자열')

//EX
UPPER('HELlo') // 결과로 'HELLO'가 조회된다
LOWER('HELlo') // 결과로 'hello'가 조회된다
```

### INSTR

* `특정 문자의 INDEX를 얻기`
* Oracle의 INDEX는 1부터 시작이다.(찾고자 하는 문자가 없을시 0이 반환된다.)
* INDEX를 얻을 문자열이 한 글자가 아닌 문자열이라면 문자열의 첫 글자의 INDEX를 얻는다.

```java
INSTR(column명,'INDEX를 얻을 문자열')
```

### SUBSTR

* `문자열을 자를때 사용하는 함수`
* 자를 글자수를 입력하지 않으면 시작INDEX부터 문자열 끝까지 자른다.

```java
SUBSTR(column명, 시작INDEX, 자를 글자수)
    
//EX
SELECT SUBSTR('AbcdeF',2,4)
FROM DUAL; // 결과로 bcde가 조회된다.  
```

### REPLACE

* 문자열 치환
  * 공백을 제거할 때에도 사용이 가능하다.

```java
REPLACE(column명,'찾을 문자열','치환할 문자열')

//EX
SELECT REPLACE('오늘은 금요일 입니다','오늘은','내일은')
FROM DUAL; //결과는 '내일은 금요일 입니다'가 조회
```

### TRIM , LTRIM, RTRIM

* TRIM : 문자열의 `앞, 뒤 공백을 제거`한다.
  * TRIM('지울 문자열' FROM '문자열')  앞뒤로 문자열에 붙어있는 지울 문자열들을 지워준다.
* LTRIM : 문자열의 `앞 공백을 제거`한다.
* RTRIM : 문자열의 `뒷 공백을 제거`한다.

```java
TRIM(column명)
    
//EX
SELECT TRIM('  A B C  ')
FROM DUAL; // 결과는 'A B C'가 조회된다.   

SELECT LTRIM('  A B C  ')
FROM DUAL; // 결과는 'A B C  '가 조회된다. 

SELECT RTRIM(' A B C  ')
FROM DUAL; // 결과는 '  A B C'가 조회된다. 
```

### LPAD, RPAD

* LPAD : `문자열 앞에 문자열을 채워 지정한 길이의 문자열을 만들 때.`
* RPAD : `문자열 뒤에 문자열을 채워 지정한 길이의 문자열을 만들 때.`
* 한글로 채울때는 한글  한 글자에 2byte로 처리된다. (2byte가 확보되지 않으면 PADING되지 않는다.)
* `모든 Data의 값을 같은 자릿수로 만들때도 사용할 수 있다`

```java
LPAD(column명, 전체 글자수 , 채울 문자) //column의 값이 전체 글자수가 되지 않는다면 지정한 채울 문자로 채운다.
RPAD(column명, 전체 글자수 , 채울 문자) //column의 값이 전체 글자수가 되지 않는다면 지정한 채울 문자로 채운다.

//EX
LPAD('ABC',10,'#') //결과는 '#######ABC'가 된다.
RPAD('ABC',10,'#') //결과는 'ABC#######'가 된다.
```

---

## 조건함수

### DECODE

* PL/SQL에서 사용할 수 없다.
* column의 값과 비교값이 같다면 그에 해당하는 반한값을 반환하고 비교 값과 같은 값이 없다면 비교값이 없을 때 반환되는 값이 반환
* DECODE는 반환값의 길이가 짧을 때 주로 사용하게 된다.
* CASE문과 기능이 동일하다.

```java
DECODE(column명,비교값,반환값,비교값,반환값,,,비교값이 없을 때 반환값) //column의 값이 비교값과 같으면 그에 해당하는 반환값이 나간다.
    
//EX
DECODE(1,1,'일',2,'이''없음')//결과는 '일'이 조회된다.
```

### CASE

* DECODE와 기능은 동일하며 반환값의 길이가 길 때 주로 사용하게 된다.
* 조회하는 column에 사용.

```java
CASE column명 
			WHEN 비교값 THEN 실행코드
			WHEN 비교값 THEN 실행코드
            ,
            ,
            ELSE 비교값이 없을 때 실행코드
END

//EX
SELECT CASE 'java' WHEN 'java' THEN '완벽한 OOP언어'
									WHEN 'HTML' THEN 'MARKUP LANGUAGE'
									WHEN 'JavaScript' THEN 'Toy Language'
									ELSE '언어의 정보가 없습니다.'
		END  LANGUAGE
FROM DUAL;
```
---

## 변환 함수

### TO_CHAR() 

* 문자가 아닌 DataType을 문자로 바꾼다. (날짜-> 문자열,  숫자 -> 문자열)

* 날짜

  * Pattern ( y - 년, m - 월, d - 일, h - 시,  mi - 분, s - 초, am - 오전,오후 , dy - 월, day - 월요일, q - 분기)
  * hh - 12시간 표현, hh24 - 24시간 표현
  * 월,일,시,분,초 는 pattern에 넣을 때 2개씩 넣어줘야 한다.
  * Date가 아닌 값을 Pattern에 넣을 때에는 " "를 붙여준다.
  * Pattern이 너무 길어지면 ERROR발생 이를 해결하기 위해서는 TO_CHAR을 두개로 작성해 CONCAT 이나 || 로 이어준다.

  
  
* 숫자

  * Pattern( 0 - pattern , 9 - pattern)

```java
//날짜 -> 문자열
TO_CHAR( 날짜, 'Pattern' )

//EX
SELECT TO_CHAR(SYSDATE,'yyyy-mm-dd am(hh24):mi:ss dy day q"분기"')
FROM DUAL;
     
//숫자 -> 문자열
TO_CHAR( 숫자, 'Pattern' )
    
// 0 : 해당자리에 데이터가 존재하지 않으면 0을 출력한다.
SELECT TO_CHAR(2020,'0,000,000')
FROM DUAL; //결과는 0,002,020

// 9 : 해당자리에 데이터가 존재하는 것만 출력한다.
SELECT TO_CHAR(2020,'9,999,999')
FROM DUAL; //결과는 2,020
```


### TO_DATE()

* 날짜형식의 문자열을 날짜로 변환해준다.
* Pattern ( y - 년, m - 월, d - 일, h - 시,  mi - 분, s - 초, am - 오전,오후 , dy - 월, day - 월요일, q - 분기)

```java
TO_DATE('날짜형식의 문자열', 'Pattern')

//EX    
SELECT TO_DATE('2020-12-17' , 'yyyy-mm-dd')
FROM DUAL;    
```


### TO_NUMBER

* 숫자형식의 문자열을 숫자로 변환해준다.
* 숫자로 바꿀 수 없는 문자열이 들어가면 ERROR 발생

```java
TO_NUMBER('숫자형식의 문자열')

//EX
SELECT TO_NUMBER('486')
FROM DUAL; //결과는 486이 조회된다.
```



## 집계 함수

* column 중 같은 값을 묶어서 하나로 만드는 함수. 하나의 레코드로 결과가 나온다.
* GROUP BY와 같이 사용하면 그룹별 집계를 얻을 수 있다.
* `WHERE절에서 사용할 수 없다.`
* 종류는 SUM, COUNT, MAX, MIN 등의 함수가 제공된다.
* `여러행이 조회되는 컬럼과 함께 사용되면 ERROR이 발생한다.



### COUNT

* column의 레코드의 갯수를 반환하여준다.
* column의 값이 null값인 경우 count 되지 않는다.
* *을 쓰면 null이 아닌 값들을 가져와 count해준다.

```java
COUTN(column 명)

//EX
SELECT COUNT( EMPNO )
FROM EMP; //결과는 EMPNO의 레코드 값중 null을 뺀 갯수가 반환된다.    
```



### SUM

* column의 값을 합쳐서 반환하는 함수

```java
SUM(column 명) //column의 값의 Datatype은 NUMBER이여야 한다.
```



### AVG

* column에 존재하는 모든 레코드의 평균값을 반환하는 함수.

```java
AVG(column 명) //column의 값의 Datatype은 NUMBER이여야 한다.
```



### MAX

* column에 존재하는 모든 레코드의 값 중 제일 큰 값을 반환.

```java
MAX(column 명) //column의 값의 Datatype은 NUMBER이여야 한다.
```



### MIN

* column에 존재하는 모든 레코드의 값 중 제일 작은 값을 반환

```java
MIN(column 명) //column의 값의 Datatype은 NUMBER이여야 한다.
```



### GROUP BY 와 집계함수 함께쓰기

* GROUP로 묶은 것에 대한 Date 처리

```java
//EX
//사원테이블에서 부서번호,부서별 인원조회 , 부서별 연봉의 합
SELECT DEPTNO,COUNT(ENAME),SUM(SAL)
FROM EMP
GROUP BY DEPTNO;
```



## 순위함수

* 조회되는 column값에 순서를 부여하여 조회할 때
* ORDER BY와 함께 사용된다. (함수 안에서 사용된다.)
* PARTITION BY를 사용할 수 있다.
  * PARTITION BY로 나눈 영역마다 순위를 부여한다.

### RANK() OVER()

* 같은 순서가 발생한다.

```java
RANK()OVER(OREDER BY 정렬할 column명)
```

### ROW_NUMBER() OVER()

* 같은 순서가 발생하지 않는다.
* 주로 ROW_NUMBER()OVER()을 사용하여 순위를 구한다.

```java
ROWNUMBER()OVER(OREDER BY 정렬할 column명)
```



## 날짜함수



### ADD_MOUTHS

* 날짜에 월을 더할 때 사용.

```java
ADD_MONTHS(날짜,더할 개월 수)
```



### MONTHS_BETWEEN()

* 두 날짜간 개월의 차이

```java
MONTHS_BETWWEN(날짜1,날짜2) // 두 날짜간 개월의 차이(앞 날짜에 큰 날짜, 뒷 날짜에 작은날짜) //사용은 마지막 로그인 기록과 현재로그인 기록을 비교할 때 등등...
```



### LAST_DAY()

* 마지막 날을 구할 수 있는 함수.

```java
LAST_DAY(날짜) //입력한 날짜에 대해 그 달의 마지막 날짜를 알 수있다.
```

