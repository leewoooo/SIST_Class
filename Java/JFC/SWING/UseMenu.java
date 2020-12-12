package day1120.memu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//1. 윈도우 컴포넌트를 상속 받는다.
@SuppressWarnings("serial")
public class UseMenu extends JFrame {

	//2.생성자를 생성한다.
	public UseMenu() {
		super("menu연습");
		
		
		//3.컴포넌트를 생성합니다.
		
		//3-1 MenuBar 생성
		JMenuBar jb = new JMenuBar();
		
		//3-2 Menu 생성
		JMenu jmfile = new JMenu("파일");
		
		JMenu jmfix = new JMenu("편집");
		
		JMenu jmsave = new JMenu("저장");
		
		
		//3-3 MenuItem생성
		
		JMenuItem jmiopen = new JMenuItem("열기");
		JMenuItem jmisave = new JMenuItem("저장");
		JMenuItem jmisaveas = new JMenuItem("다른이름으로 저장");
		JMenuItem jmiclose = new JMenuItem("닫기");
		
		//4.배치관리자를 설정
		setLayout(new BorderLayout());
		
		//5. 배치
		
		//5-1 하위 Menu 배치
		jmsave.add(jmisave);
		jmsave.add(jmisaveas);
		
		//5-2 MenuItem을 Menu에 넣기
		jmfile.add(jmiopen);
		jmfile.add(jmsave);
		
		//Menu에 구분선 넣기
		jmfile.addSeparator();
		
		jmfile.add(jmiclose);
		
		//MenuBar에 Menu 넣기
		jb.add(jmfile);
		jb.add(jmfix);
		
		//윈도우 컴포넌트에 메뉴바 세팅하기
		setJMenuBar(jb);
		
		//6. 윈도우 크기설정
		setBounds(50, 50, 200, 200);
		setResizable(false);
		
		//7. 사용자에게 보여주기
		setVisible(true);
		
		//8. 윈도우 종료하기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseMenu
	
	public static void main(String[] args) {
		new UseMenu();
	}//main

}//class
