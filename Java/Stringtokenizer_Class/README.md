StringTokenizer
===
* StringTokenizer Class 예제코드 [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.12)/Stringtokenizer_Class/UseStringTokenizer.java)
* `문자열을 Token 단위로 잘라서 문자열 하나하나씩 얻어 낼 수 있다`.
* `Pointer의 개념을 이용`하며 지정한 문자열을 기준으로 잘라낼 수 있다.<br>
  (기본은 space를 기준으로 잘라낸다.)
* StringTokenizersms Class는 java.util pacakge에 존재하기에 사용하려면 import 받아 사용.
    ```java
    java.util.StringTokenizer //문자열을 Token으로 나누는 일(문자열을 자르는 일)
    ```

## 사용방법
- StringTokenizer Class를 Instance화 하여 사용. (import를 받아야 사용이 가능하다.)
    >API를 확인해 abstract class인지 확인한다. <br>
    (StringTokenizer Class는 abstract class 아님)

* 예제 문자열   
    ```java
    String str = "오늘은^목요일^입니다." (^는 spcae)
    //pointer를 지정 초기 Pointer의 위치는 문자열 맨 앞이다. Pointer의 진행방향은 --->
    //한번 진행방향으로 흐르면 다시 돌아오지 않는다.
    ```
    
* Instance화 (import를 받아 Instance를 만들어 사용)
    ```java
    StringTokenizer stk = new StringTokenizer("문자열", "지정문자열,"boolean");
    ```
    > 문자열: Token단위로 자를 문자열<br>
      구분문자열: Token을 자를 때 기준이 되는 문자열 (복수 지정 가능) <br>
      boolean: 구분문자열의 삭제 여부 (true: 구분문자열 보호 , false :구분문자열 삭제)
    ```java
    StringTokenizer stk = new StringTokenizer(str);
    //현재 상태에는 Token의 존재를 모른다.
    ```
*  StringTokenizer Class에서 주로 쓰는 method

    >토큰의 수 (현재 pointer의 위치를 기준으로 Token의 갯수를 int형으로 반환
    ```java
    stk.countTokens(); :int 
    //결과는 3
    ```

* 토큰의 존재 여부 (Token을 가지고 있는지 boolean형으로 반환)
    ```java
    stk.hasMoreTokens(); :boolean
    //결과는 true
    ```

* 토큰의 값을 얻고 pointer를 다음 Token으로 이동
    ```java
    stk.nextTokens() : String
    //사용할 때 마다 Token의 값을 얻고 pointer의 위치는 다음 Token으로 이동
    ```
* 문자열을 자르고 배열에 넣을 때 
    ```java
    String[] temp = new String[stk.CountTokens];//token의 갯수로 배열선언
    int flag = 0; //배열에 값을 넣어야 하기에 index 역할을 할 변수 선언.    
    while(stk.hasMoreTokens()){
      temp[flag] =stk.nextTokens;//값을 얻고 배열에 값을 입력 후 Pointer 이동
      flag++;
    }
    ```
    1. stk.hasMoreTokens()은 Token의 존재 여부를 물어보기에 Token이 있으면 true값을 반환.<br><br>
    2. while문에 있는 nextTokens로 Token의 값을 얻고 배열에 값을 입력한다. <br><br>
    3. while문의 조건식이 false되면 반복문 탈출<br>
    (Token의 존재여부를 모르기에 시작과 끝을 알지 못할때 사용하는 반복문 while문을 사용.)
    

- --

### 문자열의 split method 와 StringTokenizer의 차이점


* 문자열의 split method

    * 사용방법 
    ```java
    (문자열변수 or 문자열).split("구분문자열");
    ```
    * split method 특징
    1. 특정 문자로 구분하여 배열로 얻는일. (특정문자를 .(dat)으로 지정할 수는 없다.) <br>
    
    2. .(dat)을 특정문자로 자르려면 정규식형태로 사용 [.] <br>
    
    3. 특정문자를 한개 이상만 지정할 수 있다.

    4. 지정한 특정 문자는 보호가 되지 않는다.
    
* 예제 
    ```java
    String str = "안녕,하세요,오늘은,목요일"; //
    csv data (comma separated Value) - 원천 DATA ,가공하여 사용한다.
    
    str.split(","); => 결과: {안녕,하세요,오늘은,목요일}
    ```
