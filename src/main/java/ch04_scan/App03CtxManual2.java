package ch04_scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch04_di2.MemberRegisterService;

@Configuration
public class App03CtxManual2 {
	
	@Bean
	// method명이 xml에 id임
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService();
	}
}
