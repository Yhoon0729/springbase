package ch02_di;

public class InfraredRaySensor {
	String name;
	boolean objectFounded; // default false
	
	public InfraredRaySensor(String name) {
		this.name = name;
	}
	public void foundObject() {
		this.objectFounded = true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isObjectFounded() {
		return objectFounded;
	}
	public void setObjectFounded(boolean objectFounded) {
		this.objectFounded = objectFounded;
	}
	
	@Override
	public String toString() {
		return "InfraredRaySensor [name=" + name + ", objectFounded=" + objectFounded + "]";
	}
}
