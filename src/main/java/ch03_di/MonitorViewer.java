package ch03_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonitorViewer implements Viewer{
	
	DisplayMode displayMode;
	
	@Autowired
	public void setDisplayMode(DisplayMode displayMode) {
		this.displayMode = displayMode;
	}

	@Override
	public void add(Camera camera) {
		System.out.println("모니터에" + camera + "영상 추가");
	}

	@Override
	public void draw() {
		System.out.println(displayMode.getType() + " 모드로 카메라 이미지 출력됨");
	}
	
}
