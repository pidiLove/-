package com.pa.park.core.entity;

import java.io.Serializable;

/**
 * @author wangpei
 * @version 创建时间：2016年12月19日 下午9:17:55
 * 评价信息表
  */
public class Assess implements Serializable {

	private static final long serialVersionUID = -608764679068384346L;
	private int assess_id;
	private String assess_mark;// 评分，几颗星
	private String assess_content;// 评价内容
	private String assess_time;// 评价时间
	private String phonenumber;// 评价的用户id
	private String parking_id;// 评价的停车场id
	private int thumbs_up;// 点赞次数,评价热度

	public Assess() {

	}

	public Assess(String assess_mark, String assess_content,
			String assess_time, String phonenumber, String parking_id,
			int thumbs_up) {
		this.assess_mark = assess_mark;
		this.assess_content = assess_content;
		this.assess_time = assess_time;
		this.phonenumber = phonenumber;
		this.parking_id = parking_id;
		this.thumbs_up = thumbs_up;
	}

	public int getAssess_id() {
		return assess_id;
	}

	public void setAssess_id(int assess_id) {
		this.assess_id = assess_id;
	}

	public String getAssess_mark() {
		return assess_mark;
	}

	public void setAssess_mark(String assess_mark) {
		this.assess_mark = assess_mark;
	}

	public String getAssess_content() {
		return assess_content;
	}

	public void setAssess_content(String assess_content) {
		this.assess_content = assess_content;
	}

	public String getAssess_time() {
		return assess_time;
	}

	public void setAssess_time(String assess_time) {
		this.assess_time = assess_time;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getParking_id() {
		return parking_id;
	}

	public void setParking_id(String parking_id) {
		this.parking_id = parking_id;
	}

	public int getThumbs_up() {
		return thumbs_up;
	}

	public void setThumbs_up(int thumbs_up) {
		this.thumbs_up = thumbs_up;
	}

}
