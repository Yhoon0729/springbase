package ch02_container;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import ch02_di.AlarmDevice;
import ch02_di.Camera;
import ch02_di.DisplayMode;
import ch02_di.Executor;
import ch02_di.HomeController;
import ch02_di.InfraredRaySensor;
import ch02_di.MonitorViewer;
import ch02_di.SnsAlarmDevice;
import ch02_di.Viewer;
import ch02_di.Worker;

@Configuration // container 의미
public class ContainerAnno {
	
	@Bean
	public Executor executor() {
		Executor exec = new Executor();
		exec.setWorker(worker());
		return exec;
	}
	
	@Bean
	@Scope(value="prototype", proxyMode = ScopedProxyMode.TARGET_CLASS) // 일회용 객체로 생성
	public Worker worker() {
		return new Worker();
	}
	
	@Bean
	public AlarmDevice alarmDevice() {
		return new SnsAlarmDevice();
	}
	
	@Bean
	public Viewer viewer() {
		MonitorViewer viewer = new MonitorViewer();
		viewer.setDisplayMode(displayMode());
		return viewer;
	}
	
	@Bean 
	public DisplayMode displayMode() {
		DisplayMode mode = new DisplayMode();
		mode.setType("GRID");
		return mode;
	}
	
	@Bean
	public InfraredRaySensor windowSensor() {
		return new InfraredRaySensor("창센서");
	}
	
	@Bean
	public InfraredRaySensor doorSensor() {
		return new InfraredRaySensor("현관센서");
	}
	
	@Bean
	public Camera camera1() {
		Camera c = new Camera();
		c.setNumber(1);
		return c;
	}
	
	@Bean
	public Camera camera2() {
		Camera c = new Camera();
		c.setNumber(2);
		return c;
	}
	
	@Bean
	public Camera camera3() {
		Camera c = new Camera();
		c.setNumber(3);
		return c;
	}
	
	@Bean
	public Camera camera4() {
		Camera c = new Camera();
		c.setNumber(4);
		return c;
	}
	
	@Bean(initMethod = "init") // 객체 생성 후에 HomeController 객체의 init 메서드를 호출
	public HomeController homeController() {
		HomeController h = new HomeController();
		h.setAlarmDevice(alarmDevice());
		h.setViewer(viewer());
		h.setCamera1(camera1());
		h.setCamera2(camera2());
		h.setCamera3(camera3());
		h.setCamera4(camera4());
		
		List<InfraredRaySensor> li = new ArrayList();
		li.add(windowSensor());
		li.add(doorSensor());
		h.setSensors(li);
		
		return h;
	}	
	
}
