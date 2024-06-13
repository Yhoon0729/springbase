package ch05_di;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ConnPool1 implements InitializingBean, DisposableBean{

	// DisposableBean
	@Override
	public void destroy() throws Exception {
		System.out.println("ConnPool1.destroy()");
	}

	// InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("ConnPool1.afterPropertiesSet()");
	}

}
