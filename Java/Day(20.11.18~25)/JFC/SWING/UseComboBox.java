package day1120.combobox;

import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//1. window component를 상속받는다.
@SuppressWarnings("serial")
public class UseComboBox extends JFrame {

	//2.생성자를 작성한다.
	public UseComboBox() {
		super("ComboBox 연습");
		
		
		//3, component를 생성한다.

		JLabel jlblemail = new JLabel("이메일");
		JTextField jtfemail = new JTextField(15);
		JLabel jlblemailat = new JLabel("@");
		
		//Model instance 생성
		String[] item = new String[] {"gmail.com","daum.net","naver.com","nate.com"};
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>(item);
		
		//Model에 데이터를 추가
		dcbm.addElement("hotmail.com");
		dcbm.addElement("yahoo.co.kr");
		
		//View Instnace를 생성하고, Model객체와 관계 설정
		JComboBox<String> jcb = new JComboBox<String>(dcbm);
		
		//4. 배치관리자 설정
		setLayout(new FlowLayout());
		
		//5. 배치
		
		add(jlblemail);
		add(jtfemail);
		add(jlblemailat);
		add(jcb);
		
		//6.윈도우 크기 설치
		setBounds(200, 100, 400, 100);
		
		//7.사용자에게 보여주기
		setVisible(true);
		
		//8.Window종료하기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//UseComboBox
	
	public static void main(String[] args) {

		new UseComboBox();
		
	}//main

}//class
