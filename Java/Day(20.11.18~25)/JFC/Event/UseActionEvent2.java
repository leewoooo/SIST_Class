package day1125.event_isa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")

//1. Window Component인 JFrame을 상속, 이벤트 처리 Listener 구현.
public class UseActionEvent2 extends JFrame implements ActionListener{
	
	//2. 이벤트처리에 관련 있는 컴포넌트를 선언한다.
	
	private JTextArea jtaNameDisplay;
	private JButton jbtnInput;
	private JTextField jtfName;
	
	//2. 생성자를 생성한다.
	public UseActionEvent2() {
		super("ActionEvent 처리");
		
		//3.일반 Component를 생성합니다.
		JLabel jlblName = new JLabel("이름");
		jtfName = new JTextField(20);
		jbtnInput = new JButton("입력");
		jtaNameDisplay = new JTextArea();
		
		//4.이벤트를 등록한다.
		
		jbtnInput.addActionListener(this); //버튼이 클릭되면 이벤트 처리  코드 실행.
		jtfName.addActionListener(this); //JTextField에서 엔터키가 입력되면 이벤트 처리 코드 실행.
		
		//5.배치관리자 생성 (현재 기본 레이아웃 메니저는 Border Layout이다)
		setLayout(new BorderLayout());
		
		//6.컴포넌트 배치
		//BorderLayout은 하나의 영역에 하나의 컴포넌트만 배치할 수 있다.
		//North영역에는 여러개의 component를 배치하고자 하기에 Container Component인 Jpanel이 필요하다.
		JPanel jpNouth = new JPanel(); //flow layout
		//Container Component에 Layout을 설정하자
		jpNouth.setLayout(new FlowLayout());
		jpNouth.add(jlblName);
		jpNouth.add(jtfName);
		jpNouth.add(jbtnInput);
		
		add("North",jpNouth);
		add("Center",jtaNameDisplay);
		
		//7.window 크기 설정
		setLocation(500,500);
		setSize(400, 300);
		
		//8.사용자에게 보여주기
		setVisible(true);
		
		//9.window 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseLayoutManager
	
	//10. interface의 method를 구현
	@Override
	public void actionPerformed(ActionEvent ae) {

		//JTextField 입력값을 가져와서.
		String name = jtfName.getText();
		System.out.println(name);
		//JTextArae에 값 넣기
		jtaNameDisplay.append(name + "\n");
		//JTextField의 값을 삭제
		jtfName.setText("");
		//JTextField에 cursor를 위치
		jtfName.requestFocus();
	}//actionPerformed
	
	public static void main(String[] args) {

		new UseActionEvent2();
		
	}//main

}//class
