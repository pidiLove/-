package com.pa.park.web.dao; 

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pa.park.core.entity.Parkinglot;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 上午9:28:20 
 * 类说明 
 */
@Repository
public interface ParkingDao {
	public List<Parkinglot>getLocalPark(double longitude,double latitude );
	public List<Parkinglot>searchParkByName(String parking_name);//根据停车场的名称模糊查找停车场
	
	public int getEmptyCarSpace(String parking_id);
	public int getCollectUser(String parking_id);
	public String getParking_id(double longitude,double latitude);
	public Parkinglot getParking_Information(String parking_id);
	public String selectIn(Parkinglot pl );
}
 