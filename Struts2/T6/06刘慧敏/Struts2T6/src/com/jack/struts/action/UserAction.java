package com.jack.struts.action;

import java.util.regex.Pattern;



import com.jack.struts.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport   {
	private User user;
	
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 * 重写表单验证的方法，报告错误
	 * 数据完整型：非空验证
	 * 有效数据：数据格式验证（邮箱、手机号、用户名、密码）：正则表达式
	 */
	@Override
	public void validate() {
		Pattern pattern = Pattern.compile("^[A-Za-z][A-Za-z1-9_-]+$");
		if(!pattern.matcher(user.getUname()).matches()) {
			super.addFieldError("uname.error", getText("uname.error"));
		}
		if("".equals(user.getUname())) {
			super.addFieldError("uname.empry", getText("uname.empty"));
		}
		if("".equals(user.getUpwd())) {
			super.addFieldError("upwd.empry", getText("upwd.empty"));
		}
	}

	/**
	 * @return
	 * 登录的业务处理方法
	 */
	public String toLogin() {
		
		return "tologin";
	}
	
	/**
	 * @return
	 * 登录的业务处理方法
	 */
	public String login() {
		
		return "loginSuccess";
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}