package com.goodfile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.goodfile.db.SqlSessionFactoryBeen;
import com.goodfile.vo.GoodVO;

@Repository
public class GoodDAO {
	
	private SqlSession session;
	
	public GoodDAO() {
		session = SqlSessionFactoryBeen.getSqlSession();
	}
	
	public List<GoodVO> findAll(){
		return session.selectList("GoodsMapper.findAll");
	}

	public int save(GoodVO goodVO) {
		return session.insert("GoodsMapper.save", goodVO);
	}
	
	public GoodVO findByNo(int no) {
		return session.selectOne("GoodsMapper.findByNo", no);
	}
	
	public int deleteByNo(int no) {
		return session.delete("GoodsMapper.deleteByNo", no);
	}
	
	public int update(GoodVO goodVO) {
		return session.update("GoodsMapper.update", goodVO);
	}
	
	public void commit() {
		session.commit();
	}
	
	public void rollback(){
		session.rollback();
	}

	
}
