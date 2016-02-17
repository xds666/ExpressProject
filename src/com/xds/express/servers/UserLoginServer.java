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
import android.test.suitebuilder.annotation.Suppress;

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
	
	/**
	 * 保存用户信息函数
	 * @param context
	 * @param username
	 * @param password
	 * @return
	 */
	@SuppressLint("SdCardPath")
	public static boolean saveUserInfo(Context context,String username,String password) {
		File file = new File(context.getFilesDir(),"info.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write((username + "###" + password).getBytes());
			fos.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public static Map<String, String> getSaveUserInfo(Context context){
		File file = new File(context.getFilesDir(),"info.txt");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String str = br.readLine();
			String[] infos = str.split("###");
			Map<String, String> map = new HashMap<String, String>();
			map.put("username", infos[0]);
			map.put("password", infos[1]);
			return map;
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
}
