AWT
===

* Component의 기능만 제공한다.
    >ex) 버튼이 존재한다. <br>
    AWT는 버튼의 용도는 알 수 있어도 버튼의 생김새는 알 수 없다. 
* Component들은 운영체제(OS)의 도움을 받아 화면에 출력한다.
    > **`AWT 컴포넌트는 운영체제에 의존적이므로 OS환경에 따라 다르게 구현될 수 있다.`**

* java.awt Package에서 관련 Class를 제공합니다.

---

### Component의 종류

1. window Component
    * 사용자에게 보여줄 때 사용한다. 
    * window, Frame , Dialog , FileDialog를 주로 사용한다.

2. Container Component
    * 일반 component를 담거나 Container Component를 담아서 배치할 때 사용.
    * panel , ScrollPane를 주로 사용한다.
3. Component
    * 기능을 가지는 최소한의 단위들
    * Button(클릭하여 일), Label(이름표), TextField(한줄의 입력을 받을 때), TextArea(여러 줄의 입력을 받을 때), 
    List(여러개의 item을 사용할 때), ButtonGroup(버튼을 묶을때 사용), CheckBox(여러개의 항목을 선택 할 때),
    CheckBoxGroup(CheckBox를 묶어서 하나만 선택되도록 만들 때 , 동시선택X) ,Choic(여러개의 item중 하나만 선택하게 할때, ex-회원가입창 핸드폰번호 앞자리 선택)
    
---

### 코딩 순서

* Window Component를 상속 받습니다.
    >window Component중에 Frame을 상속받아 window 및 Frame의 기능을 사용한다.

    ```java
    public class test extends Frame{
    
    //생성자를 정의, 사용할 Component를 생성한다.
        public test(){
            //2-1. component를생성한다.
            Button b = new Button("버튼");
            //2-2. 배치를 한다. (Container Component or Window Component 사용)
            add(b);

            //사용자에게 보여줄 Window의 크기를 설정한다.
            setSize(W,h);
        
            //사용자에게 보여주기
            setVisible(true);

        }//test

        public static void main(String args[]){

            new test();

        }//main

    }//class    
    ```


