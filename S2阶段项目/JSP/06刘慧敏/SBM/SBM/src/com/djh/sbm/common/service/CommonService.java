/**
 * 
 */
package com.djh.sbm.common.service;

import java.util.List;

/**
 * @author admin
 * 2017年11月14日
 * 公共的业务
 */
public interface CommonService {
	
	/**
	 * @param tableName
	 * @return
	 * 先获取总页数
	 */
	public int getCount(String tableName,List<String> wheres,List<String> values);
}
