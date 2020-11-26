package day1126.usefiledialog;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FileDialogEvt extends WindowAdapter implements ActionListener{

	
	private UseFileDialog ufd;
	
	/**
	 * 디자인 클래스와 이벤트처리 클래스를 HAS-A  관계로 생성하는 생성자. 
	 * @param ufd
	 */
	public FileDialogEvt(UseFileDialog ufd) {
		this.ufd = ufd;
	}//FileDialogEvt
	
	@Override
	public void windowClosing(WindowEvent e) {
		ufd.dispose();
	}//windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생했을 때 비교할 목정의 코드만 정의해야 비교하는 이벤트의 목록을
		//손쉽게 알 수 있다.
		if(ae.getSource() == ufd.getJbtnFileOpen()) { //열기버튼에서 이벤트 발생
			openFileDialog();
		}//end if
		
		if(ae.getSource() == ufd.getJbtnFileSave()) { //저장버튼에서 이벤트 발생
			saveFileDialog();
		}//end if
	}//actionPerformed

	
	private void openFileDialog() {
		
		//1. 다이어로그를 생성한다.
		FileDialog fdOpen = new FileDialog(ufd, "열기", FileDialog.LOAD);
		
		//2,사용자에게 보여주기
		fdOpen.setVisible(true);
		
		//폴더명
		String dir = fdOpen.getDirectory();
		
		//파일명
		String fileName = fdOpen.getFile();
		
		if(dir != null) {
			//선택한 파일명을 JTextArea에 추가
			StringBuilder sb = new StringBuilder();
			sb.append("열기 :").append(dir).append(fileName).append("\n");
			ufd.getJtaFileList().append(sb.toString());
			//JFrame의 타이틀 바를 변경한다.
			ufd.setTitle("파일다이얼로그 - 열기");
		}//end if
		
		
	}//openFileDialog
	
	
	private void saveFileDialog() {
		
		//1. 다이어로그를 생성한다.
		FileDialog fdsave = new FileDialog(ufd, "저장", FileDialog.SAVE);
		
		//2,사용자에게 보여주기
		fdsave.setVisible(true);
		
		//폴더명
		String dir = fdsave.getDirectory();
				
				//파일명
		String fileName = fdsave.getFile();
				
		if(dir != null) {
			//선택한 파일명을 JTextArea에 추가
			StringBuilder sb = new StringBuilder();
			sb.append("저장 :").append(dir).append(fileName).append("\n");
			ufd.getJtaFileList().append(sb.toString());
			//JFrame의 타이틀 바를 변경한다.
			ufd.setTitle("파일다이얼로그 - 저장");
		}
		
	}//saveFileDialog
}//class
