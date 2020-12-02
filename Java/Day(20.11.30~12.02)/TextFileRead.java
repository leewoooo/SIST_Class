package day1201.textfileread;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * 버튼을 클릭하면 FileDialog를 제공하고 FileDialog에서 파일을 선택하면 선택한 파일의 내용을 JtextArea에 출력
 * 메모장의 읽기기능.
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class TextFileRead extends JFrame implements ActionListener {

	private JButton jbtnFileOpen;
	private JTextArea jtaNote;

	public TextFileRead() {

		super("메모장 열기 기능");

		jbtnFileOpen = new JButton("파일선택");
		jtaNote = new JTextArea();

		JScrollPane jspNote = new JScrollPane(jtaNote);
		jspNote.setBorder(new TitledBorder("문서파일의 내용"));

		JPanel jpNorth = new JPanel();
		jpNorth.add(jbtnFileOpen);

		// 이벤트의 등록
		jbtnFileOpen.addActionListener(this);

		add("North", jpNorth);
		add("Center", jspNote);

		setBounds(100, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// TextFileRead

	private void fileOpen() {

		FileDialog fdOpen = new FileDialog(this, "열기", FileDialog.LOAD);
		fdOpen.setVisible(true);

		String path = fdOpen.getDirectory();
		String name = fdOpen.getFile();

		if (path != null) {// 파일을 선택하고 열기를 누른경우
			// 파일의 확장자가 java일때만 파일을 열어서 보여주자
			if (name.endsWith("java")) {
				// 선택한 파일의 경로와 파일명으로 파일 클래스를 생성한다.
				File file = new File(path + name);
				System.out.println(file);
				if (file.exists()) {// 파일이 존재하는지 묻는이유는 내가 작업하는 동안 파일이 삭제되거나 이동될 수 있기 때문
					// 스트림을 사용하여 선택한 파일에 연결하고,
					// 파일의 내용을 읽어들여
					// JtextArea에 출력
					// 스트림을 사용했으면 스트림을 종료해야한다.
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
						jtaNote.setText("");
						String temp = "";
						while ((temp = br.readLine()) != null) {
							// JtextArea에 출력
							jtaNote.append(temp + "\n"); // append는 줄바꿈의 기능이 없다.
						}
					} catch (IOException ie) {
						JOptionPane.showMessageDialog(this, "죄송합니다. 작업중 불편을 드려 죄송합니다.,");
						ie.printStackTrace();
					} // end catch

				} // end if

			} // end if

		} // end if

	}// fileOpen

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jbtnFileOpen) {
			fileOpen();
		} // end if

	}// actionPerformed

	public static void main(String[] args) {
		new TextFileRead();
	}// main

}// class
