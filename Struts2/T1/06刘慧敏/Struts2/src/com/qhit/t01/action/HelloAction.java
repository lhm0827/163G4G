package com.qhit.t01.action;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	 private String uname;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return Action.SUCCESS;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}

}
