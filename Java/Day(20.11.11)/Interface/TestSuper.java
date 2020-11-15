package day1111;

/**
 * 구현 class가 반드시 구현해야할 일의 목록만 정의.
 * @author owner
 */
public interface TestSuper {

//	int i; 변수를 가질 수 없다.
	public static final int MAX = 99999; //상수만 가질 수 있습니다.
	
//	public TestSuper() {}  생성자를 가질 수 없다.
	
//	public void test() {} 업무를 구현할 수 있는일반 method를 가질수 없다.
	
	public void methodA(); // abstract를 생략한 abstract method;
	
	public abstract void methodB(); // abstract를 사용한 abstract method;
	
	public abstract String name(); // abstract를 사용한 abstract method;
	
	
}//class
