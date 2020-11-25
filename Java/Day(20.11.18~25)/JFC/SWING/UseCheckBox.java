package day1119.checkbox;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//1. 윈도우 컴포넌트를 상속받습니다.
@SuppressWarnings("serial")
public class UseCheckBox extends JFrame {

	//2. 생성자를 작성합니다.
	public UseCheckBox() {
		super("Check Component");
	
	//3. 컴포넌트를 생성합니다.
	
	JLabel jlblhobby = new JLabel("취미를 선택하세요");
	JCheckBox jcbho1 = new JCheckBox("낚시");
	JCheckBox jcbho2 = new JCheckBox("등산");
	JCheckBox jcbho3 = new JCheckBox("운동",true); //boolean값으로 체크 된 상태로 출력가능
	
	JLabel jlblgender = new JLabel("성별을 선택하세요");
	JRadioButton jrbman = new JRadioButton("남");
	JRadioButton jrbwoman = new JRadioButton("여");

	//4. 배치 관리자 설정
	
	setLayout(new GridLayout(2,1));
	
	//여러개의 컴포넌트를 하나로 묶을 컨테이너 컴포넌트를 생성합니다.
	JPanel jphobby = new JPanel();
	JPanel jpgender = new JPanel();
	
	//5.배치
	jphobby.add(jlblhobby);
	jphobby.add(jcbho1);
	jphobby.add(jcbho2);
	jphobby.add(jcbho3);
	
	
	//Radiobutton을 ButtonGroup로 묶어서 하나만 선택가능하도록 설정한다.
	ButtonGroup bg = new ButtonGroup();
	bg.add(jrbman);
	bg.add(jrbwoman);
	
	jpgender.add(jlblgender);
	jpgender.add(jrbman);
	jpgender.add(jrbwoman);
	
	
	//window 컴포넌트에 배치
	add(jphobby);
	add(jpgender);
	
	//6. window 크기 설정
	setBounds(100,100,400,200);
	
	//7. 사용자에게 보여준다.
	setVisible(true);
	
	//8.Window를 종료한다.
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	}//UseCheckBox
	
	public static void main(String[] args) {

		new UseCheckBox();
		
	}//main

}//class
