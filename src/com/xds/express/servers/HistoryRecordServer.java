package com.xds.express.servers;

/** 
 * @author  Reims 
 * @date 创建时间：2016年3月16日 上午12:04:11 
 * @version 1.0 
 * 
 */
/*
 * 获取历史记录服务类
 */
public class HistoryRecordServer {
	
	private String status;
	private String company;
	private int id;
	private String sign;
	
	
	private final static String ADDRESS = "http://xiaodishu.coding.io/index.php/index/app_all_express";


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getSign() {
		return sign;
	}


	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * @param status
	 * @param company
	 * @param id
	 */
	public HistoryRecordServer(String status, String company, int id, String sign) {
		super();
		this.status = status;
		this.company = company;
		this.id = id;
		this.sign = sign;
	}


	
}
