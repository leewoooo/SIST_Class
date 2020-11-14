java util
===
* Date Class 예제코드[code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.14)/Date_Class/UseDate.java)
## 날짜 관련 class

### 1.Date
* 시스템의 날짜를 얻을 때 사용한다.
* `혼자 쓰여지지 않고 SimpleDateFormat과 같이 사용된다.`
* `SimpleDateFormat은 날짜의 형식제공`.(java.text pacakge에 있다.)

#### Date의 사용
* Data Class의 Instance 생성

 ```java
 //1. 생성
Date D = new Date(); //시스템의 날짜 정보를 저장하는 Instance가 생성
 ```

### 2.SimpleDateFormat
* 날짜의 형식을 제공해준다.(형식만 가지고있고 data는 없다.)
* java text pacakge에 존재하기에 import를 받아서 사용.

#### SimpleDateFormat사용
* SimpleDateFormat Class의 Instance 생성

```java
//1.생성
 SimpleDateFormat sdf = new SimpleDateFormat("pattern");
```

* pattern
>pattern을 설정 하면 설정한 pattern 대로 출력된다.<br>
>pattern에 API를 참고하여 Letter의 값을 넣어준다.

```java
//2.날짜 정보를 넣어 형식의 날짜를 얻는다.
 sdf.format(new Date()); //String type으로 정보를 반환한다.
```

**자주 사용하는 Date and Time Patterns**
|Letter|Date or Time Component|Presentation|Examples
|:----|:----:|:-----:|:----:|
|연도|y|Year|1996; 96|
|월|M|Week year|July; Jul; 07|
|일|d|Day in month|10|
|시|h|Hour in am/pm (1-12)|11|
|오전/오후|a|Am/pm marker|AM|
|분|m|Minute in hour|30|
|초|s|Second in minute|55|
|요일|E|Day name in week|Tuesday; Tue|

<br>

-ex) pattern에 yyyy-MM-dd 를 넣으면 2020-11-13일이 반환된다.

-다른 언어의 날짜형식을 보여줄려면 Locale class를 사용한다.<br>
>ex) //new SimpleDateForMat("pattern", Locale.나라별constant);
