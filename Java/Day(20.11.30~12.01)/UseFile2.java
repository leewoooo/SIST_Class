package day1201.usefile;

import java.io.File;

/**
 * File의 조작
 * 
 * @author owner
 */
public class UseFile2 {

	public UseFile2() {
		
		//1. 생성할 Directory를 가진 File class를 생성한다.
		File file = new File("c:/dev/lee/leewoo");
		
		//2. 생성
		boolean flag = file.mkdir(); //하위폴더가 없는 하나의 폴더만 생성
		System.out.println(flag);
		
		boolean flag2 = file.mkdirs(); //여러 폴더를 동시에 생성가능
		System.out.println(flag2);
		
	}// UseFile

	public void mkDirectory() {

	}// mkDirectory

	public static void main(String[] args) {
		
		UseFile2 f2 = new UseFile2();
		f2.mkDirectory();
	}// main

}// class
