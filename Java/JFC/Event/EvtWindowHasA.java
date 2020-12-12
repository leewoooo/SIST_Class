package day1125.usewindowadapter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;


/**
 * WindowListener를 구현하면 7개의 추상 method를 Override해야합니다.
 * WindowListener를 구현한 WindowAdapter를 상속받으면 필요한 method만 Override하면 된다.
 * @author owner
 */
public class EvtWindowHasA extends WindowAdapter /* implements WindowListener */ {

	//has a
	private UseWindowAdapter uwa;
	
	public EvtWindowHasA(UseWindowAdapter uwa) {
		this.uwa=uwa;
	}//EvtWindowHasA
	
	@Override
	public void windowClosing(WindowEvent e) {
		int closeFlag = JOptionPane.showConfirmDialog(uwa, "종료하시겠습니까?");
		switch(closeFlag) {
		case JOptionPane.OK_OPTION : uwa.dispose();
		}//end switch
	}
	
}//class
