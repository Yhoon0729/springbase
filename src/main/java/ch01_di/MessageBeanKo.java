package ch01_di;

public class MessageBeanKo implements MessageBean{
	public void sayHello(String name) {
		System.out.println("안녕하세요, " + name + "!");
	}
}
