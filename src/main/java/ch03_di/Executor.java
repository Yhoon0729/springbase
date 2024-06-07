package ch03_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Executor {
	Worker worker;
	
	@Autowired
	public void setWorker(Worker worker) {
		System.out.println("setWorker");
		this.worker = worker;
	} // end of setWorker()
	
	public void addUnit(WorkUnit workUnit) {
		worker.work(workUnit);
	}
}
