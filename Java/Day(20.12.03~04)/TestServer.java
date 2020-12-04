package day1204.testserver;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1. port를 열고 접속자가 들어오기를 대기하는 일을 한다. <br>
 * 2. 접속자 소켓이 들어오면 허가하여 접속자 소켓을 받는 일을 한다.(전체적 흐름 순번은 3)
 * 
 * @author owner
 */
public class TestServer {

	public TestServer() throws IOException, BindException {

		// 1. ServerSocket 생성 : port가 열림
		ServerSocket server = new ServerSocket(65000);
		System.out.println("접속자가 들어올 수 있도록 port를 열었습니다.");

		// 2. Client Socket이 들어오면 Client Socket을 받는다.
		Socket client = server.accept();
		System.out.println("접속자가 들어왔습니다." + client);
		// 3. server를 닫는다.
		server.close();
	}// TestServer

	public static void main(String[] args) {

		try {
			new TestServer();
		} catch (BindException be) {
			System.err.println("포트가 이미 사용중 입니다.");
		} catch (IOException ie) {
			ie.printStackTrace();
		} // end catch

	}// main

}// class
