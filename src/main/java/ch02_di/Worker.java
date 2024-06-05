package ch02_di;

public class Worker {
	public void work(WorkUnit unit) {
		System.out.println(this + ":work" + unit);
	}
}
