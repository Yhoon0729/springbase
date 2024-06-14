package ch08_aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = {"ch08_aop"})
public class ContainerAnnoAop {
	@Bean
	public MemberService memberService1() {
		return new MemberServiceImpl();
	}
	
	@Bean
	public MemberService memberService2() {
		return new MemberServiceImpl();
	}
}
