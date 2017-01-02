package com.hp.cmcc.bboss.autotesting.dao;

import java.sql.ResultSet;

public abstract interface AutotestingCaseDao {

	public abstract ResultSet queryByNeed(String sql, Object[] params);

	public abstract int executeUpdate(String sql, Object[] params);

	public abstract String getOrderId(String sql, Object[] params);
	
}
