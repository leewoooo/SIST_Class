package com.sist.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		MemberService memberService = (MemberService)context.getBean("memberService");
		memberService.update("백엔드 개발자");
	}

}
