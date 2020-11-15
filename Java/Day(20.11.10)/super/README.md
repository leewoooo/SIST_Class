Super
===

* Super가 사용되는 방식은 2가지 방식이 있다.
    1. key word 방식.
    2. method 방식.

1. key word 방식

    * super 키워드는 부모 클래스로부터 상속받은 필드나 메소드를<br>
     자식 클래스에서 참조하는 데 사용하는 참조 변수입니다.

    * 문법
        ```java
        Super.변수명; or Super.method명;
        ```
    * Instance영역에서만 사용이 가능하며 부모 Instance 시작 주소를 저장하고있다.

    * 부모class와 자식class가 같은 이름의 변수 or ,method를 가지고있는 경우 <br> 식별하여 호출때 사용한다.

    * 예제 code

        * 부모 class
            ```java
            class Test{

            int i;
            int j;

                public void usevari(){
                    system.out.println( i + "/" + j);
                }//usevari
            }//Test
            ```
        * 자식 class
            ```java
            class TestSub extends Test{

            int i;

                public void useI(){
                    system.out.println(i + "/" + super.i);
                }//useI

                public static void main(String[]args){
                    TestSub ts = new TestSub();
                    ts.useI();
                }//main
            }//class TestSub
            ```
            > -자식 class에서 i변수를 호출 할 시 i 앞에 this가 생략되어있다.<br>
                -만약 부모 class의 i변수를 호출 할 시 super keyword를 사용한다.

2. method 방식

    * this() 메소드가 같은 클래스의 다른 생성자를 호출할 때 사용된다면,<br>
     `super() 메소드는 부모 클래스의 생성자를 호출할 때 사용됩니다.`

    * 문법
        ```java
        super(); or  super(매개변수);
        ```

    * method방식은 생성자의 첫번째 줄에서만 사용이 가능하다.

    * 모든 class의 생성자 첫줄에는 super();가 생략되어 있다.
        >-상속받지 않는 class는 Object를 상속받고 있기 때문이다.(java의 기본은 상속)

    * class를 Instance화 시킬 때 부모 class의 생성자가 먼저 호출
        > 부모class의 생성자가 호출된 후 자식 class의 생성자 호출

3. Memory 자료구조

    * 부모를 상속받아 자식 class를 인스턴스화 시킬때
        1. 부모 class의 Instance 변수가 먼저 heap에 올라간다.
        2. 자식 class의 Instnace 변수가 부모 class 변수 위에 올라간다.

    * 이후 Instance변수를 호출 할때는 this , super를 이용한다.