package day1118.flowlayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * FlowLayout : 흐름 레이아웃
 * 컴포넌트는 고유 크기를 가지고 배치하는 순서대로 배치된다.
 * 윈도우의 크기가 줄거나 늘어나면 컴포넌트의 위치가 위에서 아래로 이동한다.
 * @author owner
 */

//1. 윈도우 컴포넌트를 상속받는다.
@SuppressWarnings("serial")
public class UseFlowLayout extends JFrame {
//2. 생성자를 작성.
	public UseFlowLayout() {
		super("FlowLayout의 사용");
		
		//3. 컴포넌트의 생성
		JLabel jlblNanme = new JLabel("이름");
		JTextField jtfName = new JTextField(10); //대문자A기준 10글자 보여줄때
		JLabel jlblage = new JLabel("나이");
		
		
		Integer[] arrage=new Integer[100];
		for(int i = 0 ; i < arrage.length ; i++) {
			arrage[i]=i+1;
		}//end for
		
		JComboBox<Integer> jcbage = new JComboBox<Integer>(arrage); 
		
		JButton jbtninput = new JButton("입력");
		
		//4. 배치관리자를 설정 : BorderLayout => FlowLayout
		setLayout(new FlowLayout());
		
		//5. 컴포넌트를 배치합니다. ( add하는 순서대로 왼쪽에서 오른쪽으로)
		add(jlblNanme);
		add(jtfName);
		add(jlblage);
		add(jcbage);
		add(jbtninput);
		//6. 윈도우의 크기를 설정합니다.
		setSize(600, 400);
		
		//7. 사용자에게 보여주기
		setVisible(true);
		
		//8. 윈도우 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//UseFlowLayout

	public static void main(String[] args) {
		
		new UseFlowLayout();
		
	}//mian
}//class
