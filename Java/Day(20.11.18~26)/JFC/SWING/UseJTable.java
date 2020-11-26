package day1120.jtable;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UseJTable extends JFrame {
	
	//생성자 작성
	public UseJTable() {
	
		super("JTable 연습");
		
		//3.컴포넌트 생성
		//컬럼명을 저장하는 일차원 배열을 생성
		String[] columnNames = {"번호","이름","나이","이메일","비고"};
		//레코드 값을 저장하는 2차원 배열을 생성
		String[][]rowData = { 
									{"1","이우길","25","lee@test.com" ," "},
									{"2","장일규","27","jang@test.com" ," "},
									{"3","남혜진","25","nam@test.com" ," "},
									{"4","박지원","26","park@test.com" ," "},
									};
		
		//데이터를 저장할 model instance 생성
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
		
		//dtmd에 method를 사용하여 데이터 추가
		//배열로 넣는 방법
		String[] data = {"5","민병권","27","min@test.com"," "};
		dtm.addRow(data);
		
		//Vector을 이용한 방법
		Vector<String> vt = new Vector<String>();
		vt.add("6");
		vt.add("신용주");
		vt.add("25");
		vt.add("sin@test.com");
		vt.add(" ");
		dtm.addRow(vt);
		
		
		//데이터를 보여줄 view를 생성하겠습니다.
		JTable jt = new JTable(dtm);
		
		//scrollbar를 만들어준다.
		JScrollPane jsp = new JScrollPane(jt);
		
		//border설정
		jsp.setBorder(new TitledBorder("학생정보"));
		
		//행의 크기 설정
		jt.setRowHeight(25);
		//column의 넓이를 변경
		jt.getColumnModel().getColumn(0).setPreferredWidth(20);
		jt.getColumnModel().getColumn(1).setPreferredWidth(120);
		jt.getColumnModel().getColumn(2).setPreferredWidth(80);
		jt.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		//4.배치관리자를 설정
		setLayout(new BorderLayout());
		
		//5. 배치
		add("Center",jsp);
		
		//6.window크기설정
		setBounds(100, 100, 700, 200);
		setResizable(false);
		
		//7.사용자에게 보여주기
		setVisible(true);
		
		//8.window종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//UseJTable
	
	public static void main(String[] args) {
		new UseJTable();
	}

}
