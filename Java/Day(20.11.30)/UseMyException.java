package day1130.testexception;

import java.util.Random;

/**
 * 사용자정의 예외처리 class를 사용하는 class.
 * @author owner
 */
public class UseMyException {

//throws로 날리는 예외는 method 안에서 throw로 발생된 예외가 되어야합니다.
//또는 throws로 날리는 예외는 	method 안에서 throw로 발생된 예외의 부모가 될 수 있다.
	
	public void method() throws TestException{
		
		if(new Random().nextBoolean()) {
			
			//예외가 발생하는 상황이라고 가정
			
			//기본생성자를 사용할 때는 기본적인 msg를 출력할 때 사용한다.
//			throw new TestException();
			
			//매개변수가 있는 생성자를 사용할 때는 가변적인 msg를 출력할 때 사용한다.
			throw new TestException("가변적인 메세지 출력.");
			
		}//end if
		
	}//method
	
	
	/**
	 * 일을 하는 도중 만19세 미만이 흡연하는 것을 목격하면 예외를 발생
	 * @return 
	 * @throws Exception
	 */
	public  String smokeAge() throws SmokeException {

		String result = "";
		String[] grade = {"초등학생"," 중학생","고등학생","대학생"};
	
		//배열의 갯수만큼 난수를 얻어, 배열에서 난수번째 방의 값을 얻는다.
		String getGrade = grade[new Random().nextInt(grade.length)];
		
		if("초등학생".equals(getGrade)) {
			//초등학생이 흡연하는 상황에 예외를 발생시켜 처리하자.
			throw new SmokeException(getGrade + "은 흡연할 수 없는 나이입니다.");
		}//end if
		if("중학생".equals(getGrade)) {
			//초등학생이 흡연하는 상황에 예외를 발생시켜 처리하자.
			throw new SmokeException(getGrade + "은 흡연할 수 없는 나이입니다.");
		}//end if
		if("고등학생".equals(getGrade)) {
			//초등학생이 흡연하는 상황에 예외를 발생시켜 처리하자.
			throw new SmokeException(getGrade + "은 흡연할 수 없는 나이입니다.");
		}//end if
		
		result = "흡연은 만 19세 이상부터 가능합니다.";
		return result;
	}//smokeAge
	
	public static void main(String[] args) {
		
		UseMyException ums = new UseMyException();
		
//		try {
//		ums.method();
//		System.out.println("정상적인 코드의 진행이다.");
//		}catch(TestException te) {
//			System.err.println("method안에서 예외가 발생 : "+ te.getMessage());
//			te.printStackTrace();
//		}//end catch

		try {
			String msg = ums.smokeAge();
			System.out.println(msg);
		}catch(SmokeException se) { 
			//최상위 예외를 throws하면 method를 호출하여 일을 하는것과
			//상관이 없는 예외이기 때문에 가독성이 떨어진다.
			se.printStackTrace();
		}//end catch
	}//main

}//class
