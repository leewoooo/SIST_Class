package day1120.homework1120;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//1. window component를 상속받는다.
@SuppressWarnings("serial")
public class HomeWork1120 extends JFrame {

	//2. 생성자를 작성한다.
	public HomeWork1120() {

		super("JAVA-메모장");
		
		//3.컴포넌트를 생성한다.
		JMenuBar jmb = new JMenuBar();
		
		JMenu jmFile = new JMenu("File");
		JMenu jmText = new JMenu("서식");
		JMenu jmhelp = new JMenu("도움말");
		
		//filemenu
		JMenuItem jminew = new JMenuItem("새 글");
		JMenuItem jmiopen = new JMenuItem("열기");
		JMenuItem jmisave = new JMenuItem("저장");
		JMenuItem jmisaveas = new JMenuItem("새이름으로");
		JMenuItem jmiclase = new JMenuItem("닫기");

		//textmenu
		JMenuItem jmifont = new JMenuItem("글꼴");
		JMenuItem jmilinebreak = new JMenuItem("자동줄바꿈");
		
		//helpmenu
		JMenuItem jmiinfo = new JMenuItem("메모장정보");
		
		//메모장 영역만들기
		JTextArea jta = new JTextArea();
		
		jta.setLineWrap(true); //열의 범위 넘어가면 줄바꿈
		jta.setWrapStyleWord(true); //줄을 바꿀 때 단어가 보호가 되게하는 method
		
		JScrollPane jtp = new JScrollPane(jta);
		
		//4.배치관리자 설정
		setLayout(new BorderLayout());
		
		//5.배치
		
		//filemenu
		jmFile.add(jminew);
		jmFile.addSeparator();
		jmFile.add(jmiopen);
		jmFile.add(jmisave);
		jmFile.add(jmisaveas);
		jmFile.addSeparator();
		jmFile.add(jmiclase);
		
		//textmenu
		jmText.add(jmifont);
		jmText.addSeparator();
		jmText.add(jmilinebreak);
		
		//helpmemu
		jmhelp.add(jmiinfo);
		
		//menubar에 menu배치
		jmb.add(jmFile);
		jmb.add(jmText);
		jmb.add(jmhelp);
		
		//window에 배치

		setJMenuBar(jmb);
		add(jtp);
		
		//6.window크기조정
		
		setBounds(50, 50, 500, 250);
		
		//7.사용자에게 보여주기
		setVisible(true);
		
		//8.window종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//HomeWork1120
	public static void main(String[] args) {

		new HomeWork1120();
	}//main

}//class
