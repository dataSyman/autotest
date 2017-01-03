package com.hp.cmcc.bboss.autotesting.dao;

import java.util.List;

public abstract interface AutotestingChecktableDao {
	/**
	 * 获取检查表
	 * @param sql
	 * @param params
	 * @return
	 */
	public abstract List<Object> getCheckTable(String sql, Object[] params);

}
