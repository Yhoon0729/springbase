package ch05_di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ConnPool2 {
	@PostConstruct
	public void initPool() {
		System.out.println("ConnPool2.initPool()");
	}
	
	@PreDestroy
	public void destroyPool() {
		System.out.println("ConnPool2.destroyPool()");
	}
}
