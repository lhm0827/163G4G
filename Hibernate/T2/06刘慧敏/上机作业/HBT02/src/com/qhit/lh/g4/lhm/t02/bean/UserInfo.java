/**
 * 
 */
package com.qhit.lh.g4.lhm.t02.bean;

/**
 * @author 刘慧敏
 *2017年12月12日
 */
public class UserInfo {
	private int userId;
	private String username;
	private String userpwd;
	
	private Emp emp;
	/**
	 * @param userId
	 * @param username
	 * @param userpwd
	 */
	public UserInfo(int userId, String username, String userpwd) {
		super();
		this.userId = userId;
		this.username = username;
		this.userpwd = userpwd;
	}
	/**
	 * 
	 */
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the userpwd
	 */
	public String getUserpwd() {
		return userpwd;
	}
	/**
	 * @param userpwd the userpwd to set
	 */
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	/**
	 * @return the emp
	 */
	public Emp getEmp() {
		return emp;
	}
	/**
	 * @param emp the emp to set
	 */
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	
}
