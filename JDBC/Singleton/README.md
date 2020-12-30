# Singleton pattern

Singleton 패턴은 자바에서 많이 사용한다.<br>
먼저 싱글톤이란 어떤 클래스가 최초 한번만 메모리를 할당하고(Static) 그 메모리에 객체를 만들어 사용하는 디자인 패턴을 의미한다.<br>
즉 생성자의 호출이 반복적으로 이뤄져도 실제로 생성되는 객체는 최초 생성된 객체를 반환 해주는 것이다.<br>

* 장점

  * Memory를 절약할 수 있다.
  * 객체가 항상 생성 되어있기 때문에 속도가 빠르다.

* 단점

  * 객체가 소멸되었을 때 더 이상 사용할 수 없다. (코드를 구현해서 해결해야 한다.)

  * 객체의 역할이 간단한 것이 아닌 역할이 복잡한 경우라면 해당 싱글톤 객체를 사용하는 다른 객체간의 결함도가 높아져서 객체 지향 설계 원칙에 어긋나게 된다. (개방-폐쇄)


* 작성방법
  1. class의 객체를 class 내부에서만 생성할 수 있도록 만든다. -> 생성자의 접근지정자를 private으로 한다.
  2. 객체를 반환하는 method를 만든다. -> getInstance() 
  3. 객체를 반환하는 method 안에서는 객체를 하나만 생성하여 반환할 수 있도록 만든다.


```java
//lazy init 형식
public class instance {
    //Instance
    private static instance i;

    //private construct
    private instance() {}

    public static instance getInstance() {
      if(i == null){ //객체가 생성이 되어있지 않거나 객체가 소멸되었다면
        i = new instance();
      }
        return instance;
    }
}
```