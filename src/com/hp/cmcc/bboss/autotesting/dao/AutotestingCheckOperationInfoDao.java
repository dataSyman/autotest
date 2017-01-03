package com.hp.cmcc.bboss.autotesting.dao;

import java.sql.ResultSet;

public abstract interface AutotestingCheckOperationInfoDao {
    /**
     * 
     * @param sql
     * @param params
     * @return
     */
	public abstract ResultSet getCheckInfIds(String sql, Object[] params);
}
