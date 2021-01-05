package day210105;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

/**
 * procedure를 사용한 CRUD
 * 
 * @author owner
 */
public class UseCallableStatementDAO {

	private static UseCallableStatementDAO ucsDAO;

	private UseCallableStatementDAO() {
	}

	public static UseCallableStatementDAO getInstance() {
		if (ucsDAO == null) {
			ucsDAO = new UseCallableStatementDAO();
		} // end if
		return ucsDAO;
	}// UseCallableStatementDAO

	private Connection getConnection() throws SQLException {
		Connection con = null;

		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		// 2. 커넥션얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pwd = "tiger";
		con = DriverManager.getConnection(url, id, pwd);

		return con;
	}// end getConnection

	public void insertTestProc() throws SQLException {
		Connection con = null;
		CallableStatement cstmt = null;
		// 1.
		// 2.
		int empno = 261;
		String ename = "이우길";
		int SAL = 3000;
		try {
			con = getConnection();
			// 3.query실행 객체 얻기
			cstmt = con.prepareCall("{ CALL INSERT_PROC(?,?,?,?,?)}");
			// 4. 바인드 변수에 값넣기
			// in parameter : Procedure에 입력값 설정
			cstmt.setInt(1, empno);
			cstmt.setString(2, ename);
			cstmt.setInt(3, SAL);
			// out parameter : Procedure이 처리한 결과값을 받기 위한 설정
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			// 5. query실행 : Procedure 호출
			cstmt.execute();
			// 6. out parameter 값 받기.
			int cnt = cstmt.getInt(4);
			String msg = cstmt.getString(5);
			System.out.println(cnt + msg);
		} finally {
			// 7. 연결 끊기
			if (cstmt != null) {
				cstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // finally

	}// insertTestProc

	public int updateTestProc() throws SQLException {
		int cnt = 0;
		Connection con = null;
		CallableStatement cstmt = null;
		// 1.
		// 2.
		int empno = 261;
		String ename = "우길";
		int sal = 3500;
		try {
			con = getConnection();
			// 3. query 실행 객체 얻기
			cstmt = con.prepareCall("{ CALL UPDATE_PROC(?,?,?,?,?) }");
			// 4. 바인드 변수에 값 넣기
			// in parameter
			cstmt.setInt(1, empno);
			cstmt.setString(2, ename);
			cstmt.setInt(3, sal);
			// out parameter
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			// 5. query문 실행 : Procedure 생행
			cstmt.execute();
			// 6. out parameter 값 받기
			cnt = cstmt.getInt(4);
			String msg = cstmt.getString(5);
			System.out.println("Procedure에서 얻은 값");
			System.out.println(cnt + "/" + msg);
		} finally {
			// 7. 연결 끊기
			if (cstmt != null) {
				cstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // finally
		return cnt;
	}// updateTestProc

	public int deleteTesetProc() throws SQLException {
		int cnt = 0;
		Connection con = null;
		CallableStatement cstmt = null;
		// 1.
		// 2.
		int empno = 261;
		try {
			con = getConnection();
			// 3.
			cstmt = con.prepareCall("{ CALL DELETE_PROC(?,?,?)}");
			// 4.
			// in parameter
			cstmt.setInt(1, empno);
			// out parameter
			cstmt.registerOutParameter(2, Types.NUMERIC);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			// 5.
			cstmt.execute();
			// 6.
			cnt = cstmt.getInt(2);
			String msg = cstmt.getString(3);
			System.out.println("Procedure에서 얻은 값");
			System.out.println(cnt + "/" + msg);
		} finally {
			// 7.
			if (cstmt != null) {
				cstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return cnt;
	}// deleteTesetProc

	public List<ProcedureVO> selectProcedure(String hiredate) throws SQLException {
		List<ProcedureVO> list = new ArrayList<ProcedureVO>();
		// 1.
		// 2.
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			// 3. query 실행 객체 생성
			cstmt = con.prepareCall("{ CALL SELECT_PROC(? ,? ,? )}");
			// 4. 바인드 변수에 값넣기
			// in parameter
			cstmt.setString(1, hiredate);

			// out parameter
//			cstmt.registerOutParameter(2, Types.CURSOR); java에서 제공하는 cursor는 사용 불가
			// SYS_RREFCURSOR를 받기위해 OracleTypes.CURSOR를 사용한다.
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.registerOutParameter(3, Types.VARCHAR);

			// 5. query문 실행 : Procedure 실행
			cstmt.execute();

			// 6. out parameter값 얻기
			rs = (ResultSet) cstmt.getObject(2);
			String msg = cstmt.getString(3);
			System.out.println(msg);

			ProcedureVO pVO = null;
			// 7. 조회 결과 처리
			while (rs.next()) {
				pVO = new ProcedureVO(rs.getInt("DEPTNO"), rs.getString("DNAME"), rs.getString("LOC"),
						rs.getInt("EMPNO"), rs.getString("ENAME"), rs.getString("HIREDATE"));

				list.add(pVO);
			} // end while
		} finally {
			// 연결 끊기
			if (rs != null) {
				rs.close();
			} // end if
			if (cstmt != null) {
				cstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
		return list;
	}// selectProcedure

	public static void main(String[] args) {
		UseCallableStatementDAO ucsDAO = UseCallableStatementDAO.getInstance();
		String hiredate = "1982";
		try {
			List<ProcedureVO> list = ucsDAO.selectProcedure(hiredate);
			if (list.isEmpty()) {
				System.out.println(hiredate);
				System.out.println("해당 년도에 입사한 사원은 없습니다.");
			}
			for (ProcedureVO pVO : list) {
				System.out.println(pVO.toString());
			} // end for
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// main

}// class
