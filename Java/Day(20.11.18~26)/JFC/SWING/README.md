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


* 사용 예시

	<img src = https://user-images.githubusercontent.com/74294325/99745064-431d3b80-2b1c-11eb-943f-95ba3b88c028.png>

	* setRolloverIcon 사용

	<img src = https://user-images.githubusercontent.com/74294325/99755484-3f92b000-2b2e-11eb-857a-d3c63aeeebb1.png>


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

### JTextArea (여러줄의 문자열을 입력 할 때)

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

	<img src = "https://user-images.githubusercontent.com/74294325/99677924-98763000-2abd-11eb-9908-e677c60e79a9.PNG" width ="250"  height = "250" >

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

	<img src = https://user-images.githubusercontent.com/74294325/99678253-f571e600-2abd-11eb-8f8b-daf9dd9224af.PNG width =250 height =250>

---

## 2020-11-20 내용추가

### JMenu , JMenuBar, JMenuItem 

* 고정된 위치에서 사용자에게 서비스를 제공할 때 사용한다.

	1. MenuBar : Menu들이 배치되어 제공되는 막대
	2. Menu : 비슷한 일을 하는 MenItem을 묶어서 제공하기위한 컴포넌트
	3. MenItem : 개별적인 일을 제공하기 위한 컴포넌트

	<img src =https://user-images.githubusercontent.com/74294325/99743247-a5743d00-2b18-11eb-9296-5a99cdfcfe01.png>


* 사용방법

	1. JMenuBar를 생성
		```java
		JMenuBar jb = new JMenuBar();
		```
	2. JMenu를 생성
		```java
		JMenu jm = new JMenu("대표이름");
		```
	3. JMenuItem을 생성
		```java
		JMenuItem jmi = new JMenuItem("서비스할 이름");
		```
	4. 생성된 JMenuItem을 JMenu에 배치
		```java
		jmi.add("메뉴 아이템 객체");
		jmi.add("다른 메뉴 객체"); // 메뉴아이템에서 하위 메뉴를 제공할 때

		//jmi에 구분선 넣기
		jmi.addseparator();
		```

	5. JMenuItem을 JMenu를 JMenuBar에 배치한다.
		```java
		Jb.add(메뉴객체);
		```

	6. MenuBar를 Window Component에 배치한다.
		```java
		setMenuBar(jb);
		```
	
	* 사용 예시

		<img src = https://user-images.githubusercontent.com/74294325/99744033-3dbef180-2b1a-11eb-821e-a9ee3621ec72.png>

---

### TitledBorder (JComponent 자식class는 전부 사용 가능)

* 테두리를 가진 제목을 설정하는 Component

* 대부분의 Component들은 Border를 가질수 있다.

* javax.swing.border package에는 테두리를 설정할 수 있는 Component가 존재한다.

* 사용방법
	```java
	//1.생성
	TitledBorder tb = new TitledBorder("타이틀");
	//2.Border가 필요한 컴포넌트에 생선한 border 설정
	JButton jbtn = new JButton();
	jbtn.setBorder(tb);
	```

---



### MVC Patten을 도입하여 제작된 컴포넌트들. (JCombo, JList,JTable)

### MVC Pattern (Model , View , Controller)
		
* Moder = 데이터를 관리하고 처리하는 일.

* View = 데이터를 보여주는 일.

* Controller = 이벤트 처리. 업무 로직(Business Logic: 연산,제어) 구현하는일.


* Model 1
	
	* 서로 다른 생명주기를 가진 업무가 하나의 파일에 존재한다.

	* 값의 사용이 쉽고 error처리가 편리하다. 개발 결과가 빠르게 나온다

	* 단점으로는 파일의 복잡도가 상승하고 파일을 수정할 때 다른 코드를 훼손의 가능성이 있다. <br> 
	(업무 분장이 어려워지고 코드수정이 어렵다.)

	

* MVC Pattern (Model2 방식의 개발)

	* `하나의 서비스를 분해하여 구현하기 위한 개발 방식(Design Pattern)`
	  >-코드의 복잡성이 낮아지고 책임이 명확해지며 업무를 구분하여 작성하기 좋다. <br>
	-`유지보수가 편해진다. (프로그램의 생명이 길어진다.)`
	
	* `생명주기가 서로 다른 작업을 분해하여 구현하는 방식`
		> (Model file, View file, Controller file) 3개의 파일을 관리한다.

	* 단점으로는 파일이 많아지고 관리가 복잡해진다, 값의 처리 및 error 처리가 복잡하다. 

---

* JcomboBox

	* 사용방법
		1. DATA를 가진 Model class를 만든다.
			```java
			DefaultComboBoxModel<E> dcbm = new DefaultComboBoxModel<E>();
			```
		2. Model Instnace에 DATA를 추가하자

			```java
			dcbm.addElememt("값");//값으로 배열을 받을수 있다.
			```
		3. DATA를 보여줄 View class 생성
			```java
			JComboBox jcb = new JcomboBox(dcbm);
			```

	* 사용예제

		<img src = https://user-images.githubusercontent.com/74294325/99751945-a4e2a300-2b26-11eb-8144-85dbfde4f145.png>

