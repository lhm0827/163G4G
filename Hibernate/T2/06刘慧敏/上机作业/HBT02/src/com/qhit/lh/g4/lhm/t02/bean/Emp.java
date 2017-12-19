/**
 * 
 */
package com.qhit.lh.g4.lhm.t02.bean;

/**
 * @author 刘慧敏
 *2017年12月12日
 */
public class Emp {
	private int eid;
	private String empName;
	private String empSex;
	private String brithday;
	private int deptid;
	
	private UserInfo userInfo;

	/**
	 * @param eid
	 * @param empName
	 * @param empSex
	 * @param brithday
	 * @param deptid
	 */
	public Emp(int eid, String empName, String empSex, String brithday,
			int deptid) {
		super();
		this.eid = eid;
		this.empName = empName;
		this.empSex = empSex;
		this.brithday = brithday;
		this.deptid = deptid;
	}

	/**
	 * 
	 */
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the eid
	 */
	public int getEid() {
		return eid;
	}

	/**
	 * @param eid the eid to set
	 */
	public void setEid(int eid) {
		this.eid = eid;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empSex
	 */
	public String getEmpSex() {
		return empSex;
	}

	/**
	 * @param empSex the empSex to set
	 */
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	/**
	 * @return the brithday
	 */
	public String getBrithday() {
		return brithday;
	}

	/**
	 * @param brithday the brithday to set
	 */
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	/**
	 * @return the deptid
	 */
	public int getDeptid() {
		return deptid;
	}

	/**
	 * @param deptid the deptid to set
	 */
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
