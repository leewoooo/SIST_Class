package day1118.swing;

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * AWT보다 향상된 Window Application을 제작할 수 있는 Swing를 사용한다.
 * @author owner
 */

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
//		add(btn);
//		add(jbtn);//마지막 추가된 것만 남아 있는다.
		
		//배치 관리자 : Layout Manager를 사용하여 Component를 배치한다.
		
		setLayout(new GridLayout(1, 2));
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
