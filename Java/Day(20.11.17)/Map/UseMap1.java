package day1117.map;

import java.util.HashMap;
import java.util.Map;

public class UseMap1 {

	public void useHashMap() {
		
		//1. map생성
		Map<String, String> map = new HashMap<String,String>();
		//2. 값 할당 (key와 값의 쌍으로 입력 한 쌍을 entry라고 한다.
		map.put("A", "세심하다.(~^0^)~");
		map.put("B", "까칠하다. (ㅡㅡ+)");
		map.put("AB", "싸이코@,@");
		map.put("O", "우유부단~(^^~)(~^^)~");

		//key가 같다면 덮어 쓰여진다.
		map.put("B", "터프하다.");
		map.put("AB", "바보아니면천재");
		map.put("O", "개그욕심");
		
		System.out.println(map);
		
		
		//String literal인 ""는 String class에서 제공하는 모든 method를 사용할 수  있다.
		String bloodType = "a".toUpperCase();
		
		if(map.containsKey(bloodType)) { //key가 존재 하는지?
			System.out.println(bloodType+ "형의 특징은   " + map.get(bloodType));
		}else {
			System.out.println(bloodType + "은 사람의 혈액형이 아닙니다.");
		}
		
		
	}
	public static void main(String[] args) {

		UseMap1 um1 = new UseMap1();
		um1.useHashMap();
		
	}//main

	
}//class
