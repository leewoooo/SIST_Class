package day1201.usefile;

import java.io.File;
import java.io.IOException;

/**
 * HDD에 존재하는 File의 정보를 얻거나 조작할 때 사용하는 File class의 사용법
 * @author owner
 */
public class UseFile {

	public UseFile() {

		//1.생성
		File file = new File("C:/dev/temp/java_read.txt");
		System.out.println(file);
		
		//2.method를 호출.
		if(file.exists()) {//파일이 존재하는지?
			
			System.out.println("파일 크기: " + file.length()+"byte");//현재 가져온 파일의 크기는?
			System.out.println("절대경로: " +file.getAbsolutePath());
			
			//CanonicalPath Os에서 file에 접근하는 단하나의 경로 dirve는 대문자로 시작한다.
			try {
				System.out.println("절대경로 : " + file.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end catch
			
			System.out.println("파일경로 : " + file.getPath());
			
			System.out.println("파일디렉토리 : " +file.getParent());
			
			System.out.println("파일의 이름 : " +file.getName());

			System.out.println("파일입니까? : " +file.isFile());
			
			System.out.println("폴더입니가? : " +file.isDirectory());

			System.out.println("실행가능합니까? : " +file.canRead());
			
			System.out.println("쓰기가능합니까? : " +file.canWrite());
			
			System.out.println("실행가능합니까? : " +file.canExecute());
			
			System.out.println("숨긴파일입니까? : " +file.isHidden());

			
		}else {
			System.out.println(file + "파일 경로나 파일명을 확인하세요.");
		}
	}

	public static void main(String[] args) {

		new UseFile();

	}// main
}// class
