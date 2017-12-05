package com.hsj.t03.action;

import com.hsj.t03.bean.User;
import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
    private User user;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return Action.SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LoginAction(User user) {
		super();
		this.user = user;
	}
	public LoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

}
