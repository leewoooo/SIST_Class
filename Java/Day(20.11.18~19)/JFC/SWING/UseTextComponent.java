package day1119.textcomponent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//1. Window 컴포넌트를 상속받는다.
@SuppressWarnings("serial")
public class UseTextComponent extends JFrame {

	//2.생성자를 작성한다.
	public UseTextComponent() {
		super("텍스트컴포넌트의 사용");

		//3.컴포넌트를 생성합니다.
		
		JLabel jlblID = new JLabel("ID");
		JTextField jtfID = new JTextField(10);
		JLabel jlblPassword = new JLabel("Password");
		JPasswordField jpfPassword = new JPasswordField(10);
		jpfPassword.setEchoChar('*');
		
		JTextArea jta = new JTextArea();//scrollbar는 없음.
		JScrollPane jsp = new JScrollPane(jta);//swing textarae에 scrollbar 추가
		
		//입력된 문자열이 TextArea의 열 범위를 넘어가면 줄을 변경한다.
		jta.setLineWrap(true);
		
		//단어 보호 :한글은 되지 않는다.
		jta.setWrapStyleWord(true);
		
		TextArea ta = new TextArea();//awt textarea
		
		//4.배치관리자를 설정
		setLayout(new BorderLayout()); //JFrame의 배치 관리자는 BorderLayot
		
		//North에 panel을 이용해 여러개의 component를 묶는다.
		JPanel jpNorth = new JPanel();
		
		//Center에 pannel을 이용해 여러개의 component를 묶는다.
		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(1,2)); //FlowLayout => GridLayout으로 변경
		
		//5.component를 배치
		
		//BorderLayout의 North 들어갈 component를 container component를 배치
		jpNorth.add(jlblID);
		jpNorth.add(jtfID);
		jpNorth.add(jlblPassword);
		jpNorth.add(jpfPassword);
		
		//BorderLayout의 Center 들어갈 component를 container component를 배치
		jpCenter.add(jsp);
		jpCenter.add(ta);
		
		//Window component에 container component를 배치
		add("North",jpNorth);
		add("Center",jpCenter);
		
		//6. window의 크기를 조절
		setBounds(100, 100, 500, 500);
		
		//7. 사용자에게 보여준다.
		setVisible(true);
		
		
		//8. window종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}//UseTextComponent
	
	public static void main(String[] args) {
		new UseTextComponent();
	}//main

}//class