* JList (ScrollBar를 가지고 있지 않다.)

	* 사용방법

		1. DATA를 가진 Model class를 만든다.
			```java
			DefaultListModel<E> dlm = new DefaultListModel<E>();
			```
		2. Model Instnace에 DATA를 추가하자

			```java
			dlm.addElememt(값); //값으로 어떠한 타입도 받을수 있다.
			```
		3. DATA를 보여줄 View class 생성
			```java
			JList jl = new JList(dlm);
			```
		4. ScrollBar를 추가해준다.
			```java
			JScrollPane jsp = new JScrollPane(jl);
			```

	* 사용예제

		<img src = https://user-images.githubusercontent.com/74294325/99755326-d9a62880-2b2d-11eb-844b-7e2fcbc1a67f.png>


* JTable(데이터를 시안성을 높여 보여줄 때 사용한다.)

	* javax.swing.table package에서 DefaultTableModel을 제공

	* column명을 일차원 배열로 생성
		```java
		String[] columnNames={"column명","column명",,,,};
		```
	
	* DATA는 2차원 배열로 생성
		```java
		String[][] rowData={{"값","값","값",,},{"값","값","값",,}};
		```

	* 사용방법

		1. DATA를 가진 Model class를 만든다.
			```java
			DefaultTableModel dtm = new DefaultTableModel (rowData,columnNames);
			```
		2. Model Instnace에 DATA를 추가하자

			```java
			//배열
			String[] data = {"값",,,,};
			dtm.addRow(data);
			//Vector (is-a로 instance화를 사용하면 안된다.)
			Vector<E> vt = new Vector<E>();
			vt.add("값"); //column의 갯수만큼 add를 사용한다.
			dtm.addRow(vt);
			```
		3. DATA를 보여줄 View class 생성
			```java
			JTable jt = new JList(dtm);
			```
		4. ScrollBar를 추가해준다.
			```java
			JScrollPane jsp = new JScrollPane(jt);
			```

		* JScrollPane을 사용하지 않고 JTable을 직접 배치하면 Table의 Header가 보여지지 않는다.

		* 사용예제

			<img src =https://user-images.githubusercontent.com/74294325/99773269-8b098600-2b4f-11eb-98da-5c4bbd19b09f.png>

---

### 2020-11-25 추가된 내용

* JOptionpane

    * 간단한 대화창을 제공할 때 사용하는 class
    
    * ConfirmDialog, MessageDialog, InputDialog가 제공.

    * 사용법 = 객체를 생성하여 사용하지 않는다. (Static method사용)

    1. ConfirmDialog : 사용자의 의향을 물어볼 때 사용한다.(에/아니오, 확인/취소)

        ```java
        JOptionPane.showConfirmDialog(윈도우컴포넌트, "메세지");

        int flag =JOptionPane.showConfirmDialog(this, "창을 닫으시겠습니까?");
		
		switch (flag) {
		case JOptionPane.OK_OPTION: 
			dispose();
			break;
		case JOptionPane.NO_OPTION:
			System.out.println("아니오");
			break;
		case JOptionPane.CANCEL_OPTION:
			System.out.println("취소");
		}
        ```
        <img src =https://user-images.githubusercontent.com/74294325/100174320-8b1ed280-2f0f-11eb-826e-f756e8d1246f.png>

    2. MessageDialog : 사용자에게 단순 정보를 제공할 때.

        ```java
        JOptionPane.showMessageDialog(윈도우컴포넌트,"메세지");
        ```

        <img src =https://user-images.githubusercontent.com/74294325/100174977-e1404580-2f10-11eb-8183-d0c7bb5dcccb.png>

    3. InputDialog : 사용자가 입력하는 메세지를 받을 때.

        ```java
        String msg = JOptionPane.showInputDialog("메세지");
        ```

        <img src = https://user-images.githubusercontent.com/74294325/100175208-4ac05400-2f11-11eb-9ab9-bfa48b656047.png>

        * 변수로 받아 사용할 수 있다.
    

* JpasswordField의 값 String 얻기.
    
    ```java
    JpasswordField jpf = new JpasswordField();
    
    char[] pass = jpf.getPassword();
    //char[]은 다른 배열과는 다르게 출력하면 주소가 아닌 값이 나온다.

    /*
    문자열로 저장하는 법.
    1. 생성자 사용.
    String str = new String( pass );
    2. valueOf() 사용.
    String str = String.valueOf( pass );
    ```
---


