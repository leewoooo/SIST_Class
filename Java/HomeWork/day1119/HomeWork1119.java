package day1119.homework1119;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//1. 윈도우 컴포넌트를 상속 받습니다.
@SuppressWarnings("serial")
public class HomeWork1119 extends JFrame {

	//2.생성자를 작성합니다.
	public HomeWork1119() {
		super("HomeWork");
		
		//3. 컴포넌트를 생성합니다.
		JLabel jlblName = new JLabel("이름");
		JLabel jlblage = new JLabel("나이");
		JLabel jlblgender = new JLabel("성별");
		JLabel jlbladdress = new JLabel("주소");
		
		
		JTextField jtfName = new JTextField(10);
		JTextField jtfage = new JTextField(10);
		JTextField jtfaddress = new JTextField(10);
		
		JRadioButton jrbman = new JRadioButton("남");
		JRadioButton jrbwoman = new JRadioButton("여");
		
		JButton jbinput = new JButton("입력");
		JButton jbchange = new JButton("변경");
		JButton jbdelete = new JButton("삭제");
		JButton jbsearch = new JButton("검색");
		JButton jbclose = new JButton("닫기");

		JTextArea jt = new JTextArea();
		JScrollPane jsp = new JScrollPane(jt);
		jt.setLineWrap(true);
		jt.setWrapStyleWord(true);
		
		//4.배치관리자 설정
		setLayout(null);

		//5. 배치
		
		//이름
		JPanel jpname = new JPanel();
		jpname.add(jlblName);
		jpname.add(jtfName);
		
		//나이
		JPanel jpage = new JPanel();
		jpage.add(jlblage);
		jpage.add(jtfage);
		
		
		//RadioCheckBox 묶기
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbman);
		bg.add(jrbwoman);
		
		//주소
		JPanel jpaddress = new JPanel();
		jpaddress.add(jlbladdress);
		jpaddress.add(jtfaddress);
		
		//버튼 묶기
		JPanel jpbu = new JPanel();
		jpbu.add(jbinput);
		jpbu.add(jbchange);
		jpbu.add(jbdelete);
		jpbu.add(jbsearch);
		jpbu.add(jbclose);
		
		
		//window component에 배치하기
		add(jpname);
		add(jpage);
		add(jlblgender);
		add(jpaddress);
		add(jpbu);
		add(jsp);
		add(jrbman);
		add(jrbwoman);
		
		
		//window크기,배치 및 component 크기,배치 설정
		//1. 위치 및 크기
		
		setBounds(100, 100, 500, 400);
		setResizable(false);
		
		
		jpname.setBounds(10,50,200,50);
		jpage.setBounds(10,100,200,50);
		jlblgender.setBounds(37,150,200,50);
		jrbman.setBounds(70,150,50,50);
		jrbwoman.setBounds(130,150,50,50);
		jpaddress.setBounds(10,200,200,50);
		
		jpbu.setBounds(0, 250, 500, 50);
		
		jsp.setBounds(220, 50, 190, 180);
		
		
		//7. 사용자에게 보여주기
		setVisible(true);
		
		//8. window닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//HomeWork1119
	
	
	
	public static void main(String[] args) {

		new HomeWork1119();
	}//main

}//class
