package com.hp.cmcc.bboss.autotesting.common;

//this is a simple logger based on java.util.logging

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;




/**   
*    
* @author  
* @version    
*    
*/
public class SimpleLogger
{
	
	/**
	 * 
	 * @param message
	 */
	@Deprecated
    public static void logInfo(String message)
    {
    	PropertyConfigurator.configure("logConfig.properties");
    	Log log=LogFactory.getLog(SimpleLogger.class);
		try 
		{
		    log.info(message);
		} 
		catch(Exception e) 
		{

		}	
    }
	
	/**
	 *     
	 * @param classTypeInstance
	 * @param message
	 */
    public static void logInfo(Class classTypeInstance,String message)
    {
    	PropertyConfigurator.configure("logConfig.properties");
    	Log log=LogFactory.getLog(classTypeInstance);
		try 
		{
		    log.info(message);
		} 
		catch(Exception e) 
		{

		}	
    }
    
    /**
     * 
     * @param message
     */
    @Deprecated
    public static void  logError(String message)
    {
    	PropertyConfigurator.configure("logConfig.properties");
    	Log log=LogFactory.getLog(SimpleLogger.class);
		try 
		{
		    log.error(message);
		} 
		catch(Exception e) 
		{

		}	
    	
    }
    
    /**
     * 
     * @param classTypeInstance
     * @param message
     */
   public static void  logError(Class classTypeInstance,String message)
   {
   	PropertyConfigurator.configure("logConfig.properties");
   	Log log=LogFactory.getLog(classTypeInstance);
		try 
		{
		    log.error(message);
		} 
		catch(Exception e) 
		{

		}	
   	
   }
   
   /**
    * 
    * @param classTypeInstance
    * @param exception
    */
   public static void  logError(Class classTypeInstance,Exception exception)
   {
   	PropertyConfigurator.configure("logConfig.properties");
   	Log log=LogFactory.getLog(classTypeInstance);
		try 
		{
		    log.error(getMessage(exception));
		} 
		catch(Exception e) 
		{

		}	
   	
   }
    
    /**
     * 
     * @param exception
     */
   @Deprecated 
   public static void  logError(Exception exception)
    {
    	logError(getMessage(exception));
    }
    
     
    /**
     * 
     * @param exception
     * @return
     */
    private static String getMessage(Exception exception)
    {
        String result="";
        if(exception.getMessage()!="")
        {
        	result=result+"MESSSAGE: "+exception.getMessage();
        }
        
        if(exception.getCause()!=null)
        {
        	result=result+"CAUSE: "+exception.getCause().getMessage();
        }
        
        if(exception.getStackTrace().length>0)
        {
           result=result+"STACKTRACE: ";
           for(StackTraceElement item : exception.getStackTrace() )
           {
             result=result+item.toString();
           }
        }
        return result;
    }
}
