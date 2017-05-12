package com.pa.park.web.dao; 

 

import org.springframework.stereotype.Repository;

 
import com.pa.park.core.vo.UserParkinfo;
/** 
 * @author wangpei 
 * @version 
 *创建时间：2017年2月16日 下午7:52:17 
 * 类说明 
 */
@Repository
public interface CollectDao {//评价（星级、评价内容、评价人
	public boolean addCollect(UserParkinfo as);// 
	//public List<Assess> getAllAssessByParkingId(String parking_id);//根据停车场id获取所有的评价信息

}