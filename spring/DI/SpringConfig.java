package com.sist.exam03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean
	public UpdateInfo info() {
		return new UpdateInfo("ÀÌ¿ì±æ");
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(info());
	}
}
