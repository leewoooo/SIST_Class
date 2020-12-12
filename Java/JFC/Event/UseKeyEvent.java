package day1126.usekeyevent;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * 키보드의 키가 눌렸을 때 발생하는 이벤트 처리.
 * @author owner
 */
@SuppressWarnings("serial")
public class UseKeyEvent extends JFrame implements KeyListener {
	
	private static final int ESC = 27;
	private static final int UP = 38;
	private static final int DOWN = 40;
	private static final int LEFT = 37;
	private static final int RIGHT = 39;

	private JTextField jtf;
	private JTextArea jta;
	
	public UseKeyEvent() {
		super("키보드 이벤트의 처리");
	
		jtf = new JTextField();
		jta = new JTextArea();
		
		//이벤트 등록
		jtf.addKeyListener(this);
		
		JScrollPane jsp = new JScrollPane(jta);
		
		jtf.setBorder(new TitledBorder("아무키나 입력하세요."));
		jsp.setBorder(new LineBorder(Color.RED));
		
		add("North",jtf);
		add("Center",jsp);
		
		setBounds(100, 100, 300, 300);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseKeyEvent
	
	@Override
	public void keyTyped(KeyEvent ke) {
//		System.out.println("keyTyped2");		
//		Keycord를 얻을 수 없다.
	}//keyTyped

	@Override
	public void keyPressed(KeyEvent ke) {
//		System.out.println("keyPressed1");
	}//keyPressed

	@Override
	public void keyReleased(KeyEvent ke) {
//		System.out.println("keyReleased3");
		jta.append(ke.getKeyCode() + "/" + ke.getKeyChar() + "\n");
		
		int x = getX();
		int y = getY();
		
		switch (ke.getKeyCode()) {
		case ESC: 
			int flag = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?");
			switch(flag) {
			case JOptionPane.OK_OPTION:
				this.dispose();
			}//switch
		case UP: y -=10; break;
		case DOWN: y +=10; break;
		case LEFT: x-=10; break;
		case RIGHT: x+=10;
		}//switch
		setLocation(x, y);
		
		
	}//keyReleased

	public static void main(String[] args) {
		new UseKeyEvent();
	}//main

}//class
