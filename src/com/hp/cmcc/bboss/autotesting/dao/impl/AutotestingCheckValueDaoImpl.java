package com.hp.cmcc.bboss.autotesting.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hp.cmcc.bboss.autotesting.common.SimpleLogger;
import com.hp.cmcc.bboss.autotesting.dao.AutotestingCheckValueDao;
import com.hp.cmcc.bboss.autotesting.dbService.OracleService;
import com.hp.cmcc.bboss.autotesting.po.autotesting_checkgroup;
import com.hp.cmcc.bboss.autotesting.xmlService.XMLParser;

public class AutotestingCheckValueDaoImpl implements AutotestingCheckValueDao{
	
	public int executeBatch(){
		String sql ="insert into autotesting_checkvalue (check_value_id, check_point_id, cp_group_type, check_value) values (?,?,?,?)";
		 OracleService service = new OracleService();
		 Connection connection = service.getConnection();
		 final int batchSize = 1000;
		 int count = 0;
	     ResultSet resultSet = new AutotestingCaseDaoImpl().queryByNeed("select ac.test_case_id,li.xml_content from autotesting_case ac, log_info_repost li where ac.xml_file_id=li.id and ac.check_status=1 and ac.status=0  order by ac.test_case_id,ac.step_id", null);
		 autotesting_checkgroup ac= new autotesting_checkgroup();
		 SimpleLogger.logInfo(OracleService.class, "Start executeBatch...");
		 long startTime=System.currentTimeMillis();
				try {
					PreparedStatement ps = connection.prepareStatement(sql);
					Map<String, Object> map = new HashMap<String, Object>();
					Long test_case_id=1l;
					boolean bl = false;
					int n=1,i=0;
					while (resultSet.next()) {
					   String obj[]=XMLParser.readStringXml(logInfoDaoImpl.ClobToString(resultSet.getClob("xml_content")),"OperationSubTypeID");
					   if((i==0 || !bl) && test_case_id!=resultSet.getLong("Test_case_id")){
						   test_case_id = resultSet.getLong("Test_case_id");
						   n=1;
					   }
					  
					   for(i=1;i<obj.length && obj[i]!=null;i++){
//						   map.put("test_case_id", resultSet.getLong("Test_case_id"));
//						   map.put("step_id", n++);
//						   map.put("operation_id", obj[0]+obj[i]);
						   
//						   ac=result2bean(ac,map);
//						   ps.setLong(1, ac.getCheck_group_id());
//						   ps.setLong(2, ac.getTest_case_id());
//						   ps.setLong(3, ac.getStep_id());
//					       ps.setLong(4, ac.getOperation_id());
						   
						   ps.setLong(1, Long.valueOf(0));
						   ps.setLong(2, resultSet.getLong("test_case_id"));
						   ps.setLong(3, Long.valueOf(n++));
						   ps.setLong(4, Long.valueOf(obj[0]+obj[i]));
							ps.addBatch();
							if(++count % batchSize == 0){
				            	ps.executeBatch();
				            	ps.clearBatch();
				            }
							map.clear();
							
							if(i==obj.length-1){
								bl=true;
							}
							
					   }
						
					}
					
					 ps.executeBatch(); // insert remaining records
					 ps.close();
					 connection.close();
					 long endTime=System.currentTimeMillis();
//					 System.err.println("End"+(endTime-startTime));
					 SimpleLogger.logInfo("End"+(endTime-startTime));
					
				} catch (SQLException e) {
					SimpleLogger.logError(OracleService.class, e.getMessage());
				}
		
		
		return 0;
	}

}
