package day1113.Calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 하나의 날짜 정보를 얻을 때 
 * @author owner
 */
public class UseCalendar {

	public UseCalendar() {
		
		//1.객체 생성
		//is-a
		@SuppressWarnings ("unused")
		Calendar cal = new GregorianCalendar(); 
		//method
		Calendar cal1 = Calendar.getInstance();
		
//		System.out.println(cal + " / " + cal1); //주소출력.
		
//		System.out.println(cal1.get(1)); 상수를 사용하면 어떠한 값을 얻는지 알기 어렵다.
//		System.out.println(cal1.get(Calendar.YEAR));//Constant를 사용하면 얻는 값을 얻기 쉽다.
		
		int year = cal1.get(Calendar.YEAR);
		int mouth = cal1.get(Calendar.MONTH)+1;//0~11월 범위에서 나오기 때문에 사람이 보기 편하게 +1값을 넣어준다.
		int day = cal1.get(Calendar.DAY_OF_MONTH);
		
		int hour = cal1.get(Calendar.HOUR_OF_DAY); //HOUR -12시간 , HOUR_OF_DAY -24시간
		
		int am_pm=cal1.get(Calendar.AM_PM);
		String [] amArr = { "오전" , "오후"}; //조건을 처리할 때 배열을 사용하면 if or switch 문보다 간편하게 사용할 상황들이 있다.
		
		int minute=cal1.get(Calendar.MINUTE);
		int second=cal1.get(Calendar.SECOND);
		
		int week = cal1.get(Calendar.DAY_OF_WEEK);
		
		String[] weekTitle = {" " , "일" , "월" , "화" , "수" , "목" , "금" , "토"} ; // 배열을 직접 생성
		
		String temp = "일,월,화,수,목,금,토";//문자열 CSV DATA
		
		String[] arr =temp.split(","); //문자열을 특정 문자로 구분해서 배열로 만들어 준다.
		
		System.out.println(year + "-" + mouth + "-" +day + " " + amArr[am_pm] + " " + hour +":"  + minute + " " + weekTitle[week] + " " +arr[week-1]);
		
	}//UseCalendar
	
	/**
	 * set method를 사용한 날짜 변경
	 */
	public void Calendarset() {
		
		Calendar cal = Calendar.getInstance(); //현재 날짜를 가지고 있습니다. 2020.11.03
		
		//연도 변경: 2020 => 2021
		cal.set(Calendar.YEAR, 2021);
		//월 변경: 11월 => 3
		cal.set(Calendar.MONTH, 2); //0월부터 시작하기 때문에 변경하고자 하는 달에서 -1해서 설정한다.
		//일 변경: 13 => 31
		cal.set(Calendar.DAY_OF_MONTH, 31);
		
		System.out.println(cal.get(Calendar.YEAR) + "-" +(cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH) + "-"
								+ ("일,월,화,수,목,금,토".split(",")[cal.get(Calendar.DAY_OF_WEEK)-1]));
		
	}//Calendarset
	
	public static void main(String[] args) {

		UseCalendar uc = new UseCalendar();
		uc.Calendarset();
		System.out.println("====================");
		
	}//main

}//class
