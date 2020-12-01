package day1201.usefilereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 16bit Stream을 사용하여 file의 모든 내용을 읽는작업
 * 
 * @author owner
 *
 */
public class UseFileReader {

	public UseFileReader() throws /* FileNotFoundException, */ IOException {
		File file = new File("C:/dev/temp/java_read1.txt");
		// 1. File이 존재한다면 File의 Stream을 연결하겠습니다.
		if (file.exists()) {// file class를 사용하여 file의 유무를 확인하기 때문에 예외를 날리지 않아도 된다.
			FileReader fr = new FileReader(file);
			//2. 줄 단위로 읽어들이는 기능이 있는 Stream을 연결
			BufferedReader bfr = new BufferedReader(fr);

			//파일에 있는 내용을 전부 읽기
			String str = "";
			while ((str=bfr.readLine()) != null) { //파일의 끝 (EOF(end of file)에는 null이 나온다.
				System.out.println(str);
			} // end while
			
			//3. Stream의 사용이 종료되었다면 연결 종료
			bfr.close();
		} else {
			System.err.println(file + "이 존재하지 않습니다.");
		} // end else

	}// UseFileReader

	public static void main(String[] args) {

		try {
			new UseFileReader();
		} catch (IOException ie) {
			System.err.println("파일의 내용을 읽어들일 수 없습니다");
			ie.printStackTrace();
		} // end catch

	}// main

}// class
