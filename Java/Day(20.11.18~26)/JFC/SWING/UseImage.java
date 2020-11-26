package day1119.useimage;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")

//1. 윈도우 컴포넌트를 상속 받는다.
public class UseImage extends JFrame {

	//2.생성자를 작성
	public UseImage() {
		super("Image연습");
	
	//3. 이미지 생성 후 component생성
		//이미지 생성
		//경로는 /나 \모두 사용가능
		ImageIcon ii1 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1119/img/img_1.png");
		ImageIcon ii2 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1119/img/img_2.png");
		ImageIcon ii3 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1119/img/img_3.png");
		ImageIcon ii4 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1119/img/img_4.png");
		//\를 사용할때에는 특수문자의 시작기호와 겹쳐서 \뒤의 한글자와 특수문자처리가된다.
		//이때 \뒤 한 문자가 자바에서 지원하는 특수문자가 아니라면 error
		
		//버튼생성 및 이미지 삽입
		JButton jb1 = new JButton("라이언",ii1);
		JButton jb2 = new JButton("어피치",ii2);
		JButton jb3 = new JButton("무지",ii3);
		
		//jb1의 텍스트의 수평 위치 이동 (LEFT, CENTER, RIGHT)
		jb1.setHorizontalTextPosition(JButton.CENTER);
		
		//jb1의 텍스트의 수직 위치 이동 (TOP, CENTER, BOTTOM)
		jb1.setVerticalTextPosition(JButton.TOP);

		//jb3의 텍스트의 위치를 하단 중앙에 배치
		jb3.setHorizontalTextPosition(JButton.CENTER);
		jb3.setVerticalTextPosition(JButton.BOTTOM);
		
		
		//풍선 도움말 : Tooltip Text
		jb1.setToolTipText("백수의 왕");
		jb2.setToolTipText("복숭아의 왕");
		jb3.setToolTipText("단무지의 왕");
		
		//마우스 포인터가 올라가거나 클릭되면 이미지를 변경 : RollOver
		jb3.setRolloverIcon(ii4);
		
	//4. 배치관리자 설정
		setLayout(new GridLayout(1, 3));
	//5. component 배치
		add(jb1);	
		add(jb2);	
		add(jb3);	
	//6. window size설정
		setSize(600, 200);
	//7. 사용자에게 보여주기
		setVisible(true);
	//8. window종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}//UseImage
	
	public static void main(String[]args) {
		
		new UseImage();
		
	}//main
	
}//class
