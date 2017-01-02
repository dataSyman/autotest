package com.hp.cmcc.bboss.autotesting.dao.impl;

import java.sql.ResultSet;

import com.hp.cmcc.bboss.autotesting.dao.AutotestingCaseDao;
import com.hp.cmcc.bboss.autotesting.dbService.OracleService;

public class AutotestingCaseDaoImpl implements AutotestingCaseDao {

	public ResultSet queryByNeed(String sql, Object[] params) {
		ResultSet resultSet = new OracleService().executeQueryRS(sql, params);
		return resultSet;
	}

	public int executeUpdate(String sql, Object[] params) {
		int affectedLine = new OracleService().executeUpdate(sql, params);
		return affectedLine;
	};
	
	public String getOrderId(String sql, Object[] params){
		return null;
	}

}
