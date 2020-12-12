package day1126.usemouseevent;


import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//1. window component를 상속받는다.
@SuppressWarnings("serial")
public class UseListSelectionEvt extends JFrame implements ListSelectionListener {

	private DefaultListModel<String> dlmFriedns;
	private DefaultListModel<String> dlmblockFriedns;
	private JList<String> jlfriend;
	private JList<String> jlblockfriend;
	
	//2.생성자를 작성한다.
	public UseListSelectionEvt() {
		super("JList 연습");
		
		//3. component를 생성한다.
		
		dlmFriedns = new DefaultListModel<String>();
		dlmblockFriedns = new DefaultListModel<String>();
		
		//값설정
		dlmFriedns.addElement("라이언");
		dlmFriedns.addElement("무지");
		dlmFriedns.addElement("어피치");
		dlmFriedns.addElement("제이지");
		dlmFriedns.addElement("콘");

		dlmblockFriedns.addElement("브라운");
		dlmblockFriedns.addElement("코니");
		
		//data를 보여줄 View 생성
		jlfriend = new JList<String>(dlmFriedns);
		jlblockfriend = new JList<String>(dlmblockFriedns);
		
		//이벤트 등록
		jlfriend.addListSelectionListener(this);
		jlblockfriend.addListSelectionListener(this);
		
		
		//Scroll bar 기능 추가
		JScrollPane jpfriend = new JScrollPane(jlfriend);
		JScrollPane jpblockfriend = new JScrollPane(jlblockfriend);
		
		//TitleBorder 설정하기
		TitledBorder tbfriend = new TitledBorder("친구");
		jpfriend.setBorder(tbfriend);
		TitledBorder tbblockfriend = new TitledBorder("차단친구");
		jpblockfriend.setBorder(tbblockfriend);
		
		
		
		//4. 배치관리자 설정
		setLayout(new GridLayout());
		
		//5. 배치
		
		add(jpfriend);
		add(jpblockfriend);
		
		//6.Window 크기설정
		setBounds(100,	100, 400, 300);
		
		//7.사용자에게 보여주기
		setVisible(true);
		
		//8.window 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJList
	
	private boolean flag;
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		if(flag) {
		System.out.println( dlmFriedns.get( jlfriend.getSelectedIndex() ) );
		}//end if
		flag = !flag;
	}//valueChanged




	public static void main(String[] args) {

		new UseListSelectionEvt();
	}//main

}//class
