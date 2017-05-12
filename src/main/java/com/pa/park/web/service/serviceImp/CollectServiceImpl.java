package com.pa.park.web.service.serviceImp; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pa.park.core.vo.UserParkinfo;
import com.pa.park.web.dao.CollectDao;
import com.pa.park.web.service.CollectService;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2017年2月16日 下午7:57:09 
 * 类说明 
 */
@Service
public class CollectServiceImpl  implements CollectService {
	
	@Autowired
	CollectDao collectDao;

	@Override
	public boolean addCollect(UserParkinfo as) {
		
		try{
			return collectDao.addCollect(as);
			
		}catch(Exception e){
 			return false;
			
		}	}

}
 