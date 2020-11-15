package day1111;

import day1111.sub.Clark;
import day1111.sub.Fly;

/**
 * method의 매개변수가 class나 Interface를 매개변수로 선언하고 있을 때
 * 별도의 class파일을 작성하지 않고 method를 호출 할 수있는 "익명 class"의 사용.
 * @author owner
 */
public class UseAnonymous {

	public void useFly(Fly fly) {
		System.out.println(fly.drivigForece() + "/" + fly.upwoardForece());
	}
		public static void main(String[] args) {
		
			//Fly를 구현한 class를 작성하고 Instance화를 합니다.
			
			Clark c = new Clark();
			//method를 호출하기 위해 this.class를 Instance화 한다.
			UseAnonymous ua = new UseAnonymous();
			//method호출
			ua.useFly(c); //Clark는 fly와 is a 관계이므로 Clark instance를 할당할 수있다.
			
			//Fly를 구현한 class 파일을 별도로 작성하지 않고 anonymous inner class로 처리할 수 있다.
			//외부class명.class , 외부class명$1.class 이렇게 2개의 byte코드가 작성된다.
			ua.useFly(new Fly() {
				@Override
				public int upwoardForece() {
					return 0;
				}//upwoardForece

				@Override
				public int drivigForece() {
					return 0;
				}//drivigForece
			});
			
		}//main
}//class
