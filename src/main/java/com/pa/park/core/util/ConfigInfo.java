package com.pa.park.core.util; 

import java.io.InputStream;
import java.util.Properties;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2017年2月4日 上午10:46:00 
 * 读取配置文件
 */
public class ConfigInfo{
	
	private static Properties cache = new Properties();
	 static{
	  try {
	            //cacheBundle = ResourceBundle.getBundle("");
		  InputStream in = ConfigInfo.class.getResourceAsStream("/springProperties/configInfo.properties");  
	   cache.load(in);
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	 }
	 /**
	  * 获取指定key的值
	  * @param key
	  * @return
	  */
	 public static String getValue(String key){
	  return cache.getProperty(key);
	 }
public static void main(String[] args) {
	System.out.println(ConfigInfo.getValue("p1_MerId"));
}	

}
 