/**
 * 
 */
package com.qhit.lh.g4.xjl.t4.bean;

/**
 * @author 许金来
 *2017年12月13日下午3:02:24
 * 员工
 * 添加一对一关系映射
 */
public class Emp {

	private int eid;
	private String empName;
	private String empSex;
	private String birthday;
	private int deptId;
	
	private UserInfo userInfo;
	
	private Dept dept;

	/**
	 * @param eid
	 * @param empName
	 * @param empSex
	 * @param birthday
	 * @param deptId
	 * @param userInfo
	 */
	public Emp(int eid, String empName, String empSex, String birthday,
			int deptId, UserInfo userInfo) {
		super();
		this.eid = eid;
		this.empName = empName;
		this.empSex = empSex;
		this.birthday = birthday;
		this.deptId = deptId;
		this.userInfo = userInfo;
	}

	/**
	 * @param eid
	 * @param empName
	 * @param empSex
	 * @param birthday
	 * @param deptId
	 */
	public Emp(int eid, String empName, String empSex, String birthday,
			int deptId) {
		super();
		this.eid = eid;
		this.empName = empName;
		this.empSex = empSex;
		this.birthday = birthday;
		this.deptId = deptId;
	}

	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpSex() {
		return empSex;
	}

	
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}


	public String getBirthday() {
		return birthday;
	}

	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	
	public int getDeptId() {
		return deptId;
	}

	
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	
	public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return empName+userInfo.getUserName()+dept.getDeptName();
	}

	/**
	 * @return the dept
	 */
	public Dept getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
