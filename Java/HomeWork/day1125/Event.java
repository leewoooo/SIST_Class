package day1125.homework1125;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

//1. event를 처리하기 위한 interface를 구현한다.
public class Event implements ActionListener{

	//2. design class를 인스턴스 변수로 생성한다.
	private Design ds;
	
	//3. 디자인 instance를 만들기 위해 생성자 선언
	public Event(Design ds) {
		this.ds=ds;
	}//Event
	
	private boolean idFlag;
	private boolean passwordFlag;
	private int printFlag = 0;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String id = ds.getJtfName().getText();
		String password =String.valueOf(ds.getJpwPassword().getPassword());
		
		if(e.getSource() == ds.getJtfName() && !(id.isEmpty())) {
			this.idFlag=true;
			ds.getJpwPassword().requestFocus();
		}
		
		if(e.getSource() == ds.getJtfName() && id.isEmpty()) {
			JOptionPane.showMessageDialog(ds, "ID필수입력");
			ds.getJtfName().requestFocus();
		}//end if
		
		if(e.getSource() == ds.getJpwPassword() && !(password.isEmpty())) {
			this.passwordFlag=true;
		}
		
		if(e.getSource() == ds.getJpwPassword() && password.isEmpty()) {
			JOptionPane.showMessageDialog(ds, "PASSWORD필수입력");
			ds.getJpwPassword().requestFocus();
		}//end if
	
		if(e.getSource() == ds.getJpwPassword() && this.idFlag && this.passwordFlag) {
			ds.getJlbl().setText(id + " / " +password);
			Font fot = new Font("Serif", Font.BOLD, 25);
			ds.getJlbl().setFont(fot);
			ds.getJlbl().setForeground(Color.BLUE);
			this.printFlag = 1;
		}//end if
		
		//출력이 완료된 후 flag값들 초기화
		if(this.printFlag == 1) {
			this.idFlag = false;
			this.passwordFlag = false;
			this.printFlag = 0;
		}//end if
		
	}//actionPerformed
	
}//Event
