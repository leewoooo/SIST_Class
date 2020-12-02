package day1130.systeminput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 입력의 근원 중 시스템의 입력인 키보드에서 입력되 값 받기.
 * @author owner
 */
public class SystemInput {

	public SystemInput(){
	
		System.out.println("아무키나 누르고 Enter");
		
		try {
//			int code = System.in.read();
//			System.out.println("입력값 : " + code);
//			
//			int keyCode = 0;
//			//읽어드릴수 없는 값이 존재하면 read()에 -1이 return된다.
//			while((keyCode = System.in.read()) != (13)) { //한글을 읽지만 출력을 못한다.
//				System.out.println(keyCode);
//			}//end while
			
			//키보드 입력을 읽어들일 수 있는 8bit stream과 
			//줄단위로 읽어 들릴 수있는 16bit를 연결하여 줄 단위로 읽어들여 변수에 저장 후 출력
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String msg = br.readLine();
			System.out.println(msg);
			
			br.close();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		
	
		
	}//SystemInput()
	
	public static void main(String[] args) {
		new SystemInput();
		
	}//main
}//class
