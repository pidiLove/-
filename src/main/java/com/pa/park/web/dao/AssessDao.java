package com.pa.park.web.dao; 

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pa.park.core.entity.Assess;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 上午9:32:28 
 * 评价dao层
 */

@Repository
public interface AssessDao {//评价（星级、评价内容、评价人
	public boolean addAssess(Assess as);//添加评价信息
	public List<Assess> getAllAssessByParkingId(String parking_id);//根据停车场id获取所有的评价信息

}
 