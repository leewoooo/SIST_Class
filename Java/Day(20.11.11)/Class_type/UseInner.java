package day1111;

/**
 * class안에 class가 정의되는 class
 * @author owner
 */
public class UseInner {

	int outi;
	
	public UseInner() {
		System.out.println("바깥class의 생성자 입니다.");
	}//Uselnner
	
	public void createInner() {
		//안쪽 class를 Instance화
		@SuppressWarnings("unused")
		Inner in = this.new Inner(); //this는 method를 호출하는 Instance의 객체의 주소로 대체.
		// 위에 Instance화를 진행하면 과정에서 this는 생략이 가능하다. this.new ==> new 로 가능하다.
	}//createInner
	
	public void outMethod() {
		System.out.println("바깥class의 method outi" + outi);
//		System.out.println("안쪽class의 method j" + j); 바깥 class에서 안쪽 class의 변수를 직접 접근하여 사용할 수 없다.
//		inMethod(); 바깥 class에서 안쪽 method를 직접 호출할 수 없다.
	}//outMethod
	
	
	////////////////////////// Innerclass 시작 //////////////////////////
	
	public class Inner{
		int j;
		public Inner() {
			System.out.println("안쪽 class의 생성자입니다.");
		}//생성자
		
		public void inMethod(){
			System.out.println("안쪽 class의 method j = " + j);
			System.out.println("바깥 class의 method outi = " + outi); //안쪽 class에서는 바깥쪽class를 사용할 수 있다.
			outMethod();//안쪽class에서는 바깥쪽 class의 method를 직접 호출하여 사용할 수 있다.
		}//inMethod
	}//Inner
	
	////////////////////////// Innerclass 끝 //////////////////////////
	public static void main(String[] args) {
		
		//Innerclass의 Instance화
		//1.바깥 class를 Instance화 하자.
		UseInner ui = new UseInner();
		ui.createInner();
		//2.바깥 class를 사용하여 Inner class의 Instance를 생성합니다.
		//바깥 class명.안쪽class명 Instance명 = 바깥class의 Instance.new 안쪽class의 생성자();
		UseInner.Inner in = ui.new Inner(); //방법1
		@SuppressWarnings("unused")
		Inner in2 = ui.new Inner();//방법2 (바깥class의 명은 생략이 가능합니다.)
		
		in.j = 11;
		in.inMethod(); //안쪽 class의 method에서 바깥 class의 변수나 method를 호출할 수 있습니다.

	}//main

}//class
