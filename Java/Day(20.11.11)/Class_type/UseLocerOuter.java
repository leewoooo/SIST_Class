package day1111;

/**
 * method내부에 정의하고, method안에서만 사용되는 지역class의 사용.
 * @author owner
 */
public class UseLocerOuter {

	int outi;
	
	public void method(int param_i, int param_j) {
		
		int loci = 10;
		int locj = 10;
		
		///////////////// Local class 시작 //////////////////
		
		class Local{
			int i;
			public Local() {
				System.out.println("지역class의 생성자입니다.");
			}//생성자
			
			public void localMethod() {
				System.out.println("지역class의 method i =" + i);
				System.out.println("바깥class의 instnace변수 outi =" + outi);
				System.out.println("method안의 지역변수 loci =" + loci);
				System.out.println("method안의 지역변수 locj =" + locj);
				System.out.println("method안의 매개변수 param_i =" + param_i + ",param_j =" +param_j);
				//지역 class에서 바깥class의 Instance 변수에 값할당은 가능하다.
				outi=34;
//				locj=1; //지역변수 출력은 가능하나 값할당은 할 수없다.
//				param_i = 1; //값 할당은 할 수 없다.
//				param_j = 1; //값 할당은 할 수 없다.
			}//localMethod
			
		}//Local
		///////////////// Local class 끝  ///////////////////
		
		Local loc = new Local();
		loc.i=100;
		loc.localMethod();
		
	}//method
	
	public static void main(String[] args) {

		UseLocerOuter ulo = new UseLocerOuter();
		ulo.method(2020, 11);
	}//main

}//class
