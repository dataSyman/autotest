package com.hp.cmcc.bboss.autotesting.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.sql.CLOB;

import com.hp.cmcc.bboss.autotesting.common.logInfoDao;
import com.hp.cmcc.bboss.autotesting.dbService.OracleService;
import com.hp.cmcc.bboss.autotesting.po.log_info_repost;

public class logInfoDaoImpl implements logInfoDao{
	
	public  List<log_info_repost> findByNeed(){
		String sql="select * from log_info_repost where status=1";
		OracleService service = new OracleService();
		ResultSet resultSet = null;
		List<log_info_repost> list = new ArrayList<log_info_repost>();
		
		try {
			log_info_repost loginfo;
			for (resultSet = service.executeQueryRS(sql, null); resultSet.next(); list.add(loginfo))
			  {
			    loginfo = new log_info_repost();
			    loginfo = result2bean(loginfo, resultSet);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	private log_info_repost result2bean(log_info_repost loginfo, ResultSet resultSet)
	  {
	    try
	    {
	      loginfo.setId(Long.valueOf(resultSet.getLong("id")));
	      loginfo.setSeq_no(resultSet.getString("seq_no"));
	      loginfo.setCreate_date(resultSet.getDate("create_date"));
	      loginfo.setXml_content((CLOB)resultSet.getClob("xml_content"));
	      loginfo.setXml_type(resultSet.getString("xml_type"));
	      loginfo.setError_no(Integer.valueOf(resultSet.getInt("error_no")));
	      loginfo.setLog_content(resultSet.getString("log_content"));
	      loginfo.setStatus(resultSet.getInt("status"));
	      loginfo.setUpdate_date(resultSet.getDate("update_date"));
	      return loginfo;
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }return null;
	  }
	
	public static String ClobToString(Clob clob)
	  {
	    if (clob == null)
	      return "";
	    String reString = "";
	    try
	    {
	      Reader is = clob.getCharacterStream();
	      BufferedReader br = new BufferedReader(is);
	      String s = br.readLine();
	      StringBuffer sb = new StringBuffer();
	      for (; s != null; s = br.readLine()) {
	        sb.append(s);
	      }
	      reString = sb.toString();
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	    return reString;
	  }

}
