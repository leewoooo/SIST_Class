Interface
===

* 추상class 보다 추상화의 단계가 높다, 상수와 abstract method만 가진다.<br>
**일반 method 또는 member변수를 가질 수 없다.**

* JDK 1.7부터 Interface에 업무를 구현할 수 있는 default method를 추가할 수 있다.
    * default method
        >-Interface 안에서 업무를 구현할 수 있는 method <br>
         -사용하려면 Interface 자체는 Instance화가 되지 않기에 is-a관계로 Instance를 생성해 사용.
        
    * 문법
         ```java
        접근지정자 default 반환형 method명(매개변수,,,,,,,){
        필요한 code들을 구현합니다.
        }
        ```
    * 구현하는 자식 class가 꼭 구현을 할 필요없다.

* 다중 상속의 장점을 사용하기 위하여 사용한다. = 여러개의 Interface 부터 상속 가능.<br>
 (다른 기능들을 가져다 쓰기 쉽다. 기능의 확장이 쉽다.)

* Class의 다중상속의 부모가 모호해지고 class의 크기가 필요이상으로 커질 수 있다는 단점을 가지고 있다. <br>
(인스턴스의 크기가 필요이상으로 커질 수 있다.)
    >-`이것을 보완하기 위해 Interface를 사용합니다.`

* 약결합을 구현하여 인스턴스 간의 유연성을 증가시키기위해 사용한다.<br>
(약결합 = 기능의 추가 제거가 간편하다)

---

### 구조 및 사용방법

* `Interface는 Instance화 할 수 없다.` (생성자가 없기 때문이다.)

* 상속을 받아 자식 class에서 `abstract method를 필수적으로 구현해야 한다.`<br>
 구현하는 class를 생성할 때는 extends 가 아닌 `Implements를 사용하여 class를 생성한다.`

* Interface 구조 (예제코드 [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.11)/Interface/TestSuper.java))
    ```java
    접근지정자 Interface 인터페이스명 {
        public static final 타입 상수이름 = 값; //상수만 가질 수 있다.
        public abstract 메소드이름(매개변수목록);
        //Interface 를 구현하는 class가 반드시 구현해야하는 method
    }

    //ex code
    public interface TestSuper {

    //int i; 변수를 가질 수 없다.
	public static final int MAX = 99999; //상수만 가질 수 있습니다.
	
	//public TestSuper() {}  생성자를 가질 수 없다.
	
	//public void test() {} 업무를 구현할 수 있는일반 method를 가질수 없다.
	
	public void methodA(); // abstract를 생략한 abstract method;
	
	public abstract void methodB(); // abstract를 사용한 abstract method;
	
	public abstract String name(); // abstract를 사용한 abstract method;
    }//class
    ```

* Interface를 구현하는 class의 구조 (예제코드 [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.11)/Interface/TestImpl.java)) 
    ```java
    public class TestImpl implements TestSuper {
	
	@Override
	public void methodA() {
		System.out.println("Override 한 methodA가 호출되었습니다.");
	}//methodA

	@Override
	public void methodB() { //abstract를 Override 할 때는 abstract를 뺀다.
		System.out.println("Override 한 methodB가 호출되었습니다.");
	}//methodA

	@Override
	public String name() {
		return "자신의 이름";
	}//name
	
	public void subMethod() {
		System.out.println("자식의 method");
	}
    ```





