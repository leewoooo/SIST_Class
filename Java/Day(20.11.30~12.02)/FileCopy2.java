package day1202.filecopy;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class FileCopy2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4644216139357456699L;

	public static final int EOF = -1;

	private JButton jbtnFileOpen;
	private JTextArea jtaNote;

	public FileCopy2() {

		super("File Copy");

		jbtnFileOpen = new JButton("파일선택");
		jtaNote = new JTextArea();

		JScrollPane jspNote = new JScrollPane(jtaNote);
		jspNote.setBorder(new TitledBorder("복사된 File List"));

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

	private void filecopy() throws IOException {

		FileDialog fdOpen = new FileDialog(this, "열기", FileDialog.LOAD);
		fdOpen.setVisible(true);

		String path = fdOpen.getDirectory();
		String name = fdOpen.getFile();

		if (path != null) {// 파일을 선택하고 열기를 누른경우
			File orgfile = new File(path + name);
			if (orgfile.exists()) {
				StringBuffer sbcopyname = new StringBuffer(orgfile.getAbsolutePath());
				// 파일명에 _bak넣어 복사할 파일명 생성
				sbcopyname.insert(sbcopyname.lastIndexOf("."), "_bak");

				File copyFile = new File(sbcopyname.toString());

				boolean copyFlag = false;

				if (copyFile.exists()) {// 복사할 파일과 동일한 파일명이 존재하는지?
					switch (JOptionPane.showConfirmDialog(this, copyFile.getName() + "동일 파일명이 존재합니다. \n 덮어쓰시겠습니까?")) {
					case JOptionPane.OK_OPTION:
						copyFlag = false;
						break;
					case JOptionPane.NO_OPTION:
						copyFlag = true;
						break;
					case JOptionPane.CANCEL_OPTION:
						copyFlag = true;
						break;
					}// end switch
				} // end if

				if (!copyFlag) { // 중복파일이 없으면 false, 예 -false ,아니오 취소, -true

					FileInputStream readStream = null;
					FileOutputStream writeStream = null;

					try {
						// 1. File을 읽기위한 Stream을 연결한다.
						readStream = new FileInputStream(orgfile);
						// 2. File을 쓰기위한 Stream을 연결한다.
						writeStream = new FileOutputStream(copyFile);
						// 3. File의 내용을 읽어 온다.
						int readSize = 0;
						byte[] readData = new byte[512];
						while ((readSize = readStream.read(readData)) != EOF) {
							// 4. 스트림에 기록한다.
							writeStream.write(readData, 0, readSize);
							// 5. 스트림에 기록된 내용을 목적지로 분출한다.
							writeStream.flush();
						} // end while

						JOptionPane.showMessageDialog(this, name + "이 복사되었습니다.");
					} finally {
						// 6. 연결끊기.
						if (readStream != null) {
							readStream.close();
						} // end if
						if (writeStream != null) {
							writeStream.close();
						} // end if
					} // end finally

					jtaNote.append(sbcopyname.toString() + "\n");
				}
			} // end if
		} // end if

	}// fileOpen

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jbtnFileOpen) {
			try {
				filecopy();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "파일복사중 문제발생");
				e.printStackTrace();
			} // end catch
		} // end if

	}// actionPerformed

	public static void main(String[] args) {
		new FileCopy2();
	}// main

}// class
