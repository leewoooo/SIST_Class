package day1119.manuallayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//1. 윈도우 컴포넌트 상속
@SuppressWarnings("serial")
public class UseManualLayout extends JFrame {

	//2. 생성자 작성
	public UseManualLayout() {
		super("수동배치의 사용");
		
		//3.컴포넌트의 생성
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField(); //컬럼의 크기를 설정하더라도 setsize로 크기를 설정하면 setsize가 우선
		JButton jbtnInput = new JButton("입력");
		
		//4.배치관리자를 설정합니다.
		setLayout(null); // 기존의 설정된 배치관리자인 BorderLayout이 해제된다.
		
		//5.컴포넌트를 배치합니다. 
		
		//5-1 component마다 크기 및 위치를 다 설정해줘야 배치된다.
		jlblName.setBounds(10, 30, 80, 25);
		jtfName.setBounds(80, 100, 120, 30);
		jbtnInput.setBounds(200, 170, 120, 120);
		
		//5-2 배치
		add(jlblName);
		add(jtfName);
		add(jbtnInput);
		
		//6. 윈도우의 크기설정 및 보여지는 크기 설정
		setBounds(100, 100, 335, 330);
		
		//윈도우 크기조절 막기 
		//수동배치를 하면 component가 좌표값에 고정되어 있기에 윈도우 창의 크기를 고정시켜놓고 사용해야한다.
		setResizable(false);
		
		//7. 사용자에게 보여주기
		setVisible(true);
		
		//8. 윈도우 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseManualLayout
	public static void main(String[] args) {

			new UseManualLayout();
	}//main

}//class
