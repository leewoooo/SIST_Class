package day1229.singleton;

public class Usesingleton {

	public static void main(String[] args) {
		//singleton pattern이 도입된 class는 외부에서 객체화 할 수 없다.
//		TestSingleton ts = new TestSingleton();
		//객체를 얻을 수 있는 method를 사용하여 객체를 얻는다.
		
		TestSingleton ts = TestSingleton.getInstance();
		TestSingleton ts1 = TestSingleton.getInstance();
		
		System.out.println(ts);
		System.out.println(ts1);
		
		
	}//main
}//class
