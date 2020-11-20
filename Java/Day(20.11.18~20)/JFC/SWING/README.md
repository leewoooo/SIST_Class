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
----

### 2020-11-19 내용추가

* Swing Component 사용법.

### JButton (눌렀을 때 지정된 기능을 수행하는 역할)

1. ImageIcon

	* 이미지 : ImageIcon class로 이미지를 손쉽게 사용할 수 있다.
	>-어떠한 Component의 생성자가 icon을 생성자의 매개변수로 받으면 사용이 가능하다.

	* API를 확인 후 각 Component의 생성자를 확인해보자.

	* code (JButton으로 예제)

	```java
	//1. ImageIcon Instance화: 이미지파일의 경로는 절대 경로(최상위 루트부터)를 사용한다.
	ImageIcon ii = new ImageIcon("이미지 파일의 절대경로");

	//2. 이미지를 사용할 Component에서 ImageIcon Instance를 설정한다.

	//2-1 생성자 이용
	JButton jb = new JButton(ii);

	//2-2 method를 이용
	jb.setIcon(ii);
	```

---

2. setToolTipText

	* 풍선 도움말이다. 이미지만 있을 때 설명이 부족할 수도 있어 마우스를 올리면 이미지에 대한 설명이 나온다

	```java
	jb.setToolTipText("풍선도움말 내용");
	```
3. setRolloverIcon

	* 마우스 포인터가 올라가거나 클릭을 하면 이미지가 변경된다.
	
	```java
	jb.setRollOverIcon("변경될 이미지 파일의 경로");
	```

---

### JLabel (컴포넌트의 정보 제공, 이름표의 역할)

* 선언 방법
	```java
 	JLabel jl = new JLabel("정보제공 내용");
	```

---

### JTextField , JPasswordField (한줄의 문자열을 입력받을 때 사용)

* JPasswordField는 반향문자(Echochar)를 사용하여 한줄의 문자열을 입력 받을 때
	>반향문자 = 입력된 문자대신 설정한 문자가 표현되는 것. 한글입력은 안된다.


* 선언방법
	```java
	JTextField jtf = new JTextField(n); //보여주는 글자수가 n글자인 크기의 JTextField;

	//1.생성)
	JPasswordField jpf = new JPasswordField(n); // 크기 설정 가능
	//2.반향문자 설정)
	jpf.setEchoChar(char c)
	```



---

### JTextArea (쳐러줄의 문자열을 입력 할 때)

* java.awt.TextArea : ScrollBar가 포함되어 제공된다.

* javax.swing.TextArea : ScrollBar가 포함되어 제공되지 않는다.
	>따라서 Contaier Component인 JScrollPane을 사용하게 된다.

	```java
	//1. 생성
	JTextArea jta = new JTextArea();

	//2.ScrollBar를 가져야하는 Component를 위해 JScrollPane을 제공.
	//JScrollPane은 ScrollBar기능만 지원한다.
	//스크롤 바를 가져야 할 컴포넌트를 생성하고 JScrollPane과 has-a 관계 설정.
	JScrollPane jsp = new JScrollPane(jta); 
	
	//3.배치
	add(jsp);
	```

* 입력된 문자열이 TextArea의 열의 범위를 넘어가면 줄을 바꿔주는 역할을 하는 method
	```java
	jta.setLineWrap(Boolean b); //단어 보호의 기능은 없다.
	```
* 줄을 바꿀 때 단어가 보호가 되게하는 method (space를 기준으로 단어라 생각하며 한글은 지원 x)
	```java
	jta.setWrapStyleWord(Boolean b);
	```


* TextComponent의 예

	<img src = "https://user-images.githubusercontent.com/74294325/99677924-98763000-2abd-11eb-9908-e677c60e79a9.PNG" width ="300"  height = "300" >

---

### JCheckBox , JRadioButton

1. JCheckBox

	* 여러개의 선택지 중 중복 선택을 해야 할 때

	```java
	JCheckBox jcb = new JCheckBox("메세지"); //체크box가 해제된 상태로 제공
	JCheckBox jcb = new JCheckBox("메세지",boolean); //boolean으로 체크여부 선택
	```

2. JRadioButton

	* 여러개의 선택지 중 하나만 선택해야 할 때
	```java
	JRadioButton jcb = new JRadioButton("메세지"); //체크box가 해제된 상태로 제공
	JRadioButton jcb = new JRadioButton("메세지",boolean); //boolean으로 체크여부 선택
	```
	* `ButtonGroup에 포함되어야 여러개 중 하나만 선택 가능한 상태가 된다.`
	```java
	ButtonGroup bg = new ButtonGroup();
	bg.add(RadioButton instance);
	```

* CheckButton의 예

	<img src = https://user-images.githubusercontent.com/74294325/99678253-f571e600-2abd-11eb-8f8b-daf9dd9224af.PNG width =300 height =300>
