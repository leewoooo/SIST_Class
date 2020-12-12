package day1126.usedialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;


public class ChildEvt extends WindowAdapter implements ActionListener {

	private UseChild uc;
	
	public ChildEvt(UseChild uc) {
		this.uc = uc;
	}//ChildEvt
	
	@Override
	public void windowClosing(WindowEvent ae) {
		uc.dispose();
	}//windowClosing

	@Override
	public void actionPerformed(ActionEvent we) {
		
		if(we.getSource() == uc.getJbtn()) {
		String lunch =JOptionPane.showInputDialog("점심메뉴는 무엇이었습니까?");
			if(lunch != null && !lunch.isEmpty()) {
				String[] menu = {"짜장면,짬뽕,볶음밥,울면","설렁탕,곰탕,순대국,감자탕","김밥,라면,떡볶이","순두부찌개,된장찌개,김치찌개","돈가츠,히레가츠"};
				String[] type = {"중식","국밥","분식","한식","양식"};
		
				String temptype = lunch+"는 알 수 없는 음식종류입니다.";
				for(int i = 0; i < menu.length; i++) {
					if(menu[i].contains(lunch)) {
						temptype = lunch + "는 " + type[i] + "입니다";
						break;
					}//end if
				}//for
				JOptionPane.showMessageDialog(uc, temptype);
			}//end if
		}	
	}//actionPerformed

}//class
