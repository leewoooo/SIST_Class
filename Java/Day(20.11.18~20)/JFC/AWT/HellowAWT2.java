package day1117.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 윈도우 프로그래밍 (Component Programming)
 * @author owner
 */

//1. 윈도우 Component를 상속 받는다. (사용자 에게 보여주기 위해서)
@SuppressWarnings("serial") //암호를 사용하지 않겠다. (추후 I/O 수업때 배울 예정)
public class HellowAWT2 extends Frame implements WindowListener{ //HellowAWT2는 Frame, WindowLister와 Is- a관계이다.

	//2.생성자를 작성한다.
	public HellowAWT2() {
		//부모생성자를 호출한다. title을 입력해 부모 class의 생성자를 호출한다.
		//프로그램이 만들어 졌을 때 프로그램의 title을 의미
		super("안녕하세요. AWT!");
		
		//3.컴포넌트 생성
		Button btn = new Button("나는 버튼 ^o^");
		
		//4.컴포넌트 배치
		add(btn);
		
		//5.Window의 크기를 설정한다.
		setSize(200,100);
		
		//6.사용자에게 보여주기
		setVisible(true);
		
		//아직 윈도우를 닫는 이벤트처리는 배우지 않았다 (~11.17)
		//(11.18 추가내용)
		
		addWindowListener(this);
		
	}//HellowAWT
	
	

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}//windowOpened



	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing"); //윈도우의 종료를 누르면 호출
		dispose(); //현재 윈도우를 종료해주세요 , 부모 class가 Window인경우에만 사용이 가능하다.
		
//		System.exit(0); //실행 중 JVM을 강제로 종료하는 일을 한다.  위험한 명령어이다. 어디에서든 사용가능
		//0 - false의미 : 비정상종료 : 종료 이후의 작업을 수행하지 않고, 바로종료
		//0이외의 수 - true의미 : 정상종료 : 종료 이후의 작업을 수행하고 종료
	}//windowClosing



	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}//windowClosed



	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}//windowIconified



	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}//windowDeiconified



	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}//windowActivated



	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}//windowDeactivated



	public static void main(String[] args) {

			new HellowAWT2();
			
	}//main

}//class
