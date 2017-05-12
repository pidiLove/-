package com.pa.park.core.entity; 

import java.io.Serializable;

 
/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月25日 下午4:44:57 
 * 用户实体
 */
public class User implements Serializable {
	 
	 
	private static final long serialVersionUID = -3313085052878558859L;
	private String phonenumber;
	private String password;
	private String nickname;
	private int role_id;
	private String avatar;
	
	 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	

}
 