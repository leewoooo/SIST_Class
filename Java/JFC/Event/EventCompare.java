package day1125.event_isa;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//1. Window 컴포넌트를 상속받는다.
/**
 * 이벤트 비교
 * 아이디 TF에서 엔터가 눌러지면 JTextArea에 설정.
 * 비밀번호 JPF에서 엔터가 눌러지면 TextArea에 설정.
 * @author owner
 */
@SuppressWarnings("serial")
public class EventCompare extends JFrame implements ActionListener {

	
	//2.이벤트 처리에 관련된 component를 선언
	private JTextField jtfID;
	private JPasswordField jpfPassword;
	private JTextArea jtaTemp;
	private TextArea taTemp;

	//2.생성자를 작성한다.
	public EventCompare() {
		super("텍스트컴포넌트의 사용");

		//3.컴포넌트를 생성합니다.
		JLabel jlblID = new JLabel("ID");
		jtfID = new JTextField(10);
		JLabel jlblPassword = new JLabel("Password");
		jpfPassword = new JPasswordField(10);
		
		
//		jpfPassword.setEchoChar('*');
		
		jtaTemp = new JTextArea();//scrollbar는 없음.
		taTemp = new TextArea();//scrollbar 있음
		
		JScrollPane jspTemp = new JScrollPane(jtaTemp);
		
		//입력된 문자열이 TextArea의 열 범위를 넘어가면 줄을 변경한다.
		jtaTemp.setLineWrap(true);
		
		//단어 보호 :한글은 되지 않는다.
		jtaTemp.setWrapStyleWord(true);
		
		//4.컴포넌트에서 발생한 이벤트를 JVM에서 감지할 수 있도록 이벤트에 등록
		jtfID.addActionListener(this);
		jpfPassword.addActionListener(this);
		
		
		//5.배치관리자를 설정
		setLayout(new BorderLayout()); //JFrame의 배치 관리자는 BorderLayot
		
		//North에 panel을 이용해 여러개의 component를 묶는다.
		JPanel jpNorth = new JPanel();
		
		//Center에 pannel을 이용해 여러개의 component를 묶는다.
		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(1,2)); //FlowLayout => GridLayout으로 변경
		
		//6.component를 배치
		
		//BorderLayout의 North 들어갈 component를 container component를 배치
		jpNorth.add(jlblID);
		jpNorth.add(jtfID);
		jpNorth.add(jlblPassword);
		jpNorth.add(jpfPassword);
		
		//BorderLayout의 Center 들어갈 component를 container component를 배치
		jpCenter.add(jspTemp);
		jpCenter.add(taTemp);
		
		//Window component에 container component를 배치
		add("North",jpNorth);
		add("Center",jpCenter);
		
		//7. window의 크기를 조절
		setBounds(100, 100, 500, 500);
		
		//8. 사용자에게 보여준다.
		setVisible(true);
		
		
		//9. window종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseTextComponent
	
	//10.이벤트가 발생했을 때 제공할 코드를 정의하는 method를 Override
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(jtfID == ae.getSource()) {
			
			//TextField의 값을 가져와서
			String id = jtfID.getText();
			//TextArea에 추가
			jtaTemp.append(id + "\n");
			//텍스트 필드 값을 초기화
			jtfID.setText("");
		}
		
		if(jpfPassword == ae.getSource()) {
			//JpasswordField에 값을 가져와서 
		String pass = String.valueOf(jpfPassword.getPassword());
			//TextArea에 추가
			taTemp.append(pass + "\n");
			//값을 초기화
			jpfPassword.setText("");
		}
	
	}
	public static void main(String[] args) {
		new EventCompare();
		
	}//main
}//class
