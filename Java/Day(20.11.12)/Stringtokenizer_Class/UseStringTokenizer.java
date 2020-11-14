package day1112.stringtokenizer;

import java.util.StringTokenizer;

/**
 * 문자열을 자를 때 사용하는 class
 * 
 * @author owner
 */
public class UseStringTokenizer {

	public UseStringTokenizer() {
		
		String str = "안녕하세요? 행복한 하루가 되세요";
		
		// 1. 문자열을 공백으로 구분하는 StringTokenizer의 사용.
//		StringTokenizer stk = new StringTokenizer(str);
		
		// 1. 문자열을 특정 문자로 구분하여 자르고 싶습니다. : StringTokenizer(문자열,"자를기준");
		//기준 문자를 제거합니다.(보호하지 않습니다.)
		
//		StringTokenizer stk = new StringTokenizer(str,"하"); //=> 결과: 안녕 / 세요? 행복한 / 루가 되세요
//		StringTokenizer stk = new StringTokenizer(str,"하세"); //(or 기능을 사용) => 결과: 안녕/요? 행복한 /루가 되/요 
		
		// 1. 문자열을 특정 문자로 구분하여 자르기 :StringTokenizer(문자열,"자를기준",보호여부)
		//기준문자를 보호할지에 대한 여부: true - 보호, false - 비보호
//		StringTokenizer stk = new StringTokenizer(str,"하",true); //=> 결과: 안녕/하/세요? 행복한 /하/루가 되세요
		StringTokenizer stk = new StringTokenizer(str,"하",false); //=> 결과: 안녕/세요? 행복한/루가 되세요
		
		
//		System.out.println("토큰의수: "+stk.countTokens()); //pointer의 위치에 따라 countTokens의 갯수는 달라진다.
//		System.out.println("토큰의 존재여부: "+stk.hasMoreTokens());
//		System.out.println("pointer가 존재하는 위치에 값을 얻고, pointer를 이동 :"+stk.nextToken()); 
//		System.out.println("토큰의수: "+stk.countTokens()); //Token을 꺼냈기 때문에 토큰의 수가 줄어든다.
		
		//토큰의 수를 알수 없지만 토큰이 없을 때 까지 잘라내야된다.
		//시작과 끝을 알 수 없을때 사용하는 반복문인 while을 사용하게 됩니다.
		
		while(stk.hasMoreTokens()) { //토큰의 존재여부를 boolean값으로 반환하는 hasMoreTokens.
			System.out.println(stk.nextToken()); //값을 가져오고 포인터를 다음 위치로 이동.
		}//while;
		
//		포인터가 이미 문자열의 끝에 위치하고 있기 때문에 다시 while문을 돌릴 수 없다.
//		다시 사용하려면 Instance를 다시 생성해야한다.
//		while(stk.hasMoreTokens()) { //토큰의 존재여부를 boolean값으로 반환하는 hasMoreTokens.
//			System.out.println(stk.nextToken()); //값을 가져오고 포인터를 다음 위치로 이동.
//		}//while;
		
	}//UseStringTokenizer
	
	
	public void useSplit() {
		
		String csvData = "Java,Oracle,JDBC,HTML.CSS,JavaScript"; // csv DATA
		
		String[] subjectArr=csvData.split(","); // ','를 기준으로 잘라 배열을 생성한다. (Or 기능 없음.)
													
		System.out.println(subjectArr.length);
		
		for(int i = 0 ; i < subjectArr.length ; i++) {
			System.out.println(subjectArr[i]);
		}//for
		
	}//useSplit
	
	public static void main(String[] args) {

		new UseStringTokenizer().useSplit();
		
	}//main

}//class
