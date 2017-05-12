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
import com.pa.park.core.entity.Carspace;
import com.pa.park.core.entity.Check;
import com.pa.park.core.util.ResponseUtil;
import com.pa.park.web.service.CarspaceService;
import com.pa.park.web.service.CheckService;
import com.pa.park.web.service.ParkingService;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月31日 下午12:29:51 
 * 车位控制层
 */
@Controller
@RequestMapping("/carspace")
public class CarspaceController {
	@Autowired
	private CarspaceService carspaceService;
	
	@Autowired
	private CheckService checkService;
	
	@Autowired
	private ParkingService parkService;

	
	@RequestMapping(value = "/bookCarspace")//预定车位,便产生一条状态为0的订单信息
	public void bookCarspace(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject ();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String  start_time= sdf.format(now);
		Carspace cp=new Carspace();
		cp.setSpace_status(1);
		cp.setParking_id(request.getParameter("parking_id"));
		cp.setSpace_location(request.getParameter("space_location"));
		cp.setPhonenumber(request.getParameter("phonenumber"));
		cp.setStart_time(start_time);
 		boolean result1=carspaceService.updateCarspace(cp);//修改车位状态
 		//添加订单
 		Check ck=new Check();
 		ck.setCheckstatus("0");//预定
 		ck.setCheck_start_time(start_time);
 		ck.setParking_id(request.getParameter("parking_id"));
 		ck.setPhonenumber(request.getParameter("phonenumber"));
 		ck.setSpace_location(request.getParameter("space_location"));
 		boolean result2=checkService.addCheck(ck);
 		json.put("result", result1&result2);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}

	} 
	@RequestMapping(value = "/findEmptyCarspace")//查找某个停车场的空车位
	public void findEmptyCarspace(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject ();
		JSONObject jsonA=new JSONObject ();
		JSONObject jsonB=new JSONObject ();
		JSONObject jsonC=new JSONObject ();
		JSONObject jsonD=new JSONObject ();
		List<Carspace> carspce=carspaceService.findEmptyCarspace(request.getParameter("parking_id"));
 		for(Carspace cp:carspce){
 			if(cp.getSpace_location().charAt(0)=='A')
 				jsonA.put(cp.getSpace_location(),cp);
 			else if(cp.getSpace_location().charAt(0)=='B')
 				jsonB.put(cp.getSpace_location(),cp);
 			else if(cp.getSpace_location().charAt(0)=='C')
 				jsonC.put(cp.getSpace_location(),cp);
 			else  
 				jsonD.put(cp.getSpace_location(),cp);
 			
 		}
 		json.put("A", jsonA);
 		json.put("B", jsonB);
 		json.put("C", jsonC);
 		json.put("D", jsonD);
 		
	
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping(value = "/findEmptyCarspaceByTude")//查找某个停车场的所有车位
	public void findEmptyCarspaceByLocation(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JSONObject json=new JSONObject ();
		JSONObject jsonA=new JSONObject ();
		JSONObject jsonB=new JSONObject ();
		JSONObject jsonC=new JSONObject ();
		JSONObject jsonD=new JSONObject (); 
		String parking_lot=parkService.getParking_id(Double.parseDouble(request.getParameter("longitude")), Double.parseDouble(request.getParameter("latitude")));
		if(parking_lot==null){
		json.put("A", jsonA);
 		json.put("B", jsonB);
 		json.put("C", jsonC);
 		json.put("D", jsonD);
 		}
		else{
		List<Carspace> carspce=carspaceService.findEmptyCarspace(parking_lot);
 		for(Carspace cp:carspce){
 			if(cp.getSpace_location().charAt(0)=='A')
 				jsonA.put(cp.getSpace_location(),cp);
 			else if(cp.getSpace_location().charAt(0)=='B')
 				jsonB.put(cp.getSpace_location(),cp);
 			else if(cp.getSpace_location().charAt(0)=='C')
 				jsonC.put(cp.getSpace_location(),cp);
 			else  
 				jsonD.put(cp.getSpace_location(),cp);
 			
 		}
 		json.put("A", jsonA);
 		json.put("B", jsonB);
 		json.put("C", jsonC);
 		json.put("D", jsonD);
		}
	
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
	
	 
	
	
	
	}



 