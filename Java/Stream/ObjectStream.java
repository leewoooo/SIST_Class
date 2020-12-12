package day1203.mydata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 객체를 JVM외부로 내보내거나, JVM외부에 존재하는 객체를 읽어 들일때 사용하는 Stream
 * 
 * @author owner
 */
public class ObjectStream {

	/**
	 * 입력받은 객체를 JVM외부로 내보내는 일
	 * 
	 * @param md
	 */
	public void writeObj(MyData md) throws IOException , NotSerializableException{ //직렬화

		ObjectOutputStream oos = null;

		try {
			// 1. 스트림을 연결한다.
			oos = new ObjectOutputStream(new FileOutputStream("c:/dev/temp/obj.dat"));

			// 2. 객체를 스트림에 기록된다.,(Stream)
			oos.writeObject(md);

			// 3. Stream에 기록된 내용들을 목적지로 분출한다.
			oos.flush();
			System.out.println("객체가 저장되었습니다.");
		} finally {
			// 4. 사용이 완료된 Stream은 종료해준다.
			if (oos != null) {
				oos.close();
			} // end if
		} // end finally
	}// writeObj

	/**
	 * JVM외부의 객체를 읽어들여 반환하는일.
	 * 
	 * @return
	 */
	public MyData readObj() throws IOException , ClassNotFoundException{ //역 직렬화s
		MyData md = null;
		ObjectInputStream ois = null;
		
		try {
			//1. Stream을 연결
			ois = new ObjectInputStream(new FileInputStream("c:/dev/temp/obj.dat"));
			
			//2. 객체를 읽어오자
			md = (MyData)ois.readObject();
			
		}finally {
			if(ois != null) {
				ois.close();
			} // end if
		} // end finally
		
		return md;
	}// readObj

	public static void main(String[] args) {
		ObjectStream oos = new ObjectStream();

		MyData md = new MyData("이우길", 25, 172, 70);
		try {
			System.out.println("내보낸 객체" + md);
			oos.writeObj(md);
			
			MyData md2 = oos.readObj();
			System.out.println("읽어들인 객체"+md2);
			
		}catch(ClassNotFoundException cnfe) {
			System.err.println("읽어들인 값이 객체가 아닙니다.");
			cnfe.printStackTrace();
		}catch(NotSerializableException nse) {
		System.err.println("객체가 직렬화되지 않습니다.");
			nse.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} // end catch
	}// main

}// class
