//package com.pa.park.web.controller; 
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//import javax.annotation.PostConstruct;
//
//import com.pa.park.core.socket.Server;
//
// 
///** 
// * @author wangpei 
// * @version 
// *创建时间：2017年2月16日 下午1:29:45 
// * 与硬件地锁通信的控制层
// */
//public class SocketController {
//	
////	@PostConstruct//初始化之前调用
////	public void init(){
////		int port = 8989;
////		ServerSocket  serverSocket = null;
////		System.out.println("服务端开启啦");
////		try {
////			serverSocket = new ServerSocket(port);
////			while (true) {
////				try {
////					Socket socket = serverSocket.accept();
////					System.out.println("连接上啦");
////					new Server (socket).start();
////				} catch (IOException e) {
////					e.printStackTrace();
////				}
////
////			}
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////	}
////	
//
//}
// 