package com.pa.park.core.vo; 
/** 
 * @author wangpei 
 * @version 
 *创建时间：2017年2月22日 上午12:31:12 
 * 类说明 
 */
public class ParkingCheckInfo {
	private int check_id;
	private String check_start_time;
	private String check_over_time;
	private double check_money;
	private String phonenumber;
	private String parking_id;//
	private String parking_name;//停车场，名称
	private String parking_image;//停车场图片
	private String parking_location;//停车场位置
	private String space_location;//停车场位置
	private int car_number;//停车场的总容量，停车位的多少
	private Double freight_basis;//计费标准（/小时）
	private Double reserve_time;//预订时间限制
	private double longitude;//经度
	private double latitude;//纬度
	public int getCheck_id() {
		return check_id;
	}
	public void setCheck_id(int check_id) {
		this.check_id = check_id;
	}
	public String getCheck_start_time() {
		return check_start_time;
	}
	public void setCheck_start_time(String check_start_time) {
		this.check_start_time = check_start_time;
	}
	public String getCheck_over_time() {
		return check_over_time;
	}
	public void setCheck_over_time(String check_over_time) {
		this.check_over_time = check_over_time;
	}
	public double getCheck_money() {
		return check_money;
	}
	public void setCheck_money(double check_money) {
		this.check_money = check_money;
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
	public String getParking_name() {
		return parking_name;
	}
	public void setParking_name(String parking_name) {
		this.parking_name = parking_name;
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
	public String getParking_image() {
		return parking_image;
	}
	public void setParking_image(String parking_image) {
		this.parking_image = parking_image;
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
	public String getParking_location() {
		return parking_location;
	}
	public void setParking_location(String parking_location) {
		this.parking_location = parking_location;
	}
	public String getSpace_location() {
		return space_location;
	}
	public void setSpace_location(String space_location) {
		this.space_location = space_location;
	}
	
	
	
 	

}
 