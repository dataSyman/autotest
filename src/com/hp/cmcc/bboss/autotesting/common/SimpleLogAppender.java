package com.hp.cmcc.bboss.autotesting.common;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**   
*    
* @author    
* @version    
*    
*/

public class SimpleLogAppender extends DailyRollingFileAppender
{
  
 @Override
 public boolean isAsSevereAsThreshold(Priority priority)
 {
	 return this.getThreshold().equals(priority);
 }

}
