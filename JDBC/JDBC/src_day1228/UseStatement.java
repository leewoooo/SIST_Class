package day1228;

import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Statement를 사용한 CRUD
 * 
 * @author owner
 */
public class UseStatement {

	private StatementCRUD stmtCRUD;

	public UseStatement() {
		stmtCRUD = new StatementCRUD();
	}

	public void addForm() {
		String csvData = JOptionPane.showInputDialog("부서정보추가 \n 입력 ex) 부서번호,부서명,위치");
		// ,로 구분되어 입력된 값을 분리한다
		String[] processData = csvData.split(",");

		// 입력된 값을 DBMS에 insert하기 위해 입력값을 VO에 설정한다.
		CPDeptVO cdVO = new CPDeptVO(Integer.parseInt(processData[0]), processData[1], processData[2]);

		try {
			stmtCRUD.insertProcess(cdVO);// 입력된 값을 묶어서 가지고 있는 VO를 입력.
			System.out.println(cdVO.getDeptno() + "번 부서정보 추가 성공");
		} catch (SQLException e) { // method안에서 발생하는 모든 예외를 모아서 처리 할 수있다.
			System.out.println(cdVO.getDeptno() + "번 부서정보 추가 실패");
			// SQLException은 error코드를 다양하게 반환한다.
			switch (e.getErrorCode()) {
			case 1:
				System.out.println("같은 부서 번호가 존재합니다.");
				break;
			case 1400:
				System.out.println("부서명은 반드시 입력해야 합니다.");
				break;
			case 1438:
				System.out.println("부서번호는 숫자 2자리 입니다.");
				break;
			case 12899:
				System.out.println("부서명이나 위치의 글자수를 확인해주세요.\n부서명 : 14byte 위치: 13byte");
				break;
			}
			e.printStackTrace();
		} // end catch

	}// insert

	public void modifyForm() {

		String csvData = JOptionPane.showInputDialog("부서정보변경\n부서번호와 일치하는 부서의 부서명과 위치 변경 \n입력 ex) 부서번호,부서명,위치");
		// ,로 구분되어 입력된 값을 분리한다
		String[] processData = csvData.split(",");

		// 입력된 값을 DBMS에 insert하기 위해 입력값을 VO에 설정한다.
		CPDeptVO cdVO = new CPDeptVO(Integer.parseInt(processData[0]), processData[1], processData[2]);

		try {
			int cnt = stmtCRUD.updateProcess(cdVO);

			if (cnt == 0) {
				System.out.println(cdVO.getDeptno() + "번 부서정보가 수정되지 않았습니다.\n부서번호를 확인해주세요.");
			} else {
				System.out.println(cdVO.getDeptno() + "번 부서정보가 수정되었습니다.");
			}
		} catch (SQLException e) {
			System.err.println("DB작업 중 문제 발생");
			switch (e.getErrorCode()) {
			case 1400:
				System.out.println("부서명은 반드시 입력해야 합니다.");
				break;
			case 12899:
				System.out.println("부서명이나 위치의 글자수를 확인해주세요.\n부서명 : 14byte 위치: 13byte");
				break;
			}
			e.printStackTrace();
		} // end catch

	}// updateForm

	public void removeForm() {
		String inputData = JOptionPane.showInputDialog("부서정보삭제\n부서번호와 일치하는 부서의 정보를 삭제합니다. \nex) 부서번호");

		int deptno = Integer.parseInt(inputData);
		try {
			int cnt = stmtCRUD.deleteProcess(deptno);
			if (cnt != 0) {
				System.out.println(deptno + "번 부서정보가 삭제되었습니다.");
			} else {
				System.out.println(deptno + "번 부서정보가 삭제되지 않았습니다.");
			}
		} catch (SQLException e) {
			System.err.println("DB작업 중 문제 발생");
			e.printStackTrace();
		} // end catch
	}// removeForm

	public static void main(String[] args) {
		UseStatement us = new UseStatement();
//		us.addForm();
//		us.modifyForm();
		us.removeForm();
	}// main

}// class
