Lambda(람다)
===

* Lambda식은 간단히 말해 메소드를 하나의 식으로 표현한 것입니다.

* Lambda를 작성할 때 유의해야 할 사항

    1. 매개변수의 타입을 추론할 수 있는 경우에는 타입을 생략할 수 있습니다.

    2. 매개변수가 하나인 경우에는 괄호(())를 생략할 수 있습니다.

    3. 함수의 몸체가 하나의 명령문만으로 이루어진 경우에는 중괄호({})를 생략할 수 있습니다. (이때 세미콜론(;)은 붙이지 않음)

    4. 함수의 몸체가 하나의 return 문으로만 이루어진 경우에는 중괄호({})를 생략할 수 없습니다.

    5. return 문 대신 표현식을 사용할 수 있으며, 이때 반환값은 표현식의 결괏값이 됩니다. (이때 세미콜론(;)은 붙이지 않음)

* java에서 Lambda는 Interface를 편하게 사용할 수 있는 문법으로 주로 사용된다.


* 구현 class없이, abstract method를 Override 하지 않아도 Interface를 사용할 수 있다.


* JavaSE 8 (JDK 1.8)에서 부터 지원한 문법이다.

* Interface 중 abstract method가 하나인 경우에만 Lambda식을 사용할 수 있다
<br>
(SAM / Single Abstract Method -> @FuncationalInterface)

* Interface를 정의할 때 Interface 위에 @FuncationalIterface를 사용하면 Interface는 SAM으로만 작성될 수 있다.

---
## 문법

* code
    ```java
    Interface명 객체명 = (prarmeter,,,,)->{ code작성 }; 
    ```

    * prarmeter를 지정하는 부분은 Abstract method의 parameter을 정의하는 부분이다.

    * code 작성하는 부분은 Abstracet method를 구현하는 부분이다.

    * 이 두 부분을 합친 것이 Interface의 Abstracet method를 Override하는 부분이다.

* Example

    ```java
    //Lambda로 구현할 Interface
    public interface Test{
        public void test();
    }

    //Lambda
    Test t =()->{System.out.println("Override")};
    

    //Lambda로 구현할 Interface
    public interface Test{
        public String myName(String name);
    }

    //Lambda
    Test t =(String name)->{String inputName = name; return inputName;};

    //호출할 때
    t.myName("Happy");
    ```

---
