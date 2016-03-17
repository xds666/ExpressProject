package com.xds.express.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;



/*
 * JSON解析工具类
 */

public class JsonUtil {
	
	public static String getJsonContent(String urlStr) {
		try {
			//获取HttpURLConnection连接对象
			URL url = new URL(urlStr);
			HttpsURLConnection httpConnection = (HttpsURLConnection) url.openConnection();
			
			//设置连接属性
			httpConnection.setConnectTimeout(3000);
			httpConnection.setDoInput(true);
			httpConnection.setRequestMethod("GET");
			
			//获取响应码
			
			int resqcode = httpConnection.getResponseCode();
			if (resqcode == 200) {
				return ConvertStreamToJson(httpConnection.getInputStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}

	private static String ConvertStreamToJson(InputStream inputStream) {
		
		String jsonStr = "";
		
		//ByteArayOutputSream相当于内存溢出流
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		
		int length = 0;
		//将输出流存到内存溢出流
		try {
			while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
				out.write(buffer,0,length);
				jsonStr = new String(out.toByteArray());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonStr;
	}
	

}
