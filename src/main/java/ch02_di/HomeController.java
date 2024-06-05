package ch02_di;

public class HomeController {
	SnsAlarmDevice alarmDevice;
	MonitorViewer viewer;
	
	public void setAlarmDevice(SnsAlarmDevice alarmDevice) {
		this.alarmDevice = alarmDevice;
	}
	
	public void setViewer(MonitorViewer viewer) {
		this.viewer = viewer;
	}
}
