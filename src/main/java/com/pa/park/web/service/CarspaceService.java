package com.pa.park.web.service; 

import java.util.List;

import com.pa.park.core.entity.Carspace;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月31日 下午12:30:39 
 * 类说明 
 */
public interface CarspaceService {
	 
	public boolean updateCarspace(Carspace cp);//预定车位
	public List<Carspace> findEmptyCarspace(String parking_id);//根据停车场编号查找所有的空车位
 	public List<Carspace> findAllCarspace(String parking_id);//根据停车场编号查找所有的车位

}
 