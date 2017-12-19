package com.qhit.lh.g4.lhm.t02.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.g4.lhm.t02.dao.BaseDao;
import com.qhit.lh.g4.lhm.t02.utils.HibernateSessionFactory;

public class BaseDaoImpl implements BaseDao {
private  Session session =HibernateSessionFactory.getSession();
private  Transaction ts=session.beginTransaction();
	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.lhm.t02.dao.BaseDao#add(java.lang.Object)
	 */
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		session.save(object);
		ts.commit();
		HibernateSessionFactory.closeSession();
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.lhm.t02.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		session.delete(object);
		ts.commit();
		HibernateSessionFactory.closeSession();
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.g4.lhm.t02.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		session.update(object);
		ts.commit();
		HibernateSessionFactory.closeSession();
	}


	@Override
	public List<Object> queryAll(String  tableName) {
		// TODO Auto-generated method stub
		List<Object> list =new ArrayList<Object>();
		list=session.createQuery(tableName).list();
		ts.commit();
		HibernateSessionFactory.closeSession();
		return list;
	}

}
