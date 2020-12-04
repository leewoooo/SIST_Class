package day1204.simplemsg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleMsgSever {

	public SimpleMsgSever() throws IOException, BindException {

		// 1. ServerSocket을 생성합니다. (port생성)
		ServerSocket server = null;
		Socket client = null;
		DataOutputStream dos = null; // java의 Data(int,char,String)를 외부로 내보낼 때 사용하는 Stream
		DataInputStream dis = null;
		try {
			server = new ServerSocket(55555); // 0~65535
			// 3. 접속자가 소켓이 존재한다면 접속자 소켓을 받는다.

			while (true) {
				client = server.accept();

				InetAddress ia = client.getInetAddress();

				System.out.println("접속자 있음. : " + ia.getHostAddress());
				// 4. 서버에 존재하는 데이터를 접속자에게 보내기 위해 "Stream"을 연결한다.
				dos = new DataOutputStream(client.getOutputStream());

				String msg = "안녕하세요 코로나 조심하세요. -이우길-";
				// 5. Data를 Stream에 기록.
				// 한글이 packet에 전달될 수 있게 변한. 가 ->%xx%xx%xx로 전달 UTF-8 = 한글 1글자에 3byte로 분리해 전달
				dos.writeUTF(msg);

//				boolean flag = false;
//				dos.writeBoolean(flag);
				// 6. Stream에 기록된 내용을 목적지로 분출한다.
				dos.flush();
				
				//접속자가 보내오는 값을 받기 위한 스트림.
				dis = new DataInputStream(client.getInputStream());
				//접속자가 보내오는 값 읽기
				String revMsg = dis.readUTF();
				System.out.println(revMsg);
				
			} // end while

			// 8. 연결을 끊는다.
		} finally {
			if (client != null) {
				client.close();
			} // end if
			if (server != null) {
				server.close();
			} // end if
			if (dos != null) {
				dos.close();
			} // end if
			if (dis != null) {
				dos.close();
			} // end if

		} // end finally

	}// SimpleMsgSever

	public static void main(String[] args) {
		try {
			new SimpleMsgSever();
		} catch (BindException be) {
			System.err.println("서버가 이미 실행중입니다."); // port가 열려 있는 경우
			be.printStackTrace();
		} catch (IOException ie) {
			System.err.println("통신에 문제가 발생했습니다.");
			ie.printStackTrace();
		} // end catch

	}// main

}// class
