package com.xds.express.bean;



import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;



public class ExpressBean {
	
	private String id;
	private String company;
	private String pick_way;	//对应数据库里面的express_action属性
	
	private int Sender_id;
	private String Sender_name;
	private String Sender_phone;
	private String Sender_address;
	
	private int Receiver_id;
	private String Receiver_name;
	private String Receiver_phone;
	private String Receiver_address;
	
	private String collection_id;	//代领人id 0则为不是代领
	private String delivery_id;		//派件人id 0则为尚未派件
	private String serv_eval_id;	//评价表id 0则为尚未评价
	
	private String Send_date;//需要用到上门收件的快递才需要的  "寄件时间" 属性
	private String Pick_date;
	
	private String status;
	
	/**
	 * @param company
	 * @param pick_way
	 * @param status
	 */
	public ExpressBean(String company, String pick_way, String status) {
		super();
		this.company = company;
		this.pick_way = pick_way;
		this.status = status;
	}
	
	
	
	public ExpressBean() {
		super();
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSender_id() {
		return Sender_id;
	}
	public void setSender_id(int sender_id) {
		Sender_id = sender_id;
	}
	public String getSender_name() {
		return Sender_name;
	}
	public void setSender_name(String sender_name) {
		Sender_name = sender_name;
	}
	public String getSender_phone() {
		return Sender_phone;
	}
	public void setSender_phone(String sender_phone) {
		Sender_phone = sender_phone;
	}
	public String getSender_address() {
		return Sender_address;
	}
	public void setSender_address(String sender_address) {
		Sender_address = sender_address;
	}
	public int getReceiver_id() {
		return Receiver_id;
	}
	public void setReceiver_id(int receiver_id) {
		Receiver_id = receiver_id;
	}
	public String getReceiver_name() {
		return Receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		Receiver_name = receiver_name;
	}
	public String getReceiver_phone() {
		return Receiver_phone;
	}
	public void setReceiver_phone(String receiver_phone) {
		Receiver_phone = receiver_phone;
	}
	public String getReceiver_address() {
		return Receiver_address;
	}
	public void setReceiver_address(String receiver_address) {
		Receiver_address = receiver_address;
	}
	public String getPick_date() {
		return Pick_date;
	}
	public void setPick_date(String pick_date) {
		Pick_date = pick_date;
	}
	public String getSend_date() {
		return Send_date;
	}

	public void setSend_date(String send_date) {
		Send_date = send_date;
	}

	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}




	public String getPick_way() {
		return pick_way;
	}




	public void setPick_way(String pick_way) {
		this.pick_way = pick_way;
	}
	
	/*
	 * 因为不知道要放在哪里，就先写在这里好了
	 */
	
	public static ExpressBean getExpressBean(String jsonStr) {
		ExpressBean express = new ExpressBean();
		
		try {
			//将json字符串转换成json对象
			JSONObject jsonObj = new JSONObject(jsonStr);
			//得到指定json key对应的value值
			JSONObject expressObj = jsonObj.getJSONObject("express");
			//设置对应的值
			express.setId(expressObj.getString("express_id"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return express;
	}
	
	
	public static List<ExpressBean> getExpressBeans(String jsonStr) {
		List<ExpressBean> list = new ArrayList<ExpressBean>();
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(jsonStr);
			
			JSONArray expressList = jsonObj.getJSONArray("express");
			//遍历JSONArray
			for (int i = 0; i < expressList.length(); i++) {
				//获取JSON对象
				JSONObject jsonItem = expressList.getJSONObject(i);
				//获取JSON对象的值
				ExpressBean express = new ExpressBean();
				express.setId("express_id");
				
				
				list.add(express);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
