package ch03_di;

import org.springframework.stereotype.Component;

@Component
public class SnsAlarmDevice implements AlarmDevice{

	@Override
	public void alarm(String name) {
		System.out.println(name + "에서 침입 감지됨. 신고 요망");
	}

}
