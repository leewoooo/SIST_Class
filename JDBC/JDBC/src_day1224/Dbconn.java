package day1224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB에 연결해서 cconnection 얻는 것 까지
 * 
 * @author owner
 */
public class Dbconn {

	public Dbconn() {

		// 1. Driver Loading
		try {
			//외부 jar파일을 eclipse가 사용하려면 build path를 설정하여 사용
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로딩 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		//2. Loading된 Driver를 사용하여 DB연결 얻기
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pass="tiger";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pass);
			System.out.println("DB연결 성공 : " + con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		} finally {
//			if(con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}//end catch
//			}//end if
//		}// end finally
		
	}// Dbconn

	public static void main(String[] args) {
		new Dbconn();
	}// main

}// class
