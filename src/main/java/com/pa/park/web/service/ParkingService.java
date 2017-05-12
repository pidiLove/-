package com.pa.park.web.service; 

 
import java.util.List;
import com.pa.park.core.entity.Parkinglot;
import com.pa.park.core.vo.ParkinglotInfo;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 上午9:28:36 
 * 类说明 
 */

public interface ParkingService {
	public List<ParkinglotInfo>getLocalPark(double longitude,double latitude );
	public int getEmptyCarSpace(String parking_id);
	public int getCollectUser(String parking_id);
	public String getParking_id(double longitude,double latitude);
	public String selectIn(Parkinglot pl );
	public Parkinglot getParking_Information(String parking_id);
	public List<ParkinglotInfo>searchParkByName(String parking_name);//根据停车场的名称模糊查找停车场


 
		
	
}
 