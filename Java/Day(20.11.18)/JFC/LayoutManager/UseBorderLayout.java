package day1118.boarderlayout;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * BorderLayout: 경계 Layout. 
 * Component의 고유 크기가 무시되고 배치되는 위치의 크기에 맞게 변경된다.
 * 하나의 영역에 하나의 Component만 배치 가능.
 * Window Component의 기본 Layout이다.
 * @author owner
 */
@SuppressWarnings("serial")
//1. 윈도우 컴포넌트를 상속
public class UseBorderLayout extends JFrame{

	//2.생성자 작성
	public UseBorderLayout() {
		super("borderlayout의 연습"); // 부모 class의 생성자를 호출후 title 설정
	
	//3. Component 생성
	JButton jbtnNorth = new JButton("North");
	JButton jbtnEast = new JButton("East");
	JTextField jtfSouth = new JTextField("South"); //web상 id 입력창
	JLabel jlblWest = new JLabel("West"); //이름표
	JTextArea jtaCenter = new JTextArea("Center"); //메일내용 입력창
	
	//4. 배치관리자 설정
	setLayout(new BorderLayout());
	
	//5. 컴포넌트의 배치
	// 문자열 상수로 component로 배치되는 위치를 설정할 수 있다. (첫 글자는 대문자로 작성합니다.)
	add("Center",jtaCenter);
	add("North",jbtnNorth);
	// BorderLayout의 상수 (constant)로 component가 배치되는 위치를 설정할 수 있다.
	add(BorderLayout.WEST,jlblWest);
	add(BorderLayout.SOUTH,jtfSouth);
	add(jbtnEast,BorderLayout.EAST);
	//6. 윈도우의 크기 설정
	setSize(500, 500);
	//7. 사용자에게 보여주기
	setVisible(true);
	//8. Window종료
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}//UseBorderLayout
	public static void main(String[] args) {
		new UseBorderLayout();
	}//main

}//class
