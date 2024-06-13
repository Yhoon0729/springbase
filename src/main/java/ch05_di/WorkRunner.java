package ch05_di;

import org.springframework.beans.factory.BeanNameAware;

public class WorkRunner implements BeanNameAware{
	private String beanId;
	
	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName:" + name);
		this.beanId = name;
	}
	
	public void execute(Work work) {
		System.out.printf("Work[%s]:WorkRunner[%s] execute Work[%d}\n",
				work.toString(), beanId, work.getOrder());
		work.run();
	}
}
