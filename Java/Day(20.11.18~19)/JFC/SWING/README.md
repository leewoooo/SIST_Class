SWING
===

* AWT와 호환이 된다.

* package는 javax.swing에 존재한다.
    >javax의 의미는 추가된 package를 의미한다.<br> (기존기능을 갱신, 갱신할 필요 없는 기능은 기존의 기능을 사용한다 = 호환.)

* **`Os마다 동일하게 보여지며 작업이 OS에게 의존적이지 않다.`**


### 기본적인 사용방법

```java
//1. javax.swing.JFrame을 상속받는다.
@SuppressWarnings("serial")
public class UseSwing extends JFrame {
	
	//2. Default Constructor 생성
	
	public UseSwing() {
		super("JFrame을 사용하여 Window Application 제공하기");
		
		//3. 일반 Component생성
		Button btn = new Button("AWT의 버튼");
		JButton jbtn = new JButton("SWING의 버튼");
		
		//4. 배치 (Component를 붙임)
		//배치 관리자 : Layout Manager를 사용하여 Component를 배치한다.
		
		setLayout(new GridLayout(1, 2)); //1행 2열을 설정한다.
		add(btn);
		add(jbtn);
		
		//5. Window의 크기
		setSize(400, 200);
		
		//6.윈도우 Component를 사용자에게 보여주기
		setVisible(true);
	
		//Window를 종료하자
		//사용하지 않으면 window를 닫아도 Instance가 작동하고 있다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}//UseSing 
	

	
	public static void main(String[] args) {
		
		new UseSwing();
		
	}//main

}//class
```