* Font class의 사용

	* java.awt package에서 제공한다.

	* Non Visual Component로 컴포넌트의 폰트(글꼴, 크기 , 스타일) 정보를 병경해주는 일을 하는 class

	* 사용ex)

    	1. 객체를 생성한다.
        	```java
        	Font fnt = new Font("글꼴",스타일,크기);
     		```

    	* 글꼴 = Dialog, DialogInput, Monospaced, Serif, or SansSerif
        * 스타일 = PLAIN, BOLD, ITALIC(for example, bitwise BOLD|ITALIC)

        	```java
        	Font fnt = new Font("SanSerif",Font.BOLD,20);
        	```

    	2. font를 적용할 컴포넌트에 setFont()를 사용하여 생성된 font를 적용.

        	```java
        	JButton jbtn = new JButton();
        	jptn.setFont(fnt);
        	```
---

* color class의 사용

	* Non Visual Component로 컴포넌트의 글자색, 바닥색을 변경할 때 사용.

	* 몇가지 색은 상수로 제공을 한다. 복잡한 색은 RGB를 이용한 생성자로 정의한다.

        ```java
        //글자색(전경색) : Foreground Color
        jlbl.setForegound(Color.RED);
        
        //바닥색 : Background Color
        //투명도 설정이 되어있지 않은 component는 바로 적용
        //투명도 설정이 되어 있는 component는 투명도를 해제 해야한다.
        jibl.setOpaque(true);//투명도 해제
        jibl.setBackground(Color.RED);
        ```
---

## 2020-11-26 추가내용

<br>


## FileDialog

* java.awt pacakage에서 제공하는 window component이다

* 파일을 선택할 때 사용.

    <img src = https://user-images.githubusercontent.com/74294325/100293906-9124ba00-2fc8-11eb-82f2-7990a63d0693.png>


* Windows OS에서 사용하는 Dialog를 사용한다.

* 반드시 부모창(Window,Frame,Dialog)이 필요하다. 

* 사용ex)

    1. 생성
        ```java
        FileDialog fd = new FileDialog(Frame parent,String Title, int mode);
        //mode는 열기와 저장이 있다.
        //FileDialog에 있는 상수를 가져다 쓴다. LOAD, SAVE
        ```
    2. 사용자에게 보여주기
        ```java
        fd.setVisible(true);
        ```

    3. 선택한 폴더 얻기
        ```java
        String path = fd.getDirectory();
        ```
    
    4. 선택한 파일명 얻기
        ```java
        fd.getFile();
        ```

---

## Dialog

* Window Component이며 Window(Frame)에서 부가적인 정보를 제공할 때 사용하는 Window

* 주 기능(Frame) 부가적인 기능(Dialog)

* 메모장으로 예를 들면 메모를 하는 것이 주 기능이고 Font를 변경하는 것이 부가 기능이라 할 수 있다.

* Dialog가 활성화 되어있을 때 부모 창의 접근을 막는 것을 Modal이라고 한다.
    > 자식 창이 동작했을 때 부모 창의 선택을 허가하지 않는것. 생성자에서 boolean으로 관리

<br>

* 사용 ex1) (상속하지 않고 사용할 때, 배치되는 컴포넌트의 수가 적을 때)

    1. 생성 (Dialog Default layout은 BorderLayout)

        ```java
        JDialog jd = new JDialog(Dialog owner, String title, boolean modal);
        ```

    2. Dialog에 배치될 component를 생성한다.

        ```java
        Jbutton jb = new Jbutton("버튼");
        ```
    
    3. Dialog 배치

        ```java
        jd.add("Center",jb);
        ```

    4. Dialog의 크기 설정

        ```java
        jd.setBounds(x,y,w,h);
        ```

    5. Dialog를 사용자에게 보여주기

        ```java
        jd.setVisible(true);
        ```
    
    6. Dialog의 종료처리

        ```java
        jd.setDefaultCloseOperator(JFrame.DISPOSE_ON_CLOSE);
        ```
    
* 사용 ex2) (상속받아서 사용, 배치되는 컴포넌트가 복잡할 때)

    1. JDialog를 상속받는다. (Jpanel도 동일한 방법 사용가능, 각자 만들어서 하나로 붙일때 사용)

        ```java
        public class Test extends JDialog{
        ```
    
    2. 부모 창(Jframe을 상속받고 있는 class)과 Has - A 관계를 설정하는 생성자를 만든다.

        ```java
        public Test(ParentWindow pw){
            super(pw,"Dialog의 title", modla여부)
        ```
        
    3. Dialog에 배치될 component를 생성한다.

        ```java
        JButton jbtn = new Jbutton("버튼");
        ```
    
    4. 배치

        ```java
        add("Center", jbtn);
        ```
    
    5. Dialog의 크기설정

        ```java
        setBounds(pw.getX(),pw.getY(),w,h);
        //Dialog를 실행할 때 부모창 안에서 실행이 되어야 하기 때문에
        //부모의 실행 좌표 X,Y를 얻어오는 get() method를 호출해서 사용한다.
        ```
    
    6. 사용자에게 보여주기

        ```java
        setVisible(true);
        ```
    
    7. Window를 종료한다.

        ```java
        //Dialog를 닫을 때에는 EXIT_ON_CLOSE Constant를 사용할 수 없다. 
        setDefaultCloseOperator(JFrame.DISPOSE_ON_CLOSE);
        ```
---
