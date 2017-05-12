package com.pa.park.web.controller; 


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pa.park.core.entity.Parkinglot;
import com.pa.park.core.util.PageParameter;
import com.pa.park.core.util.ResponseUtil;
import com.pa.park.core.vo.ParkinglotInfo;
import com.pa.park.web.service.ParkingService;
 
/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 上午9:27:55 
 * 停车场类的控制层
 */
@Controller
@RequestMapping("/parkinglot") 
public class ParkingController {
		 
		@Autowired
		ParkingService parkingService;
	
 		@RequestMapping(value = "/getlocalpark")//根据坐标信息获得附近停车场推荐的信息***加上分页
		public void getlocalpark(HttpServletRequest request,HttpServletResponse response ){
			 
			Integer page=Integer.parseInt(request.getParameter("page"));//当前页
			Integer rows=5;//Integer.parseInt(request.getParameter("rows"));//每页显示的数量
			double longitude=Double.parseDouble(request.getParameter("longitude"));//经度
			double latitude=Double.parseDouble(request.getParameter("latitude"));//纬度
			int intPage = page == null ||  page <= 0 ? 1 : page;//当前页
		    int intPageSize = rows == null || rows <= 0 ? 10 : rows; // 设置每页显示的数量
	        PageParameter page1 = new PageParameter();
	 		JSONObject json=new JSONObject ();
	 		
	 		System.out.println("rrr"+longitude);
			 System.out.println("vv"+latitude);

	        page1.setCurrentPage(intPage);
	        page1.setPageSize(intPageSize);
	        PageHelper.startPage(intPage, intPageSize);
	        List<ParkinglotInfo> pl=parkingService.getLocalPark(longitude, latitude);//获得停车场
  	           
 
 	        for(ParkinglotInfo pf:pl){
	        	
	        	json.put(pf.getParking_id(), pf);
	        	System.out.println(pf.getParking_name()+"---");
	        }
 	        
 	        System.out.println("AAA"+json.toString());
 	       try {
				ResponseUtil.write(response, json.toString());
			} catch (Exception e) {
				e.printStackTrace();
			} 
		
		}
		
		
		@RequestMapping(value = "/choseParkingInDatabase")//对从百度地图中获得的数据进行一次过滤。
		public void choseParkingInDatabase(HttpServletRequest request,HttpServletResponse response) throws IOException{
			String str=request.getParameter("parkinglotData");
			Gson gson = new Gson();
	 		List<Parkinglot> ps = gson.fromJson(str, new TypeToken<List<Parkinglot>>(){}.getType());  
	 		List<Parkinglot> right=new ArrayList<Parkinglot>();  
	 		for(int i = 0; i < ps.size() ; i++){  //循环从数据库中读取数据  
	 			String parking_id=parkingService.selectIn(ps.get(i));
	 			if(parking_id!=null){
	 				ps.get(i).setParking_id(parking_id);
	 				right.add(ps.get(i));
	 				
	 			}
	 		     
	 		}  	
	 		
	 		JSONObject json=new JSONObject ();
			json.put("right", right);
	 		
		
			try {
				ResponseUtil.write(response, json.toString());
			} catch (Exception e) {
	 			e.printStackTrace();
			}
		}
		
		
		 
		@RequestMapping(value = "/searchParkByName")//根据坐标信息搜索附近停车场的信息***加上分页
		public void searchParkByName(HttpServletRequest request,HttpServletResponse response ){
		String parking_name = request.getParameter("parking_name");
		System.out.println("]]"+parking_name);
		JSONObject json = new JSONObject();
		List<ParkinglotInfo> pl = parkingService.searchParkByName(parking_name);
		for (ParkinglotInfo p : pl) {
			json.put(p.getParking_id(), p);
			System.out.println("+++"+p.getParking_name());
 		}
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
				e.printStackTrace();
		}}
		

		
	

}
 