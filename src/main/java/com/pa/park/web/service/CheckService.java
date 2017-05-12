package com.pa.park.web.service; 

import java.util.List;
import com.pa.park.core.entity.Check;
import com.pa.park.core.vo.ParkingCheckInfo;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 上午9:33:11 
 * 订单Service层
 */
 
public interface CheckService {
	public boolean addCheck(Check ck);
	//public List<Check> getAllCheck(String phonenumber);//根据用户名获取所有的订单
 	public List<ParkingCheckInfo> getCheckByStatus(String phonenumber,String checkStatus);//根据用户名获取所有的订单
 }
 

