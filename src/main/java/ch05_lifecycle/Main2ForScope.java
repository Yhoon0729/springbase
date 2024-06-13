package ch05_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch05_di.WorkScheduler;

public class Main2ForScope {
	public static void main(String[] args) {
		useXml();
		useJava();
	}
	
	private static void useXml() {
		System.out.println("==== XML Meta ====");
		String configLocation = "classpath:ch05_lifecycle/config-for-scope.xml";
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext(configLocation);
		WorkScheduler scheduler = ctx.getBean(WorkScheduler.class);
		scheduler.makeAndRunWork();
		ctx.close();
	}
	
	private static void useJava() {
		System.out.println("\n==== Java Meta ====");
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(ConfigForScope.class);
		WorkScheduler scheduler = ctx.getBean(WorkScheduler.class);
		scheduler.makeAndRunWork();
		ctx.close();
	}
}
