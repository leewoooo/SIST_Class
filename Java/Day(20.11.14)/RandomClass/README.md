
Random Class
====
 - Random Class 예제코드 [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.14)/RandomClass/UseRandom.java)
 - `난수를 생성하기 위해` 만들어진 Class
 - `java util package`에 속해있다.
 - 다음수가 예측이 가능하다는 단점을 가지고 있다. Random(long seed)를 사용해 보안가능

## 사용법

- Instance생성 : Instance를 생성하면 난수가 생성이 된다.

  ```java
  Random r = new Random();
  ```

### 난수 얻기
<br>

#### 정수 

  - int형의 MIN_VALUE부터 MAX_VALUE 범위의 값중 1개가 나온다.

    ```java
      r.nextInt();
    ```

  -  내가원하는 범위에서 난수를 발생시킬때 %를 사용한다.

     (수없이 많은 수를 내가 원하는 범위로 축소 시킬때 %를 사용한다.)

      ```java
      //ex) 0~9
      Math.abs(r.nextInt()%10); // %를 사용하면 추출되는 난수가 0~9범위로 줄어든다.
      ```

  - Math Class 및 abs Method를 사용하고 싶지 않다면 

     ```java
      r.nextInt(int bound) 를 사용하여 bound 값에 범위를 넣어준다.
      ```

#### 실수 
  - 실수의 경우 또한 정수와 동일하다.
     ```java
      r.nextDouble(); 
      ```
