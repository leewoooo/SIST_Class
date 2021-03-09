package com.diary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.diary.service.DiaryService;
import com.diary.util.GoToPage;
import com.diary.util.PagiNation;
import com.diary.vo.DiaryVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class DiaryController {
	
	private final DiaryService diaryService; 
	private final GoToPage goToPage;
	
	//전체 일기 조회
	@GetMapping("/listDiary.do")
	public String listDiary(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,HttpSession httpSession,Model model) {
		//로그인 할 때 저장했던 userID를 가져온다.
		String userID = (String)httpSession.getAttribute("userID");
		
		//userID로 작성된 게시글의 갯수와 현재 페이지 번호를 넘겨받아 PagiNation객체 생성
		PagiNation pagiNation = new PagiNation(diaryService.count(userID), pageNumber);
		
		//페이징 처리 된 List를 가져온다
		List<DiaryVO> diaryList = diaryService.findAllPaging(userID, pagiNation.getStart(), pagiNation.getEnd());
		
		//전체 페이지 수와 가져온 List를 view에 전달한다
		model.addAttribute("totalPage", pagiNation.getTotalPage());
		model.addAttribute("diaryList", diaryList);
		return "diary";
	}
	
	//번호를 받아서 일기 조회
	@GetMapping("/detailDiary.do")
	public String detail(@RequestParam("diaryNO") int diaryNO,Model model) {
		model.addAttribute("diary", diaryService.findByNo(diaryNO));
		return "detail";
	}
	
	//일기 작성 폼으로 이동
	//답글쓰기로 접근하면 diaryNO가 넘어오기 때문에 받아줘야하고
	//처음 부모글을 작성할 때는 diaryNO값이 필요 없기때문에 default값 0으로 받는다.
	@GetMapping("/write.do")
	public String writeForm(@RequestParam(value = "diaryNO",defaultValue = "0") int diaryNO,Model model) {
		model.addAttribute("diaryNO", diaryNO);
		return "write";
	}
	
	//일기 작성 후 저장 요청
	@PostMapping("/write.do")
	public String write(DiaryVO diaryVO,HttpSession session, HttpServletRequest request,Model model) {
		int result = diaryService.save(diaryVO, session, request);
		String msg = "일기 작성에 실패하였습니다 잠시 후 다시 시도해주세요.";
		return goToPage.redirect(result,msg, model);
	}//write
	
	//일기 수정 폼으로 이동 (이동 시 현재 일기의 VO를 가지고 view로 이동)
	@GetMapping("/update.do")
	public String updateForm(@RequestParam("diaryNO") int diaryNO,Model model) {
		model.addAttribute("diary", diaryService.findByNo(diaryNO));
		return "update";
	}
	
	//일기 수정 요청
	@PostMapping("/update.do")
	public String update(DiaryVO diaryVO,HttpServletRequest request,Model model) {
		int result = diaryService.update(diaryVO, request);
		String msg = "일기 수정에 실패하였습니다 잠시 후 다시 시도해주세요.";
		return goToPage.redirect(result,msg, model);
	}

	//일기 삭제 요청
	@GetMapping("/delete.do")
	public String delete(@RequestParam("diaryNO") int diaryNO,Model model,HttpServletRequest request) {
		int result = diaryService.deleteByNo(diaryNO,request);
		String msg = "일기 삭제에 실패하였습니다 잠시 후 다시 시도해주세요.";
		return goToPage.redirect(result,msg, model);
	}
}
