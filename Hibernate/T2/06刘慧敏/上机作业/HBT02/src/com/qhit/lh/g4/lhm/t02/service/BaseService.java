/**
 * 
 */
package com.qhit.lh.g4.lhm.t02.service;

import java.util.List;

/**
 * @author  刘慧敏
 *2017年12月12日
 */
public interface BaseService {

	public void add(Object object);
	public void delete(Object object);
	public void update(Object object);
	public List<Object> queryAll(String  fromStr);

}
