package com.pa.park.core.vo; 
/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月29日 下午8:32:28 
 * 停车场实体类
 */
public class ParkinglotInfo {
	private String parking_id;//
	private String parking_name;//停车场，名称
	private String parking_image;//停车场图片
	private String parking_location;//停车场位置
	private int car_number;//停车场的总容量，停车位的多少
	private Double freight_basis;//计费标准（/小时）
	private Double reserve_time;//预订时间限制
	private double longitude;//经度
	private double latitude;//纬度
	private int collect_number;//收藏人数
	private int emptyCarSpace;//空车位
	public ParkinglotInfo(){
		
	}
	public ParkinglotInfo(String parking_id,String parking_name,String parking_image,String parking_location,int car_number,Double freight_basis,Double reserve_time,double longitude, double latitude,int collect_number,int emptyCarSpace){
		this.parking_id=parking_id;
		this.parking_name=parking_name;
		this.parking_image=parking_image;
		this.parking_location=parking_location;
		this.car_number=car_number;
		this.freight_basis=freight_basis;
		this.reserve_time=reserve_time;
		this.longitude=longitude;
		this.latitude=latitude;
		this.collect_number=collect_number;
		this.emptyCarSpace=emptyCarSpace;
		
	}
	public String getParking_id() {
		return parking_id;
	}
	public void setParking_id(String parking_id) {
		this.parking_id = parking_id;
	}
	public String getParking_name() {
		return parking_name;
	}
	public void setParking_name(String parking_name) {
		this.parking_name = parking_name;
	}
	public String getParking_image() {
		return parking_image;
	}
	public void setParking_image(String parking_image) {
		this.parking_image = parking_image;
	}
	public String getParking_location() {
		return parking_location;
	}
	public void setParking_location(String parking_location) {
		this.parking_location = parking_location;
	}
	public int getCar_number() {
		return car_number;
	}
	public void setCar_number(int car_number) {
		this.car_number = car_number;
	}
	public Double getFreight_basis() {
		return freight_basis;
	}
	public void setFreight_basis(Double freight_basis) {
		this.freight_basis = freight_basis;
	}
	public Double getReserve_time() {
		return reserve_time;
	}
	public void setReserve_time(Double reserve_time) {
		this.reserve_time = reserve_time;
	}
 
	 
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public int getCollect_number() {
		return collect_number;
	}
	public void setCollect_number(int collect_number) {
		this.collect_number = collect_number;
	}
	public int getEmptyCarSpace() {
		return emptyCarSpace;
	}
	public void setEmptyCarSpace(int emptyCarSpace) {
		this.emptyCarSpace = emptyCarSpace;
	}
	 
	

}
 