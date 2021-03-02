package com.sist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@Controller
public class BoardController {
	
	private final BoardDAO boardDAO;
	
	@Autowired
	public BoardController(BoardDAO boardDAO) {
		super();
		this.boardDAO = boardDAO;
	}



	@RequestMapping(value = "/listboard.do", method = RequestMethod.GET)
	public String findAll(Model model) {
		model.addAttribute("list", boardDAO.findAll());
		return "listBoard";
	}
	
	@RequestMapping(value = "/detailboard.do", method = RequestMethod.GET)
	public String findByNo(@RequestParam int no, Model model ) {
		model.addAttribute("board", boardDAO.findByNo(no));
		return "detailBoard";
	}
	
	//저장
	@RequestMapping(value = "/insertboard.do", method = RequestMethod.GET)
	public String save() {
		return "insertBoard";
	}
	
	//저장처리
	@RequestMapping(value = "/insertboard.do", method = RequestMethod.POST)
	//BoardVO처럼 받아오는 객체를 커맨드 객체라한다.
	//(이렇게 하기 위해서는 form의 이름과 객체 필드명과 같아야하며 프로퍼티 방식으로 값을 할당해
	//가져온다.
	public String saveAction(BoardVO boardVO, HttpServletRequest request,Model model) {
		String ip = request.getRemoteAddr();
		boardVO.setIp(ip);
		int flag = boardDAO.save(boardVO);
		
		switch(flag) {
			case 1 : {
				return "redirect:listboard.do";
			}
			default :{
				model.addAttribute("msg", "게시글 등록이 실패하였습니다.");
				return "error";
			}
		}
	}
	
	//업데이트 폼으로
	@RequestMapping(value = "/updateboard.do", method = RequestMethod.GET)
	public String update(@RequestParam int no, Model model) {
		model.addAttribute("board", boardDAO.findByNo(no));
		return "updateBoard";
	}
	
	//업데이트 수행
	@RequestMapping(value = "/updateboard.do", method = RequestMethod.POST)
	public String updateAction(BoardVO boardVO, Model model) {
		
		int flag = -1;
		
		String dbpwd = boardDAO.findByNo(boardVO.getNo()).getPwd();
		String inputpwd = boardVO.getPwd();
		
		if(dbpwd.equals(inputpwd)) {
			flag = boardDAO.update(boardVO);
		};
		
		switch(flag) {
			case 1 : {
				return "redirect:listboard.do";
			}
			default :{
				model.addAttribute("msg", "게시글 수정 실패하였습니다.");
				return "error";
			}
		}
	}
	
	@RequestMapping(value = "/deleteboard.do", method = RequestMethod.GET)
	public String deleteByNo(@RequestParam int no,Model model) {
		int flag = boardDAO.delete(no);
		switch(flag) {
			case 1 : {
				return "redirect:listboard.do";
			}
			default :{
				model.addAttribute("msg", "게시글 삭제 실패하였습니다.");
				return "error";
			}
		}
	}
	
}
