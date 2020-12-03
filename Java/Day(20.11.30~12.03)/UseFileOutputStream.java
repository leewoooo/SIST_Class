package day1202.usefileoutputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JVM안에서 발생한 데이터를 파일에 기록
 * 
 * @author owner
 */
public class UseFileOutputStream {

	public UseFileOutputStream() throws IOException {
		FileOutputStream fos = null;
		try {
			File path = new File("c:/dev/temp/");
			if (!path.exists()) { // 파일을 생성할 폴더가 없다면 폴더를 생성한다.
				path.mkdirs();
			} // end if

			// 생성된 경로를 사용하여 파일을 생성.
			File file = new File(path.getAbsolutePath() + "/" + "test.txt");

			// 1. 스트림 생성 (덮어쓰거나 , 생성하거나)
			fos = new FileOutputStream(file);

			// 2. 스트림에 목적지로 보낼 내용을 쓴다.
			fos.write(65); // IOException

			// 3. 스트림에 기록된 내용을 목적지로 분출
			// (기본형은 flush를 하지 않아도 목적지로 분출된다.)
			// (참조형은 flush를 해야 목적지로 분출된다.)
			fos.flush(); // IOException
			System.out.println("파일에 기록되었습니다.");

		} finally {// 반드시 실행되어야 하는 코드 작성.
			// 4. 연결 끊기
			if (fos != null) {
				fos.close(); // IOException
			}
		} // end finally

	}// UseFileOutputStream

	public static void main(String[] args) {
		try {
			new UseFileOutputStream();
		} catch (IOException e) {
			// 생성자 안에서 발생한 IOException을 모아서 처리할 수 있다.(코드 집중)
			// 예외가 발생한 코드와 예외를 처리할 코드를 분리할 수 있다.(복잡도 낮아짐)
			e.printStackTrace();
		}//end catch
	}// main

}// class
