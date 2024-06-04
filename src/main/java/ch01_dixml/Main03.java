package ch01_dixml;

import ch01_di.MessageBean;
import ch01_di.MessageBeanEn;
import ch01_di.MessageBeanKo;

public class Main03 {
	public static void main(String[] args) {
		MessageBean mb = new MessageBeanEn();
		mb.sayHello("java");
		
		mb = new MessageBeanKo();
		mb.sayHello("자바");
	} // end of main()
} // end of class Main03
