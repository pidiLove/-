package com.pa.park.web.service.serviceImp; 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pa.park.core.entity.Assess;
import com.pa.park.web.dao.AssessDao;
import com.pa.park.web.service.AssessService;

 

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月29日 下午7:17:23 
 * 评价 
 */
@Service
@Transactional(rollbackForClassName={"RuntimeException","Exception"})
public class AssessServiceImp implements AssessService  {
	
	@Autowired
	AssessDao assessDao;

	@Override
	public boolean addAssess(Assess as) {
		 
			return assessDao.addAssess(as);
			
		 
	}

	@Override
	//@ReadThroughSingleCache(namespace="com.pa.park.core.entity.Assess") @ParameterValueKeyProvider 
	public List<Assess> getAllAssessByParkingId(String parking_id) {
		// 获取所有的评价信息
	 
		try{
			return assessDao.getAllAssessByParkingId(parking_id);
			
		}catch(Exception e){
 			return null;
			
		}
		
	}

}
 