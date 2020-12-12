package day1127.usethrow;

/**
 * 예외 강제 발생. 
 * 
 * 아이디와 비밀번호를 입력받아 아이디가 "admin"이고 비밀번호가 "1234"일때만 로그인 성공 처리
 * 로그인 실패시 예외를 발생시켜 호출한 곳에서 로그인 실패 처리를 수행한다.
 * @author owner
 */
public class UseThrow {

	public void login(String id, String password) throws Exception{
		
		//문자열 객체의 method를 호출하여 비교할 때에는 NullPointerException이 발생할 수 있기 때문에
		//예외가 발생하는 상황을 미연에 방지하기 위해 "".equals(변수명)의 문법을 사용한다.
		if("admin".equals("id") && "1234".equals(password)) { //문자열의 같음을 비교하는거 ==은 문자열이 기본형으로 만들어졌을때만 가능 참조형일때는 주소비교로 불가능
			System.out.println("로그인 성공!");
		}else {
			throw new Exception("로그인실패, 아이디나 비밀번호를 확인해주세요.");
		}//end else
	}//end login
	
	public static void main(String[] args) {
		
		String id = null ;
		String password = "1234";

		UseThrow ut =	new UseThrow();
		try {
			ut.login(id, password);
		}catch(Exception e){
			System.err.println(e.getMessage());
//			e.printStackTrace();
		}//end catch
		
	}//main
}//class
