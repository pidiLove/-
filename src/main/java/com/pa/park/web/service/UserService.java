package com.pa.park.web.service; 

import java.util.List;

import com.pa.park.core.entity.User;
import com.pa.park.core.vo.ParkinglotInfo;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月19日 下午9:03:51 
 * 类说明 
 */
public interface UserService {
	public String getRoleByUsername(String phonenumber);
	public boolean login(String phonenumber,String password);//登录
	public boolean regist(User us);//注册
	public User getUserMessage(String phonenumber);//获得用户基本信息
	public List<ParkinglotInfo> getUserCollect(String phonenumber);//获得用户的收藏信息
	public boolean updateNickname(String phonenumber,String newNickname);//修改昵称
	public boolean updatePhonenumber(String phonenumber,String newPhonenumber);//修改手机号码
	public boolean updatePassword(String phonenumber,String newPassword);//修改用户密码

}
 