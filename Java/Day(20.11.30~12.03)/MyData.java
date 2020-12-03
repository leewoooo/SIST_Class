package day1203.mydata;

import java.io.Serializable;

/**
 * 나의 개인정보
 * 
 * @author owner
 */
public class MyData implements Serializable {

	
	/**
	 * 이 아이디는 2021년 12월 03일 00시 00분 00초까지 유효합니다.
	 * 이후 다른 값으로 변경됩니다. 
	 */
	private static final long serialVersionUID = -4833088407624055249L;
	
	
	private transient String name; //직렬화 방지
	private int age;
	private double height;
	private transient double weight;

	public MyData() {
		// TODO Auto-generated constructor stub
	}// My data

	public MyData(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}// My Data

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "MyData [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}

	
}// class
