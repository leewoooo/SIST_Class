package day1125.event_isa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Action event를 처리해 볼겁니다. (ActionListener로 처리할것이다.)
 * @author owner
 */

//1. window component를 상속받는다. 이벤트 처리할 Listener를 구현한다.
@SuppressWarnings("serial")
public class UseActionEvent extends JFrame implements ActionListener{
	
	//2. 이벤트가 발생했을 때 처리될 component를 선언.
	
	private JButton jbtn;
	
	//2. Default Constructor 정의하고 component를 생성한다.
	public UseActionEvent() {
		super("ActionEvent 처리");
		
		//3. Component생성
		jbtn = new JButton("SWING의 버튼");
		
		
		//4. Component를 Event에 등록한다.
		//is - a 관계로 event를 처리하는 구조이므로 내 객체안에서 이벤트 처리하고자 할 때 this를 사용
		jbtn.addActionListener(this);
		
		//5. 배치 (Component를 붙임)
		//배치 관리자 : Layout Manager를 사용하여 Component를 배치한다.
		add("Center",jbtn);
		
		//6. Window의 크기
		setSize(400, 200);
		
		//7.윈도우 Component를 사용자에게 보여주기
		setVisible(true);
	
		//8. Window를 종료하자
		//사용하지 않으면 window를 닫아도 Instance가 작동하고 있다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}//UseSing 
	

	//9. 추상 method Override
	@Override
	public void actionPerformed(ActionEvent ae) {
		JOptionPane.showMessageDialog(this,"버튼이 클릭이 되었습니다.");
	}//actionPerformed



	public static void main(String[] args) {
		
		new UseActionEvent();
		
	}//main

}//class
