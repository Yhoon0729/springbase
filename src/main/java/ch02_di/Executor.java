package ch02_di;

public class Executor {
	Worker worker;
	
	public void setWorker(Worker worker) {
		System.out.println("setWorker");
		this.worker = worker;
	} // end of setWorker()
	
	public void addUnit(WorkUnit workUnit) {
		worker.work(workUnit);
	}
}
