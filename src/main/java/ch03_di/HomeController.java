package ch03_di;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeController {
	@Autowired
	AlarmDevice alarmDevice;
	
	@Autowired
	Viewer viewer;
	
	@Resource(name="camera1")
	Camera camera1;
	@Resource(name="camera2")
	Camera camera2;
	@Resource(name="camera3")
	Camera camera3;
	@Resource(name="camera4")
	Camera camera4;
	
	List<InfraredRaySensor> li;
	
	private Recorder recorder;
	
	public void init() {
		viewer.add(camera1);
		viewer.add(camera2);
		viewer.add(camera3);
		viewer.add(camera4);
		System.out.println("redorder:" + recorder);
	}
	
	public void checkSensorAndAlarm() {
		for(InfraredRaySensor s : li) {
			// System.out.println(s);
			if(s.isObjectFounded()) {
				alarmDevice.alarm(s.getName());
			}
		}
	}
	
	public void showCameraImage() {
		viewer.draw();
	}
	
	public void setAlarmDevice(AlarmDevice alarmDevice) {
		this.alarmDevice = alarmDevice;
	}
	
	public void setViewer(Viewer viewer) {
		this.viewer = viewer;
	}
	
	public void setCamera1(Camera camera1) {
		this.camera1 = camera1;
	}
	
	public void setCamera2(Camera camera2) {
		this.camera2 = camera2;
	}
	
	public void setCamera3(Camera camera3) {
		this.camera3 = camera3;
	}
	
	public void setCamera4(Camera camera4) {
		this.camera4 = camera4;
	}
	
	
	public void setSensors(List<InfraredRaySensor> li) {
		this.li = li;
	}
}
