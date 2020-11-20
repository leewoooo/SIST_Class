package day1120.homework1120;


import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//1. window component를 상속받는다.
@SuppressWarnings("serial")
public class HomeWork1120_2 extends JFrame {

	//2. 생성자를 작성한다.
	public HomeWork1120_2() {

		super("글꼴");
		
		//3.컴포넌트를 생성한다.
		JLabel jlblfont = new JLabel("글꼴");
		JLabel jlblstyle = new JLabel("스타일");
		JLabel jlblsize = new JLabel("크기");
		
		JTextField jtffont = new JTextField(15);
		JTextField jtfstyle = new JTextField(15);
		JTextField jtfsize = new JTextField(15);
		
		DefaultListModel<String> dlmtext = new DefaultListModel<String>();
		dlmtext.addElement("Dialog");
		dlmtext.addElement("DialogInput");
		dlmtext.addElement("Serif");
		dlmtext.addElement("SansSerif");
		dlmtext.addElement("Monospaced");

		DefaultListModel<String> dlmstyle = new DefaultListModel<String>();
		dlmstyle.addElement("보통");
		dlmstyle.addElement("굵게");
		dlmstyle.addElement("기울임꼴");
		dlmstyle.addElement("굵은기울임꼴");
		
		DefaultListModel<String> dlmsize = new DefaultListModel<String>();
		dlmsize.addElement("8");
		dlmsize.addElement("10");
		dlmsize.addElement(".");
		dlmsize.addElement(".");
		dlmsize.addElement("100");
		
		JList<String> jltext = new JList<String>(dlmtext);
		JList<String> jlstyle = new JList<String>(dlmstyle);
		JList<String> jlsize = new JList<String>(dlmsize);
		
		JScrollPane jsptext = new JScrollPane(jltext);
		JScrollPane jspstyle = new JScrollPane(jlstyle);
		JScrollPane jspsize = new JScrollPane(jlsize);
		
		
		
		JLabel jlblpreview = new JLabel("AaBbYyZz");
		jlblpreview.setBorder(new TitledBorder("미리보기"));
		
		JButton jbapply = new JButton("적용");
		JButton jbclose = new JButton("닫기");
		
		
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		dcbm.addElement("영어");
		dcbm.addElement("한글");
		
		JComboBox<String> jb = new JComboBox<String>(dcbm);
		
		//4. 배치관리자 설정
		setLayout(null);
		
		//5. 배치
		
		
		add(jlblfont);
		jlblfont.setBounds(55, 20, 100, 30);
		add(jtffont);
		jtffont.setBounds(20,60,100,30);
		add(jsptext);
		jsptext.setBounds(20,100,100,150);
		
		add(jlblstyle);
		jlblstyle.setBounds(200, 20, 100, 30);
		add(jtfstyle);
		jtfstyle.setBounds(170, 60, 100, 30);
		add(jspstyle);
		jspstyle.setBounds(170, 100, 100, 150);
		
		add(jlblsize);
		jlblsize.setBounds(353, 20, 100, 30);
		add(jtfsize);
		jtfsize.setBounds(318, 60, 100, 30);
		add(jspsize);
		jspsize.setBounds(318, 100, 100, 150);
		
		add(jlblpreview);
		jlblpreview.setBounds(280, 250, 100, 50);		
		
		add(jb);
		jb.setBounds(280, 310, 100, 30);
		
		add(jbapply);
		jbapply.setBounds(280, 360, 70, 30);
		
		add(jbclose);
		jbclose.setBounds(360, 360, 70, 30);
		
		
		//6.window크기조정
		
		setBounds(50, 50, 500, 450);
		
		//7.사용자에게 보여주기
		setVisible(true);
		
		//8.window종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//HomeWork1120
	public static void main(String[] args) {

		new HomeWork1120_2();
	}//main

}//class
