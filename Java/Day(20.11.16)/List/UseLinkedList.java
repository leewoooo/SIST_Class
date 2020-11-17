package day1117.uselinkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * java util.List를 구현한 class : 일차원 배열의 형식이면서 가변 길이 형이다.
 * 발생된 DATA가 기존의 DATA의 사이에 들어가는 일이 많을때 사용한다.
 * @author owner
 */
public class UseLinkedList {

	public UseLinkedList() {
		
		//1. 생성
		LinkedList<String> ll = new LinkedList<String>();
		
		List<String> list = new LinkedList<String>();
		
		
		//2. 값 추가
		ll.add("JAVA");
		ll.add("ORACLE");
		ll.add("JDBC");
		
		
		list.add("Java");
		list.add("JSP");
		list.add("XML");
		list.add("JSON");
		
		//3. 방의 갯수 확인
		System.out.println(ll.size() + " / " + list.size());
		
		//기존에 DATA사이에 값을 추가 할 때 ArrayList, Vector보다 효율이 좋다.
		list.add(1, "Oracle");
		//Oracle이라는 객체를 생성해서 시작주소를 Java의 끝주소로 가져온다. 끝 주소는 JSP의 시작주소를 가져온다.
		//이후 Index를 조정한다.
		System.out.println(list + " / " +list.size());
		list.add(2, "JDBC");
		System.out.println(list + " / " +list.size());
		
		//4. 값 삭제
		list.remove(4);
		System.out.println(list + " / " +list.size());
		//XML이 지워지면 JSP의 끝주소는 JSON의 시작 주소를 갖게 되고
		//JSON의 시작주소는 JSP의 시작주소를 갖게된다.
		
		
		//5.일괄처리
		for(int i = 0 ; i < list.size(); i++){
			System.out.print(list.get(i) + " ");
		}//end for
	}//UseLinkedList

	public static void main(String[] args) {

		new UseLinkedList();
		
	}//main

}//class
