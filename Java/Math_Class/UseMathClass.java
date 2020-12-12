package day1112.mathclass;

/**
 * 수학관련 class
 * Instance를 생성하지 않고 사용합니다.(생성자를 만들수 없음,접근지정자 private)
 * @author owner
 */
public class UseMathClass {

	public UseMathClass(){
		
//		Math m = new Math(); 생성자의 접근지정자가 private이기에 Instance화 불가능.
		
		double d = 10.6;
		double d1 = 10.2;
		double d2 = 10.9;
		
		//반올림 (소수점 첫번째 자리에서 반올림을 합니다.
		System.out.println(d + "를 반올림: " + Math.round(d));
		
		//올림 (소수점 첫번째 자리에서 올림을 합니다. 반환형은 double형)
		System.out.println(d + "를 반올림: " + Math.ceil(d1));
		
		//내림 (소수점 첫번째 자리에서 내림을 합니다. 반환형은 double형)
		System.out.println(d + "를 반올림: " + Math.floor(d2));
		
		//소수점 아래 절삭
		System.out.println(d2 + "를 소수절삭: "+ (int)d2);
		
		int i = -11;
		
		//절대값
		System.out.println(i + "의 절대값: " + Math.abs(i));
		
		//난수 발생
		d= Math.random(); //임의의 수가 나온다.
		System.out.println("난수: " + d);
		System.out.println("범위의 난수: " + (d * 10)); //발생한 수 * 범위
		System.out.println("범위의 난수를 정수로 Casting: " + (int)(d * 10)); //(형변환)(발생한 수 * 범위)
		
		//1~5까지의 범위에서 난수를 추출
		System.out.println("1~5 범위의 난수: " + (int)((d * 5)+1)); //(형변환)(발생한 수 * 범위)
		
		//알파벳 대문자 A에서 Z중 임의의 문자 하나를 얻어보세요.
//		System.out.println("A(65)~Z(90) 범위의 임의의 문자: " + (char)((d * (90-64)+65))); 
		System.out.println("A(65)~Z(90) 범위의 임의의 문자: " + ((char)((Math.random()*26)+65))); 
		
		
	}//UseMathClass
	
	
	
	/**
	 * 길이가 8인 char배열에 0~9,a~z,A~Z의 문자를 무작위로 집어넣어 비밀번호 생성
	 * 비밀번호 초기화 문제
	 * 
	 * @return
	 */
	public char[] createPassword() {
		
		//배열선언
		char[] tempPassword = new char[8];

		int random=0; //난수를 입력받을 변수.
		
		
		//배열에 값을 넣고 출력할 반복분
		for(int i = 0 ; i < tempPassword.length ; i++) {
			
			random=(int)((Math.random()*3)+1);//3가지의 경우를 random으로 발생하기 위한 난수

			switch(random) { //3가지의 조건 제시
			
			case 1: //0~9
				tempPassword[i]=(char)((Math.random() * 10)+48);
				break;
			case 2: //A~Z
				tempPassword[i]=((char)((Math.random()*26)+65));
				break;
			case 3: //a~z
				tempPassword[i]=((char)((Math.random()*26)+97));
				break;
			}//switch
			
//			System.out.print(tempPassword[i]); //각 자리 확인

		}//for

		return tempPassword;
		
	}//createPassword
	
	
	public static void main(String[] args) {

		UseMathClass umc = new UseMathClass();
		
		char[] pass = umc.createPassword();
		
		for(int i = 0 ; i < pass.length ; i++) {
			System.out.print(pass[i]);
		}//for
		
	}//main

}//class
