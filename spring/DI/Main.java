package com.sist.exam07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/sist/exam07/bookBean.xml");
		BookDAO bookDAO = (BookDAO)applicationContext.getBean("bookDAO");
		bookDAO.insertBook();
	}

}
