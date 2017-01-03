package com.hp.cmcc.bboss.autotesting.dao.impl;

import java.sql.ResultSet;

import com.hp.cmcc.bboss.autotesting.dao.AutotestingCheckOperationInfoDao;
import com.hp.cmcc.bboss.autotesting.dbService.OracleService;

public class AutotestingCheckOperationInfoDaoImpl implements AutotestingCheckOperationInfoDao{

	public ResultSet getCheckInfIds(String sql, Object[] params){
		ResultSet resultSet = new OracleService().executeQueryRS(sql, params);
		return resultSet;
	}
}
