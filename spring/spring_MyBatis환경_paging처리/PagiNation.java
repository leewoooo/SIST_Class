package com.diary.util;


import lombok.Getter;

@Getter
public class PagiNation {
	
	
	private int pageSize;
	private int count;
	private int totalPage;
	private int start;
	private int end;
	
	public PagiNation(int count ,int pageNumber) {
		this.count = count;
		this.pageSize = 10;
		this.totalPage = (int)Math.ceil(count/(double)pageSize);
		//만약 10개를 보여주고 현제 pageNumber가 1이라면 
		//시작값은 0
		//끝값은 11로 해서 범위를 0 < seq AND 11 > seq로 하면 10개의 게시물을 보여줄 수 있다.
		this.start = (pageSize*pageNumber) - pageSize;
		this.end = start + pageSize + 1;
	}

}
