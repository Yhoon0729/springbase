package ch05_di;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// BeanPostProcessor 인터페이스이지만 추상 메소드가 없다
public class MyExtension implements BeanPostProcessor{
	public MyExtension() {
		System.out.println("MyExtension");
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization==>" + beanName);
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("\npostProcessBeforeInitialization==>" + beanName);
		return bean;
	}
}
