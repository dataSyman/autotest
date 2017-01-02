package com.hp.cmcc.bboss.autotesting.xmlService;



import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.hp.cmcc.bboss.autotesting.common.SimpleLogger;

public class XMLSerializer 
{
	/**
	 * 
	 * @param targetInstance
	 * @param xmlFileName
	 */
    public static void ObjectToXML(Object targetInstance,String xmlFileName)
    {		  
    	 try
    	 {
    		 Serializer serializer = new Persister();  
    	     File file = new File(xmlFileName);  
    	     serializer.write(targetInstance, file);
    	 } 
    	 catch (Exception e1)
    	 {
    	     SimpleLogger.logError(e1);
    	 }
		
	}
    
    /// serialize a xmlstring to object
    
    /**
     * 
     * @param targetInstance
     * @param objectXmlString
     * @return
     */
    public static Object XMLToObject(Object targetInstance,String objectXmlString)
    {
    	 Object targeResult=null;
    	 try
    	 {
    		 Serializer serializer = new Persister();  
    		 targeResult=serializer.read(targetInstance.getClass(),objectXmlString);
    	 }
    	 catch (Exception ex)
    	 {
    	     SimpleLogger.logError(ex);
    	 }
    	 return targeResult;
    }
}
