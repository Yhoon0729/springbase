package ch05_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main01ForLifecycle {
	public static void main(String[] args) {
		useXml();
		useJava();
	} // end of main()
	
	private static void useXml() {
		System.out.println("==== XML Meta ====");
		String configLocation = "classpath:ch05_lifecycle/config-for-lifecycle.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		ctx.close();
	} // end of useXml()
	
	private static void useJava() {
		System.out.println("\n==== Java Meta ====");
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(ConfigForLifeCycle.class);
		ctx.close();
	}
} // end of class Main01ForLifecycle
