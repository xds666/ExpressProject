package com.xds.express.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wsy 地理位置模型
 */
public class AddressBean {
	private double latitude;// 纬度
	private double longitude;// 经度
	private String time;// 定位时间
	private String address; // 地址
	private String country; // 国家信息
	private String province;// 省份信息
	private String city;// 城市信息
	private String distric; // 地区信息
	private String street;// 街道消息

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistric() {
		return distric;
	}

	public void setDistric(String distric) {
		this.distric = distric;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
