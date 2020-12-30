package day1230;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")

//1. JFrame을 상속받는다 ( Window Component를 상속받은 것과 같다)
public class ZipcodeSearch extends JFrame {

	private JButton jbtnInput;
	private JTextArea jtaZipcodeDisplay;
	private JScrollPane jspZipcodeScroll;
	private JTextField jtfDong;

	// 2. 생성자를 생성한다.
	public ZipcodeSearch() {
		super("우편번호 검색");

		// 3.일반 Component를 생성합니다.
		JLabel jlblZipcode = new JLabel("우편번호");
		jtfDong = new JTextField(20);
		jbtnInput = new JButton("조회");
		jtaZipcodeDisplay = new JTextArea();
		jspZipcodeScroll = new JScrollPane(jtaZipcodeDisplay);

		// 4.배치관리자 생성 (현재 기본 레이아웃 메니저는 Border Layout이다)
		setLayout(new BorderLayout());

		// 5.컴포넌트 배치
		// BorderLayout은 하나의 영역에 하나의 컴포넌트만 배치할 수 있다.
		// North영역에는 여러개의 component를 배치하고자 하기에 Container Component인 Jpanel이 필요하다.
		JPanel jpNouth = new JPanel(); // flow layout
		// Container Component에 Layout을 설정하자
		jpNouth.setLayout(new FlowLayout());
		jpNouth.add(jlblZipcode);
		jpNouth.add(jtfDong);
		jpNouth.add(jbtnInput);

		// inner class에 이벤트 등록
		InnerEvt ie = this.new InnerEvt();
		jbtnInput.addActionListener(ie);
		jtfDong.addActionListener(ie);

		add("North", jpNouth);
		add("Center", jspZipcodeScroll);

		// 6.window 크기 설정
		setLocation(500, 500);
		setSize(400, 300);

		// 7.사용자에게 보여주기
		setVisible(true);

		// 8.window 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// UseLayoutManager

	// ineer class로 event처리
	public class InnerEvt implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			String dong = jtfDong.getText().trim();
			if (!"".equals(dong)) {
				setZipcode(dong);
				jtfDong.setText("");
			} // end if

		}// actionPerformed

		public void setZipcode(String dong) {

			ZipcodeDAO zDAO = ZipcodeDAO.getInstance();
			//sql injection 방어 코드: ' , --의 특수문자를 제거한다.. 공백을 제거한다., query에 관련된 문장을 제거한다.
			if(dong.contains("'") || dong.contains("-") || dong.contains(" ")) {
				dong=dong.replaceAll("'", "").replaceAll("-", "").replaceAll(" ", "");
			}
			try {
				List<ZipcodeVO> listZipcode = zDAO.selectZipcode(dong);//PreParedStatement
//				List<ZipcodeVO> listZipcode = zDAO.selectStatementZipcode(dong);//Statement : SQLINJECTION이 발생할 수 있다.

				StringBuilder sbOutput = new StringBuilder();
				sbOutput.append("[ ").append(dong).append(" ]으로 검색한 결과입니다.\n");
				sbOutput.append("우편번호\t주소\n");
				sbOutput.append("==============================================================\n");

				if (listZipcode.isEmpty()) {
					sbOutput.append("입력하신 동은 존재하지 않습니다.\n 동이름을 확인해주세요.");
				} else {
					for (ZipcodeVO zVO : listZipcode) {
						sbOutput
						.append(zVO.getZipcode()).append("\t").append(zVO.getSido()).append(" ")
						.append(zVO.getGugun()).append(" ")
						.append(zVO.getDong()).append(" ")
						.append(zVO.getBunji()).append("\n");
					} // end for
				} // end else

				jtaZipcodeDisplay.setText(sbOutput.toString());

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}// setZipcode

	}// InnerEvt

	public static void main(String[] args) {

		new ZipcodeSearch();

	}// main

}// class
