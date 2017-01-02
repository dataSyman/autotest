package com.hp.cmcc.bboss.autotesting.xmlService;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.hp.cmcc.bboss.autotesting.common.SimpleLogger;

public class XMLParser
{
	
	private static String nodeText[]=new String[10];
	private static int i;
	
   /**
    * 
    * @param filePath
    * @param xpath
    * @param attributeName
    * @param attributValue
    * @return
    */
   public static Element getElementByID(String filePath,String xpath,String attributeName,String attributValue)
	    {
	       Element result=null;
           List<Element> elementList=getElementsByXPath(filePath, xpath);
           for(Element item : elementList)
           {        	   
              if(item.attributeValue(attributeName)!=null)
              {
            	  if( item.attributeValue(attributeName).equals(attributValue))
            	  {
            		  result=item;
                	  break;
            	  }
              }
           }
            return  result;
	    }
   
   /**
    * 
    * @param filePath
    * @param xpath
    * @return
    */
   public static List<Element> getElementsByXPath(String filePath,String xpath)
		{
		 List<Element> result=new ArrayList<Element>();
		 Document document=getDocument(filePath);
		 List<Node> nodesList= document.selectNodes(xpath);
		 Iterator<Node> it=nodesList.iterator(); 
		 
	     while(it.hasNext())
	       {  
	          Element elm=(Element)it.next();
	          result.add(elm);
	       }
	     return result;
	     
		}
	 	    
   private static Document getDocument(String filePath)
	{
		Document  document=null;
		try
		{
			SAXReader reader = new SAXReader();  
		    document = reader.read(new File(filePath));
		}
		catch(Exception ex)
		{
			SimpleLogger.logError(ex);
		}
        return document;
	}
	/**
	 * 字符串转XML 
	 * @param xmlStr
	 * @return
	 */
   public static Document str2xml(String xmlStr) {
	   Document document=null;
	   try {
		document = DocumentHelper.parseText(xmlStr);
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
	   return document;
   }
   /**
    *  XML转字符串
    * @param document
    * @return
    */
   public static String xml2str(Document document) {
	   return document.asXML();
   }
   
   public static String[] readStringXml(String xml,String nodeName) {

           Document document=null;
		try {
			document = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           Element root = document.getRootElement();

           //遍历所有的元素节点  
           try{
        	   i=0;
        	   listNodes(root,nodeName);
           }catch(StopMsgException e){
//        	   System.out.println(e.getMessage());
           }
             
       return nodeText;
   }
   
   /** 
    * 遍历当前节点元素下面的所有(元素的)子节点 
    *  
    * @param node 
    */  
   public static void listNodes(Element node,String nodeName) {  
//       System.out.println("当前节点的名称：：" + node.getName()); 
       
       if(node.getName().equals(nodeName)){
    	   
    	   nodeText[i++]=node.getTextTrim();
    	   //跳出递归
//    	   throw new StopMsgException();
    	   
       }
//       // 获取当前节点的所有属性节点  
//       List<Attribute> list = node.attributes();  
//       // 遍历属性节点  
//       for (Attribute attr : list) {  
//           System.out.println(attr.getText() + "-----" + attr.getName()  
//                   + "---" + attr.getValue());  
//       }  
// 
//       if (!(node.getTextTrim().equals(""))) {  
//           System.out.println("文本内容：：：：" + node.getText());  
//       }  
 
       // 当前节点下面子节点迭代器  
       Iterator<Element> it = node.elementIterator();  
       // 遍历  
       while (it.hasNext()) {  
           // 获取某个子节点对象  
           Element e = it.next();  
           
           // 对子节点进行遍历  
           listNodes(e,nodeName);  
       }
   } 
   /**
    * 
    * @author 
    *
    */
   static class StopMsgException extends RuntimeException{
   }
   
}
