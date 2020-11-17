package day1117.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * key와 값의 쌍으로 Data가 존재하는 Map의 사용
 * @author owner
 */
public class UseMap {

	/**
	 * 기본 생성자를 사용하여 Instance를 생성하면 11개의 행이 생성된 HashTable을 사용해보겠습니다.
	 * 동기화가 되어 있기에 Hash Map보다 느리다.
	 */
	public void useHashTable() {
		
		//1. 생성
		Map<String, String> map = new Hashtable<String, String>();
		
		//2. 값 넣기 (값은 순차적으로 들어가지 않는다.)
		map.put("Java", "OOP언어");
		map.put("Oracle", "대용량Data");
		map.put("HTML", "웹 페이지의 구조설정");
		map.put("CSS", "웹 페이지의 통일성 있는 DESIGN을 설정");
		System.out.println(map);
		
		map.put("python", "OOP언어");
		//key는 중복 될수 없다. 같은 key가 존재하면 해당 key에 덮어쓴다.
		map.put("Java", "완벽한 OOP언어"); // 기존 Value는 OOP언어 였는데 완벽한 OOP언어로 덮어쓰여졌다.
		
		//3. 행의 크기 얻기
		System.out.println(map.size() + "행");
		
		//4. 값얻기
		System.out.println(map.get("Oracle"));
		
		//5. Key가 존재하는지?
		System.out.println(map.containsKey("Oracle")); // true | false
		
		//6. 모든 key 얻기.
		Set<String> set = map.keySet();
		System.out.println("모든 key" + set);
		
		//7. 모든 값 얻기
		Iterator<String> ita = set.iterator();
		while(ita.hasNext()) {
			System.out.println(map.get(ita.next())); //모든값
		}
		
		
	}//useHashTable
	

	/**
	 * 기본 생성자를  사용하여 Instance를 생성하면 16개의 행이 생선된다.
	 */
	public void useHashMap() {
		
		//1. 생성
		Map<String, String> map = new HashMap<String, String>();
		
		//2. 값 넣기 (값은 순차적으로 들어가지 않는다.)
		map.put("Java", "OOP언어");
		map.put("Oracle", "대용량Data");
		map.put("HTML", "웹 페이지의 구조설정");
		map.put("CSS", "웹 페이지의 통일성 있는 DESIGN을 설정");
		System.out.println(map);
		
		map.put("python", "OOP언어");
		//key는 중복 될수 없다. 같은 key가 존재하면 해당 key에 덮어쓴다.
		map.put("Java", "완벽한 OOP언어"); // 기존 Value는 OOP언어 였는데 완벽한 OOP언어로 덮어쓰여졌다.
		
		//3. 행의 크기 얻기
		System.out.println(map.size() + "행");
		
		//4. 값얻기
		System.out.println(map.get("Oracle"));
		
		//5. Key가 존재하는지?
		System.out.println(map.containsKey("Oracle")); // true | false
		
		//6. 모든 key 얻기.
		Set<String> set = map.keySet();
		System.out.println("모든 key" + set);
		
		//7. 모든 값 얻기
		Iterator<String> ita = set.iterator();
		while(ita.hasNext()) {
			System.out.println(map.get(ita.next())); //모든값
		}
		
	}//useHashMap
	
	
	public static void main(String[] args) {

		UseMap um =new UseMap();
		um.useHashTable();
		System.out.println("===========================");
		um.useHashMap();
		
	}//main

}//class
