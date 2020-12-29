package day1229.preparedstatement;

import java.sql.SQLException;

public class UsePreParedStatementDAO {

	public void addEmp() {
		CpEmpAddVO ceaVO = new CpEmpAddVO(1111, "이우길", "개발자", 5000, 5000);
		PreparedStatementDAO psdao = PreparedStatementDAO.getInstance();
		try {
			psdao.insertCpEmp(ceaVO);
			System.out.println(ceaVO.getEmpno() + "번 사원 정보추가 성공");
		} catch (SQLException e) {
			System.err.println("DB에서 문제가 발생하였습니다.");
			switch (e.getErrorCode()) {
			case 1438:
				System.out.println("사원번호는 4자리 입력해주세요.");
				break;
			case 12899:
				if (e.getMessage().contains("ENAME")) {
					System.out.println("사원번호는 10byte 이내로 입력해주세요.");
				} // end if
				if (e.getMessage().contains("JOB")) {
					System.out.println("직무는 9byte 이내로 입력해주세요.");
				} // end if
			}// end switch
			e.printStackTrace();
		} // end catch
	}// addEmp

	public void modifyEmp() {
		
		CpEmpModifyVO cemVo = new CpEmpModifyVO(1, "대리", 5500, 6000);
		
		PreparedStatementDAO psDAO = PreparedStatementDAO.getInstance();
		try {
			int rowCnt = psDAO.updateCpEmp(cemVo);
			if(rowCnt !=0) {
				System.out.println(cemVo.getEmpno() + "번 사원의 정보가 변경되었습니다.");
			}else {
				System.out.println(cemVo.getEmpno() + "번 사원은 존재하지 않습니다.\n사원번호확인요함");
			}
		} catch (SQLException e) {
			System.err.println("DB 작업 중 문제 발생");
			e.printStackTrace();
		}

		
	}// modifyEmp

	public void removeEmp() {

		PreparedStatementDAO psDAO = PreparedStatementDAO.getInstance();
		try {
			int empno = 1111;
			int rowCnt = psDAO.deleteCpEmp(empno);
			if(rowCnt != 0) {
				System.out.println(empno + "번 사원의 정보가 삭제되었습니다.");
			}else {
				System.out.println(empno + "번 사원은 존재하지 않습니다.\n사원번호확인요함");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}//end catch
		
	}// removeEmp

	public void searchAllEmp() {

	}// searchAllEmp

	public void searchOneEmp() {

	}// searchOneEmp

	public static void main(String[] args) {
		UsePreParedStatementDAO upsDAO = new UsePreParedStatementDAO();
//		upsDAO.addEmp();
//		upsDAO.modifyEmp();
		upsDAO.removeEmp();
		

	}// main

}// class
