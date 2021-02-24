package com.sist.exam07;

public class BookDAO {
	
	private final int cnt;
	private final Book book;
	

	public BookDAO(Book book, int cnt) {
		super();
		this.book = book;
		this.cnt = cnt;
	}
	
	public void insertBook() {
		System.out.println("도서" + book +"을 " +cnt+"권 등록하였습니다.");
	}

	
}
