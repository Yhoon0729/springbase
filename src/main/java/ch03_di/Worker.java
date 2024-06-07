package ch03_di;

import org.springframework.stereotype.Component;

@Component
public class Worker {
	public void work(WorkUnit unit) {
		System.out.println(this + ":work" + unit);
	}
}
