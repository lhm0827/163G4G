/**
 * 
 */
package com.qhit.lh.g4.xjl.t4.bean;

/**
 * @author 许金来
 *2017年12月13日下午3:06:08
 * 账户表
 * 添加一对一关系映射
 */
public class UserInfo {

	private int userId;
	private String userName;
	private String pasword;
	
	private Emp emp;

	/**
	 * @param userId
	 * @param userName
	 * @param pasword
	 * @param emp
	 */
	public UserInfo(int userId, String userName, String pasword, Emp emp) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pasword = pasword;
		this.emp = emp;
	}

	/**
	 * @param userId
	 * @param userName
	 * @param pasword
	 */
	public UserInfo(int userId, String userName, String pasword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pasword = pasword;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getUserId() {
		return userId;
	}

	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public String getUserName() {
		return userName;
	}

	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getPasword() {
		return pasword;
	}

	
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	
	public Emp getEmp() {
		return emp;
	}

	
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	
}
