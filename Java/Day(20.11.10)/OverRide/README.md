Override (Over riding)
===

* OOP 언어의 특성중 다형성에 속한다 (method의 다형성)

<br>

* 상속 관계를 기반으로 하며 부모 clss의 method중 자식class 에게 사용용도가 맞지 않을 때<br>
자식 class에서 부모 class의 method를 재 정의하여 사용합니다.

<br>

### Over ride의 조건

1. 접근지정자는 광의의 방향으로만 변경 가능
    >부모 class의 접근 지정자 보다 더 큰 범주에 속하는 접근 지정자로만 변경가능

2. 부모 class에서 Over ride가 예상되는 method의 접근 지정자는 private이 불가능.
    >private은 같은 class에서만 자원을 공유하기 때문에 부모class에 것을 자식class 사용 불가능    

3. 사용방법
* 자식 class에서 부모class와 동일한 method를 정의한다.

* `부모class와 Data type , method명 ,매개변수의 Data type 및 갯수는 동일해야한다.`

* 자식 class를 가지고 Instance를 만들어 Override 한 method를 호출시<br>
`부모의 class의 method가 아닌 Override method가 호출된다.` (override를 최우선 호출)

    * 부모 class [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.10)/OverRide/code(super))

        ```java
        /**
         * 부모 class : 자식 class의 정보가 저장되지 않습니다.
         * @author owner
        */
        public class OverrideSuper {

	    public void methodA() {
		System.out.println("부모가 코드를 구현한 methodA");
	    }//methodA

	    public void methodB() {
		System.out.println("부모가 코드를 구현한 methodB");
	    }//methodB

        }//class
        ```
    * 자식 class [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.10)/OverRide/code(sub2))

        ```java
        /**
        * OverrideSuper의 자식 class
        * 자식class에서는 부모class를 알 수 있다.
        * 자식class가 객체화 되면, 부모class가 먼저 생성되고 난 후
        * 자식class가 생성된다. (자식class를 instance화 하면 부모 생성자 먼저 호출하고 자식 생성자 호출)
        * 그렇기 때문에 부모의 모든 기능을 사용 할 수 있다. (public protected)
        * @author owner
        */

        public class OverrideSub2 extends OverrideSuper {

	    /**
	     *Override 된 method:
	     *Override 규칙 : 접근지정자는 달라도 되고 (광의의) , 반환형 ,method명 , 매개변수는 같아야합니다.
	     */

	    @Override
	    public void methodA() {
		System.out.println("OverrideSub2 class 에서 Override 한 methodA");
	    }//methodA

	    @Override
	    public void methodB() {
		System.out.println("OverrideSub2 class 에서 Override 한 methodB");
	    }//methodB

	    public void childMethod() { // is - a 관계의 instance화가 되었을 때는 사용 X
		System.out.println("자식의 method입니다.");
	    }

        }//class

