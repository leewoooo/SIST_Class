package day1117.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HomeWork1117_2 {

	//1.값을 입력받아 List에 추가하고 List를 반환하는 method생성
	public List<String> temp() {
		List<String> list = new ArrayList<String>();
		list.add("Java-James Gosling:1995");
		list.add("Oracle-Larry Ellison");
		list.add("Python-Guido van Rossum:1991");
		list.add("HTML-Tim Berners, LEE:1995");
		list.add("JavaScript-Brandan");
		return list;
	}//temp
	
	//2.List를 받아 지정된 형식대로 출력하는 method
	public void printtemp(List<String> list) {
		
		//입력받은 List를 배열에 복사해서 넣습니다.
		String[] copy = new String[list.size()];
		list.toArray(copy);

		//출력할 문자열을 넣을 배열을 생성합니다.
		String[][]arr = new String[5][3];
		
		
		//배열에 값들을 하나씩 가져와서 StringTokenizer을 이용해 자른후 배열에 입력합니다.
		int flag = 0; //배열의 열의 index를 지정해줄 변수
		for(int i = 0; i <copy.length ; i++) {
			StringTokenizer stk = new StringTokenizer(copy[i],"-:");
				flag=0; //변수 초기화
				while(stk.hasMoreTokens()) {
					arr[i][flag]=stk.nextToken();
					flag++;
			}//while
		}//for
		
		//문자열을 넣은 배열을 출력합니다. 
		System.out.print("항목\t핵심개발자\t개발년도\n");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0 ; j <arr[i].length; j++) {
				if(arr[i][j]==null) {//개발년도가 없는경우 배열의 방에 참조형 data형의 초기화 값인 null값이 저장되어 있다.
					arr[i][j]="알수 없음"; // null값이 있는경우 알수 없음으로 바꿔준다.
				}//end if
				System.out.printf("[%s]",arr[i][j]);
			}//end for
			System.out.println();
		}//for
	}//print temp
	
	
	public static void main(String[] args) {
		HomeWork1117_2 hw2 = new HomeWork1117_2();
		hw2.printtemp(hw2.temp());
	}//main
	
}//class