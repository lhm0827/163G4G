/**
 * 
 */
package com.djh.sbm.common.dao;

import java.util.List;

/**
 * @author admin
 * 2017年11月14日
 */
public interface CommonDao {

	/**
	 * @param tableName
	 * @return
	 * 先获取总页数
	 */
	public int getCount(String tableName,List<String> wheres,List<String> values);
}
