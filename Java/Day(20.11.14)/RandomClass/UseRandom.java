package day1113.random;

import java.util.Random;

/**
 * 난수를 얻기 위한 목적으로 만들어진 class
 * @author owner
 */
public class UseRandom {

	public UseRandom() {
		//1.class를 Instance화 합니다.
		Random random = new Random();
//		System.out.println(random);// to String을 Override하지 않았기 때문에 주소가 나온다.
		
		//2. method를 호출하여 난수를 얻는 일을 하자.
		int num=random.nextInt();
		System.out.println("정수의 난수 발생");
		System.out.println("발생한 난수: = " +num);
		System.out.println("범위의 난수: = " +num%10); // %가짓수
		System.out.println("범위의 난수에서 양수만 얻기 = " + Math.abs(num%10));
		
		int num1=random.nextInt(10); //nextInt(가짓수)
		System.out.println("범위의 난수 = " + num1);
		
		//실수의 난수
		double num2 = random.nextDouble();
		System.out.println("실수의 난수 발생");
		System.out.println("발생한 난수 = " + num2);
		System.out.println("범위의 난수 = " + num2*5); // *범위 
		System.out.println("범위의 난수에서 정수만 얻기 = " + (int)(num2*5)); // int형으로 casting하자
	
		//Boolean의 난수
		System.out.println("Boolean의 난수 발생");
		boolean bool = random.nextBoolean();
		System.out.println("Boolean의 난수 = " + bool);
		
	}//UseRandom
	
	public static void main(String[] args) {

		new UseRandom();
		
	}//main

}//class
