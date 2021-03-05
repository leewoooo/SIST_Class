package com.goodfile.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.goodfile.dao.GoodDAO;
import com.goodfile.util.GoodsUtil;
import com.goodfile.vo.GoodVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class GoodConroller {
	
	private final GoodDAO goodDAO;
	
	@GetMapping("/listGoods.do")
	public String findAll(Model model) {
		model.addAttribute("goodsList", goodDAO.findAll());
		return "listGoods";
	}
	
	@GetMapping("/insertGoods.do")
	public String saveForm() {
		return "insertGoods";
	}
	
	//사용자가 입력한 값을 받아올 vo, 실제 경로를 얻어오기 위한 request
	@PostMapping("/insertGoods.do")
	public String save(GoodVO goodVO, HttpServletRequest httpServletRequest,Model model) {
		//webapp경로 찾아서 그 하위에 있는 images파일 설정
		String path = httpServletRequest.getServletContext().getRealPath("/images");
		MultipartFile uploadFile = goodVO.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		if(!fname.endsWith(".jpg") && !fname.endsWith(".png") && !fname.endsWith(".jpeg") && !fname.endsWith(".bmp")) {
			model.addAttribute("msg","사진 형식의 파일만 가능합니다.");
			return "error";
		}
		if(fname != "" && fname!=null) {
			try {
				fname = GoodsUtil.getFileName(fname, path);
				System.out.println(fname);
				//사용자가 올린 파일을 가져온다
				byte[] data = uploadFile.getBytes();
				//사용자가 올린 파일의 이름을 가져온 후
				//VO에 파일이름을 저장한다.
				goodVO.setFname(fname);
				//가져온 파일을 지정 경로에 저장한다.
				FileOutputStream fileOutputStream = new FileOutputStream(path+"/"+fname);
				fileOutputStream.write(data);
				//리소스 반납
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
			
		}//end if
		
		int result = goodDAO.save(goodVO);
		
		if(result == 1) {
			goodDAO.commit();
			return "redirect:listGoods.do";
		}else {
			goodDAO.rollback();
			model.addAttribute("msg","파일등록에 문제가 발생하였습니다.");
			return "error";
		}//end else
	}//save
	
	//상품 번호로 상품 검색 후 상품 디테일
	@GetMapping("/detailGoods.do")
	public String findByNo(@RequestParam("no") int no ,Model model) {
		model.addAttribute("good", goodDAO.findByNo(no));
		return "detailGoods";
	}//findByNo
	
	//상품 번호를 받아 삭제
	@GetMapping("/deleteGoods.do")
	public String deleteByNo(@RequestParam("no") int no, HttpServletRequest httpServletRequest,Model model) {
		String fname = goodDAO.findByNo(no).getFname();
		String filepath = httpServletRequest.getServletContext().getRealPath("/images/")+fname;
		int result = goodDAO.deleteByNo(no);
		if(result==1) {
			File file = new File(filepath);
			file.delete();
			goodDAO.commit();
			return "redirect:listGoods.do";
		}else {
			goodDAO.rollback();
			model.addAttribute("msg","상품 삭제에 실패하였습니다.");
			return "error";
		}//end else
		
	}//end delete

	//상품 번호를 받아 updateform으로 이동
	@GetMapping("/updateGoods.do")
	public String updateForm(@RequestParam("no") int no,Model model) {
		model.addAttribute("good",goodDAO.findByNo(no));
		return "updateGoods";
	}
	
	@PostMapping("/updateGoods.do")
	public String update(GoodVO goodVO, Model model, HttpServletRequest httpServletRequest) {
		String path = httpServletRequest.getServletContext().getRealPath("/images");
		String oldFname = goodVO.getFname();
		
		//사용자가 올린 파일을 가져온다.
		MultipartFile uploadFile = goodVO.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		//사용자가 파일을 지정하지 않아도 uploadFile에 
		//MultipartFile[field="uploadFile", filename=, contentType=application/octet-stream, size=0]
		//이러한 값이 넘어온다.
		if(fname != "" && fname!=null) {
			try {
				fname = GoodsUtil.getFileName(fname, path);
				byte[] data = uploadFile.getBytes();
				FileOutputStream fileOutputStream = new FileOutputStream(path+"/"+fname);
				fileOutputStream.write(data);
				fileOutputStream.close();
				goodVO.setFname(fname);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}//end if
		int result = goodDAO.update(goodVO);
		if(result == 1) {
			//수정도 성공하고 수정할 때 이미지도 수정했다면
			if(fname != "" && fname!=null) {
				File file = new File(path+"/"+oldFname);
				file.delete();
			}//end if
			goodDAO.commit();
			return "redirect:listGoods.do";
		}else {
			goodDAO.rollback();
			model.addAttribute("msg","상품 수정에 실패하였습니다.");
			return "error";
		}//end else;
	}
	

}
