package ch05_di;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements BeanNameAware, ApplicationContextAware, 
								InitializingBean, DisposableBean{
	String value;
	
	public void customInit() {
		System.out.println("customInit()");
	}
	
	public void customDestroy() {
		System.out.println("customDestroy");
	}
	
	public void setProperty1(String value) {
		this.value = value;
	}
	
	public MyBean() {
		System.out.println("\nMyBean");
	}

	// ApplicationContextAware
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware.setApplicationContext() 실행");
	}

	// BeanNameAware
	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware.setBeanName() 실행");
	}

	// DisposableBean
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destroy() 실행");
	}

	// InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean.afterPropertiesSet() 실행");
	}
}
