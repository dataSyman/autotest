package com.hp.cmcc.bboss.autotesting.dao;

import java.sql.ResultSet;
import java.util.Map;

import com.hp.cmcc.bboss.autotesting.po.autotesting_checkgroup;

public abstract interface AutotestingCheckgroupDao {
    /**
     * 批量插入
     * @return
     */
	public abstract int executeBatch();
    /**
     * 
     * @param ac
     * @param resultSet
     * @return
     */
//	public abstract autotesting_checkgroup result2bean(autotesting_checkgroup ac, Map<String, Object> hm);
	/**
	 * 获取EC_GROUP_ID
	 * @param orderId 产品订购ID
	 * @return
	 */
	public abstract String getEcgroupId(String orderId);
	/**
	 * 获取TEST_CASE_ID
	 * @param checkGroupId 输出检查编号
	 * @return
	 */
	public abstract String getTestCaseId(String checkGroupId);
}
