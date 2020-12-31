package day1231;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class IdForm extends JFrame {

	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JLabel jlOutput;
	private boolean loginflag;

	public IdForm() {
		super("로그인");
		jtfId = new JTextField();
		jpfPass = new JPasswordField();
		jlOutput = new JLabel("출력창");

		jtfId.setBorder(new TitledBorder("아이디"));
		jpfPass.setBorder(new TitledBorder("비밀번호"));
		jlOutput.setBorder(new TitledBorder("출력창"));

		setLayout(new GridLayout(3, 1));

		add(jtfId);
		add(jpfPass);
		add(jlOutput);

		// Inner class로 이벤트 처리
		IdForm.EvtInner ei = this.new EvtInner();
		jtfId.addActionListener(ei);
		jpfPass.addActionListener(ei);

		setLocationRelativeTo(null);
		setSize(300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// IdForm

	public void idNullCheck() {
		if ("".equals(jtfId.getText().trim())) {
			JOptionPane.showMessageDialog(this, "아이디 필수입력입니다.");
			return;
		} // end id
		jpfPass.requestFocus();
	}// end idNullCheck

	public void pwdNullCheck() {
		String pwd = new String(jpfPass.getPassword());
		if ("".equals(pwd.trim())) {
			JOptionPane.showMessageDialog(this, "비밀번호 필수입력입니다.");
			return;
		} // end if
		loginflag = true;
	}// pwdNullCheck

	public void login() {
		LoginDAO lDAO = LoginDAO.getInstance();
		String id = jtfId.getText().trim();
		String pwd = new String(jpfPass.getPassword());
		try {
			String name = lDAO.login(id, pwd);
			if ("".equals(name.trim())) {
				jlOutput.setText("로그인에 실패했습니다. ID와 Password를 확인해주세요");
				jtfId.setText("");
				jpfPass.setText("");
				jtfId.requestFocus();
			} else {
				jlOutput.setText(name + "님 환영합니다.");
			} // end else
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// end login

	// Event Inner Class
	public class EvtInner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == jtfId) {
				idNullCheck();
			} // end if

			if (ae.getSource() == jpfPass) {
				pwdNullCheck();
				if(loginflag) {
				login();
				}//end if
				loginflag = false;
			} // end if
		}// actionPerformed

	}// EvtInner

	public static void main(String[] args) {
		new IdForm();
	}// main

}// class
