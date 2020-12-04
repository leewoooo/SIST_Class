package day1204.testserver;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 자신의 임의의 port를 열고 Server에 접속하는 일.
 * 
 * @author owner
 */
public class TestClient {

	public TestClient() throws UnknownHostException, IOException {
		// 1. Socket 생성 (전체적 흐름 순번은 2)
		Socket client = new Socket("211.238.142.31", 65000);
		System.out.println("클라이언트 생성: 서버에 접속 시도.");
		//socket을 닫는다.
		client.close();
	}// TestClient

	public static void main(String[] args) {
		try {
			new TestClient();
		} catch (UnknownHostException ue) {
			ue.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}// main

}// class
