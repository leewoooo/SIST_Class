package day1202.usefilewrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UseFileWrite {

	public UseFileWrite() throws IOException {

		FileWriter fw = null;
		try {

			// 1.파일에 스트림 연결
			fw = new FileWriter(new File("c:/dev/temp/String_data.txt"));
			// 2.데이터를 스트림 기록.
			String msg = "코로나야 물러가라";
			fw.write(msg);
			// 3.스트림의 내용을 목적지로 분출
			fw.flush();
			System.out.println("정상적인 기록");
		} finally {
			// 4.연결끊기
			if (fw != null) {
				fw.close();
			} // end if
		} // end finally
	}// UseFileWrite

	public static void main(String[] args) {

		try {
			new UseFileWrite();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

	}// main

}// class
