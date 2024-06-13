package ch03_scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch03_di.Executor;
import ch03_di.HomeController;
import ch03_di.InfraredRaySensor;
import ch03_di.WorkUnit;

public class MainCompScan {
	public static void main(String[] args) {
		String[] config = {"ch03_scan/ContainerScan.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		
		System.out.println("====================");
		Executor exec = ctx.getBean("executor", Executor.class);
		exec.addUnit(new WorkUnit());
		exec.addUnit(new WorkUnit());
		
		HomeController home = ctx.getBean(HomeController.class);
		System.out.println("\n======== homeController setting");
		home.checkSensorAndAlarm();
		home.showCameraImage();
		
		InfraredRaySensor windowSensor = 
				ctx.getBean("windowSensor", InfraredRaySensor.class);
		windowSensor.foundObject();
		
		InfraredRaySensor doorSensor = 
				ctx.getBean("doorSensor", InfraredRaySensor.class);
		doorSensor.foundObject();
		home.checkSensorAndAlarm();
	}
}
