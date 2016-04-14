package it.ads.activitiesmanager.service.common;

public class UserStruct {
	private Integer id;
	private String login;
	private String password;
	private String name;
	private String address;
	private String birthday;
	private String city;
/*
	public UserStruct(String l, String p, String n, String a, String b, String c) {
		setLogin(l);
		setPassword(p);  
		setName(n);
		setAddress(a);
		setBirthday(b);
		setCity(c);
	}
	*/
	public UserStruct() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}