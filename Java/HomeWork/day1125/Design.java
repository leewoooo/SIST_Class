package day1125.homework1125;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


//1. window component를 상속받는다.
@SuppressWarnings("serial")
public class Design extends JFrame {

	//2. event에 관한 component를 생성한다.
	private JTextField jtfName;
	private JPasswordField jpwPassword;
	private JLabel jlbl;
	
	
	//3. 생성자를 생성한다.
	public Design() {
		super("2020-11-25-과제");
		
		//4.컴포넌트를 생성한다.
		jtfName = new JTextField();
		jpwPassword = new JPasswordField();
		jlbl = new JLabel();
		
		//컴포넌트 Border설정
		TitledBorder tbName = new TitledBorder("ID");
		TitledBorder tbPassword = new TitledBorder("PASSWORD");
		TitledBorder tbtext = new TitledBorder("출력");
		jtfName.setBorder(tbName);
		jpwPassword.setBorder(tbPassword);
		jlbl.setBorder(tbtext);
		
		
		//5.Has - A 관계를 맺고 event를 등록시킨다.
		Event ev = new Event(this);
		jtfName.addActionListener(ev);
		jpwPassword.addActionListener(ev);
		
		//6. 배치관리자를 설정해준다.
		setLayout(new GridLayout(3,1));
		
		//7. 배치
		add(jtfName);
		add(jpwPassword);
		add(jlbl);
		
		//8.window의 크기를 설정해준다.
		setBounds(100, 100, 300, 300);
		
		//9.사용자에게 보여준다.
		setVisible(true);
		
		//10.window종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//Design
	
	//11. getter생성
	
	public JTextField getJtfName() {
		return jtfName;
	}//getJtfName

	public JPasswordField getJpwPassword() {
		return jpwPassword;
	}//getJpwPassword

	public JLabel getJlbl() {
		return jlbl;
	}//getJlbl

	public static void main(String[] args) {
		Design ds = new Design();
		System.out.println(ds.jtfName.getText());
	}//main

}//class
