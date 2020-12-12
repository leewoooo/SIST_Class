Math class
===
* Math Class 예제코드[code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.12)/Math_Class/UseMathClass.java)
* Math class는 java lang package에 존재하기에 사용하려면 import 받아 사용.


## 사용방법

* `생성자가 없는 class 진짜 없는 것이 아닌 private으로 생성자가 정의되어있다.`<br>
`따라서 instance화 하여 사용할 수 없다`.(instance method가 존재하지 않음.)

* `static method만 구성되어 있습니다.`<br> 
(static method로만 구성되어 있기에 method 호출시 class명.method명)
    ```java
    Math.method명(매개변수...);
    ```

### 자주 쓰이는 Math class의 method들
---

* 절대값을 얻는 method
    ```java
    Math.abs(수); // 결과: 수의 절대값
    ```
* 반올림을 얻는 method
    ```java
     Math.round(실수); // 결과: 실수 첫번째 자리에서의 반올림한 정수형 값 반환
    ```
* 올림을 얻는 method
    ```java
    Math.ceil(실수); => 결과: 실수 첫번째 자리에서 올림하여 double 값 반환
    ```
* 내림을 얻는 method
    ```java
    Math.floor(실수); => 결과: 실수 첫번째 자리에서 내림하여 double 값 반환
    ```   
* 소수점을 절삭하는 방법
    ```java
    실수형인 datatype을 casting하면 됩니다.
    ```
* 난수를 반환하는 method
    ```java
    Mate.Random(); => double값을 반환하며 반환 값은 0.0<= x <1.0 의 값이다.
       
    //사용방법
    (int)(Math.Random * 범위); => 결과: 지정한 범위안에 있는 정수의 난수를 얻음.
    //ex
    //1~5까지의 범위에서 난수를 추출
	"1~5 범위의 난수:" + (int)((d * 5)+1)); //(형변환)(발생한 수 * 범위)
    ```
