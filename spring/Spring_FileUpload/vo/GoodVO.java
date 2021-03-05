package com.goodfile.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoodVO {

	private int no;
	private String name;
	private int qty;
	private int price;
	private String fname;
	private MultipartFile uploadFile;
	
}
