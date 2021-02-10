package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sist.vo.GoodsVO;

public class GoodsDAO {

	private static GoodsDAO gDAO;
	
	private GoodsDAO() {
	}

	public static GoodsDAO getInstance() {
		if(gDAO == null) {
			gDAO = new GoodsDAO();
		}
		return gDAO;
	}

	public Connection getConnection() throws SQLException{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		return DriverManager.getConnection(url, user, password);
	}
	
	public int insert(GoodsVO gVO) {
		int flag = -1;
		String sql = "INSERT INTO GOODS VALUES (?,?,?,?,?)";
		try(Connection con = gDAO.getConnection(); PreparedStatement pstmt =con.prepareStatement(sql)){
			pstmt.setInt(1, gVO.getNo());
			pstmt.setString(2, gVO.getName());
			pstmt.setInt(3, gVO.getQty());
			pstmt.setInt(4, gVO.getPrice());
			pstmt.setString(5, gVO.getFname());
			flag = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}//end catch
		return flag;
	}//insert
	
	
	public List<GoodsVO> findAll(){
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "SELECT * FROM GOODS";
				
		try(Connection con = gDAO.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()){
			GoodsVO gVO = null;
			while(rs.next()) {
				gVO = new GoodsVO(rs.getInt("NO"), rs.getString("NAME"), rs.getInt("QYT"), rs.getInt("PRICE"), rs.getString("FNAME"));
				list.add(gVO);
			}//while
		}catch(SQLException e) {
			e.printStackTrace();
		}//end catch
		return list;
	}//findAll
	
	public GoodsVO findGood(int no){
		GoodsVO gVO = null;
		String sql = "SELECT * FROM GOODS WHERE NO =?";
		try(Connection con = gDAO.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, no);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					gVO = new GoodsVO(no, rs.getString("NAME"), rs.getInt("QYT"), rs.getInt("PRICE"), rs.getString("FNAME"));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return gVO;
	}
	
	public int deleteGood(int no) {
		int flag = -1;
		String sql = "DELETE FROM GOODS WHERE NO =?";
		try(Connection con = gDAO.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, no);
			flag = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public int updateGood(GoodsVO gVO) {
		int flag = -1;
		String sql = "UPDATE GOODS SET NAME=?,QYT=?,PRICE=?,FNAME=? WHERE NO=?";
		try(Connection con = gDAO.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, gVO.getName());
			pstmt.setInt(2, gVO.getQty());
			pstmt.setInt(3, gVO.getPrice());
			pstmt.setString(4, gVO.getFname());
			pstmt.setInt(5, gVO.getNo());
			flag = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
