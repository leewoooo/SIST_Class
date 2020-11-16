package day1113.homework;

import java.util.StringTokenizer;

public class Work1113 {
	
	public String[] csvProcess() {
		
	
		String station = "봉천, 신림,신대방,대림.신도림, 문래,영등포구청, 당산,합정, 홍대 입구";
		
		//문자열에 있는 공백을 제거합니다. replace ("찾을문자열" , "변경할 문자열")
		String spacex=station.replaceAll(" ","");
		//replace 확인
//		System.out.println(spacex);
		
		
		//1.StringBuilder기능을 사용하기위해 StringBuilder를 Instance화 한 후 문자열을 넣어준다.
		StringBuilder sb = new StringBuilder();
		sb.append(spacex);
		
		//2. 신대방역 뒤에 "구로디지털 단지"를 추가 하기 위해 삽입할 위치의 index를 구한다.
		int index = (station.indexOf("신대방"))+3;
		//기존 index를 찾을때 "방"으로 찾았었는데 신대방 역이 나오기전 방이 들어간 역 이름이 나오면
		//원하고자 하는 출력형식을 얻을 수 없기에 더 명확히 지정
		System.out.println(index);
		
		//3. "구로디지털 단지"의 공백을 제거후 정거장 문자열에 삽입한다.
		sb.insert(index, "구로디지털 단지,".replace(" ", "")); 
		//구한 index를 값으로 지정하는 것이 아닌 변수로 지정하여 동적인 코드로 변경.
//		System.out.println(sb);
				
		
		//4.sb를 to string 해서 문자열로 만든다.
		String temp = sb.toString();
//		System.out.println(temp);
		
		//5.StringTokenizer를 생성 후 temp를 집어넣어줍니다.
		StringTokenizer stk = new StringTokenizer(temp,",.");
		
		//6. Token 단위로 잘라서 배열에 넣어주는 작업을 합니다.
		//배열에 넣을때 역의 순서를 반대로 집어 넣습니다.
		String[] stationArr= new String[stk.countTokens()];
		int flag =stk.countTokens()-1;
		while(stk.hasMoreTokens()) {
			stationArr[flag]=stk.nextToken();
			flag--;
		}//while
		
//		//배열에 잘 들어갔는지 출력해서 확인
//		for(int i = 0 ; i < stationArr.length ; i++) {
//			System.out.printf(stationArr[i] + " ");
//		}//for
		
		return stationArr;
	}//csvProcess
	
	/**
	 * 원하는 형식으로 만들어진 stationArr배열을
	 * 출력하는 method
	 * @param stationArr
	 */
	public void printstation(String[] stationArr) {
		System.out.println("역 명");
		System.out.println("----------");
		
		//역의 이름을 반복문을 통해 출력
		for(int i = 0; i< stationArr.length; i++) {
			System.out.println(stationArr[i]);
		}//for
		
		System.out.println("----------");
	}//printstation

	public static void main(String[] args) {
		Work1113 hw = new Work1113();
		String[] stationArr = hw.csvProcess();
		hw.printstation(stationArr);
	}//main

}//class
