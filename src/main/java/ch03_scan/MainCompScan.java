package ch03_scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCompScan {
	public static void main(String[] args) {
		String[] config = {"ch03_scan/containerScan.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
	}
}
