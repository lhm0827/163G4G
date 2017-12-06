package com.djh.sbm.user.service.impl;

import com.djh.sbm.user.bean.User;
import com.djh.sbm.user.dao.impl.UserDaoImpl;
import com.djh.sbm.user.service.UserService;

public class UserServiceImpl implements UserService {
		
	public User dologin(String userName,String userPassword){
		return new UserDaoImpl().dologin(userName, userPassword);
		
	}

	@Override
	public User doRepswd(User user , String newpswd) {
		return new UserDaoImpl().doRepswd(user, newpswd);
	}
	
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}
	
	public User doselectUser(String userName){
		return new UserDaoImpl().doselectUser(userName);
	}
}
