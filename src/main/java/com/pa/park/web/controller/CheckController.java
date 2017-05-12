package com.pa.park.web.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;
import com.pa.park.core.util.ResponseUtil;
import com.pa.park.core.vo.ParkingCheckInfo;
import com.pa.park.web.service.CheckService;

/**
 * @author wangpei
 * @version 创建时间：2016年12月25日 上午9:31:10 账单控制层
 */
@Controller
@RequestMapping("/check")
public class CheckController {

	@Autowired
	private CheckService checkService;

	// @RequestMapping(value = "/addCheck")//添加账单
	// public void addAccess(HttpServletRequest request,HttpServletResponse
	// response) throws IOException{
	// JSONObject json=new JSONObject ();
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// Date now = new Date();
	// String check_start_time= sdf.format(now);
	// Check ck=new Check();
	// ck.setCheck_start_time(check_start_time);
	// int choseHours=Integer.parseInt(request.getParameter("choseHours"));
	// Date over = new Date(choseHours);
	// String check_over_time= sdf.format(over);
	// ck.setCheck_over_time(check_over_time);
	// ck.setParking_id(request.getParameter("parking_id"));
	// ck.setPhonenumber(request.getParameter("phonenumber"));
	// ck.setPlate_number( request.getParameter("plate_number"));
	// boolean result=checkService.addCheck(ck);
	// json.put("result", result);
	// try {
	// ResponseUtil.write(response, json.toString());
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// @RequestMapping(value = "/getAllCheck")//根据用户电话 获取所有的订单信息
	// public void getAllAssessByParkingId(HttpServletRequest
	// request,HttpServletResponse response) throws IOException{
	// JSONObject json=new JSONObject ();
	// List<Check>
	// check=checkService.getAllCheck(request.getParameter("phonenumber"));
	// for(Check as:check){
	// json.put(String.valueOf(as.getCheck_id()),as);
	// }
	//
	// try {
	// ResponseUtil.write(response, json.toString());
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//

	@RequestMapping(value = "/getCheckByStatus")
	// 根据用户电话 和订单状态，获取所有订单信息
	public void getCheckByStatus(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JSONObject json = new JSONObject();
		List<ParkingCheckInfo> check = checkService.getCheckByStatus(
				request.getParameter("phonenumber"),
				request.getParameter("checkStatus"));
		for (ParkingCheckInfo as : check) {
			json.put(String.valueOf(as.getCheck_id()), as);
		}

		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
