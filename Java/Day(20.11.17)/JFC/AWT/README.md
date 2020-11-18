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
    
    | Component | 기능 |
    | :---: | :---|
    | Button |클릭하여 일을 한다 |
    | Label |이름표 역할|
    | TextField| 한줄의 입력을 받을 때 |
    | TextArea | 여러줄의 입력을 받을 때 |
    | List | 여러개의 item을 사용할 때 |
    | ButtonGroup | 버튼을 묶을 때 사용 |
    | CheckBox | 여러개의 항목을 선택 할 때 |
    | CheckBoxGroup | CheckBOX를 묶어서 하나만 선택되도록 할 때 (동시선택 X)|
    | choice | 여러개의 item중 하나만 선택하게 할 때 (회원가입창 핸드폰 번호 앞자리 선택|
---


### 2020-11-18 추가 내용


* AWT Window Component의 종료 이벤트 처리

    * 2020-11-17에 작성한 code를 이용하면 프로그램 종료를 할 수 없다.

    * addWindowListener method 호출
        * addWindowListener(WindowListener l)
            >-WindowListener는 Interface이다.<br>
            -Interface는 상수와 abstract method만 가지고 있으며 Instance화가 되지 않는다.

    * method의 parmeter가 interface일 때 method를 호출하는 방법
           
         1. Interface를 구현한 class를 만들고 Instance화 하여 Instance를 넣는다.

         2. anonymous inner class를 만든다.
            ```java
            addWindowListener (new WindowListener(){

                //WindowListener의 abstract method Override...

                });
            ```    
            * 지금과 같은경우는 WindowListener의 abstract method를 전부 Override해야 하기에 비효율 적이다.
                
                
                
                
    * WindowClosing method를 Override 받아 사용

        * WindowListener interface를 미리 구현한 class인 WindowAdapter를 사용한다.
        * WindowAdapter class는 WindowListener의 7개 추상 method를 일반 method로 구현했기에 필요한 method만 Override하여 사용

        * Window의 닫기를 눌렀을 때 실행되는 method는 WindowClosing이므로 method안에 dispose()를 넣어준다.
            >dispose(); = Frame과 그 위에 포함된 모든 컴포넌트를 OS에게 반납하고 닫아준다. 하나의 Frame을 닫을 때 사용

        ```java
        addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			dispose();
		    }; 
		});
        ```
                
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


            //11-18에 추가된 code
            addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
		        }; 
		    });


        }//test

        public static void main(String args[]){

            new test();

        }//main

    }//class    
    ```
