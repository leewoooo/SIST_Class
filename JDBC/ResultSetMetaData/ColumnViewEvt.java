package day210104;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ColumnViewEvt implements ActionListener {

	private ColumnView cv;

	public ColumnViewEvt(ColumnView cv) {
		this.cv = cv;
		setAllTable();
	}// ColumnViewEvt

	public void setAllTable() {
//		ColumnViewDAO cvDAO = ColumnViewDAO.getInstance();
//		try {
//			cv.getDcbmTableName().addAll(cvDAO.selectAllTablename());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}//end catch

		// JComboBox에 값을 설정하는 Model객체를 얻는다.
		DefaultComboBoxModel<String> dcbm = cv.getDcbmTableName();
		// dbms에서 조회된 테이블 명을 얻는다.
		ColumnViewDAO cvDAO = ColumnViewDAO.getInstance();
		try {
			List<String> list = cvDAO.selectAllTablename();
			// Model 객체에 조회된 결과를 설정합니다.
//			dcbm.addAll(list);
			for (String table : list) {
				dcbm.addElement(table);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(cv, "죄송합니다. 테이블명을 조회할 수 없습니다.");
			e.printStackTrace();
		} // end catch
	}// setAllTable

	public void setTableColumn(String tableName) {
		try {
			// 입력된 테이블에 column정보를 조회하여
			List<ColumnVO> columnData = ColumnViewDAO.getInstance().selectOneTable(tableName);
			// Model에 설정.
			DefaultTableModel dtm = cv.getDtmColumnView();
			dtm.setRowCount(0); // 행을 보여주기 전에 행을 초기화한다.

			// 행의 값을 설정하기 위한 Object[] 선언
			Object[] rowData = null;
			ColumnVO cv = null;
			for (int i = 0; i < columnData.size(); i++) {
				cv = columnData.get(i);
				rowData = new Object[5];
				rowData[0] = Integer.valueOf(i + 1);
				rowData[1] = cv.getColumnName();
				rowData[2] = cv.getDataType();
				rowData[3] = cv.getPrecision();
				rowData[4] = cv.getNullFlag()==0? "NOT NULL" : "NULL";
				dtm.addRow(rowData);
			} // end for

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(cv, tableName + "테이블의 정보를 조회할 수 없습니다.");
			e.printStackTrace();
		} // end catch
	}// end setTableColumn

	@Override
	public void actionPerformed(ActionEvent ae) {
		String tableName = cv.getDcbmTableName().getElementAt(cv.getJcbTableName().getSelectedIndex());
		switch (JOptionPane.showConfirmDialog(cv, tableName + "의 정보를 조회하시겠습니까?")) {
		case JOptionPane.OK_OPTION: {
			setTableColumn(tableName);
		} // end case
		}// end switch
	}// actionPerformed
}// class
