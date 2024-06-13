package ch04_scan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch04_di.MemberDao;
import ch04_di.MemberOracleDao;
import ch04_di.MemberPrinter;
import ch04_di.MemberSummaryPrinter;
import ch04_di.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"ch04_di"})
public class App01CtxWithExplicit {

	@Bean
	public MemberDao memberDao() {
		MemberDao memberDao = new MemberOracleDao();
		System.out.println("explicit : " + memberDao);
		return memberDao;
	}
	
	@Bean
	@Qualifier("printer")
	// method name이 id
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMajorVersion(0);
		return versionPrinter;
	}
}
