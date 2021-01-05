package day210105.clob;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UseClob {

	public UseClob() throws SQLException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pwd = "tiger";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, id, pwd);

			String selectTestClob = "SELECT SUBJECT,CONTENTS,WRITER,TO_CHAR(INPUT_DATE,'yyyy-mm-dd') INPUT_DATE FROM TEST_CLOB";
			pstmt = con.prepareStatement(selectTestClob);

			rs = pstmt.executeQuery();

			BufferedReader br = null;
			StringBuilder sb = null;
			Clob clob = null;
			String subject = "";
			String contents = "";
			String writer = "";
			String input_date = "";
			while (rs.next()) {
				subject = rs.getString("SUBJECT");
//				contents = rs.getString("CONTENTS");//local인경우에는 문제가 없다.
				writer = rs.getString("WRITER");
				input_date = rs.getString("INPUT_DATE");

				System.out.println("-------------------------------------------------------------");
				System.out.println("제목" + subject);
				System.out.println("-------------------------------------------------------------");
//				System.out.println("내용" + contents);

				System.out.println("내용 : ");
				// Clob 데이터형을 읽어들이기 위해 Stream을 연결한다.
				clob = rs.getClob("CONTENTS");
				br = new BufferedReader(clob.getCharacterStream());
				sb = new StringBuilder();
				try {
					while ((contents = br.readLine()) != null) {
						sb.append(contents).append("\n");
//						System.out.println(contents);
					}
					System.out.println(sb.toString());
				} catch (IOException ie) {
					System.out.println("기사를 읽어들일 수 없습니다.");
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						} // end catch
					} // end if
				} // finally

				System.out.println("작성자" + writer);
				System.out.println("작성일" + input_date);

			} // end while

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally
	}// UseClob

	public static void main(String[] args) {
		try {
			new UseClob();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// main

}// class
