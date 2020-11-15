package day1110;

/**
 * 부모클래스 : 자식class들이 사용해야 할 공통 코드
 * @author owner
 */
public class TestSuper {
	
	int i;
	int j;
	
	public TestSuper(){
//		super(); //Object class의 상속을 받고있기 때문이다.
		this(100);
		System.out.println("TestSuper기본생성자(부모)");
	}
	public TestSuper(int i ){
//		super(); //Object class의 상속을 받고있기 때문이다.
		System.out.println("TestSuper 매개변수 있는 생성자(부모)");
	}

	public void print() {
		System.out.println("부모의 i = " + i + " 부모의 j = " + j);
	}
}
