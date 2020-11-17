Work(2020.11.17)
===
Work내용

---

### 과제내용

### 1번과제

* "년 - 월 - 일 요일 오전/오후 시:분:초" 형식의 날짜 정보를 출력한다.
* 실행 할 때 마다 한국,영국,미국,중국,일본중 날짜 형식으로 출력되도록 만들어보세요 

* 과제 완료 [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/HomeWork/day1117/HomeWork1117.java)

* 내가 한 방식

    ```java
    public Locale randomnation() {
		int flag = (int)(Math.random()*5+1); //1~5까지의 난수를 발생시킴
		switch(flag) {
		case 1:
			this.nation = "한국";
			return Locale.KOREA;
		case 2:
			this.nation = "영국";
			return Locale.UK;
		case 3:
			this.nation = "미국";
			return Locale.US;
		case 4:
			this.nation = "중국";
			return Locale.CHINA;
		default :
			this.nation = "일본";
			return Locale.JAPAN;
		}//switch
	}//random nation
    ```
    >switch case문을 사용하여 난수의 값마다 Locale의 나라 지정

* 강사님의 review

    ```java
    Locale[] nation = new Locale[] {Locale.KOREA,Locale.UK,Locale.US,Locale.CHINA,Locale.JAPAN};
	String[] nation2= new String[] {"대한민국","영국","미국","중국","일본"};
	int flag = (int)(Math.random()*5+1); //1~5까지의 난수를 발생시킴
	```
    >배열을 이용하여 발생시킨 난수를 배열의 index로 사용하여 코드를 간편화 시켰다.

---

### 2번과제

1. 아래와 같은 데이터를 List에 추가하여 반환하는 method 를 작성하세요.<br>
 "Java-James Gosling:1995"<br>
 "Oracle-Larry Ellison"<br>
 "Python-Guido van Rossum:1991"<br>
 "HTML-Tim Berners, LEE:1995"<br>
 "JavaScript-Brandan "<br>


2. 위의 method를 호출하였을 때 반환되는 리스트를 받고, 해당 리스트를 입력값으로  받아 아래와 같이 출력되는  method를 작성하세요.

	| 항목 | 핵심개발자 | 개발년도 |
	| ---|---|---|
	| java | James Gosling | 1995 |
	| Oracle | Larry Ellison | 알수없음 |
	| Python | Guido van Rossum | 1991 |
	| HTML | Tim Berners, LEE | 1995 |
	| JavaScript | Brendan  Eich | 알수없음 |
