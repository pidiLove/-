package com.pa.park.web.service; 

import java.util.List;
import com.pa.park.core.entity.Assess;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月29日 下午7:17:40 
 * 类说明 
 */
public interface AssessService {
	public boolean addAssess(Assess as);
	public List<Assess> getAllAssessByParkingId(String parking_id);//根据停车场id获取所有的评价信息

}
 