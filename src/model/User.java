package model;

public class User {
	private Integer id;
	private String email;
	private String name;
	private String passWord;
	private String phone;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User() {
		super();
	}
	public User(Integer id, String email, String name, String passWord, String phone) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.passWord = passWord;
		this.phone = phone;
	}
	

}
