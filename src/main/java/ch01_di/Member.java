package ch01_di;

import java.util.Date;

public class Member {
	private Long id;
	private String email;
	private String name;
	private String password;
	private Date registerDate;
	
	
	
	public Member(String email, String name, String password, Date registerDate) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.registerDate = registerDate;
	}
	
	public void changePassword(String oldPw, String newPw) {
		if (!password.equals(oldPw)) {
			throw new IdPasswordNotMatchException();
		}
		password = newPw;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", registerDate="
				+ registerDate + "]";
	}
}
