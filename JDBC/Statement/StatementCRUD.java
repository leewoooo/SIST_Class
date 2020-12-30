package day1228;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementCRUD {

	public void insertProcess(CPDeptVO cdVO) throws SQLException {
		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
		// 2. 로딩된 드라이버를 사용하여 connection 얻기.
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pwd = "tiger";
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			// 3. connection으로 부터 query문 생성 객체 얻기
			stmt = con.createStatement();
			// 4. query문 실행 후 결과 얻기.
			String insertQuery = new StringBuilder("INSERT INTO CP_DEPT VALUES (").append(cdVO.getDeptno()).append(",'")
					.append(cdVO.getDname()).append("','").append(cdVO.getLoc()).append("')").toString();
			stmt.executeUpdate(insertQuery);
		} finally {
			// 5 연결 끊기
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

	}// insertProcess

	public int updateProcess(CPDeptVO cdVO) throws SQLException {
		int rowCnt = 0;

		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		try {
			// 2. 커넥션 얻기
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";

			con = DriverManager.getConnection(url, id, pwd);
			// 3. 쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			// 4. 쿼리문 수행 후 결과 얻기
			String updateCP_DEPT = new StringBuilder("UPDATE CP_DEPT SET DNAME ='").append(cdVO.getDname())
					.append("',LOC = '").append(cdVO.getLoc()).append("' WHERE DEPTNO =").append(cdVO.getDeptno())
					.toString();

			rowCnt = stmt.executeUpdate(updateCP_DEPT);
		} finally {
			// 5. 연결 끊기
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return rowCnt;
	}// updateProcess

	public int deleteProcess(int deptno) throws SQLException {
		int rowCnt = 0;

		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. 커넥션 얻기
		Connection con = null;
		Statement stmt = null;

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pwd = "tiger";

		try {
			con = DriverManager.getConnection(url, id, pwd);
			// 3. 쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			// 4. 쿼리문 수행 후 결과 얻기
			String deleteCP_DEPT = new StringBuilder("DELETE FROM CP_DEPT WHERE DEPTNO =").append(deptno).toString();
			rowCnt = stmt.executeUpdate(deleteCP_DEPT);
		} finally {
			// 5. 연결 끊기
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return rowCnt;
	}// deleteProcess

}// class
