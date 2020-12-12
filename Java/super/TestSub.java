package day1110;

/**
 * 자식 class
 * @author owner
 */
public class TestSub extends TestSuper {
	
	int j; // 부모와 같은 이름의 변수.
	int k;

	public TestSub() {
		super(); // 상속받은 TestSuper의 기본생성자를 호출.
		System.out.println("TestSub 자식class의 기본 생성자");
	}
	
	@Override
	public void print() {
		j=11; //부모와 자식이 같은 이름의 변수를 가지면 자식의 변수를 먼저 사용하게 된다.
		k=10;
		
//		i = 20000;  //부모만 가진 변수는 식별되어 사용된다.
//		this.i = 20000;  //부모만 가진 변수는 자식class의 시작주소인 this로 부터 사용될 수 있다.
		super.i = 20000;  //부모만 가진 변수는 부모의 시작인 주소 super로 부터 사용될 수 있다.
		
		//부모와 자식이 같은 이름의 변수를 가지고 있는 상태에서, 부모에 변수를 사용하기 위해서는
		//반드시 super로만 접근을 해야합니다.
		super.j = 2020; //부모class 의 Instance 변수 j에 값 할당.
		this.j = 11;//자식class의 Instance 변수 j에 값 할당.
		
//		System.out.println(super); // 자식class에서 부모class의 주소를 출력 할 수  없다.
		System.out.println("자식의 j = " + j + " 부모의 k = " + k);
		super.print(); //자신의 method가 아닌 부모의 method를 호출
	}
	
	public static void main(String[] args) {
		
		
		TestSub ts = new TestSub();
		ts.print();
		//인스턴스의 주소로는 부모와 자식이 이름이 같다면 식별되지 못하기 때문에 부모의 자원을
		//호출할 수없다.
		
	}//main
}//class
