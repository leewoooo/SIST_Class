package day1112.mathclass;

/**
 * 수학관련 class
 * Instance를 생성하지 않고 사용합니다.(생성자를 만들수 없음,접근지정자 private)
 * @author owner
 */
public class UseMathClassWork {
	
	/**
	 * 길이가 8인 char배열에 0~9,a~z,A~Z의 문자를 무작위로 집어넣어라
	 * 비밀번호 초기화 문제
	 * 
	 * @return
	 */
	
	//이번경우는 tempNum이 범위 안에 있어야만 입력이 가능하기에
	//8자리를 채우기 위해 몇번이 돌지 모른다.
	public char[] createPassword() {
		
	
		char[] tempPassword = new char[8];
		
		int tempNum = 0;
		
		for(int i = 0 ; i < tempPassword.length; i++) {
			
			tempNum=(int)(Math.random()*123); //0~122
			
			if((tempNum>47 && tempNum <58) || (tempNum>64 && tempNum <91) || (tempNum>96 && tempNum <123)) {
				tempPassword[i]=(char)tempNum;
			}else {
				i--;
			}
		}//for
		
		return tempPassword;
		
	}//createPassword
	
	
	public static void main(String[] args) {

		UseMathClassWork umc = new UseMathClassWork();

		umc.createPassword();
		char[]temp =umc.createPassword();
		for(int i = 0 ; i < temp.length ; i++) {
			System.out.print(temp[i]);
		}//for
		
	}//main

}//class
