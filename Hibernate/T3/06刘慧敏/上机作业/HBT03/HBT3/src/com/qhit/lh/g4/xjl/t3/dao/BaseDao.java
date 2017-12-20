/**
 * 
 */
package com.qhit.lh.g4.xjl.t3.dao;

import java.util.List;



/**
 * @author 许金来
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
