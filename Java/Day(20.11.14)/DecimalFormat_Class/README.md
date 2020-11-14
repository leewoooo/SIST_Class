

DecimalFormat Class
===

* 숫자를 원하는 format을 사용하여 문자열로 반환합니다. (가독성 향상 효과)

* java.text package에 존재한다.
    >예를들어 쇼핑몰 가격을 웹에서 보여주는 형식을 지정할 때.

## 사용법

* Instance를 생성한다.

    ```java
    DecimalFormat df = new DecimalFormat("pattern");
    ```
    -pattern 에는 # 과 0 이 들어갈 수 있다.
    > (#) = 값이 있을때에만 출력한다. <br>
    > (0) = 값이 있다면 값을 출력하고 값이 없다면 0을 출력한다.

* 형식에 따른 문자열을 얻기
    > format method를 이용합니다.

* method 호출 방법
    ```java
    df.format(정수or실수);
    ```

* 예제
    ```java
    DecimalFormat df = new DecimalFormat("#,###");
    df.format(2020); // => "2,020"

    DecimalFormat df2 = new DecimalFormat("0,000,000.000");
    df2.format(12345.123456) // => 0,012,456.123
    ```
* 예제설명
    > pattern에 #,### 이 들어갔고 df.format(); 에 2020을 넣어서
    실행하면 "2,020"을 반환해준다.<br>
    .(dat)을 사용하여 소수점이하 자리를 설정해줄수 있다.
