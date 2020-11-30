package day1130.testexception;

@SuppressWarnings("serial")
public class SmokeException extends Exception {

	
	/**
	 * 일반적인 예외의 메세지
	 */
	public SmokeException() {
		super("흡연은 해롭습니다.");
	}//SmokeException
	
	/**
	 * 상황에 맞는 예외의 메세지
	 * @param msg
	 */
	public SmokeException(String msg) {
		super(msg);
	}//SmokeException
	
	
}//SmokeException
