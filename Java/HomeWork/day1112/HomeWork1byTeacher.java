package day1112.homework;

import java.util.StringTokenizer;

//1. 아래와 같은 형식의 데이터가 존재한다. 
//
//String station="봉천,신림,신대방.구로디지털단지,대림.신도림,문래,영등포구청,당산,합정,홍대입구";
//
//1. 각각의 역을StringTokenizer를 사용하여 String[]에 저장하고 반환하는 method를 만든다.
//2.  1번 method를 호출하여 반환되는 배열을 받아 아래와 같이 출력한다. 
//   역명 
//------------
//   봉천
//     .
//     .
//   홍대입구
//-------------
//정거장 수 : [ x ]개, '신'으로 시작하는 역수 [ 3 ]역

public class HomeWork1byTeacher { 
	//나와의 차이점은 배열에 값을 집어 넣을때 while을 사용함
	//token의 유무를 모르고 끝값도 알수 없기에 while을 사용하여 배열의 값을 입력.
	
	//'신'으로 시작하는 역의 이름을 구할때 나는 charAt을 사용하였지만
	// 강사님의 풀이는 startWith method를 사용하였다.
	
	
	/**
	 * CSV Data를 Token을 분리하여 배열에 담는 일을 할 것입니다.
	 * @return
	 */
	public String[] csvProcess() {
		 
		String[] stationArr=null;
		String station="봉천,신림,신대방.구로디지털단지,대림.신도림,문래,영등포구청,당산,합정,홍대입구";
		
		// 1. 하나의 문자열에서 특정 문자로 분리할 수 있는 class를 생성.(StringTokenizer)
		 StringTokenizer stk = new StringTokenizer(station, ",." , false);
		// 2. Token의 갯수로 배열을 생성합니다. -배열의 방이 동적으로 생성이 된다.
		 stationArr = new String[stk.countTokens()]; // index를 사용하여 방에 접근하는 배열
		 
		 int idx = 0;
		 // 3. Token이 존재하는지 물어보고 Token이 있다면 
		 while(stk.hasMoreTokens()) {
		// 4. Token을 가져와서 배열 방에 저장을 한다.
			 stationArr[idx] = stk.nextToken();
			 idx++;
		 }//end while
		return stationArr;
	}//csvProcess
	
	public void printArray(String[] stationArr) {
		
		int cnt =0;
		
		System.out.println("역 명");
		System.out.println("==========");
		for(int i = 0 ; i <stationArr.length ; i++) {
			System.out.println(stationArr[i]);
			if(stationArr[i].startsWith("신")) { // '신'으로 시작하는 역의 수를 알고 싶습니다. stratWith method를 사용하여 접두어가 '신' 인지 확인한다.
				cnt++;
			}//if
		}//for
		System.out.println("==========");
		System.out.printf("정거장 수 [%d] , '신'으로 시작하는 역의 갯수 [%d]" , stationArr.length , cnt);
	}//printArray
	
	
	
	
	public static void main(String[] args) {
		
		//1. Instance화
		HomeWork1byTeacher hwt = new HomeWork1byTeacher();
		//2. csv데이터를 처리하는 method 호출
		String[] temp= hwt.csvProcess();
		//3.출력
		hwt.printArray(temp);
	}//main

}//class

