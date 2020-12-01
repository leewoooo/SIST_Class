package day1201.usefile;

import java.io.File;

public class UseFile3 {

	
//	public void removeFile() {
//		File file = new File("C:/dev/temp/java_read1.txt");
//		
//		if(file.exists()) {
//			file.delete();
//		}
//	}//removeFile
//	
	public void reName() {
		
		//파일 객체를 생성
		File file = new File("C:/dev/temp/java_read.txt");
		//변경할 이름을 가진 파일 객체를 생성
		File refile = new File("C:/dev/temp/java_read1.txt");
		
		System.out.println(file.renameTo(refile));
		
	}//reName
	
	public static void main(String[] args) {

		UseFile3 f3 = new UseFile3();
//		f3.removeFile();
		f3.reName();
		
	}//main

}//class
