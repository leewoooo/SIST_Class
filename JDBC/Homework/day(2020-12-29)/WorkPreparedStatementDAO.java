package day1229.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkPreparedStatementDAO {

	private static WorkPreparedStatementDAO wpsDAO;
	
	private WorkPreparedStatementDAO() {
	}

	public static WorkPreparedStatementDAO getInstance() {
		if(wpsDAO == null) {
			wpsDAO = new WorkPreparedStatementDAO();
		}//end if
		return wpsDAO;
	}//getInstance
	
	private Connection getConnection() throws SQLException{
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2. 커넥션 얻기.
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pwd ="tiger";
		Connection con = DriverManager.getConnection(url, id, pwd);
		return  con;
	}
	
	
	public List<WorkEmpAllVO> selectAllEmp() throws SQLException{
		List<WorkEmpAllVO> list = new ArrayList<WorkEmpAllVO>();
		WorkEmpAllVO weVO = null;
		//1.드라이버 로딩
		//2.커넥션얻기.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			//3.query 생성 객체 얻기
			String selectEmp = "SELECT EMPNO,ENAME,DEPTNO,SAL,COMM,JOB FROM EMP";
			pstmt = con.prepareStatement(selectEmp);
			//4.query 실행 후 결과 얻기
			rs = pstmt.executeQuery();
			int empno, deptno,sal,comm = 0;
			String ename,job ="";
			
			while(rs.next()) {
				empno = rs.getInt("EMPNO");
				ename = rs.getString("ENAME");
				deptno = rs.getInt("DEPTNO");
				sal = rs.getInt("SAL");
				comm = rs.getInt("COMM");
				job = rs.getString("JOB");
				weVO= new WorkEmpAllVO(empno, ename, deptno, sal, comm, job);
				list.add(weVO);
			}//end while
		}finally {
			//5.연결 끊기
			if(rs != null) {
				rs.close();
			}//end if
			if(pstmt != null) {
				pstmt.close();
			}//end if
			if(con != null) {
				con.close();
			}//end if
		}//end finally
		return list;
	}//selectAllEmp
	
//	public static void main(String[] args) {
//		try {
//			List<WorkEmpAllVO> list=WorkPreparedStatementDAO.getInstance().selectAllEmp();
//			System.out.println(list);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	
}//end class
