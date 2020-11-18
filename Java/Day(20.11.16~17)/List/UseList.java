package day1116.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * - 검색의 기능이 있으며 중복 Data를 저장할 수 있는 List의 사용
 * - 가변 길이형 : 데이터의 추가, 삭제 작업에 따라 방의 갯수가 변경된다.
 * @author owner
 */
public class UseList {

	/**
	 * Multi Thread에서 동시 접근이 불가능 합니다. (보안성을 요구 할때 사용)
	 * 동기화가 되어 있다, 속도가 느리다 (Arraylist에 비해)
	 */
	public void useVector(){
		
		//1. 생성 : Generic은 기본형 DatType을 사용할 수 없다 , 기본형 대신 Wrapper Class를 사용
		Vector<Integer> vec = new Vector<Integer>(3); 
		//기본 방의 크기, size로 방의 크기가 나오지 않는다, Data가 추가되면 방의 크기가 늘어난다.

		List<String> list = new Vector<String>();
		
		System.out.println( "백터의 크기 " + vec.size());
		System.out.println("리스트의 크기 " + vec.size());
		
		//2.값 추가 : Generic으로 설정된 Datatype만 추가 가능
		vec.add(10); // => vec.add(Integer(10));
		//기본형 Datatype을 추가하면 JVM이  기본형 Datatype에 대응되는 
		//Wrapper Class를 사용하여 객체를 만들어주고 추가한다. 
		// JDK 1.5부터 추가된 autoboxing 기능이라고 한다.
		
		vec.add(20);
		System.out.println( "백터의 크기 " + vec.size());
		vec.add(30);
		vec.add(10); //중복값 허용
		//capacity의 크기를 초과하더라도 방이 증가하여 추가된다.
		//생성할 때 방의 크기를 지정해주었어도 Data가 추가 되면 계속해서 방이 증가된다.
		System.out.println( "백터의 크기 " + vec.size());
		System.out.println(vec); //Object.toString()를 Vector가 Override하여 주소가 아닌 값이 출력
		
		list.add("함혜림");
		list.add("최혜원");
		list.add("최은혜");
		list.add("정예진");
		list.add("정소윤"); 
		System.out.println("list의 크기 " + list.size() + " / " + list);
		
		//배열로 복사
		//Generic이 설정되지 않은 List의 복사는 warning이 발생
		//배열을 List의 크기로 선언합니다.
//		int[]arr = new int[vec.size()];  int와 Integer은 동일 Datatype이 아니다.
		Integer[]arr = new Integer[vec.size()];  
		String[]arr1 = new String[list.size()];
		
		//복사 
		list.toArray(arr1);
		vec.toArray(arr);
		
		//3. 값얻기 : unboxing 발생
		String name = list.get(0); //입력 데이터 형과 저장하는 데이터 형이 같다면 unboxing이 동작하지 않는다.
		System.out.println(name);
		
		int num = vec.get(0); 
		//get method의 반환형은 Integer이지만 unboxing이 동작하여 int에 저장된다.
		//Wrapper Class가 Generic으로 설정되어 있을 때 기본형 Datatype으로 값을 얻으면 JVM이 Wrapper Class에서 기본형으로 값을 얻어내는  Unboxing을 수행.
		//int num=vec.get(0).intValue();
		
		
		System.out.println(name + " / " + num);
		
		//4.일괄처리
		for(int i = 0 ; i < vec.size() ; i ++) {
			System.out.println(vec.get(i));
		}//end for
		
		for(int j = 0 ; j < list.size() ; j++) {
			System.out.println(list.get(j));
		}//end for
		
		
		//5.값 삭제
		
		//index으로 지우기
		
		vec.remove(1); //1을 Index로 가지고 있는 방의 값 삭제
		list.remove(3); // 정예진 삭제
		System.out.println(vec);
		System.out.println(list);
		//Object으로 지우기
//		vec.remove(new Integer(30));// 30이 삭제 JDK 1.8 까지
		vec.remove(Integer.valueOf(30));// 30이 삭제 // JDK9이후에는 생성자가 비추천으로 변경되어 Static method사용
		list.remove("함혜림");//함혜림 삭제
		System.out.println(vec);
		System.out.println(list);
		
		System.out.println("vec가 비었는가?" + vec.isEmpty());
		System.out.println("list가 비었는가?" + list.isEmpty());
		
		//모든 방의 값을 삭제
		vec.clear();
		list.clear();
		System.out.println("vec가 비었는가?" + vec.isEmpty());
		System.out.println("list가 비었는가?" + list.isEmpty());
		
//		System.out.println(list.size() == 0); //isempty와 같은 기능입니다.
		
		System.out.println("=====배열에 복사한 내용 =====");
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}//end for
		
