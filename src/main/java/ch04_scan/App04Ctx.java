package ch04_scan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch04_di.MemberPrinter;
import ch04_di.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"ch04_di"})
public class App04Ctx {
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		// 기본형 타입 (int)임으로 AutoWired 안 하고 container에서 명시
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
