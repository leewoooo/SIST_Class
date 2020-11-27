package day1127.useruntimeexception;

public class PrintErrorMsg {

	public static void main(String[] args) {
	
		
//		System.out.println("정상출력");
//		System.err.println("정상출력");
		
		try {
		int i = Integer.parseInt(args[0]);
		System.out.println(i);
		}catch(ArrayIndexOutOfBoundsException aioobe) {
			System.err.println(aioobe.getMessage());
		}catch (NumberFormatException nfe) {
			System.err.println(nfe.getMessage()); // 예외 이유
			System.err.println(nfe.toString()); // 예외처리 class 와 예외 이유
			nfe.printStackTrace(); //stack에 쌓인 자세한 예외 메세지
		}
	}//main
}//class
