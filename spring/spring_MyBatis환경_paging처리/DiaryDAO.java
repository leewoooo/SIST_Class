package com.diary.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.diary.db.SqlSessionFactoryBean;
import com.diary.vo.DiaryVO;

@Repository
public class DiaryDAO {
	
	private final SqlSession session;
	
	public DiaryDAO() {
		session = SqlSessionFactoryBean.getSqlSession();
	}
	
	//일기번호로 하나의 일기 조회
	public DiaryVO findByNo(int diaryNO) {
		return session.selectOne("diaryMapper.findByNo", diaryNO);
	}
	
	//VO를 받아서 일기 저장
	public int save(DiaryVO diaryVO) {
		return session.insert("diaryMapper.save", diaryVO);
	}
	
	//일기번호로 일기 삭제
	public int deleteByNo(int diaryNO) {
		return session.delete("diaryMapper.deleteByNo", diaryNO);
	}
	
	//VO를 받아 일기 업데이트
	public int update(DiaryVO diaryVO) {
		return session.update("diaryMapper.update", diaryVO);
	}
	
	//로그인한 유저의 아이디로 작성된 게시글 갯수
	public int count(String userID) {
		return session.selectOne("diaryMapper.count",userID);
	}
	
	//페이징 처리한 일기 조회
	public List<DiaryVO> findAllPaging(Map<String, Object> pagingMap){
		return session.selectList("diaryMapper.findAllPaging",pagingMap);
	}
	
	//글 번호 구하기
	public int getMax() {
		return session.selectOne("diaryMapper.getMax");
	}
	
	//현재 답글보다 step값이 큰 step의 값들을 +1씩 업데이트
	public void updateStep(Map<String, Integer> map) {
		session.update("diaryMapper.updateStep", map);
		commit();
	}
	
	public void commit() {
		session.commit();
	}

}
