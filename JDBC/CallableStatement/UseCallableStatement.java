package day210104;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class UseCallableStatement {

	public UseCallableStatement() throws SQLException {

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

		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = DriverManager.getConnection(url, id,pwd);
			// 3. query실행 객체 얻기 (미리 생성해 둔 PLUS_PROC를 호출할 것이다. in 2개 out 1개)
			cstmt = con.prepareCall("{call PLUS_PROC(?,?,?)}");
			// 4. 바인드 변수에 값 설정 (in parameter, out parameter)
			//in parameter
			int num1 = 100, num2 = 200;
			cstmt.setInt(1, num1);
			cstmt.setInt(2, num2);
			//out parameter : PL/SQL에서는 var로 선언하는 바인드 변수
			cstmt.registerOutParameter(3, Types.NUMERIC);
			// 5. Procedure를 실행
			cstmt.execute();
			// 6. out parameter의 설정된 값 얻기
			int result = cstmt.getInt(3);
			System.out.println(num1 +"+"+num2+"="+result);
		} finally {
			// 7. 연결 끊기
			if (cstmt != null) {
				cstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
	}// UseCallableStatement

	public static void main(String[] args) {
		try {
			new UseCallableStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// main
}// class
