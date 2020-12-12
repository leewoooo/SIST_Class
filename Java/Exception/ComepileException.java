package day1127.objectclone;

/**
 * 객체를 복사한다 (같은 값을 가진 객체)
 * 모든 객체는 clone()로 호출할 수 있으나 복제되지 않는다.
 * clone()은 protected이므로 복제하려는 class 안에서만 복제가가능하다
 * @author owner
 */
public class ComepileException implements Cloneable {
	
	private int year;
	private String name;
	
	public ComepileException() {
		year = 2020;
		name = "test";
	}
	
	
	public static void main(String[] args) {

		//1.복제하려는 객체를 생성한다.
		ComepileException ce = new ComepileException();
		
		//2.복제
		//clone() method가 컴파일예외를 throws하고 있으므로 개발자는 해당 예외를 반드시 try~catch로 처리해야함
		//객체의 상태를 저장해야 할 때 사용한다.
		try {
			ComepileException ce1 = (ComepileException)ce.clone();
			System.out.println("복제되었습니다");
			System.out.println(ce + " /" + ce1);
			ce.year = 1010;
			ce.name= "테스트";
			ce1.year = 101010;
			ce1.name= "테테스스트트";
			System.out.println(ce.year + "/" + ce1.year + "/" + ce.name + " / " + ce1.name);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}//end catch
		
		//forName()가 ClassNotFoundException을 throws하고 있기 때문에
		//method를 호출하는 곳에서 try~catch를 처리해야한다.
		try {
			Class cl = Class.forName("java.lang.String");
			System.out.println(cl);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		
		
	}//main
}//class
