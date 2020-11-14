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

public class HomeWork1 {
	
	
	String station="봉천,신림,신대방.구로디지털단지,대림.신도림,문래,영등포구청,당산,합정,홍대입구";
	private int cnt; // '신'으로 시작하는 역의 갯수를 받는 변수
	
	/**
	 * String 배열을 입력받아 StringTokenizer을 이용해 역마다 Token으로 구분하여
	 * 배열에 입력하는 method.
	 * @return
	 */
	
	public String[] Stations(String station) {
		
		StringTokenizer stk = new StringTokenizer(station,".,",false);
		String[] stations = new String[stk.countTokens()];
		for(int i = 0; i <stations.length ; i++) {
			stations[i] = stk.nextToken();
			if(i==stations.length-1) { //index에 벗어나지 않게 끝방까지 채운후 break;
				break; 
			}//if
		}//for
		return stations;
	}//Stations
	
	
	/**
	 * StringTokenizer를 이용해 배열에 넣은 역들을
	 * 조건에 맞춰 출력.
	 * 정거장의 수 및 '신'으로 시작하는 역의 갯수.
	 * @param stations
	 */
	public void stationprint(String[] stations) {
		
		System.out.println("역명");
		System.out.println("=============");
		
		for(int i = 0; i < stations.length ; i++) {
			
			if(stations[i].charAt(0)=='신') {
				this.cnt++;
			}//if
			System.out.println(stations[i]);
		}//for
		System.out.println("=============");
		System.out.printf("정거장의수 [%d],신으로 시작하는 역의수 [%d]" , stations.length , cnt);
	}//stationprint
	
	
	public static void main(String[] args) {
		
		HomeWork1 hw = new HomeWork1();
		String [] station2 = hw.Stations(hw.station);
		hw.stationprint(station2);
		
	}//main

}//class

