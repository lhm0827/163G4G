package com.djh.sbm.common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.djh.sbm.user.bean.User;

public class ExitListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("创建会话");
	}

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("结束会话");
		HttpSession session = arg0.getSession();
		ServletContext application = session.getServletContext();
		User user = (User) session.getAttribute("user");
		List<User> users = (List<User>) application.getAttribute("online");
		application.setAttribute("online", users);
	}

}
