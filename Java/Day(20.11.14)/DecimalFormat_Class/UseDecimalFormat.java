package day1113.decimalformat;

import java.text.DecimalFormat;

/**
 * 숫자를 지정한 문자열의 형식으로 만들 때
 * 예를들어 쇼핑몰에서 가격의 형식을 설정할때.
 * @author owner
 */
public class UseDecimalFormat {

	public UseDecimalFormat() {
		
		//'#' pattern : 해당 자리에 데이터가 존재하는 것만 출력.
		DecimalFormat df = new DecimalFormat("#,###,###");
		int i = 2020;
		System.out.println(df.format(i)); // Format에 맨 뒷자리 부터 들어간다.
		
		//'0' pattern : 해당 자리에 데이터가 존재하면 값을 출력하고, 존재하지 않으면 0을 출력
		DecimalFormat df1 = new DecimalFormat("0,000,000");
		int j = 2020;
		System.out.println(df1.format(j)); // Format에 맨 뒷자리 부터 들어간다.
		
		//실수의 처리 :  소수점 이하 자릿수를 설정할 수 있다.
		DecimalFormat df2 = new DecimalFormat("0,000,000.000"); //백만단위와 실수 3 자리 출력
		double k = 123456.789;
		System.out.println(df2.format(k)); // Format에 맨 뒷자리 부터 들어간다.
		
		long l = 2_17_483_649L; //정수의 자릿수 구분은 _ 를 넣어 code상 구분할 수 있다. => JDK 1.7
		System.out.println(l);
		
	}//UseDecimalFormat
	
	public static void main(String[] args) {

		new UseDecimalFormat();
		
	}//main

}//class
