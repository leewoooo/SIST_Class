package day1125.event_hasa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Action event를 처리해 볼겁니다. (ActionListener로 처리할것이다.)
 * @author owner
 */

//1. window component를 상속받는다. 이벤트 처리할 Listener를 구현한다.
@SuppressWarnings("serial")
public class EvtDesign extends JFrame{
	
	//2. 이벤트가 발생했을 때 처리될 component를 선언.
	
	private JButton jbtn;
	private JLabel jlbl;
	private JTextField jtf;
	
	//2. Default Constructor 정의하고 component를 생성한다.
	public EvtDesign() {
		super("ActionEvent 처리");
		
		//3. Component생성
		jbtn = new JButton("SWING의 버튼");
		jlbl = new JLabel("출력JLabel");
		jtf = new JTextField(20);
		
		//4. Component를 Event에 등록한다./ has-a관계로 설정하고 이벤트를 등록한다.
		HasAEvt hasA = new HasAEvt(this);
		jbtn.addActionListener(hasA);
		jtf.addActionListener(hasA);
		
		//5. 배치 (Component를 붙임)
		//배치 관리자 : Layout Manager를 사용하여 Component를 배치한다.
		add("Center",jbtn);
		add("North",jlbl);
		add("South",jtf);
		
		//6. Window의 크기
		setSize(400, 200);
		
		//7.윈도우 Component를 사용자에게 보여주기
		setVisible(true);
	
		//8. Window를 종료하자
		//사용하지 않으면 window를 닫아도 Instance가 작동하고 있다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}//UseSing 

	
	//8. 이벤트 처리 클래스에서 컴포넌트를 사용할 수 있도록 getter method를 만든다.
	
	public JButton getJbtn() {
		return jbtn;
	}//getJbtn
	
	public JLabel getJlbl() {
		return jlbl;
	}//getJlbl
	
	public JTextField getJtf() {
		return jtf;
	}//getJtf


	public static void main(String[] args) {
		
		new EvtDesign();
		
	}//main



}//class
