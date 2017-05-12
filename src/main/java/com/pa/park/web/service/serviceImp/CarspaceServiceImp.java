package com.pa.park.web.service.serviceImp; 

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pa.park.core.entity.Carspace;
import com.pa.park.web.dao.CarspaceDao;
import com.pa.park.web.service.CarspaceService;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月31日 下午12:31:57 
 * 类说明 
 */
@Service
public class CarspaceServiceImp implements CarspaceService{
	@Autowired
	CarspaceDao carspaceDao;

	@Override
	public boolean updateCarspace(Carspace cp) {//预定车位，先查找出车位状态为待使用，修改车位状态
		try{
			if(carspaceDao.findStatus(cp.getParking_id(), cp.getSpace_location())==0)
			return carspaceDao.updateCarspace(cp);
			else
				return false;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
	}

	  
	@Override
	//@ReadThroughSingleCache(namespace="com.pa.park.core.entity.Carspace")
	public List<Carspace> findEmptyCarspace(   String parking_id) {//根据停车场id查找所有的空车位
		try{
			return carspaceDao.findEmptyCarspace(parking_id);
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
			
		}
	}

	@Override
	//@ReadThroughSingleCache(namespace="com.pa.park.core.entity.Carspace")
	public List<Carspace> findAllCarspace( String parking_id) {
		//查找出停车场所有的车位信息，包括车位状态
		try{
			return carspaceDao.findAllCarspace(parking_id);
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
			
		}
	}

 
	

}
 