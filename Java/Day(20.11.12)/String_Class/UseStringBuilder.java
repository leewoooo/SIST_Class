package day1112.useString;

/**
 * 긴 문자열을 사용 할 때 쓰는 class : StringBuffer , StringBuilder의 사용.
 * 긴문자열 = "문자열"+"문자열"
 * @author owner
 */
public class UseStringBuilder {
	
	
	public void useStringBuffer() {
		
		//class를 사용하려면 처음 Instance화 한 후 사용.
		//1.생성 (class에서 다른 class의 기능을 사용하기 위해 상속(is-a)을 받을 수 도 있고,
		// Instance를 직접 생성하여 사용(has-a)할 수도 있다.
		StringBuffer sb = new StringBuffer();
		//2.사용 (method 호출 : Instance가 제공하는 일을 사용)
		//값 추가.(정수, 실수, 문자, 문자열, Boolean)
		sb.append("오늘은 ");
		sb.append(11);
		sb.append("월");
		sb.append("12");
		sb.append("일");
		
		//값 삽입.(인덱스를 지정하여 값을 넣는다.)
		//오늘은 11월12일
		//0 1 2 3456 78 9 << String Index
		sb.insert(4, "2020년");
		//오늘은 2020년11월12일
		//0 1  23 456789......
		
		//값 삭제 : 문자열에서 년도 4자리 중 앞 2자리를 삭제
		//delete(시작index, 끝index+1)
		//끝에 null문자를 포함하고 있기 때문에 끝index에 +1
		sb.delete(4, 6);
		
		//문자열 뒤집기.
		sb.reverse();
//		sb.reverse();
		
		//StringBuffer의 내용을 String에 할당해 봅시다.
		//String str = sb; // String과 StringBuffer은 다른 Data type이다.
		String str = sb.toString();
		System.out.println(str);
		
	}//useStringBuilder
	
	public void useStringBuilder() {
		
		
		//class를 사용하려면 처음 Instance화 한 후 사용.
		//1.생성 (class에서 다른 class의 기능을 사용하기 위해 상속(is-a)을 받을 수 도 있고,
		// Instance를 직접 생성하여 사용(has-a)할 수도 있다.
		StringBuilder sb = new StringBuilder();
		//2.사용 (method 호출 : Instance가 제공하는 일을 사용)
		//값 추가.(정수, 실수, 문자, 문자열, Boolean)
//		sb.append("오늘은 ");
//		sb.append(11);
//		sb.append("월");
//		sb.append("12");
//		sb.append("일");
		
		//method chain
		sb.append("오늘은").append(11).append("월").append(12).append("일");
		
		
		//값 삽입.(인덱스를 지정하여 값을 넣는다.)
		//오늘은 11월12일
		//0 1 2 3456 78 9 << String Index
		sb.insert(4, "2020년");
		//오늘은 2020년11월12일
		//0 1  23 456789......
		
		//값 삭제 : 문자열에서 년도 4자리 중 앞 2자리를 삭제
		//delete(시작index, 끝index+1)
		//끝에 null문자를 포함하고 있기 때문에 끝index에 +1
		sb.delete(4, 6);
		
		//문자열 뒤집기.
		sb.reverse();
//		sb.reverse();
		
		String str = sb.toString();
		System.out.println(str);		
		
	}//useStringBuilder

	public static void main(String[] args) {

		UseStringBuilder usb = new UseStringBuilder();
		usb.useStringBuffer();
		System.out.println("=================");
		usb.useStringBuilder();
		
//		String(문자열)에 +연산을 사용하면 Compiler가 +연산을 StringBuilder로 변경
//		String str = "안녕";
//		str+="하세요";
//		str+="오늘은 목요일 입니다";
//		System.out.println(str);
//		
//		+연산으로 String을 사용 했을 시 Compiler에서 실행되는 과정
//		
//		public static void main(String args[])
//	    {
//	        String str = "\uC548\uB155";
//	        str = (new StringBuilder(String.valueOf(str))).append("\uD558\uC138\uC694").toString();
//	        str = (new StringBuilder(String.valueOf(str))).append("\uC624\uB298\uC740 \uBAA9\uC694\uC77C \uC785\uB2C8\uB2E4").toString();
//	        System.out.println(str);
//	    }
		
	}//main
}//class
