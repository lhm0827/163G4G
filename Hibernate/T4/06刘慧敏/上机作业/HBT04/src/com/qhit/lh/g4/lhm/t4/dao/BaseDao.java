/**
 * 
 */
package com.qhit.lh.g4.lhm.t4.dao;

import java.util.List;



/**
 * @author 刘慧敏
 *2017-12-13下午4:07:48
 * TODO
 */
public interface BaseDao {

	
	public void add(Object obj);
	public void delete(Object obj);
	public void update(Object obj);
	public List<Object> queryAll(String  tableName);
	
	public Object getObjectById(Class clazz, int id);
	
}
