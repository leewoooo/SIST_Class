문자열을 다루는 class
==
## 문자열을 다루는 class
---
* String Class 예제코드[code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.12)/String_Class/UseStringBuilder.java)
### java.lang.String 

* String의 주소를 저장 할 class(string = 문자열 저장소) 

<br>

* `짧은 문자열`을 다룰 때 사용하며 문자열저장소에서 찾은 후 사용하기에 느리다. <br>
(찾는 이유는 문자열 저장소에는 같은 문자열은 하나만 존재하기 때문이다.) 

<br>

* method를 호출하여 일을 하면 `원본 문자열에 영향을 끼치지 않는다.`

<br>

### java.lang.StringBuffer (JDK 1.0) , java.lang.StringBuilder(JDK 1.5)

* 긴 문자열을 다룰 때

<br>


* `속도 개선을 위해 memory(heap)에 문자열을 직접 생성한다.`<br>
(문자열을 직접 생성하여 사용하기에 같은 문자열이 존재한다. `객체마다 문자열을 따로 생성하고 각각 사용합니다.`)

<br>

* method를 호출하여 일을 하면 `원본 문자열에 영향을 끼친다.`

<br>

#### java.lang.StringBuffer 와 java.lang.StringBuilder의 차이점

* java.lang.StringBuffer
    > `Multi Thread에서 동시 접근이 안된다.` = 동기화 처리가 되어있다. <br>
    (하나의 Thread에서 사용을 하고있으면 lock을 걸어 다른 Thread에서 사용하지 못하게 한다.)

<br>

* java.lang.StringBuilder
    >`Multi Thread에서 동시 접근이 가능하다.`(동기화가 되어있지 않다.)

<br>

* 대부분 `java.lang.StringBuilder를 사용한다.`

<br>
   
### 짧은 문자열과 긴 문자열의 차이점

* 짧은 문자열
    ```java
    "안녕하세요";
    ```
* 긴 문자열 
    ```java
    "안녕" + "하세요";
     //(문자열에 +를 이용하여 문자열을 더했을때 Compiler가 String을 String StringBuilder로 바꿔준다.)
    ```

<br>

### StringBuilder의 사용.

* 대부분의 String class method를 지원

<br>

1. Instance화
     ```java
    StringBuilder sb = new StringBuilder();
    //(stack에 sb가 올라가고 아직 값할당이 되지않은 heap의 시작주소를 sb가 가지고 있는다.)
    ```

<br>

2. 값 추가 (append)

   * append method를 가지고 값을 덭붙인다. return값은 StringBuilder이다.
        ```java
        sb.append("안녕");
        sb.append(11);
        sb.append("월");
        sb.appernd(true);
        ```
        >여기서 Instance를  새로 만들어 동일한 순서로 값을 넣어 줬을 때<br> 
        만들어진 sb의 문자열을 가져와서 사용하는 것이 아니라 또 다시 새로운 문자열을 만든다.
    
    * method chain의 형태
        >append의 반환형이 StringBuilder이므로 chain형식으로 가능
        ```java
        sb.append("안녕").append(11).append("월").append(true)
        ```

<br>

3. 값 삽입(insert (index,값))
    * 원하는 위치에 원하는 문자열을 삽입 할 수 있다.
        ```java
        sb.insert(2,"하세요") => 결과 = "안녕하세요11월true"
        ```
        >삽입하는 값의 datatype은 (정수,실수,문자.boolean,문자열) 가능하다 <br>
        삽입되는 자리에 있던 값은 뒤로 밀린다.

<br>

4. 값 삭제(delete(시작index, 끝index +1))

    * 원하는 부분의 문자를 삭제 할 수 있다.
        ```java
        sb.delete(5,8) => 결과 = "안녕하세요true"
        ```
        >끝 index에 +1 하는 이유는 끝에 null을 포함하고 있기 때문에

<br>

5. 문자열 뒤집기 (reverse())
        ```java
        reverse(sb) => 결과 = "eurt요세하녕안"
        ```

<br>

6. StringBuilder 의 값을 문자열로 얻기
    * toString method 이용
        ```java
        String s = sb.toString();
        ```

---

## 추가 내용

* String class의 SubString()

```java

String.subString(start index); //문자열을 start위치부터 문자열의 끝까지를 추출

String.subString(start index, end index); //문자열을 start위치부터 end전까지 문자열 추출

//ex
String str = "ABCDEFG"
//index A=0, B=1, C=2, D=3, E=4, F=5, G=6

str.subString(3); //결과는 DEFG* 

Str.subString(3,6) //결과는 DEF* 

//*은 끝문자를 의미한다.
```