package com.hp.cmcc.bboss.autotesting.dao.impl;

import java.util.List;

import com.hp.cmcc.bboss.autotesting.dao.AutotestingChecktableDao;
import com.hp.cmcc.bboss.autotesting.dbService.OracleService;

public class AutotestingChecktableDaoImpl implements AutotestingChecktableDao{
	
	public List<Object> getCheckTable(String sql, Object[] params){
		List<Object> list = new OracleService().excuteQuery(sql, params);
		return list;
	}

}
