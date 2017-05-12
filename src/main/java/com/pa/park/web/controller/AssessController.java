package com.pa.park.web.controller; 

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;
import com.pa.park.core.entity.Assess;
import com.pa.park.core.util.ResponseUtil;
import com.pa.park.web.service.AssessService;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 上午9:31:56 
 * 评价控制层
 */
@Controller
@RequestMapping("/assess") 
public class AssessController {
	
	@Autowired
	private AssessService accessService;

	@RequestMapping(value = "/addAssess")//添加评价信息
	public void addAccess(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject ();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String  assess_time= sdf.format(now);
 		Assess as=new Assess( request.getParameter("assess_mark"),request.getParameter("assess_content"),assess_time,request.getParameter("phonenumber"),request.getParameter("parking_id"),0);
		boolean result=accessService.addAssess(as);
		json.put("result", result);
		 	try {
				ResponseUtil.write(response, json.toString());
			} catch (Exception e) {
 				e.printStackTrace();
			}
		 
	}
	@RequestMapping(value = "/getAllAssessByParkingId")//根据停车场的id号获得对其的评价信息
	public void getAllAssessByParkingId(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject ();
		List<Assess> assess=accessService.getAllAssessByParkingId(request.getParameter("parking_id"));
		for(Assess as:assess){
			json.put(String.valueOf(as.getAssess_id()),as);
			
		}

		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}


}
 