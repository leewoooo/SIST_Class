package day1201.usefileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 8bit Stream을 사용하여 HDD에 존재하는 File 내용을 읽기 작업
 * 
 * @author owner
 */
public class UseFileInputStream {

	public UseFileInputStream() {

		try {
			// 1. File Stream 생성
			FileInputStream fis = new FileInputStream(new File("C:/dev/temp/java_read1.txt"));
			// 2.File의 내용 읽기.
//			System.out.println(fis.read()); // read()에서 throws로 IOExceoption
			
			int temp = 0;
			while((temp=fis.read()) != -1) {
				System.out.print((char)temp);
			}
			
		} catch (FileNotFoundException fe) {// FileInputStream에서 throws로 FileNotFindException
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}// UseFileInputStream

	public static void main(String[] args) {

		new UseFileInputStream();

	}// main

}// class
