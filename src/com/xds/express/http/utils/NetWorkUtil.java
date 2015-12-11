package com.xds.express.http.utils;

import com.xds.express.http.app.TestApplication;

import android.R.integer;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/*
 * 网络相关工具类
 */

public class NetWorkUtil {
	
	/*
	 * 获取Manager
	 */
	
	private static ConnectivityManager getSysytemConnectivityManager() {
		ConnectivityManager connectivityManager = (ConnectivityManager) TestApplication
				.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
		return connectivityManager;
	}
	
	/**
	 * 判断网络链接是否有效(此时可以传输数据)
	 * 
	 * @return boolean 不管是wifi，还是mobile net,只要当前在链接状态(可有效传输数据)才返回true，否则为false
	 */
	public static boolean isNetWorkConnected() {
		NetworkInfo net = getSysytemConnectivityManager().getActiveNetworkInfo();
		return net != null && net.isConnected();
	}
	
	/**
	 * 检查是否连接wifi(可传输数据)
	 * @return 已连接wifi返回true,否则为false
	 */
	
	public static boolean isWifiConnected() {
		ConnectivityManager connectivityManager = getSysytemConnectivityManager();
		NetworkInfo wifiNetworkInfo = connectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if(wifiNetworkInfo.isConnected())
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否连接移动网络
	 * @return	已连接返回true，否则为false
	 */
	public static boolean isMobileConnected() {
		ConnectivityManager connectivityManager = getSysytemConnectivityManager();
		NetworkInfo mobileNetworkInfo = connectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if(mobileNetworkInfo.isConnected())
		{return true;}
		return false;
	}
	
	/**
	 * 获取网络连接类型
	 * @return 无法连接返回-1
	 */
	public static int getConnectedType(Context context) {
		NetworkInfo net = getSysytemConnectivityManager().getActiveNetworkInfo();
		if (null != net && net.isConnected()) {
			return net.getType();
		}
		return -1;
	}
}
