package day1110;

import java.util.Date;
import java.util.List;

/**
 * annotation사용
 * @author owner
 */
public class UseAnnotation {

	
	@Override //annotations. Override를 제대로 했는지 compiler가 확인해준다.
	public String toString() {
		return "나는 주소를 반환하기싫어요.";
	}//to string
	
	
	/**
	 * 정상동작을 기대하기 어려운 경우에 
	 * @deprecated를 걸어서 비추천 method임을 알린다.
	 * 가급적이면 사용하지 마세요~
	 * 대체 class와 method를 제시
	 */
	@Deprecated
	public void test( ) {
		System.out.println("업무코드정의");
	}//test
	
	
	
	//unused - 변수가 사용되지 않을때 생기는 경고를 없애기.
	//rawtypes - 데이터형에 안정성을 위해 Generic을 사용하는 문법을 권장하는데
	//				Generic을 사용하지 않고 JCF를 사용해야 할 때 발생하는 경고 없애기.
	@SuppressWarnings({ "unused", "rawtypes" })
	public void temp() {
//		@SuppressWarnings("unused")
		int i;
		
//		@SuppressWarnings({ "unused", "rawtypes" })
		List l = null;
	}//temp
	
	
	
	public static void main(String[] args) {

		String str = new String("오늘은 화요일입니다.");
		System.out.println(str);//주소x //객체를 생성했을데 주소값이 나오지 않는것은 그 객체에서 toString 를 Overriding 한 것이다.
		System.out.println(str.toString());//주소X / object.toString()를 Override 하여 주소가 아니고 값이 나온다.
		
		UseAnnotation ua = new UseAnnotation();
		System.out.println(ua); //주소
		System.out.println(ua.toString()); //주소O / Object.toString()를 Override 하지 않아 Object이 제공하는 주소 형태가 문자열로 반환.
		//getClass().getName() + '@' + Integer.toHexString(hashCode())
		
		Date date = new Date();
		System.out.println(date); // Object에서 toString()를 Override하여 주소가 아닌 message가 반환된다.
		System.out.println(date.toString());
		System.out.println(date.getYear() + 1900); //비추천 method를 불러주면 일을 하기는 하지만 원하는 결과를 얻을수는 없다. 가급적이면 쓰지마세요.

		ua.test();
		
	} //main

}//class
