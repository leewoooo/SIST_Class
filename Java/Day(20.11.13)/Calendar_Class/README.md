
calendar
===
* Calendar 예제코드 [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.14)/Calendar/UseCalendar.java)
* `단편적인 날자 정보를 얻을 때` 사용한다.
* `Instance가 되지 않습니다.`
* 날짜 정보를 얻기 위해 Constant를 사용합니다.


## 사용법
* Is-A Instance 생성
    ```java
      //1.Is-A Instance를 하여 사용할 수 있다.
      Calendar c = new GregorianCalendar();

      //2.Instance를 얻는 method를 사용 = getInstance();
      calendar cal = calendar.getInstance();
    ```


* 날짜 정보를 얻을 때는 `get method`를 사용합니다. 
    >ex) calendar instance .get(Field); (Field = Constant 사용의 이유는 가독성 향상입니다.)
    <br>
    >get method는 반환형이 int이다. Field는 API를 참고해서 사용한다. =>Calendar.Field
* code
  ```java
  //연도를 얻을 때 - YEAR Field 사용
   cal.get(calendar.YEAR);// => 2020

  //월을 얻을 때 - MOUTH Field 사용
  cal.get(calendar.MOUTH)+1;
  //java에서는 달을 0~11월까지 표현한다. 그렇기에 사용자가 보기좋게 +1을한다.

  //일을 얻을 때 - DAY_OF_MOUTH Field 사용
  cal.get(calendar.DAY_OF_MOUTH); // =>13

  //요일을 얻을 때 - DAY_OF_WEEK Field 사용
  cal.get(calendar.DAY_OF_WEEK);// => 6(금요일)
  //요일은 1(일요일)~7(토요일)
  ```

* 요일의 이름을 사용하고 싶으면
<br>
요일들의 이름을 넣은 `배열들을 만든후`
  <br>
cal.get(calendar.DAY_OF_WEEK)에서 반환된 값을 가지고 요일의 이름이 들어있는 배열의 열을 호출한다.

* code
  ```java
  String[] weektitle = {"일요일", "월요일" ,,,,,}
  weektitle[cal.get(calendar.DAY_OF_WEEK) -1]; //-1의 이유는 배열 처음 index가 0이기 때문
  ```

## 날짜 변경

* set() 사용
* cal.set(field , value)
    >field는 변경하고자 하는 값이 의미하는 Constant<br>
    >value는 변경하고자 하는 값

* code
  ```java
  //생성
  Calendar cal = Calendar.getInstance();
  (cal은 현재 날짜 정보를 가지고있다.=> 2020 11 13 )

  //변경
  cal.set(Calendar.YEAR,2019); // 년도를 2019년도로 바꾼다.

  cal.set(Calendar.MONTH,5-1); // 월을 5월로 바꾼다.(바꾸고 싶은 월 -1 )

  cla.set(Calendar.DAY_OF_MOUTH, 31) //일을 31로 바꾼다.
    ```
