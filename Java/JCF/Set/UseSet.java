package day1116.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 검색의 기능이 없으며, 중복값을 허용하지 않는 Set의 사용.<br>
 * 입력값은 순차적으로 입력되지 않는다.
 * @author owner
 */
public class UseSet {
	
	public UseSet() {
		
		//1. 생성
		Set<String> set = new HashSet<String>();
		
		//2. 값넣기 (값이 순차적을 입력되지 않습니다.)
		set.add("오늘은");
		set.add("2020년");
		set.add("11월");
		set.add("16일");
		set.add("11월"); //중복 Data의 추가 : 중복Data는 추가되지 않는다.
		System.out.println(set + " / " + set.size());
		
		//3. 값 삭제 (값이 순차적을 입력되지 않기에 index사용 불가)
		set.remove("오늘은");
		System.out.println(set);
		
		//4. 검색. : Iterator를 사용.
		Iterator<String> ita = set.iterator(); //Iterator의 데이터를 가진 set에 제어권을 넘겨준다.
		
		//5. 값이 존재하는지?
		while(ita.hasNext()) { //방이 존재하는 지
			System.out.println(ita.next()); //값을 얻고 pointer를 다음 방 앞으로 이동
		}//end while
		
	}//UseSet
	
	public static void main(String[] args) {

		new UseSet();
		
	}//main

}//class
