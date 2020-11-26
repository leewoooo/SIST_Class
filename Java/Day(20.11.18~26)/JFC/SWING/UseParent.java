package day1126.usedialog;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 주 기능을 가지고 있는 Main 창(부모 창)
 * @author owner
 */
@SuppressWarnings("serial")
public class UseParent extends JFrame {

	private JButton jbtn;
	
	public UseParent() {
		super("부모창");
		
		jbtn = new JButton("부가적인 기능");
		
		//이벤트 instance를 생성하고 관계를 설정
		ParentEvt pe = new ParentEvt(this);
		
		//이벤트에 등록하기
		jbtn.addActionListener(pe);
		addWindowListener(pe);
		
		JPanel jpSouth = new JPanel();
		jpSouth.add(jbtn);
		
		add("South",jpSouth);
		
		setBounds(100, 100, 1000, 700);
		
		setVisible(true);
		
		
	}//UesParent
	
	
	public JButton getJbtn() {
		return jbtn;
	}//getJbtn


	public static void main(String[] args) {
		new UseParent();
	}//main
}//class
