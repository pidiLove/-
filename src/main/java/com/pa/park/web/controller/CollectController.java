package com.pa.park.web.controller; 

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;
import com.pa.park.core.util.ResponseUtil;
import com.pa.park.core.vo.UserParkinfo;
import com.pa.park.web.service.CollectService;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2017年2月16日 下午7:59:11 
 * 用户收藏控制层
 */
@Controller
@RequestMapping("/collect") 
public class CollectController {
	@Autowired
	private CollectService collectService;

	/*
	 * 添加收藏信息
	 * 未处理：对于未在该停车场停车的用户不应该可以添加评价信息
	 * */
	@RequestMapping(value = "/addCollect")
	public void addAccess(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject ();
		UserParkinfo up=new UserParkinfo();
		 up.setPhonenumber(request.getParameter("phonenumber"));
		 up.setParking_id(request.getParameter("parking_id"));
 		boolean result=collectService.addCollect(up);
		json.put("result", result);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}

}
 