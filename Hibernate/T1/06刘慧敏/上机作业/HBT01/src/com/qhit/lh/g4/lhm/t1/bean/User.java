package com.qhit.lh.g4.lhm.t1.bean;

public class User {
private int id;
private String uname;
private String upwd;


public User(int id, String uname, String upwd) {
	super();
	this.id = id;
	this.uname = uname;
	this.upwd = upwd;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
@Override
public String toString() {
	return "User [id=" + id + ", uname=" + uname + ", upwd=" + upwd + "]";
}




}
