package com.hp.cmcc.bboss.autotesting.test;

import com.hp.cmcc.bboss.autotesting.dao.impl.AutotestingCheckgroupDaoImpl;


public class DbTest {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//step1:依据log_info_repost status更新autotesting_case表check_status 
//		logInfoDaoImpl li = new logInfoDaoImpl();
//		List list = li.findByNeed();
//		Iterator iterator = list.iterator();
//		String params[]=new String[1];
//		String sql = "update autotesting_case set check_status=1 where xml_file_id=?";
//		while (iterator.hasNext())
//	    {
//	      log_info_repost l = (log_info_repost)iterator.next();
//	      String ecgroupid= new AutotestingCheckgroupDaoImpl().getEcgroupId(XMLParser.readStringXml(logInfoDaoImpl.ClobToString(l.getXml_content()),"ProductID"));
//	      params[0]=l.getId().toString();
//	      new AutotestingCaseDaoImpl().executeUpdate(sql, params);
//	      System.out.println("ProductID========"+ XMLParser.readStringXml(logInfoDaoImpl.ClobToString(l.getXml_content()),"OperationSubTypeID"));
	      
//	      String  obj[]=XMLParser.readStringXml(logInfoDaoImpl.ClobToString(l.getXml_content()),"OperationSubTypeID");
//	      
//	      System.out.println("===="+ obj[0]+":" + obj[1]);
//	    }
		
//setp2:依据autotesting_case表check_status状态向autotesting_checkgroup表插入测试数据
//		int i = new AutotestingCheckgroupDaoImpl().executeBatch();
		
		
		new AutotestingCheckgroupDaoImpl().executeBatch();
		
		
	}

}
