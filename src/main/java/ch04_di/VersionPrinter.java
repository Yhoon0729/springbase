package ch04_di;

import org.springframework.stereotype.Component;

@Component("versionPrinter")
public class VersionPrinter {
	// 기본형 타입임으로 AutoWired 필요 없음
	private int majorVersion;
	private int minorVersion;
	
	public void print() {
		System.out.printf("이 프로그램의 버전은 %d.%d입니다.\n\n", majorVersion, minorVersion);
	}
	
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}
}
