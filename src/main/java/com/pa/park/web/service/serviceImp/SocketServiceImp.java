package com.pa.park.web.service.serviceImp; 


import java.net.Socket;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.pa.park.core.socket.Server;
import com.pa.park.web.service.SocketService;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2017年2月26日 下午7:32:17 
 * 类说明 
 */
@Service
public class SocketServiceImp  implements SocketService{
	public static Socket controller=null;//总控socket
	
     @PostConstruct//初始化之前调用
	 public void init() {
		System.out.println("进入impl中的init");
		Server socketDemo=new Server();
		socketDemo.start();
	//	this.socket=socketDemo.getSocket();
		
	}
	
 
}
 