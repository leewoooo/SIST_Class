package day1125.event_hasa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

/**
 * 디자인 class와 has a 관계의 이벤트 처리 class를 생성.
 * @author owner
 */
//1. 이벤트 처리하기 위한 LIstener를 구현한다.
public class HasAEvt implements ActionListener {

	//2.디자인 class를 instance변수로 선언한다.
	private EvtDesign ed;
	
	//3.디자인 instance를 만들기 위한 생성자를 선언
	public HasAEvt( EvtDesign ed) { //has a 관계가 완성
		this.ed = ed;
	}//HasAEvt
	
	//interface에 있는 method를 Override한다.
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼이 눌린다면 라벨의 글자를 변경한다.
		
		if( e.getSource() == ed.getJbtn()) {
			JLabel jlblOutPutLabel = ed.getJlbl();
			Font font = new Font("Serif",Font.BOLD, 30);
			jlblOutPutLabel.setFont(font);
//			jlblOutPutLabel.setForeground(Color.DARK_GRAY); //Constant 전경색 설정
			Color c = new Color(0xC889FF);
			jlblOutPutLabel.setForeground(c); //Color class를 생성하여 전경색 설정
			ed.getJbtn().setForeground(c); 
			
			//Constant 배경색 설정, 투명도설정되지 않은 component는 바로 적용된다.
			ed.getJtf().setBackground(Color.GRAY);
			
			jlblOutPutLabel.setOpaque(true);//투명도 해제
			jlblOutPutLabel.setBackground(Color.BLUE);
		}
		
	} //actionPerformed

}//HasAEvt
