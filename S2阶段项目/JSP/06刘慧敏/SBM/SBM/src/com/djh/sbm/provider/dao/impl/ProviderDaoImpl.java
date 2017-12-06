/**
 * 
 */
package com.djh.sbm.provider.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.djh.sbm.provider.bean.Provider;
import com.djh.sbm.provider.dao.ProviderDao;
import com.djh.sbm.util.DBManager;

/**
 * @author admin
 * 2017年11月11日
 */
public class ProviderDaoImpl implements ProviderDao {
	private Connection con = null;
	private PreparedStatement ps = null;

	@Override
	public List<Provider> getProvider() {
		List<Provider> list = new ArrayList<>();
		Provider provider = null;
		con = DBManager.getConnection();
		String sql = "select * from tb_provider";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				provider = new Provider(
						rs.getInt("providerId"), 
						rs.getString("providerName"), 
						rs.getString("providerDetail"), 
						rs.getString("contact"), 
						rs.getString("telephone"), 
						rs.getString("facsimile"), 
						rs.getString("address"));
				list.add(provider);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int addprovider(Provider provider){
		con = DBManager.getConnection();
		String sql = "insert into tb_provider values (?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,provider.getProviderName());
			ps.setString(2,provider.getProviderDetail());
			ps.setString(3,provider.getContact());
			ps.setString(4,provider.getTelephone());
			ps.setString(5,provider.getFacsimile());
			ps.setString(6,provider.getAddress());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
