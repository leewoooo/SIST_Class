package day1117.stack;

import java.util.Stack;

/**
 *	LIFO(Last Input First Output)를 구현한 Class  Stack의 사용 
 * @author owner
 */
public class UseStack {

	public UseStack() {
		
		//1.생성: IS-A 관계의 Instance화를 하지 않습니다.
		
		Stack<String> stk = new Stack<String>();
		//2.method호출 : 부모의 method는 사용하지 않습니다. (LIFO에 위배될 수 있기에)
		
		//값 추가						[heap]
		stk.push("A");				//D
		stk.push("B");				//C
		stk.push("C");				//B
		stk.push("D");				//A
		
		System.out.println(stk);
		
		//Stack가 비어있는지?
		System.out.println("Stack가 비어있는가?" + stk.empty());
		
		//값 얻기
		stk.pop(); //stack의 가장 위에 적재되어 있는 D가 반환된다.
		System.out.println(stk + " / " + stk.empty());
		
		//Stack의 모든 방 얻기 (일괄처리)
		while(!stk.empty()) {
			System.out.println(stk.pop()); // C , B, A 순서대로 출력이 된다. (후입선출)
		}//end while
		
		System.out.println("Stack가 비어있는가?" + stk.empty());
		
	}//UseStack
	public static void main(String[] args) {
		new UseStack();
	}//main

}//class
