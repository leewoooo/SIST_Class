package com.goodfile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class SpringConfig {
	
	//파일 업로드를 하기위해 필요한 객체를 config파일로 Bean등록
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

}
