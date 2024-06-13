package ch05_lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch05_di.ConnPool1;
import ch05_di.ConnPool2;
import ch05_di.ConnPool3;
import ch05_di.MyBean;
import ch05_di.MyExtension;

@Configuration
public class ConfigForLifeCycle {
	
	@Bean
	public MyExtension myExtension() {
		return new MyExtension();
	}
	
	@Bean
	public ConnPool1 connPool1() {
		return new ConnPool1();
	}
	
	@Bean
	public ConnPool2 connPool2() {
		return new ConnPool2();
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public ConnPool3 connPool3() {
		return new ConnPool3();
		
	}
	
	@Bean(initMethod = "customInit", destroyMethod = "customDestroy")
	public MyBean myBean() {
		MyBean my = new MyBean();
		my.setProperty1("값1");
		return my;
	}
}
