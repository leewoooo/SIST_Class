package day1228.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementCRUD {

	public void insertForm() throws SQLException {
		// 1. 드라이브연결
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
		// 2. 연결 객체 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pwd = "tiger";

		Statement stmt = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			// 3. 커넥션으로 부터 query실행 객체 얻기
			stmt = con.createStatement();
			// 4. query실행 후 결과 얻기
			String insertCP_EMP3 = new StringBuilder("INSERT INTO CP_EMP3 VALUES (").append(2222).append(",'남혜진',")
					.append("SYSDATE,").append(20).append(",'사원',").append(3000).append(")").toString();
			stmt.executeUpdate(insertCP_EMP3);
		} finally {
			//5.연결끊기
			if (stmt != null) {
				stmt.close();
			}//end if
			if (con != null) {
				con.close();
			}//end if
		}// end finally
	}//insertForm
	
	public void updateForm() throws SQLException {
		//1. 드라이브 연결
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		//2. 연결 객체 얻기.
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pwd = "tiger";
		
		Statement stmt = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			//3. 커넥션에서 query 실행 객체 얻기.
			stmt = con.createStatement();
			//4. 4. query실행 후 결과 얻기
			String updateCP_EMP3 = new StringBuilder("UPDATE CP_EMP3 SET ").append("DEPTNO = 50,").append("JOB = '주임',").append("SAL = 3200 ")
					.append("WHERE EMPNO = 2222").toString();
			stmt.executeUpdate(updateCP_EMP3);
		}finally {
			//5.연결 끊기
			if(stmt != null) {
				stmt.close();
			}//end if
			if(con != null) {
				con.close();
			}//end if
		}//end finally
	}//updateForm
	
	
	public void deleteForm() throws SQLException {
		//1.드라이브 연결
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
		
		//2. 연결 객체 얻기.
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pwd = "tiger";
		
		Statement stmt = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			//3. 연결 객체에서 query실행 객체 얻기.
			stmt = con.createStatement();
			//4. query 실행 후 결과 얻기
			String deleteCP_EMP3 ="DELETE FROM CP_EMP3 WHERE EMPNO = 2222";
			stmt.executeUpdate(deleteCP_EMP3);
		}finally {
			//5.연결 끊기
			if(stmt !=null) {
				stmt.close();
			}//end if
			if(con != null) {
				con.close();
			}//end if
		}//end finally
		
	}//deleteForm
	
	
}// class
