package day1229.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * PreparedStatement를 사용하여 query문을 실행하는 예
 * 
 * @author owner
 */
public class PreparedStatementDAO {

	private static PreparedStatementDAO psDAO;

	/**
	 * 외부에서 객체생성할 수 없는 생성자
	 */
	private PreparedStatementDAO() {
	}// PreparedStatementDAO

	/**
	 * 하나로 관리되는 객체를 반환하는 일.
	 * 
	 * @return singleton 객체
	 */
	public static PreparedStatementDAO getInstance() { // lazy init 형태의 singleton
		if (psDAO == null) {
			psDAO = new PreparedStatementDAO();
		} // end if
		return psDAO;
	}// PreparedStatementDAO

	/**
	 * 커넥션을 반환하는 일을 하는 method
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
			// 2. 커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pwd = "tiger";
		Connection con = DriverManager.getConnection(url, id, pwd);
		return con;
	}// getConnection

	public void insertCpEmp(CpEmpAddVO ceaVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1. 드라이버 로딩
			// 2. 커넥션 얻기
			con = getConnection();
			// 3. query 생성객체 얻기
			String insertEmp = "INSERT INTO CP_EMP2 VALUES (?,?,?,?,?,SYSDATE)";
			pstmt = con.prepareStatement(insertEmp);
			// 4. 바인드 변수에 값넣기
			pstmt.setInt(1, ceaVO.getEmpno());
			pstmt.setString(2, ceaVO.getEname());
			pstmt.setString(3, ceaVO.getJob());
			pstmt.setInt(4, ceaVO.getSal());
			pstmt.setInt(5, ceaVO.getComm());
			// 5. query 수행 후 결과 얻기
			pstmt.executeUpdate(); // query문을 실행할 때 query문을 매개변수로 넣지 않는다.
		} finally {
			// 6. 연결 끊기
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
	}// insertCpEmp

	public int updateCpEmp(CpEmpModifyVO cemVO) throws SQLException {
		int rowCnt = 0;
		// 1.드라이버 로딩
		// 2.커넥션 얻기
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			// 3.query 생성 객체 얻기.
			String updateEmp = 
			new StringBuilder()
			.append("UPDATE CP_EMP2 ")
			.append("SET JOB=?,SAL=?,COMM=? ")
			.append("WHERE EMPNO = ?").toString();
			pstmt = con.prepareStatement(updateEmp);
			// 4.바인드변수에 값 넣기
			pstmt.setString(1, cemVO.getJob());
			pstmt.setInt(2, cemVO.getSal());
			pstmt.setInt(3, cemVO.getComm());
			pstmt.setInt(4, cemVO.getEmpno());
			// 5.query 실행 후 결과 얻기
			rowCnt = pstmt.executeUpdate();
		} finally {
			// 6.연결 끊기
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
		return rowCnt;
	}// insertCpEmp

	
	public int deleteCpEmp(int empno) throws SQLException {
		int rowCnt = 0;
		//1.드라이버 로딩
		//2.커넥션 얻기
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			//3.query 생성 객체 얻기
			String deleteEmp = "DELETE FROM CP_EMP2 WHERE EMPNO = ?";
			pstmt = con.prepareStatement(deleteEmp);
			//4.바인드 변수에 값넣기
			pstmt.setInt(1, empno);
			//5.query 실행 후 결과 얻기
			rowCnt = pstmt.executeUpdate();
		}finally {
			//6.연결 끊기
			if(pstmt != null) {
				pstmt.close();
			}//end if
			if(con != null) {
				con.close();
			}//end if
		}// end finally
		return rowCnt;
	}// insertCpEmp
	
//	public static void main(String[] args) {
//		
//		try {
//			PreparedStatementDAO.getInstance().deleteCpEmp(1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public List<CpEmpAllVO> selectAllCpEmp() throws SQLException {

		return null;
	}// insertCpEmp

	public CpEmpOneVO selectOneCpEmp(int empno) throws SQLException {

		return null;
	}// insertCpEmp

}// class
