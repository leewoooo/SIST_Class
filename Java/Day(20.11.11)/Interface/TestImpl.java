package day1111;

/**
 * Interface를 구현한 class입니다.
 * class에서 필요한 모든 Interface를 구현할 수 있습니다.(여러개의 Interface구현 가능.)
 * 문법)
 * 접근지정자 class명 implements 인터페이스명,,,,,,,,
 * @author owner
 */
public class TestImpl implements TestSuper {
	
	@Override
	public void methodA() {
		System.out.println("Override 한 methodA가 호출되었습니다.");
	}//methodA

	@Override
	public void methodB() { //abstract를 Override 할 때는 abstract를 뺀다.
		System.out.println("Override 한 methodB가 호출되었습니다.");
	}//methodA

	@Override
	public String name() {
		return "자신의 이름";
	}//name
	
	public void subMethod() {
		System.out.println("자식의 method");
	}

	public static void main(String[] args) {
		
//		Interface는 Instance화가 되지 않습니다.
//		TestSuper ts = new TestSuper(); 생성자가 없기 때문에 불가능 하다.
		
//		Interface는 구현한 class의 Instance의 주소를 저장할 수 있다. = is-a관계의 Instance화
		TestSuper ts = new TestImpl();
		System.out.println(ts);
		
//		ts Instance로 호출이 가능한 것.
//		is - a 관계이기 때문에 사용이 가능한 것은 부모class의 자원이다.(부모의 변수 , 부모의 method)
		
		ts.methodA(); // 자식 class에서 Override했기에 자식class에서 Override한 method가 최우선으로 호출
		ts.methodB();
		System.out.println(ts.name());
//		ts.subMethod(); is-a관계로 instance화 하면 자식의 자원을 사용할 수 없습니다.
		
		
	}//main
}//class
