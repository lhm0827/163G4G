/**
 * 
 */
package com.qhit.lh.g4.lhm.t3.service;

import java.util.List;

/**
 * @author 刘慧敏
 *2017-12-13下午5:16:15
 * TODO
 */
public interface BaseService {


	public void add(Object obj);
	public void delete(Object obj);
	public void update(Object obj);
	public List<Object> queryAll(String  tableName);
	
	public Object getObjectById(Class clazz, int id);
}
