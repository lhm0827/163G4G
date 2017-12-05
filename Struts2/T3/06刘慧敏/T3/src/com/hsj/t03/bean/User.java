package com.hsj.t03.bean;

public class User {
	private String uname;
	private String upwd;
	private String uad;
	public User(String uname, String upwd, String uad) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.uad = uad;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUad() {
		return uad;
	}
	public void setUad(String uad) {
		this.uad = uad;
	}

}
