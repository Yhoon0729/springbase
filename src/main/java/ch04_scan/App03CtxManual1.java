package ch04_scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch04_di.MemberDao;
import ch04_di.MemberOracleDao;
import ch04_di.MemberRegisterService;

@Configuration
public class App03CtxManual1 {

	@Bean
	public MemberDao memberDao() {
		return new MemberOracleDao();
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService();
	}
}
