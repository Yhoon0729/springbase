package ch05_lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ch05_di.Work;
import ch05_di.Work.WorkType;
import ch05_di.WorkRunner;
import ch05_di.WorkScheduler;

@Configuration
public class ConfigForScope {
	
	@Bean
	@Scope("prototype")
	public Work workProto() {
		Work work = new Work();
		work.setTimeout(2000);
		work.setType(WorkType.SINGLE);
		return work;
	}
	
	@Bean
	public WorkRunner workRunner() {
		return new WorkRunner();
	}
	
	@Bean
	public WorkScheduler workScheduler() {
		WorkScheduler ws = new WorkScheduler();
		ws.setWorkRunner(workRunner());
		return ws;
	}
}
