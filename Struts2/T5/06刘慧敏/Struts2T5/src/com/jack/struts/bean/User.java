package com.jack.struts.bean;

public class User {
private int uid;	
private String name;
private String password;
private String birthday;
private int  sex;
private String isable;


public User(int uid, String name, String password, String birthday, int sex,
		String isable) {
	super();
	this.uid = uid;
	this.name = name;
	this.password = password;
	this.birthday = birthday;
	this.sex = sex;
	this.isable = isable;
}
public User(String name, String password, String birthday, int sex,
		String isable) {
	super();
	this.name = name;
	this.password = password;
	this.birthday = birthday;
	this.sex = sex;
	this.isable = isable;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}

public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
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
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public int getSex() {
	return sex;
}
public void setSex(int sex) {
	this.sex = sex;
}
public String getIsable() {
	return isable;
}
public void setIsable(String isable) {
	this.isable = isable;
}

}
