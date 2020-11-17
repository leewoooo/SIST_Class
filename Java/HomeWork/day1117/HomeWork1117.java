package day1117.homework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * "년 - 월 - 일 요일 오전/오후 시:분:초 형식의 날짜 정보를 출력한다.
 * 실행 할 때 마다 한국,영국,미국,중국,일본중 날짜 형식으로 출력되도록 만들어보세요
 * @author owner
 */
public class HomeWork1117 {
	
	String nation = " ";

	public void printDate() {
	// 1. 시스템의 날짜 정보를 얻는다.
	Date data = new Date();
	// 2. SimpleDataFormat을 이용하여 원하고자 하는 출력 방식을 만든다.
	Locale[] nation = new Locale[] {Locale.KOREA,Locale.UK,Locale.US,Locale.CHINA,Locale.JAPAN};
	String[] nation2= new String[] {"대한민국","영국","미국","중국","일본"};
	int flag = (int)(Math.random()*5+1); //1~5까지의 난수를 발생시킴
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E", nation[flag]);
	String formatData = sdf.format(data);
	System.out.println(nation2[flag]+ "의 현재 시간은" +formatData);
	}
	
	/**
	 * 실행할때마다 지정한 나라의 시간이 random으로 출력되게 하기 위한 method
	 * @return Locale.나라 '
	 * 현재는 switch case문을 썼지만 배열을 이용하면 더 간단하게 만들수 있다.
	 */
	public Locale randomnation() {
		int flag = (int)(Math.random()*5+1); //1~5까지의 난수를 발생시킴
		switch(flag) {
		case 1:
			this.nation = "한국";
			return Locale.KOREA;
		case 2:
			this.nation = "영국";
			return Locale.UK;
		case 3:
			this.nation = "미국";
			return Locale.US;
		case 4:
			this.nation = "중국";
			return Locale.CHINA;
		default :
			this.nation = "일본";
			return Locale.JAPAN;
		}//switch
	}//random nation
	
	public static void main(String[] args) {
		HomeWork1117 hw = new HomeWork1117();
		hw.printDate();
	}//main
}//class