		for(int i = 0 ; i < arr1.length ; i++) {
			System.out.println(arr1[i]);
		}//end for
		
	}//useVector
	
	/**
	 * Multi Thread에서 동시 접근이 가능하다.
	 * 비 동기화가 되어 있다, 속도가 빠르다 (Vector에 비해)
	 */
	public void useArrayList() {
		

		//1. 생성 : Generic은 기본형 DatType을 사용할 수 없다 , 기본형 대신 Wrapper Class를 사용
		ArrayList<Integer> al = new ArrayList<Integer>(3); 
		//기본 방의 크기, size로 방의 크기가 나오지 않는다, Data가 추가되면 방의 크기가 늘어난다.

		List<String> list = new ArrayList<String>();
		
		System.out.println( "ArrayList의 크기 " + al.size());
		System.out.println("리스트의 크기 " + al.size());
		
		//2.값 추가 : Generic으로 설정된 Datatype만 추가 가능
		al.add(10); // => al.add(Integer(10));
		//기본형 Datatype을 추가하면 JVM이  기본형 Datatype에 대응되는 
		//Wrapper Class를 사용하여 객체를 만들어주고 추가한다. 
		// JDK 1.5부터 추가된 autoboxing 기능이라고 한다.
		
		al.add(20);
		System.out.println( "ArrayList의 크기 " + al.size());
		al.add(30);
		al.add(10); //중복값 허용
		//capacity의 크기를 초과하더라도 방이 증가하여 추가된다.
		//생성할 때 방의 크기를 지정해주었어도 Data가 추가 되면 계속해서 방이 증가된다.
		System.out.println( "ArrayList의 크기 " + al.size());
		System.out.println(al); //Object.toString()를 altor가 Override하여 주소가 아닌 값이 출력
		
		list.add("함혜림");
		list.add("최혜원");
		list.add("최은혜");
		list.add("정예진");
		list.add("정소윤"); 
		System.out.println("list의 크기 " + list.size() + " / " + list);
		
		//배열로 복사
		//Generic이 설정되지 않은 List의 복사는 warning이 발생
		//배열을 List의 크기로 선언합니다.
//		int[]arr = new int[al.size()];  int와 Integer은 동일 Datatype이 아니다.
		Integer[]arr = new Integer[al.size()];  
		String[]arr1 = new String[list.size()];
		
		//복사 
		list.toArray(arr1);
		al.toArray(arr);
		
		//3. 값얻기 : unboxing 발생
		String name = list.get(0); //입력 데이터 형과 저장하는 데이터 형이 같다면 unboxing이 동작하지 않는다.
		System.out.println(name);
		
		int num = al.get(0); 
		//get method의 반환형은 Integer이지만 unboxing이 동작하여 int에 저장된다.
		//Wrapper Class가 Generic으로 설정되어 있을 때 기본형 Datatype으로 값을 얻으면 JVM이 Wrapper Class에서 기본형으로 값을 얻어내는  Unboxing을 수행.
		//int num=al.get(0).intValue();
		
		
		System.out.println(name + " / " + num);
		
		//4.일괄처리
		for(int i = 0 ; i < al.size() ; i ++) {
			System.out.println(al.get(i));
		}//end for
		
		for(int j = 0 ; j < list.size() ; j++) {
			System.out.println(list.get(j));
		}//end for
		
		
		//5.값 삭제
		
		//index으로 지우기
		
		al.remove(1); //1을 Index로 가지고 있는 방의 값 삭제
		list.remove(3); // 정예진 삭제
		System.out.println(al);
		System.out.println(list);
		//Object으로 지우기
//		al.remove(new Integer(30));// 30이 삭제 JDK 1.8 까지
		al.remove(Integer.valueOf(30));// 30이 삭제 // JDK9이후에는 생성자가 비추천으로 변경되어 Static method사용
		list.remove("함혜림");//함혜림 삭제
		System.out.println(al);
		System.out.println(list);
		
		System.out.println("al가 비었는가?" + al.isEmpty());
		System.out.println("list가 비었는가?" + list.isEmpty());
		
		//모든 방의 값을 삭제
		al.clear();
		list.clear();
		System.out.println("al가 비었는가?" + al.isEmpty());
		System.out.println("list가 비었는가?" + list.isEmpty());
		
//		System.out.println(list.size() == 0); //isempty와 같은 기능입니다.
		
		System.out.println("=====배열에 복사한 내용 =====");
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}//end for
		
		for(int i = 0 ; i < arr1.length ; i++) {
			System.out.println(arr1[i]);
		}//end for
		
		
	}//useArraylist
	
	public static void main(String[] args) {

		UseList ul = new UseList();
		ul.useVector();
		System.out.println("======================");
		ul.useArrayList();
			
	}//main

}//class
