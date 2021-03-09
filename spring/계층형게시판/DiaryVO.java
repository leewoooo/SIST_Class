package com.diary.vo;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryVO {
	
	private String userID;
	private String diaryTitle;
	private String diaryContent;
	private Timestamp createdAt;
	private Timestamp modifiedAt;
	private String fname;
	private int diaryNO;
	private MultipartFile uploadFile;
	
	//계층형 게시판을 위한 필드
	private int b_ref; // 답글다는 부모글 번호
	private int b_step; // 답글그룹안에서의 순번
	private int b_level; // 답글의 깊이 ex) 부모글의 답글 or 답글의 답글

}
