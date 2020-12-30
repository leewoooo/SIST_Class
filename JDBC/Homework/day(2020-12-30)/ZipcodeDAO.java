package day1230;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ZipcodeDAO {

	private static ZipcodeDAO zDAO;

	private ZipcodeDAO() {
	}// ZipcodeDAO

	public static ZipcodeDAO getInstance() {
		if (zDAO == null) {
			zDAO = new ZipcodeDAO();
		} // end if
		return zDAO;
	}// getInstance

	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException {
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
			// 2.커넥션 얻기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pwd = "tiger";
		try {
			con = DriverManager.getConnection(url, id, pwd);
			// 3. query 생성 객체 얻기
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode
			.append(" SELECT ZIPCODE,SIDO,GUGUN,DONG,NVL(BUNJI,'번지없음') BUNJI ")
			.append(" FROM ZIPCODE ")
			.append(" WHERE DONG LIKE  ?||'%' ");
			pstmt = con.prepareStatement(selectZipcode.toString());
			// 4.바인드 변수에 값넣기
			pstmt.setString(1, dong);
			// 5.query 실행 후 결과 얻기
			rs = pstmt.executeQuery();
			String zipcode = "",sido ="",gugun="",db_dong="",bunji="";
			ZipcodeVO zVO= null;
			while(rs.next()) {
				zipcode = rs.getString("ZIPCODE");
				sido = rs.getString("SIDO");
				gugun = rs.getString("GUGUN");
				db_dong = rs.getString("DONG");
				bunji = rs.getString("BUNJI");
				zVO = new ZipcodeVO(zipcode, sido, gugun, db_dong, bunji);
				list.add(zVO);
			}//end while
		} finally {
			// 6. 연결 끊기
			if (rs != null) {
				rs.close();
			} // end if
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		}//end finally
		return list;
	}//selectZipcode
	
	public List<ZipcodeVO> selectStatementZipcode(String dong) throws SQLException {
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
			// 2.커넥션 얻기
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pwd = "tiger";
		try {
			con = DriverManager.getConnection(url, id, pwd);
			// 3. query 생성 객체 얻기
			stmt=con.createStatement();
			// 4.query 실행 후 결과 얻기
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode
			.append(" SELECT ZIPCODE,SIDO,GUGUN,DONG,NVL(BUNJI,'번지없음') BUNJI ")
			.append(" FROM ZIPCODE ")
			.append(" WHERE DONG LIKE '").append(dong).append("%'");
			rs = stmt.executeQuery(selectZipcode.toString());
			String zipcode = "",sido ="",gugun="",db_dong="",bunji="";
			ZipcodeVO zVO= null;
			while(rs.next()) {
				zipcode = rs.getString("ZIPCODE");
				sido = rs.getString("SIDO");
				gugun = rs.getString("GUGUN");
				db_dong = rs.getString("DONG");
				bunji = rs.getString("BUNJI");
				zVO = new ZipcodeVO(zipcode, sido, gugun, db_dong, bunji);
				list.add(zVO);
			}//end while
		} finally {
			// 6. 연결 끊기
			if (rs != null) {
				rs.close();
			} // end if
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		}//end finally
		return list;
	}//selectStatementZipcode
	
//	public static void main(String[] args) {
//		ZipcodeDAO z = ZipcodeDAO.getInstance();
//		try {
//			System.out.println(z.selectStatementZipcode("상도동%"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

}// ZipcodeDAO
