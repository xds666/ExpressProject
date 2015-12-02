package com.xds.express;

public class Express {
	
	
	private static final String[] TODOOR_STATE_STRINGS = {  //寄件申请状态
		"DISPLACEORDER",//未下单
		"PLACEORDER",//已下单
		"RECIVERED",//已签收
		"SENDED",//已送出
		"CANCEL",//已撤销
		"SE"//已评价
		};

	private static final String[] placeorder_operation = { //派发动作
		"BYMYSELF",//自取
		"STEPPED"//代领
	};
	
	private static final String[] placeorder_status = { //派发状态
		"REACHED",//到件
		"SENDING",//正在派发
		"SENDED",//送达
		"CANCEL",//已撤销
		"SE"//已评价
	};
	

	
	private String id;
	private String Num;
	private String company;
	private String pick_way;
	
	private int Sender_id;
	private String Sender_name;
	private String Sender_tel;
	private String Sender_address;
	
	private int Receiver_id;
	private String Receiver_name;
	private String Receiver_tel;
	private String Receiver_address;
	
	private String Send_date;//需要用到上门收件的快递才需要的  "寄件时间" 属性
	private String Pick_date;
	
	private String status;
	
	/**
	 * @param company
	 * @param pick_way
	 * @param status
	 */
	public Express(String company, String pick_way, String status) {
		super();
		this.company = company;
		this.pick_way = pick_way;
		this.status = status;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
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
	public String getSender_tel() {
		return Sender_tel;
	}
	public void setSender_tel(String sender_tel) {
		Sender_tel = sender_tel;
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
	public String getReceiver_tel() {
		return Receiver_tel;
	}
	public void setReceiver_tel(String receiver_tel) {
		Receiver_tel = receiver_tel;
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
	
}
