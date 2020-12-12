package day1211;

import java.util.Random;

public class UseLambda {

	public UseLambda() {
		// Interface를 편하게 사용. (구현 class를 만들지 않고, abstract method를 Override하지 않고 사용.
		Lambda1 l1 = () -> {
			System.out.println("Test method를 Override");
		};

		Lambda1 aoiny = new Lambda1() {
			@Override
			public void Test() {
				System.out.println("Test method를 Override");
			}
		};

		// 람다식 호출
		l1.Test();
		aoiny.Test();

	}// UseLambda

	public void test(Lambda1 lm) {
		lm.Test();
	}// test

	public void pararmeter() {
		Lambda2 l2 = (String name) -> {
			String familyName = "";
			String firtstName = "";
			// 입력되는 name를 사용하여 성과 이름을 변수에 할당하는 코드를 작성

			String[] arr = { "남궁", "제갈", "선우", "독고" };
			int idx = 1;
			for (int i = 0; i < arr.length; i++) {
				if (name.startsWith(arr[i])) {
					idx = 2;
				} // end if
			} // end for
			familyName = name.substring(0, idx);
			firtstName = name.substring(idx);

			System.out.println("성: " + familyName + ", 이름:" + firtstName);
		};
		l2.name("이우길");
	}// pararmeter
	
	
	
	public void returnValue(){
	Lambda3 l3 =()->{
		Random r= new Random();
		return r.nextInt(45)+1;
	};
	
	System.out.println(l3.luckNumber());
	}//returnValue
	
	public void threadtest() {
	Runnable t =()->{
		for(int i = 1; i < 101; i++) {
			System.out.println(i);
		}
	};
	Thread tt = new Thread(t);
	tt.start();
	
	Thread ttt = new Thread(()->{
		for(int i = 1; i < 101; i++) {
			System.out.println(i);
		}
	});
	
	ttt.start();
	
	}//threadtest
	

	public static void main(String[] args) {
		UseLambda ul = new UseLambda();
		ul.test(() -> {
			System.out.println("람다식으로 구현");
		});
		ul.pararmeter();
		ul.returnValue();
		ul.threadtest();
	}// main

}// class
