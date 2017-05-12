package com.pa.park.core.util; 

import java.util.Date;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2017年4月18日 上午8:48:22 
 * 预定15min的任务 
 */
public class ReverseTask{
	private static int counter = 0;  
    protected void execute()  {  
        long ms = System.currentTimeMillis();  
        System.out.println("\t\t" + new Date(ms));  
        System.out.println("(" + counter++ + ")");  
    }  

}
 