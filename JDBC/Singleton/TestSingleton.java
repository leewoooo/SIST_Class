package day1229.singleton;

/**
 * singleton pattern을 도입한 class
 * 
 * @author owner
 */
public class TestSingleton {

	//객체만 하만 생성할 때 비교하기 위해
	private static TestSingleton ts;
	
	// 1.class 외부에서 직접 객체화를 하지 못하도록 막는다.
	private TestSingleton() {
	} //TestSingleton

	// 2.객체화를 반환하는 method를 생성
	public static TestSingleton getInstance() {
		if(ts == null) { //객체가 생성이 되어있지 않거나 객체가 소멸되었다면
			ts = new TestSingleton();
		}// end if
		return ts;
	}//end getInstance
}// class
