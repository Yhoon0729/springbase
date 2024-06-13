package ch03_scan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ch03_di.Camera;
import ch03_di.DisplayMode;
import ch03_di.InfraredRaySensor;


@Configuration // container 의미
// 기본형 말고는 이 곳에 정리
@ComponentScan(basePackages = {"ch03_di"})
public class ContainerAnnoScan {

	// 값이 떨어지는거(기본형)은 bean 으로 만들겠다
	@Bean 
	public DisplayMode displayMode() {
		DisplayMode mode = new DisplayMode();
		mode.setType("GRID");
		return mode;
	}
	
	@Bean
	@Qualifier("intrusionDetection")
	public InfraredRaySensor windowSensor() {
		return new InfraredRaySensor("창센서");
	}
	
	@Bean
	@Qualifier("intrusionDetection")
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
	
	
}
