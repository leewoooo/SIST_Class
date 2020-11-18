package day1117.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HomeWork1117_2_review {
	
	public static final int UNKNOWN =2;

	/**
	 * List에 데이터를 추가하고 반환하는 일을 한다.
	 * @return 프로그램, 주 개발자, 개발년도
	 */
	public List<String> getList(){
		// 1. is a 관계의 Instance화로 List 생성
		List<String> list = new ArrayList<String>();
		// 2. List에 값 추가 
		list.add("Java-James Gosling:1995");
		list.add("Oracle-Larry Ellison");
		list.add("Python-Guido van Rossum:1991");
		list.add("HTML-Tim Berners, LEE:1995");
		list.add("JavaScript-Brandan");
		return list;
	}//getList
	
	

	public void printlist(List<String> list) { //처리된 데이터를 가진 List를 매개변수로 받아 
		System.out.println("항목\t핵심개발자\t\t개발년도");
		System.out.println("------------------------------------");
		if(list.isEmpty()) {//처리된 데이터가 없을 때
			System.out.println("처리된 Data가 존재하지 않습니다."); //List를 처리할 때는 데이터가 없었을 때의 처리가 필수적으로 들어가야 한다.
		}else { //처리된 데이터가 존재할 때 

			//반복중인 리스트의 현재 방의 값을 저장하기 위해 선언
			String data =" "; //empty로 처리하면 메소드 호출이 가능하고 잠재적 error가 적다
			StringTokenizer stk = null;
			int cntToken = 0;
//			int j; // 반복문 안에서 변수를 선언하면 데이터에 변수가 오르락 내리락 하면서 병목현상을 발생시켜 실행 속도를 감소 시킨다.
			for(int i = 0 ; i < list.size(); i ++) {
				data=list.get(i);
				stk = new StringTokenizer(data,":-");
				cntToken = stk.countTokens(); // 기본 문자열로 구분된 토큰의 수를 얻는다 => 2 or 3
				while(stk.hasMoreTokens()) { // 토큰이 존재하니?
					System.out.printf("%s\t", stk.nextToken());
				}//end while
				switch(cntToken) {
				case UNKNOWN:
					System.out.printf("%s", "알수없음");
				}//end switch
				cntToken = 0; //토큰의 초기화
				System.out.println();
			}//end for 
			
			
		}// end else
		
		
		
	}//printlist
	
	
	
	
	public static void main(String[] args) {
		HomeWork1117_2_review hw2r = new HomeWork1117_2_review();
		//method가 return을 가지고 있으면 변수를 만들어 받아준다.
		List<String> list = hw2r.getList();
		hw2r.printlist(list);
		
	}//main
	
}//class