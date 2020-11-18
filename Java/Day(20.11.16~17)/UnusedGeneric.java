package day1116.list;

import java.util.ArrayList;
import java.util.List;

public class UnusedGeneric {
	
	public UnusedGeneric() {
		
		//JDk 1.4까지 사용하던 문법 (Generic이 지원되지 않을 때) : List가 모든 값을 저장할 수 있다.
		
		//1. 생성
		@SuppressWarnings("rawtypes")
		List list = new ArrayList(); //Generic을 사용을 권장하는 warning이 발생한다.
		
		//2.값 추가 (Generic을 사용하지 않으면 모든 값을 추가할 수 있다.)
//		System.out.println(list.size()); //Data가 하나도 없을때
		list.add(10);
		list.add(20);
		list.add(30.11);
		list.add("안녕하세요"); // Generic을 사용하지 않았기에 모든 값을 추가 할 수 있다.
		System.out.println(list.size()); //값을 넣을 때마다 방의 갯수가 1씩 증가한다.
		
		//3.값 얻기
		for(int i =0; i < list.size() ; i++) {
//			System.out.println(list.get(i) * 10); //값을 꺼내 사용할 때에는 error이 발생한다.
			System.out.println(list.get(i));  //단순히 꺼내는 것은 error가 발생하지 않는다.
		}//end for
		
	}//UnusedGeneric

	public static void main(String[] args) {

		new UnusedGeneric();
	}//main
}//class
