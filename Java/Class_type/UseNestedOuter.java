package day1111;

/**
 * 중첩class : class안에 static class를 정의하는 class
 * @author owner
 */
public class UseNestedOuter {
	
	int outi; //instance변수
	
	static int outj; // static변수

	public void outInsMethod() {
		System.out.println("바깥 class의 Instance method");
	}//outInsMethod
	
	public static void outStaMethod() {
		System.out.println("바깥 class의 static method");
	}//outStaMethod
	
	
	//////////////////////////Nested class 시작 //////////////////////////
	static class Inner{
		
		static int ini;
		//public Inner() {}; Nested class를 정의하지 않고 사용합니다.(기본생성자)

		public static void inMethod() {
			System.out.println("안쪽 class의 method입니다.");
			//outi=100; static영역에서는 instance 변수를 사용할 수 없습니다 
			//outStaMethod(); static영역에서는 instance method를 사용할 수 없습니다 
			
			outj=1000; //같은 static 영역에 있기에 사용이 가능합니다.
			outStaMethod(); //같은 static 영역에 있기에 사용이 가능합니다.
		}//inMethod (Nested class일 경우 접근지정자를 static으로 설정하는걸 지향한다.)
		
		
		
	}//class
	//////////////////////////Nested class 끝 //////////////////////////
	public static void main(String[] args) {
		
		Inner.inMethod(); //안쪽 class의 method를 static문법으로 사용할 수 있다.
		
	}//main

}//class
