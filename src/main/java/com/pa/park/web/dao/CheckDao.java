package com.pa.park.web.dao; 

import java.util.List;

import org.springframework.stereotype.Repository;
import com.pa.park.core.entity.Check;
import com.pa.park.core.vo.ParkingCheckInfo;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 上午9:32:15 
 * 订单(订单状态：0：已预订，未支付，1：已支付，2：待评价，3：已评价)
 */
@Repository
public interface CheckDao {
	public boolean addCheck(Check ck);
	
	  
	public List<Check> getAllCheck(String phonenumber);//根据用户名获取所有的订单
//	public List<Check> getAssessByPhonenumber(String phonenumber,String parking_id);
	public List<ParkingCheckInfo> getCheckByStatus(String phonenumber,String checkStatus);//根据用户名获取所有的订单
	
}
 