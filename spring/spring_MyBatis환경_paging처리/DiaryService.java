package com.diary.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.diary.dao.DiaryDAO;
import com.diary.util.FileUtil;
import com.diary.vo.DiaryVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DiaryService {
	
	private final DiaryDAO diaryDAO;
	private final FileUtil fileUtil;
	
	private final static int SUCCESS = 1;
	
	//페이징 처리를 하여 List를 반환
	public List<DiaryVO> findAllPaging(String userID, int start, int end){
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("userID", userID);
		pagingMap.put("start", start);
		pagingMap.put("end", end);
		return diaryDAO.findAllPaging(pagingMap);
	}
	
	//넘겨받은 일기 번호를 통하여 검색
	public DiaryVO findByNo(int diaryNO) {
		return diaryDAO.findByNo(diaryNO);
	}//findByNo
	
	//일기 저장
	public int save(DiaryVO diaryVO,HttpSession session,HttpServletRequest request) {
		
		//만약 부모글 작성 요청이라면
		int no = diaryDAO.getMax();
		int b_ref = no;
		int b_step = 0;
		int b_level = 0;
		
		//만약 답글에 대한 요청이라면?
		if(diaryVO.getDiaryNO() != 0) {
			DiaryVO p_board = diaryDAO.findByNo(diaryVO.getDiaryNO());
			b_ref = p_board.getB_ref();
			b_step = p_board.getB_step();
			b_level = p_board.getB_level();
			
			Map<String, Integer> map = new HashMap<>();
			map.put("b_ref", b_ref);
			map.put("b_step", b_step);
			//이후 같은 답글 그룹에 있는 답글들의 step값을 1씩 증가시킨다.
			diaryDAO.updateStep(map);
			//증가를 시켰으면 이제 작성되는 답글의 step과 level의 값을 증가시킨다.
			b_step++;
			b_level++;
		}//end if
		
		//처리가 다 끝났으면 VO에 값 할당
		diaryVO.setDiaryNO(no);
		diaryVO.setB_ref(b_ref);
		diaryVO.setB_step(b_step);
		diaryVO.setB_level(b_level);
		
		//세션에 있는 userID로 값을 저장
		diaryVO.setUserID((String)session.getAttribute("userID"));
		//webapp경로 얻어오기
		String path = request.getServletContext().getRealPath("/images");
		//올린 파일의 이름을 얻어온다.
		String fname = diaryVO.getUploadFile().getOriginalFilename();

		//파일 업로드 진행
		if(fname!=null && !"".equals(fname)) {
			try {
				fname = fileUtil.upload(diaryVO, fname, path);
				//fname값 할당
				diaryVO.setFname(fname);
			} catch (IOException e1) {
				e1.printStackTrace();
			}//end catch
		}//end if
		int result = diaryDAO.save(diaryVO);
		
		//저장에 성공할 시 commit 및 return
		if(result == SUCCESS) {
			diaryDAO.commit();
			return result;
		}//end if

		//만약 저장이 실패했다면 upload한 사진 삭제
		File file = new File(path +"/"+fname);
		file.delete();
		return result;
	}

	//파일 삭제
	public int deleteByNo(int diaryNO,HttpServletRequest request) {
		//파일명과 경로를 얻는다.
		String path = request.getServletContext().getRealPath("/images");
		String fname = diaryDAO.findByNo(diaryNO).getFname();
		//삭제를 실행한다.
		int result = diaryDAO.deleteByNo(diaryNO);

		//삭제가 정상적으로 이루어지면 파일을 삭제하고 커밋을 한다.
		if(result == 1) {
			File file = new File(path + "/" + fname);
			file.delete();
		}//end if
		
		return result;
	}//deleteByNo

	//파일 업데이트
	public int update(DiaryVO diaryVO,HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/images");
		String oldFname = diaryVO.getFname();
		String fname = diaryVO.getUploadFile().getOriginalFilename();
		
		if(fname!=null && !"".equals(fname)) {
			try {
				fname = fileUtil.upload(diaryVO,fname,path);
				diaryVO.setFname(fname);
			} catch (IOException e1) {
				e1.printStackTrace();
			}//end catch
		}//end if
		
		int result = diaryDAO.update(diaryVO);
		
		if(result == 1) {
			if(fname!=null && !"".equals(fname)) {
				 new File(path+"/"+oldFname).delete();
			}//end if
			diaryDAO.commit();
		}else {
			//업데이트 실패시 파일 삭제
			new File(path+"/"+fname).delete();
		}//end else
		return result;
	}//update
	
	//로그인 된 아이디의 게시글 수 구하기
	public int count(String userID) {
		return diaryDAO.count(userID);
	}
	
}
