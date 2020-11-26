package day1126.usedialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseChild extends JDialog {

	private JButton jbtn;
	private JLabel jlbl;
	
	public UseChild(UseParent up) {
		super(up , "JDialog 부가적인기능", true);
		
		jbtn = new JButton("버튼");
		jlbl = new JLabel("JDialog는 부모창에서 필요한 부가적인 기능을 구현한다.");
		jlbl.setBorder(new TitledBorder("메세지"));
		
		//이벤트 처리 객체를 생성하고 has a 관계를 설정
		ChildEvt ce = new ChildEvt(this);
		jbtn.addActionListener(ce);
		addWindowListener(ce);
		
		JPanel jpSouth = new JPanel();
		jpSouth.add(jbtn);
		
		add("Center", jlbl);
		add("South", jpSouth);
		
		//Dialog의 시작점은 부모창 안에서 실행되어야 한다.
		//따라서 getX(),getY()로 부모의 좌표를 얻어서 사용한다.
		setBounds(up.getX() + 300 ,up.getY() + 300, 500, 300);
		
		setVisible(true);
		
	}//UseChild

	public JButton getJbtn() {
		return jbtn;
	}//getJbtn

	public JLabel getJlbl() {
		return jlbl;
	}//getJlbl
	
}//class
