package com.sist.vo;

public class GoodsVO {

	private int no;
	private String name;
	private int qty;
	private int price;
	private String fname;
	
	public GoodsVO() {
		// TODO Auto-generated constructor stub
	}

	public GoodsVO(int no, String name, int qty, int price, String fname) {
		super();
		this.no = no;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.fname = fname;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public int getQty() {
		return qty;
	}

	public int getPrice() {
		return price;
	}

	public String getFname() {
		return fname;
	}

	@Override
	public String toString() {
		return "GoodsVO [no=" + no + ", name=" + name + ", qty=" + qty + ", price=" + price + ", fname=" + fname + "]";
	}
	
	
}
