package ch04_scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import ch04_di.MemberDao;
import ch04_di.MemberOracleDao;

@Configuration
@ComponentScan(basePackages = {"ch04_di", "ch04_di2"}
	, excludeFilters = 
		{@Filter(type = FilterType.ANNOTATION, classes = NoProduct.class)}
)
public class App02CtxForList {
	
	@Bean
	public MemberDao memberDao() {
		MemberDao memberDao = new MemberOracleDao();
		System.out.println("explicit : " + memberDao);
		return memberDao;
	}
}
