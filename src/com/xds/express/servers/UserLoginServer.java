package com.xds.express.servers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.test.suitebuilder.annotation.Suppress;

/*
 * 用户登陆服务的请求 响应类
 */

public class UserLoginServer {

	//请求参数必须为公有属性
	private String userphone;
	private String password;
	private String sign;
	
	public static String ADDRESS = "http://xiaodishu.coding.io/index.php/member/login/applogin";

	
	public UserLoginServer (String userphone,String password,String sign){
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
	
	/**
	 * 保存用户信息函数
	 * @param context
	 * @param username
	 * @param password
	 * @return
	 */
	public static void saveUserInfo(Context context,String username,String password) {
		
		SharedPreferences sp  = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("username", username);
		editor.putString("password", password);
		editor.commit();
		

	}
	
}
