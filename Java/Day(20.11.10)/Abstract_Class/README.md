Abstract class
===

* 상속을 강제하는 class이다. (추상 클래스란 구체적이지 않은 클래스를 의미한다.)
* Instance화가 되지 않는 class 이다.(abstract method는 직접 호출이 불가능)<br>
  `사용을하려면 자식class를 만들어 상속 후 자식 class를 Instance화 하여 사용`
  
* Abstract method를 가지고 있으며 Abstract method는 body가 없습니다. <br>
  `자식 class가 가져야하는 기능들을 정의할 수 있다.`

* Abstract class를 상속받은 자식 class는 반드시 Abstract method를 구현해야 한다.

* Abstract method 이외에도 body가 있는 method 및 변수를 가질 수 있습니다.

### 구조 및 사용방법.

1. Abstract class의 구조
    ```java
    접근지정자 abstract class class명 (extands 부모class 명 implements 구현할 inteface...) {
    
    변수 (Instance 변수, Static변수)
    
    //(Instance method, Static method)
    public void methodA{
    
    }//methodA

    //method에 body가 없는 추상 method를 가진다.
    public abstract void methodB();
    
    }//class
    ```

    >-Abstract class의 접근지정자 = public package

2. Abstract method의 구조
    ```java
    접근지정자 abstract 반환형 method명(매개변수...);
    ```
    >Abstract method의 접근지정자 <br>
    -접근지정자는 `private을 줄 수 없다`. (default도 같은 package라는 제약조건이 있기에
    잘 사용하지 않는다.) <br>
    -`final 사용 불가.(자식class에서 override 해서 사용하기 때문이다.)`

3. Abstract method의 사용

    * 상속을 강제한다. 구현에 강제성이 있는 method
    * 추상class를 상속받으려면 자식 class에서 추상class의 추상 method를 반드시 override하여 사용한다.
    >-`method의 body가 없기 때문에 상속받아 override해서` 정의하여 사용. <br>
    -`자식 class가 구현 해야만 하는 일의 목록을 만들 때` 사용한다.