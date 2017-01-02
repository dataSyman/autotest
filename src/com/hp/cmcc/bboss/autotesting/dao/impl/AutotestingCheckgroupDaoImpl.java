package com.hp.cmcc.bboss.autotesting.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hp.cmcc.bboss.autotesting.common.SimpleLogger;
import com.hp.cmcc.bboss.autotesting.dao.AutotestingCheckgroupDao;
import com.hp.cmcc.bboss.autotesting.dbService.OracleService;
import com.hp.cmcc.bboss.autotesting.po.autotesting_checkgroup;
import com.hp.cmcc.bboss.autotesting.xmlService.XMLParser;

public class AutotestingCheckgroupDaoImpl implements AutotestingCheckgroupDao {
	int checkGroupId=100000000;
	int checkInfId=200000000;

	public int executeBatch() {
		 String sql ="insert into autotesting_checkgroup (CHECK_GROUP_ID, TEST_CASE_ID, STEP_ID, OPERATION_ID) values (?,?,?,?)";
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
					Long test_case_id;
					while (resultSet.next()) {
					   int n=1;
					   String obj[]=XMLParser.readStringXml(logInfoDaoImpl.ClobToString(resultSet.getClob("xml_content")),"OperationSubTypeID");
					   test_case_id = resultSet.getLong("Test_case_id");
					   for(int i=1;i<obj.length && obj[i]!=null;i++){
						   map.put("test_case_id", resultSet.getLong("Test_case_id"));
						   map.put("step_id", n++);
						   map.put("operation_id", obj[0]+obj[i]);
						   
						   ac=result2bean(ac,map);
							ps.setLong(1, ac.getCheck_group_id());
							ps.setLong(2, ac.getTest_case_id());
							ps.setLong(3, ac.getStep_id());
							ps.setLong(4, ac.getOperation_id());
							
							ps.addBatch();
							if(++count % batchSize == 0){
				            	ps.executeBatch();
				            	ps.clearBatch();
				            }
							map.clear();
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
	};
    
	public autotesting_checkgroup result2bean(autotesting_checkgroup ac,
			Map<String, Object> hm) {
//		try {
//			String  obj[]=XMLParser.readStringXml(logInfoDaoImpl.ClobToString(resultSet.getClob("xml_content")),"OperationSubTypeID");
			ac.setCheck_group_id(Long.valueOf(++checkGroupId));
			ac.setTest_case_id(Long.valueOf(hm.get("test_case_id").toString()));
			ac.setStep_id(Long.valueOf(hm.get("step_id").toString()));
			ac.setOperation_id(Long.valueOf(hm.get("operation_id").toString()));
			return ac;
//		} catch (SQLException e) {
//			SimpleLogger.logError(AutotestingCheckgroupDaoImpl.class,
//					e.getMessage());
//		}
//		return null;
	};
	
	public String getEcgroupId(String orderId){
		String sql="select * from serv_biz_code where order_id=" + orderId;
		ResultSet resultSet = new OracleService().executeQueryRS(sql, null);
		Object object = null;
		try {
			if (resultSet.next()) {
				object = resultSet.getObject("ec_group_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			SimpleLogger.logError(this.getClass(), e.getMessage());
		}
		return object.toString();
	}
	
	public String getTestCaseId(String checkGroupId){
		String sql="select * from autotesting_checkgroup where check_group_id=" + checkGroupId;
		ResultSet resultSet = new OracleService().executeQueryRS(sql, null);
		Object object = null;
		try {
			if (resultSet.next()) {
				object = resultSet.getObject("ec_group_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			SimpleLogger.logError(this.getClass(), e.getMessage());
		}
		HashMap<String,String>  hm = new HashMap<String,String>();
		return object.toString();
	}
	

}
