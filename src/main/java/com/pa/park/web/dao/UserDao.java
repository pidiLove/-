package com.pa.park.web.dao; 


import java.util.List;

import org.springframework.stereotype.Repository;

import com.pa.park.core.entity.Parkinglot;
import com.pa.park.core.entity.User;




/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 上午9:28:05 
 * 类说明 
 */
@Repository
public interface UserDao {
	public String getRoleByUsername(String phonenumber);
	public boolean login(String phonenumber,String password);//登录
	public boolean regist(User us);//注册
	public User getUserMessage(String phonenumber);//获得用户信息
	public List<Parkinglot> getUserCollect(String phonenumber);//返回用户收藏信息
	public boolean updateNickname(String phonenumber,String newNickname);//修改昵称
	public boolean updatePhonenumber(String phonenumber,String newPhonenumber);//修改手机号码
	public boolean updatePassword(String phonenumber,String newPassword);//修改用户密码
	 
	
}
 