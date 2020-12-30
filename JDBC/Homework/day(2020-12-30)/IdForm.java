package day1230;

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

	private IdForm idfrm;

	public IdForm() {
		super("로그인");
		idfrm = this;
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

		setBounds(100, 100, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// IdForm

	public void idNull() {
		if ("".equals(jtfId.getText().trim())) {
			JOptionPane.showMessageDialog(idfrm, "아이디필수입력");
			jtfId.requestFocus();
			return;
		} // end if
		jpfPass.requestFocus();

	}// idNull

	public void pwdNull() {
		if ("".equals(new String(jpfPass.getPassword()).trim())) {
			JOptionPane.showMessageDialog(idfrm, "비밀번호필수입력");
			jpfPass.requestFocus();
			return;
		} // end if
	}// pwdNull

	public void login() {
		String id = jtfId.getText().trim();
		String pass = new String(jpfPass.getPassword()).trim();

//		LoginStatementDAO lDAO = LoginStatementDAO.getInstance();
		LoginPreParedStatementDAO lpDAO = LoginPreParedStatementDAO.getInstance();
		try {
			String name = lpDAO.login(id, pass);
			
			if("".equals(name)) {
				JOptionPane.showMessageDialog(idfrm, "아이디나 비밀번호를 확인해주세요.");
			}else {
				jlOutput.setText(name+"님 로그인 하셨습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// login

	// Event Inner Class
	public class EvtInner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == jtfId) {
				idNull();
			} // end if

			if (ae.getSource() == jpfPass) {
				pwdNull();
				login();
			}
		}// actionPerformed

	}// EvtInner

	public static void main(String[] args) {
		new IdForm();
	}// main

}// class
