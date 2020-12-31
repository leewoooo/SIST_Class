package day1231;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private static LoginDAO lDAO;

	private LoginDAO() {
	}// LoginDAO

	public static LoginDAO getInstance() {
		if(lDAO == null) {
			lDAO = new LoginDAO();
		}//end if
		return lDAO;
	}// getInstance

	// 로그인에 성공시 이름을 반환한다,
	public String login(String id, String pwd) throws SQLException {
		String name = "";
		// id,pwd 유효성 검사
		id = id.replaceAll("'", "").replaceAll(" ", "").replaceAll("-", "");
		pwd = pwd.replaceAll("'", "").replaceAll(" ", "").replaceAll("-", "");

		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
			// 2.커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String dbid = "scott";
		String dbpwd = "tiger";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, dbid, dbpwd);
			// 3.커넥션으로 부터 query문 실행 객체 얻기
			StringBuilder loginQuery = new StringBuilder();
			loginQuery
			.append(" SELECT NAME ")
			.append(" FROM TEST_LOGIN " )
			.append(" WHERE ID = ? AND PASS = ? ");
			pstmt = con.prepareStatement(loginQuery.toString());
			// 4.바인드 변수에 값넣기
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			// 5.query실행 후 결과얻기.
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("NAME");
			}//end if
			
		} finally {
			// 6.연결 끊기
			if (rs != null) {
				rs.close();
			} // end close
			if (pstmt != null) {
				pstmt.close();
			} // end close
			if (con != null) {
				con.close();
			} // end close
		} // end finally

		return name;
	}//login
	
//	public static void main(String[] args) {
//		LoginDAO lDAO = LoginDAO.getInstance();
//		
//		try {
//			String temp = lDAO.login("lee","123");
//			System.out.println(temp);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}// class
