package com.jack.struts.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jack.struts.bean.User;
import com.jack.struts.dao.UserDao;
import com.jack.struts.utils.DBManager;

public class UserDaoImpl implements UserDao {
private Connection con =null;
private  PreparedStatement ps=null;
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		
		try {
			con=DBManager.getConnection();
			String sql ="insert into tb_user values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getBirthday());
			ps.setInt(4, user.getSex());
			ps.setString(5, user.getIsable());
			System.out.println(sql);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		return 0;
	}
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			con=DBManager.getConnection();
			String sql ="update  tb_user set name=?,password=?,birthday=?,sex=?,isable=? where uid=?;";
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getBirthday());
			ps.setInt(4, user.getSex());
			ps.setString(5, user.getIsable());
			ps.setInt(6, user.getUid());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		return 0;
	}
	@Override
	public int deleteUser(int uid) {
		// TODO Auto-generated method stub
		try {
			con=DBManager.getConnection();
			String sql ="delete from tb_user where uid =?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, uid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		
		return 0;
	}
	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		List<User> list =new ArrayList<User>();
		User user =null;
		try {
			con=DBManager.getConnection();
			String sql ="select * from tb_user ";
			ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				user= new User(
						rs.getInt("uid"), 
						rs.getString("name"), 
						rs.getString("password"), 
						rs.getString("birthday"), 
						rs.getInt("sex"), 
						rs.getString("isable"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		
		return null;
	}
	@Override
	public User querySingleUser(int uid) {
		// TODO Auto-generated method stub
		User user =null;
		try {
			con=DBManager.getConnection();
			String sql ="select * from tb_user where uid =?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				user= new User(
						rs.getInt("uid"), 
						rs.getString("name"), 
						rs.getString("password"), 
						rs.getString("birthday"), 
						rs.getInt("sex"), 
						rs.getString("isable"));
				
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		
		return null;
	}

}
