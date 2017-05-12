package com.pa.park.web.dao; 

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pa.park.core.entity.Carspace;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月31日 上午11:00:06 
 * 类说明 
 */
@Repository
public interface CarspaceDao {
	 /*车位状态：-1:坏车位 0：空车位 1：已经预定的车位 2：正在使用的车位
	  * */
	public boolean updateCarspace(Carspace cp);//预定车位
 	public List<Carspace> findEmptyCarspace(String parking_id);//查找一个停车场中的所有空车位
	public List<Carspace> findAllCarspace(String parking_id);//根据停车场编号查找所有的车位
	public int findStatus(String parking_id,String space_location); //茶渣停车场中的一个车位的状态
	

}
 