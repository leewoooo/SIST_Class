package day1126.usefiledialog;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseFileDialog extends JFrame {
	
	private JButton jbtnFileOpen;
	private JButton jbtnFileSave;
	private JTextArea jtaFileList;
	
	public UseFileDialog() {
		super("FileDialog");
		
		//생성자 안에서 component를 설정할 때 형을 제거후 선언한다.
		jbtnFileOpen = new JButton("파일열기");
		jbtnFileSave = new JButton("파일저장");
		jtaFileList = new JTextArea();
		
		JScrollPane jspCenter = new JScrollPane(jtaFileList);
		jspCenter.setBorder(new TitledBorder("파일리스트"));
		
		JPanel jpNorth = new JPanel();
		jpNorth.setBorder(new TitledBorder("다이얼로그 선택"));
		jpNorth.add(jbtnFileOpen);
		jpNorth.add(jbtnFileSave);
		
		//이벤트 처리 객체를 생성하고
		FileDialogEvt fde = new FileDialogEvt(this);
		//컴포넌트에서 발생하는 이벤트를 처리할수 있도록 이벤트를 등록한다.
		jbtnFileOpen.addActionListener(fde); //ActionEvent
		jbtnFileSave.addActionListener(fde); //ActionEvent
		addWindowListener(fde);//WindowEvent
		
		
		add("North",jpNorth);
		add("Center",jspCenter);
		
		setBounds(100,100,500,600);
		
		
		setVisible(true);
		
		
	}//UseFileDialog

	public JButton getJbtnFileOpen() {
		return jbtnFileOpen;
	}//getJbtnFileOpen

	public JButton getJbtnFileSave() {
		return jbtnFileSave;
	}//getJbtnFileSaver

	public JTextArea getJtaFileList() {
		return jtaFileList;
	}//getJtaFileList
	

	public static void main(String[]args) {
		new UseFileDialog();
	}//main
}
