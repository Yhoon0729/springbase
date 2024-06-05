package ch02_container;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch02_di.Executor;
import ch02_di.WorkUnit;

public class Main01_xml {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:ch02_container/Container01.xml");
		System.out.println("====================");
		Executor exec = ctx.getBean("executor", Executor.class);
		exec.addUnit(new WorkUnit());
		exec.addUnit(new WorkUnit());
	} // end of main
}
