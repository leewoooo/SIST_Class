package day1228.work;

import java.sql.SQLException;

public class UseStatement {

	private StatementCRUD stmt;

	public UseStatement() {
		stmt = new StatementCRUD();
	}//UseStatement

	public void addForm() {
		try {
			stmt.insertForm();
			System.out.println("행이 추가 되었습니다.");
		} catch (SQLException e) {
			System.out.println("행의 추가가 실패하였습니다.");
			e.printStackTrace();
		} // end catch
	}// end addForm

	public void modifyForm() {
		try {
			stmt.updateForm();
			System.out.println("행이 업데이트 되었습니다.");
		} catch (SQLException e) {
			System.out.println("행의 업데이트가 실패하였습니다.");
			e.printStackTrace();
		} // end catch
	}// modifyForm

	public void removeForm() {
		try {
			stmt.deleteForm();
			System.out.println("행이 삭제 되었습니다.");
		} catch (SQLException e) {
			System.out.println("행의 삭제가 실패하였습니다.");
			e.printStackTrace();
		} // end catch
	}// end removeForm

	public static void main(String[] args) {

		UseStatement us = new UseStatement();
//		us.addForm();
//		us.modifyForm();
		us.removeForm();
	}// main

}// class
