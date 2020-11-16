package day1113.homework;

import java.util.StringTokenizer;

public class HomeworkReview {
	
	//1.문자열을 입렵받고 (parameter String정의), string[]을 반환하는 method 작성
	
	public String[] stationProcess(String station) {
		
		String[] temp = null; // 처리된 데이터를 저장할 배열을 선언.
		
		//입력된 역에서 누락된 "구로디지털 단지" 역을 추가
		//신대방역, 뒤에 "구로디지털 단지" 역을 추가
		
		
		//1. 신대방 역의 존재를 찾아보자.
		StringBuilder sbTemp = new StringBuilder(station);
		
		
		if(station.contains("신대방")) { //유효성 검사
			
			//신대방역뒤에 구로디지털 단지 역을 추가하자.
			sbTemp.insert(sbTemp.indexOf("신대방")+4, "구로디지털 단지,");
		}//end if

		//구로디지털 단지가 추가된 문자열로 parameter을 변경.
		station = sbTemp.toString();
		
		//2. 문자열에 공백을 제거하자. (replace method를 이용) => white space를 찾아서 empty로 치환
		station = station.replaceAll(" ", "");
		
		//3. parameter로 입력된 date를 거꾸로 배열에 넣어 반환.
		//입력데이터를 토큰으로 구분할 필요가 있다. 
		//StringTokenizer - 포함되는 여러 문자열을 자를수 있다.(or기능)
		//String.split() - 하나의 문자열만 자를 수 있다.(단일)
		
		StringTokenizer stk = new StringTokenizer(station,",.");
		
		//토큰으로 구분된 데이터를 저장하기 위한 배열 생성. (배열의 방의 갯수는 토큰의 갯수)
		temp = new String[stk.countTokens()]; //11개의 방이 생성이 되었습니다.
		
		
		int index = temp.length -1; //처음 data를 마지막 방에 넣기 위한 index 변수 초기화
		while(stk.hasMoreTokens()) { //토큰이 존재한다면
			temp[index] = stk.nextToken(); //마지막 방 부터 처음 data를 추가
			index--; //다음 data는 마지막방 전 방에 추가하기 위해 인덱스를 1씩 감소.
		}//end while
		return temp;
	}//stationProcess
	
	/**
	 * 배열을 입력 받아 출력
	 * @param station
	 */
	public void printstation(String[] station) {
		
		//업무 처리 method에서 0번째 방에서 부터 추가하였다면. 마지막 방부터 출력.
		
		//업무 처리 method에서 데이터를 마지막 방부터 추가하였다면 0번째 방부터 실행
		
		System.out.println(" 역 명 ");
		System.out.println(" ================================ ");
		
		for(int i = 0 ; i <station.length ; i++) {
			System.out.println(station[i]);
		}//end for
		
		System.out.println(" ================================ ");
		
	}//printstation
	public static void main(String[] args) {
		
		//1. Instance화 : static영여겡서 instance 영역의 변수, method를 호출하기 위해서.
		HomeworkReview work = new HomeworkReview();
		
		//method argument에 입력할 지역변수를 선언
		String station = "봉천, 신림,신대방,대림.신도림, 문래,영등포구청, 당산,합정, 홍대 입구";
		// 1번 method 호출.
		String[] temp = work.stationProcess(station);
		// 2번 method 호출.
		work.printstation(temp);
	}//main
	
}//class
