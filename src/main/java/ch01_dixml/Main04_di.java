package ch01_dixml;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch01_di.MessageBean;

public class Main04_di {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:ch01_dixml/container04.xml");
		
		MessageBean mb = ctx.getBean("messageBean", MessageBean.class);
		mb.sayHello("자바");
	}
}
