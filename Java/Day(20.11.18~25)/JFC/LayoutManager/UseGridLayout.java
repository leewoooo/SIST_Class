package day1118.gridlayout;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 모든행과 모든 열에 Component가 동일하게 설정되는 Layout이다.
 * @author owner
 */
//1. 윈도우 컴포넌트를 상속받는다.
@SuppressWarnings("serial")
public class UseGridLayout extends JFrame {
	
	//2.생성자를 작성한다.
	public UseGridLayout() {
		super("GridLayout 연습");
		
		//3.컴포넌트를 생성한다.
		
		//내가 한 방법
		JButton[] bu = new JButton[9]; //모든 데이터형은 배열로 만들수 있다. 모든 데이터형은 LIst에 넣을 수 있다.
		for(int i = 0 ; i < bu.length; i ++) {
			//모든 방의 값이 null이므로 사용할 수 없어서 모든 방의 객체를 생성한다.
			bu[i] = new JButton("NUM "+ (i+1)); //내가 한 방법
//			bu[i] = new JButton(String.valueOf(i)); //강사님 방법 - 기본형의 값을 문자열로 바꿀때는 String.valueof(기본형데이터);
		}//end for
		
//		//List를 이용한 방법 (강사님)
//		List<JButton> list = new ArrayList<JButton>();
//		for(int i = 1 ; i < 10; i ++) {
//			list.add(new JButton(String.valueOf(i)));
//		}//end for
//		
		
		//4.배치관리자를 설정한다.
		setLayout(new GridLayout(3,3));
		
		//5. 컴포넌트를 배치한다.
		
		//array
		for(int j = 0 ; j < bu.length ; j++) {
			add(bu[j]);
		}//end for
		
		//list (강사님)
//		for(int j = 0 ; j < list.size();  j++) {
//			add(list.get(j));
//		}//end for
		
		//6. Window의 크기를 설정한다.
		setSize(400,400);
		
		//7. 사용자에게 보여준다.
		setVisible(true);
		
		//8. Window를 종료한다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//UseGridLayout

	public static void main(String[] args) {
		new UseGridLayout();
	}//main

}//class
