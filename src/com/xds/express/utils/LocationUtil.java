package com.xds.express.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.xds.express.bean.AddressBean;

/**
 * @author wsy 定位服务
 */
public class LocationUtil implements AMapLocationListener {

	private static final String TAG = "LoactionUtil - wusy";
	private AMapLocationClient locationClient = null;
	private AMapLocationClientOption locationOpt = null;
	private LocationListener listener;
	private int loactionCount = 1;// 默认定位三次

	private static LocationUtil loactionUtil;

	private static LocationUtil checkLocationUtil() {
		if (loactionUtil == null) {
			loactionUtil = new LocationUtil();
			return loactionUtil;

		} else {
			return loactionUtil;
		}
	}

	public static void startLocation(Context context, LocationListener listener) {
		Log.i(TAG, "开始定位！");
		checkLocationUtil().loaction(context, listener);
	}

	private void stopLocation() {
		Log.i(TAG, "停止定位！");
		loactionCount = 1;
		locationClient.stopLocation();
	}

	public void loaction(Context context, LocationListener listener) {
		this.listener = listener;
		locationClient = new AMapLocationClient(context);
		locationClient.setLocationListener(loactionUtil);
		initLoactionOPT();
		locationClient.setLocationOption(locationOpt);
		locationClient.startLocation();
	}

	private void initLoactionOPT() {
		locationOpt = new AMapLocationClientOption();
		locationOpt.setLocationMode(AMapLocationMode.Hight_Accuracy);
		locationOpt.setNeedAddress(true);
		locationOpt.setOnceLocation(false);
		locationOpt.setWifiActiveScan(true);
		locationOpt.setMockEnable(false);
		locationOpt.setInterval(2000);
	}

	@Override
	public void onLocationChanged(AMapLocation amapLocation) {
		if (amapLocation.getErrorCode() == 0) {
			// 定位成功回调信息，设置相关消息
			AddressBean bean = new AddressBean();
			bean.setLongitude(amapLocation.getLongitude());
			bean.setLatitude(amapLocation.getLatitude());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(amapLocation.getTime());
			bean.setTime(df.format(date));
			bean.setAddress(amapLocation.getAddress());
			bean.setCountry(amapLocation.getCountry());
			bean.setProvince(amapLocation.getProvince());
			bean.setCity(amapLocation.getCity());
			bean.setStreet(amapLocation.getStreet());
			bean.setDistric(amapLocation.getDistrict());
			listener.getAddress(bean);
			// 关闭定位
			stopLocation();
		} else {
			loactionCount++;
			if (loactionCount >= 3) {
				stopLocation();
			}
		}
	}

	/**
	 * @author wsy 回调接口 定位
	 */
	public interface LocationListener {
		public void getAddress(AddressBean address);
	}

}
