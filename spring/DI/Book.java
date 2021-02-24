package com.sist.exam07;

public class Book {
	
	private int no;
	private String name;
	private String price;
	private String publisher;
	
	
	public Book(int no, String name, String price, String publisher) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.publisher = publisher;
	}


	@Override
	public String toString() {
		return "Book [no=" + no + ", name=" + name + ", price=" + price + ", publisher=" + publisher + "]";
	}


	
	
}
