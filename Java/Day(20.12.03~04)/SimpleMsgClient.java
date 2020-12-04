package day1204.simplemsg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class SimpleMsgClient {

	public SimpleMsgClient() throws IOException, UnknownHostException {
		// 2. Socket 생성: 임의의 port를 열고, 지정한 ip주소의 컴퓨터로 가서 지정한 port에 연결된다.
		Socket client = null;
		DataInputStream dis = null; // Java의 Data를 받기 위한 Stream
		DataOutputStream dos = null;// 서버로 데이터를 보내기 위한 Stream
		try {
			String ip = JOptionPane.showInputDialog("ip입력 \n 37,26,22,44,33,45,21,28,31,27,39,32,34,24,38,25");
			client = new Socket("211.238.142."+ip, 55555);
			
			
			//자신컴퓨터 접속 : ip address, loopBack : localhost, 127.0.0.1
//			client = new Socket("localhost",55555);
			// 4. 서버에서 전달하는 값을 받기위해 "Stream"을 연결한다
			dis = new DataInputStream(client.getInputStream());
			
			//7. 서버에서 보내오는 msg를 읽기
			//%xx%xx%xx로 분리되어 들어온 글자를 순서대로 합친다.
			
			String revMsg = dis.readUTF(); 
//			System.out.println("서버에서 온 메세지 = " + revMsg);
			
			String sendMsg = JOptionPane.showInputDialog(revMsg);
			
			//입력받은 message를 보낼 스트림 얻기.
			dos = new DataOutputStream(client.getOutputStream());
			//메세지를 스트림에 기록
			dos.writeUTF(sendMsg);
			//스트림의 내용을 목적지(소켓)으로 분출
			dos.flush();
			
			
//			boolean flag = dis.readBoolean();
//			System.out.println(flag);
			
			//8. 연결을 끊는다.
		} finally {
			if (client != null) {
				client.close();
			} // end if
			if (dis != null) {
				dis.close();
			} // end if
			if (dos != null) {
				dos.close();
			} // end if
		} // end finally

	}// SimpleMsgClient

	public static void main(String[] args) {
		try {
			new SimpleMsgClient();
		} catch (UnknownHostException uhe) {
			System.err.println("서버를 알 수 없음");
			uhe.printStackTrace();
		} catch (IOException ie) {
			System.err.println("통신 문제발생");
			ie.printStackTrace();
		} // end catch
	}// main
}// class
