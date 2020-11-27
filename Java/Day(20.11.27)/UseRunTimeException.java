package day1127.useruntimeexception;

/**
 * Runtime Exception 처리
 * ArrayIndexOutOfBoundsException : 배열 , List에 없는 Index를 사용할 때
 * NumberFormetException : 문자열을 숫자로 변경할 때, 문자열이 숫자로 변경되지 못하는 형식으로 입력될 때
 * ArithmeticException: 0으로 나눌때 발생한다.
 * @author owner
 */
public class UseRunTimeException {

	
	public static void main(String[] args) {

		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		try {
			num1 = Integer.parseInt(args[0]);//ArrayIndexOutOfBoundsException, NumberFormatException
			num2 = Integer.parseInt(args[1]);//ArrayIndexOutOfBoundsException, NumberFormatException

			result = num1/num2;//ArithmeticException
			System.out.printf("%d / %d = %d",num1, num2 , result);
		
		}catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("프로그램을 실행할 때 값을 2개 넣어 사용해야 합니다.");
			System.out.println("사용법) java day1127.UseRunTimeException 값1 값2");
		}catch(NumberFormatException nfe){
			System.out.println("값은 정수만 입력 가능합니다.");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (Exception e){ //개발자가 인식하지 못하는 예외 처리를 하기 위해 최상위 예외class를 마지막에 정의해준다. 
			System.out.println("개발자가 인식하지 못하는 예외 처리 하기 위한 최상위 예외 class");
		}
		finally {
			System.out.println("현재 입력값은" + num1 + " / " + num2 + "입니다");
		}//end try
		
		//instance of 연산자 - 객체가 class(interface)로 생성된 객체인지 판단.
		PrintErrorMsg pem = new PrintErrorMsg();
		System.out.println(pem instanceof PrintErrorMsg);
		
		
	}//main

}//class
