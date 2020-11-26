Event Handling
===

## Event

* 사용자 동작에 따른 준비된 코드를 만들어 실행 시키는 것.

* java.awt.event 패키지, javax.swing 패키지 에서 관련 클래스를 제공한다.

* Swing component는 AWT의 이벤트 처리 객체를 사용하게 된다.

* 종류

    이벤트 종류 | 처리 Listener(interface) | 주 적용component |
    :---: | :---: | :---:
    Action event(버튼을 클릭,textcomponent에서 enter가 쳐졌을때) | ActionListener | Button, Text Component
    window event(window component에만 처리) | WindowListener | Frame, Window , Dialog
    keyboard event(text component) | Key Listener | Text Component
    Item event(item을 갖는 component) | Item Listener | java.awt.List, Choice
    List selectionevent(swing component) | javax.swing.event | JList, JcomboBox
    Mouse event(모든 component적용) | Mouse Listener | 모든 component에 적용
---

## Event 처리 방법

1. event를 처리할 Listener을 구현한다.

    * ex)버튼을 클릭 했을 때 이벤트를 처리할 것이다.
        
        ```java
        public class Test extends JFrame implements ActionListener{
        ```

2. 추상 method를 Override한 후 이벤트가 발생했을 때 제공할 기능 구현

    * ex)

        ```java
        @Override
        public void actionPerformed(ActionEvent ae){
        // 이벤트가 발생했을 때 제공할 기능 구현.
        }
        ```

3. Component를 event에 등록시킨다.

    * event에 등록하는 method = add 사용할Listener(사용할Listener)
    * ex)
        ```java
        Button btn = new Button("버튼");
        btn.addActionListner(this);
    
---

## IS -A 관계로 이벤트 처리 순서

1. Window component를 상속, event처리 Listener를 구현
    
    ```java
    public class Test extends JFrame implememts ActionListener{

2. event처리와 관계있는 component를 instance 변수로 선언한다.

    ```java
    private Button btn;
    ```
3. 생성자를 정의하고 Component를 생성한 후 이벤트에 등록(이벤트처리와 관계 있는것)

    ```java
    public Test(){
        //컴포넌트 생성
        btn = new JButton("버튼");

        //컴포넌트를 이벤트에 등록
        btn.addActionListner(this);
    }
    ```
4. 추상 method를 Override한 후 event 발생시 제공할 코드 작성

    ```java
    public void actionPerformed(Action ae){
        //이벤트 발생시 제공할 기능의 코드들
    }
    ```
---

## 이벤트 비교

* 이벤트를 발생시킨 component에 대한 비교.

* 위치: 이벤트 처리 method안에서 진행한다. (Override method안)

* 순서ex)

    1. 이벤트를 등록

        ```java
        btn.addActionListener(this); // -> actionPerformed
        tf.addActionListener(this); // -> actionPerformed

    2. 이벤트 처리 method에서 매개변수로 입력되는 객체(Action)를 사용하여 비교.

        ```java
        public void actionPerformed(ActionEvent ae){

            //매개변수로 입력되는 이벤트 객체는 이벤트를 발생한 객체의 주소를 얻을 수 있다.
            if(ae.getSource() == btn){//이벤트를 발생시킨 객체의 주소가 btn과 같은지 비교
                
            }
            if(ae.getSource() == tf){//이벤트를 발생시킨 객체의 주소가 btn과 같은지 비교
            
            }
        }
        ```

---

## HAS - A 관계로 이벤트 처리 순서

* 디자인을 구현한 class와 event를 처리하는 class를 구분하여 만들 수 있다.(여기서 발전한 것이 MVC)

* 디자인 class를 생성한다.

    1. Window component를 상속받는다.
        ```java
        public class Test extends JFrame{
        ```
    
    2. event 처리대상 component를 선언 한다.
        ```java
        JButton btn;
        ```
    
    3. 생성자를 작성 하고 component를 생성한다.
        ```java
        public test(){
            btn = new JButton("버튼");
        }
        ```

    4. event 처리 객체를 생성하고 이벤트를 등록한다. (여기서 이벤트 class생성)
        ```java
        TestEvt te = new TestEvt(this);//has a
        btn.addActionListener(te);
        ```

    5. event처리 클래스에서 디자인 클래스이 컴포넌트를 처리하기 위해 getter 작성
        ```java
        public Jbutton getBtn(){
            return btn;
        }
        ```



* 이벤트 class를 생성한다.
    
    1. event객체를 구현한다.
        ```java
        public class TestEvt implement ActionListener{
        ```

    2. 디자인 calss를 인스턴스 변수로 선언
        ```java
        private Test t;
        ```

    3. 생성자에서 디자인 클래스의 객체를 전달받는다.
        ```java
        public TestEvt(Test t){
            this.t =t;
        }
        ```

    4. 추상 method를 Override 한다.
        ```java
        public void actionperformed(ActionEvent ae){
        //이벤트가 발생했을 때 처리할 코드.
        //현재 예제같은경우 has-a관계가 성립되었기에 버튼이 클릭되었을 시 처리할 코드 제공
        }
        ```

---

## Window Event

* Adapter Design pattern

    * 추상 method를 하나 이상 가지고 있는 이벤트 처리용 interface를 미리 구현해 놓은 추상 calss

* WindowListener을 구현하여 처리하면 7개의 method를 구현해야한다. <br>
하지만 나는 WindowClosing method하나만 사용할려한다. 이 때 Adapter Design pattern을 이용한다.

* WindowListener -> Windowadpter

* Windowadpter를 상속받아 WindowListener의 자원을 사용하자.

---


## 2020-11-26 추가내용

<br>


## Key event

* Text Component에서 사용 (JTextField, JPasswordField, JTextArea)

* 키보드의 key가 눌렸을 때 동작하는 event이다.

* keyListener은 Interface이며 3개의 method를 가지고 있다 keyListener를 구현한 KeyAdapter를 사용한다.

* 사용ex)

    1. keyListener를 구현한다. or KeyAdaper를 상속한다.

        ```java
        public class Test extends JFrame implements KeyListener{
        ```

    2. abstract method Override.

        ```java

         @Override
        public void KeyPressd(Key Event){
            //key가 눌려지는순간에 처리해야할 일.
        }

        @Override
        public void KeyType(Key Event){
            //키가 눌려서 문자가 입력되는 순간에 해야할 일
        }

       

        @Override
        public void KeyReleased(Key Event){
            //눌린 키가 올라오는 순간에 해야 할 일
        }
        ```

    3. TextComponent를 Event에 등록시킵니다.

        ```java
        jtf.addKeyListener(Event를 처리할 Instance);
        ```
    
* KeyEvent로 눌린 key의 keycord와 key문자를 얻을 수 있다.

    ```java
    int keycord = ke.getKeyCode(); //유니코드로 반환
    char key의 문자 = ke.getKeyChar(); //문자로 반환
    ```
* keyCode는 ASCII code가 아니고 키보드의 키를 식별하기 위한 고유의 값.

* ASCII code는 소문자와 대문자를 식별하기 위한 다른 코드 값을 같는다. a(97) A(65)

* Keycode는 a와 A의 값은 동일하다 같은 key를 사용하기 때문이다. a(65) A(65)

---

## Mouse Event

* Mouse Adapter을 상속받던 anonymousclass를 만들어 사용한다.

* addMouseListener에 등록하여 사용한다.


---





