package ch06_aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main_aop06 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:ch06_aop/aop06.xml");
		
		WriteImpl write = ctx.getBean(WriteImpl.class);
		write.write();
		
		ReadImpl read = ctx.getBean(ReadImpl.class);
		read.read();
	}
}
