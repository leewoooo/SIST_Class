package day1130.testexception;

/**
 * 사용자 정의 예외처리 class
 * @author owner
 */

//1. 예외처리 class를 상속 받는다.
@SuppressWarnings("serial")
public class TestException extends Exception{

	public TestException() {
		super("예외발생시 고정적인 메세지");
	}//TestException
	
	public TestException(String msg) {
		super(msg);
	}//TestException
	
}//class
