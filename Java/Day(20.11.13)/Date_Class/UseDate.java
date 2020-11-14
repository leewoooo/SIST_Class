package day1113.Date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * 형식이 있는 날짜 정보를 사용할 때.
 * SimpleDateFormet과 함께 사용한다.
 * @author owner
 */
public class UseDate {

	public UseDate() {
		
		// 1. Date 생성 : 시스템의 날짜 정보를 얻는다.
		Date date = new Date();
		//System.out.println(date.toString()); //사용자가 원하는 날짜형식이 아니다.
		
		// 2. SimpleDateFormat : 사용자가 원하는 날짜 형식을 만들수 있는 class
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh(HH,kk):mm:ss E");
     	//System.out.println(sdf); // 주소 출력. simpleDateFormet은 toString()을 Override하지 않았기 때문
		String formatDate = sdf.format(date); 
		//date를 넣어주는 이유는 SimpleDateFormat은 형식만 가지고있을 뿐 시간정보는 없다.
		//날짜 객체를 전달받아 (has a)원하는 날짜 형식의 문자열을 얻는다.
		System.out.println(formatDate);
		
		
		//다른 언어의 날짜형식을 보여줄려면 Locale class를 사용한다.
		//new SimpleDateForMat("pattern", Locale.나라별constant);
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy a hh(HH,kk):mm:ss E",Locale.UK); //영국의 시간 형식
		String formatDate1 = sdf1.format(date); 
		System.out.println(formatDate1);
		
	}//UseDate
	
	public static void main(String[] args) {

		new UseDate();
		
	}//main

}//class
