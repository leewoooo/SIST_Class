package day1201.homework1201;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HomeWork1201 {

	public HomeWork1201() {

		// 1. JOptionPane을 이용하여 경로 입력을 제공하여 값을 입력받음.
		String path = JOptionPane.showInputDialog("경로입력");

		// 2. 입력된 값이 정산적인 경로라면
		if ("c:/dev".equals(path)) {
			File file = new File(path);
			if (file.exists() && file.isDirectory()) {

				String[] fileList = file.list();
				printFileList(fileList,path);

			} // endif
		} else {
			printErrMsg();
		} // end if

	}// HomeWork1201

	public void printErrMsg() {
		JOptionPane.showMessageDialog(null, "경로를 확인해주세요");
	}// printErrMsg

	public void printFileList(String[] fileList, String path) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm");

		JTextArea jta = new JTextArea(10, 50);
		JScrollPane jsp = new JScrollPane(jta);
		jta.append("이름" + "\t" + "수정한날짜" + "\t" + "유형" + "\t" + "크기" +"\n");
		jta.append("========================================"+"\n");

		String fileName = "";
		for (int i = 0; i < fileList.length; i++) {
			File file = new File(path + "/" + fileList[i]);
			if (file.isFile()) {
//				fileName = file.getName().substring(0, file.getName().indexOf("."));
//				String fileType = file.getName().substring(file.getName().indexOf(".") + 1);
				jta.append(fileName + "\t"
						+ sdf.format(new Date(file.lastModified())) + "\t" + "파일" + "\t" + file.length() + "byte" +"\n");
			} else if(file.isDirectory()) {
				fileName = file.getName();
				jta.append(fileName + "\t"
						+ sdf.format(new Date(file.lastModified())) + "\t" + "폴더" + "\t" + file.length() + "byte"+"\n");
			} // end else
		} // end for
		
		JOptionPane.showMessageDialog(null, jsp);
		
	}// printFileList

	public static void main(String[] args) {
		new HomeWork1201();
	}// main

}// class
