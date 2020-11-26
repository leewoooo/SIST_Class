package day1119.layoutmanager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")

//1. JFrame을 상속받는다 ( Window Component를 상속받은 것과 같다)
public class UseLayoutManager extends JFrame {
	
	//2. 생성자를 생성한다.
	public UseLayoutManager() {
		super("여러개의 Layout을 사용합니다.");
		
		//3.일반 Component를 생성합니다.
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField(20);
		JButton jbtnInput = new JButton("입력");
		JTextArea jtaNameDisplay = new JTextArea();
		
		//4.배치관리자 생성 (현재 기본 레이아웃 메니저는 Border Layout이다)
		setLayout(new BorderLayout());
		
		//5.컴포넌트 배치
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
		
		//6.window 크기 설정
		setLocation(500,500);
		setSize(400, 300);
		
		//7.사용자에게 보여주기
		setVisible(true);
		
		//8.window 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}//UseLayoutManager

	public static void main(String[] args) {

		new UseLayoutManager();
		
	}//main

}//class
