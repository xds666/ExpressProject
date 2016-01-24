package com.xds.express.servers;

/*
 * 用户登陆服务的请求 响应类
 */

public class UserLoginServer {

	//请求参数必须为公有属性
	public String userphone;
	public String password;
	public String sign;
	
	public static String ADDRESS = "http://xiaodishu.coding.io/index.php/member/login/applogin";

	
	public UserLoginServer (String sign,String userphone,String password){
		this.sign = sign;
		this.userphone = userphone;
		this.password = password;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	/*
	 * 用户登陆响应类
	 */
	
	public static class UserLoginServerRsp {
		
	}
}
