package day1126.usedialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * UseParent의 이벤트를 처리하는 class
 * UseParent와 ParentEvt는 has-a관계.
 * @author owner
 */
public class ParentEvt extends WindowAdapter implements ActionListener{

	private UseParent up; 
	
	public ParentEvt(UseParent up) {
		this.up = up;
	}//ParentEvt

	@Override
	public void windowClosing(WindowEvent e) {
		up.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//버튼이 눌려지면 JDialog를 생성하자
		if(e.getSource() == up.getJbtn()) {
			createDialog();
		}//end if
		
	}//actionPerformed
	
	private void createDialog() {
		new UseChild(up);
	}//createDialog
	
	
}//class
