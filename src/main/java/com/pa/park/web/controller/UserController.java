package com.pa.park.web.controller;

 
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pa.park.core.entity.User;
import com.pa.park.core.util.ResponseUtil;
import com.pa.park.core.vo.ParkinglotInfo;
import com.pa.park.web.service.UserService;

/**
 * @author wangpei
 * @version 创建时间：2016年12月25日 上午9:27:35 
 * 用户类控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	// 根据手机号密码登录
	public void login(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String phonenumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");
		boolean b = userService.login(phonenumber, password);
		  if(b==true){//用户名密码验证是正确的
			  //判断memcached中是否存在token,存在提醒用户不可重复登录
			  
			  //生成token，将token写入memcached,并将token返回给客户端
			  
			  
		  }
		
		int status = 0;
		if (b == true) {
			status = 1;
			User us = userService.getUserMessage(phonenumber);
			json.put("nickname", us.getNickname());
			json.put("avatar", us.getAvatar());// 获得用户头像
		}
		json.put("status", status);	
		

		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @RequestMapping(value = "/sendValidate")
	// // 发送手机验证码
	// public void sendValidate(HttpServletRequest request,
	// HttpServletResponse response) throws MalformedURLException {
	// String vcode = "";
	// String phonenumber = request.getParameter("phonenumber");
	// URL url;
	// String str = null;
	// JSONObject json = new JSONObject();
	// /* 生成验证码 */
	// for (int i = 0; i < 6; i++) {
	// vcode = vcode + (int) (Math.random() * 9);
	// }
	//
	// User us = userService.getUserMessage(phonenumber);
	// if (us != null) {
	// json.put("status", -2);// 电话号码已被注册过
	// try {
	// ResponseUtil.write(response, json.toString());
	// } catch (Exception e1) {
	// }
	// return;
	// }
	// try {
	// // url = new URL(
	// //
	// "http://api.sms.cn/sms/?ac=send&uid=wwwwww&pwd=64e23fcfaba29b429e09fe6913af5605&template=100006&mobile="+phonenumber+"&content={code:"+vcode+"}");
	// // URLConnection connection = url.openConnection();
	// // connection.setDoOutput(true);
	// // DataInputStream read= new
	// // DataInputStream(connection.getInputStream());
	// str = "{" + "stat" + ":" + "100" + "," + "message:" + "发送成功" + "}";//
	// read.readUTF();
	// } catch (Exception e) {
	// json.put("status", -1);// 服务器端错误,例如没网了
	// try {
	// ResponseUtil.write(response, json.toString());
	// } catch (Exception e1) {
	// }
	// return;
	// }
	// if (str != null && str.substring(6, 9).equals("100") == true) {
	// map.put(phonenumber, vcode);
	// json.put("status", 1);// 验证码发送成功
	// } else
	// json.put("status", 0);// 验证码发送失败
	// try {
	// ResponseUtil.write(response, json.toString());
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	//
	// }
	
 	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	// 用户注册
	public void regist(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		int status = 0;
		String phonenumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");
	//	String validate = request.getParameter("validate");
		// 判断用户是否已经被注册过。
		// if(map.get(phonenumber)!=null&&map.get(phonenumber).equals(validate)){
		User us = new User();
		us.setPhonenumber(phonenumber);
		us.setPassword(password);
		us.setNickname(phonenumber);
		us.setRole_id(3);
		us.setAvatar("jiangliuer.jpg");
		boolean b = userService.regist(us);
		if (b == true)// 用户注册成功
			status = 2;
		else {// 用户名已经存在了
			status = 1;//
			json.put("status", status);
		}
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/returnMessage", method = RequestMethod.POST)
	// 根据手机号返回用户基本信息
	public void returnMessage(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String phonenumber = request.getParameter("phonenumber");
		User us = userService.getUserMessage(phonenumber);
		us.setPassword(null);
		json.put(phonenumber, us);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/collect")
	// 根据手机号返回用户的收藏信息
	public void collect(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String phonenumber = request.getParameter("phonenumber");

		List<ParkinglotInfo> pl = userService.getUserCollect(phonenumber);
		for (ParkinglotInfo p : pl) {
			json.put(p.getParking_id(), p);
		}

		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/updateNickname")
	// 修改昵称
	public void updateNickname(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String phonenumber = request.getParameter("phonenumber");
		String newNickname = request.getParameter("newNickname");
		boolean bl = userService.updateNickname(phonenumber, newNickname);
		json.put("result", bl);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/updatePhonenumber")
	// 修改已绑定的手机号码
	public void updatePhonenumber(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String phonenumber = request.getParameter("phonenumber");
		String newPhonenumber = request.getParameter("newPhonenumber");
		boolean bl = userService.updatePhonenumber(phonenumber, newPhonenumber);
		json.put("result", bl);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/updatePassword")
	// 修改密码
	public void updatePassword(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String phonenumber = request.getParameter("phonenumber");
		String newPassword = request.getParameter("newPassword");
		boolean bl = userService.updatePassword(phonenumber, newPassword);
		json.put("result", bl);
		try {
			ResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
